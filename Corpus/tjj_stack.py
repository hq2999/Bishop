import redis
import requests
import json
import re
from pyquery import PyQuery as jq
import random
import time
from get_proxy import ProxyUtils

userId = None
token = None
corpus_id = None

headers = {
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
        "Accept-Language": "zh-CN,zh;q=0.9",
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36",
        # "Cookie": "_trs_uv=kgsro796_6_jeik; SF_cookie_1=72991020; wzws_cid=5c33478df51a25eaa2471741d49cf7e9ea4a6dcd5022b3f3fee31e044ab97e18071993ed5e75b3650bc41ea5075128be0ee9c8d60f6f6ec2d171cec241cb7f0c3125526e07322f877de12cf6b505e6df; _trs_ua_s_1=kjnvw9j7_6_id4b",
    }

base_url = 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2020/'
# base_url = 'https://www.ip.cn/api/index?ip=&type=0'
# base_url = 'https://ip.tool.chinaz.com/'

rds = redis.Redis(host='localhost', port=6379, decode_responses=True)

pu = ProxyUtils(10000)

def exists(content):
    lst = rds.lrange('url', 0, rds.llen('url'))
    for item in lst:
        if content == item:
            return True
    return False


def do_get(url, count):
    time.sleep(random.randint(999, 3999)/1000)
    r = ''
    try:
        proxy_addr = pu.get_random_proxy()

        proxies = {
            'http': proxy_addr,
            'https': proxy_addr,
        }

        s = requests.session()
        s.keep_alive = False
        res = s.get(url=url, headers=headers, timeout=3, proxies=proxies)
        res.encoding = res.apparent_encoding

        if not re.match(r'.*05034670.*', res.text, flags=re.DOTALL):
            raise Exception("proxy content error")

        pu.refresh(proxy_addr)

        result = res.text
        result = re.sub('[\\uf000-\\uffff]', '', result)
        return result

    except Exception as err:
        print("do_get" + "  " + proxy_addr + ' ' + str(count+1) + "  " + url)
        pu.remove(proxy_addr)
        if count < 100:
            return do_get(url, count+1)


def get_links(htext, path, father_name, father_id):

    links = jq(htext).find("table .provincetr").find("td")

    if len(links) > 0:
        for link in links:
            href = jq(link).find('a').attr('href')
            name = jq(link).text().replace('\n', '')

            if name in ['北京市', '天津市', '新疆维吾尔自治区']:
                continue

            print('0', name, father_id, father_name)

            if href:
                p = ''
                if re.match(r'(\d+)/\w+\.html', href):
                    p = re.sub(r'([^/]+)/\w+\.html', "\\1", href) + "/"

                data = json.dumps({'path': path + p, 'href': href, 'father_name': name, 'father_id': '0'})
                if not exists(data):
                    rds.lpush('url', data)

    links = jq(htext).find("table .citytr")
    if len(links) > 0:
        for link in links:
            href = jq(link).find('a').attr('href')
            id = jq(link).find('td').eq(0).text().replace('\n', '')
            name = jq(link).find('td').eq(1).text().replace('\n', '')

            print(id, name, father_id, father_name)

            if href:
                p = ''
                if re.match(r'(\d+)/\w+\.html', href):
                    p = re.sub(r'([^/]+)/\w+\.html', "\\1", href) + "/"

                data = json.dumps({'path': path + p, 'href': href, 'father_name': name, 'father_id': id})
                if not exists(data):
                    rds.lpush('url', data)

    links = jq(htext).find("table .countytr")
    if len(links) > 0:
        for link in links:

            id = jq(link).find('td').eq(0).text().replace('\n', '')
            name = jq(link).find('td').eq(1).text().replace('\n', '')

            print(id, name, father_id, father_name)
            href = jq(link).find('a').attr('href')

            if href:
                p = ''
                if re.match(r'(\d+)/\w+\.html', href):
                    p = re.sub(r'([^/]+)/\w+\.html', "\\1", href) + "/"

                data = json.dumps({'path': path + p, 'href': href, 'father_name': name, 'father_id': id})
                if not exists(data):
                    rds.lpush('url', data)

    links = jq(htext).find("table .towntr")
    if len(links) > 0:
        for link in links:
            href = jq(link).find('a').attr('href')

            id = jq(link).find('td').eq(0).text().replace('\n', '')
            name = jq(link).find('td').eq(1).text().replace('\n', '')

            print(id, name, father_id, father_name)

            if href:
                p = ''
                if re.match(r'(\d+)/\w+\.html', href):
                    p = re.sub(r'([^/]+)/\w+\.html', "\\1", href) + "/"

                data = json.dumps({'path': path + p, 'href': href, 'father_name': name, 'father_id': id})
                if not exists(data):
                    rds.lpush('url', data)

    links = jq(htext).find("table .villagetr")
    if len(links) > 0:
        for link in links:
            id = jq(link).find('td').eq(0).text().replace('\n', '')
            name = jq(link).find('td').eq(2).text().replace('\n', '')
            print(id, name,  father_id, father_name)

# htext = do_get(base_url, 0)
# get_links(htext, '', '', '0')


while rds.llen('url') > 0:
    url = rds.lpop('url')
    print(url)
    item = json.loads(url)
    href = item['href']
    path = item['path']
    father_name = item['father_name']
    father_id = item['father_id']
    htext = do_get(base_url + path + re.sub(r'.*?([^/]+\.html)', '\\1', href), 0)
    get_links(htext, path, father_name, father_id)




