import redis
import requests
import json
import re
from pyquery import PyQuery as pq
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

rds = redis.Redis(host='localhost', port=6379, decode_responses=True)

pu = ProxyUtils(10000)

def exists(content):
    lst = rds.lrange('url', 0, rds.llen('url'))
    for item in lst:
        if content == item:
            return True
    return False


def do_request(url, proxy_addr):
    try:
        proxies = {
            'http': proxy_addr,
            'https': proxy_addr,
        }

        s = requests.session()
        s.keep_alive = False
        res = s.get(url=url, headers=headers, timeout=5, proxies=proxies)
        res.encoding = res.apparent_encoding

        if 'cha.net' not in res.text:
            raise Exception("proxy content error")

        result = res.text
        result = re.sub('[\\uf000-\\uffff]', '', result)
        return result

    except Exception as err:
        return ''

def do_get(url, count):
    time.sleep(random.randint(999, 3999) / 1000)

    proxy_addr = pu.get_random_proxy()
    r = do_request(url, proxy_addr)

    c = 0

    while len(r) == 0 and c < count:
        print("do_get" + "  " + proxy_addr + ' ' + str(c + 1) + "  " + url)
        # pu.remove(proxy_addr)
        proxy_addr = pu.get_random_proxy()
        r = do_request(url, proxy_addr)
        c = c + 1

    pu.refresh(proxy_addr)
    return r


def get_links(htext):

    if '详细介绍页面' not in htext:
        trs = pq(htext).find('.tablea').find('tr')
        for tr in trs:
            href = pq(tr).find('td').find('a').attr('href')
            if href:
                rds.lpush('url', href)

    if '详细介绍页面' in htext:
        tb = pq(htext).find('.tablea')
        tr0 = tb.find('tr').eq(0)
        tr1 = tb.find('tr').eq(1)
        tr2 = tb.find('tr').eq(2)
        tr3 = tb.find('tr').eq(3)
        tr4 = tb.find('tr').eq(4)

        port_code = tr0.find('td').eq(1).text()
        city = tr0.find('td').eq(3).text()

        city_cn = re.split('\\s+(?=[\\u4e00-\\u9fff])', city)[1]
        city_en = re.split('\\s+(?=[\\u4e00-\\u9fff])', city)[0]

        port_name_cn = tr1.find('td').eq(1).text()
        port_name_en = tr1.find('td').eq(3).text()

        nation = tr2.find('td').eq(1).text()
        area = tr2.find('td').eq(3).text()

        nation_cn = re.split('(?<=[\\u4e00-\\u9fff])\\s+', nation)[0]
        nation_en = re.split('(?<=[\\u4e00-\\u9fff])\\s+', nation)[1]

        line_code_cn = tr3.find('td').eq(1).text()
        line_code_en = tr3.find('td').eq(3).text()

        anchorage = tr4.find('td').eq(1).text()
        port_type = tr4.find('td').eq(3).text()

        print(port_code + "," + city_cn + "," + city_en + "," + port_name_cn + ","
              + port_name_en + "," + nation_cn + "," + nation_en + "," + line_code_cn + ","
              + line_code_en + "," + anchorage + "," + port_type)

base_url = 'http://gangkou.00cha.net/'

while rds.llen('url') > 0:

    url = rds.lpop('url')
    print(url)
    htext = do_get(base_url + url, 15)

    while len(htext) == 0:
        url = rds.lpop('url')
        print(url)
        htext = do_get(base_url + url, 15)

    get_links(htext)


