from concurrent.futures import ThreadPoolExecutor
import threading, time
import socket
import requests
import re

headers = {
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
        "Accept-Language": "zh-CN,zh;q=0.9",
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36",
        # "Cookie": "_trs_uv=kgsro796_6_jeik; SF_cookie_1=72991020; wzws_cid=5c33478df51a25eaa2471741d49cf7e9ea4a6dcd5022b3f3fee31e044ab97e18071993ed5e75b3650bc41ea5075128be0ee9c8d60f6f6ec2d171cec241cb7f0c3125526e07322f877de12cf6b505e6df; _trs_ua_s_1=kjnvw9j7_6_id4b",
    }

def is_enable1(proxy_addr):
    proxies = {
        'http': proxy_addr,
        'https': proxy_addr,
    }

    try:
        requests.adapters.DEFAULT_RETRIES = 5
        s = requests.session()
        s.keep_alive = False
        res = s.get(url='https://www.ip.cn/api/index?ip=&type=0', headers=headers, timeout=5, proxies=proxies)
        res.encoding = res.apparent_encoding

        if proxy_addr.split(":")[0] in res.text:
            print(proxy_addr)
    except Exception as err:
        print(err)

def is_enable2(proxy_addr):
    proxies = {
        'http': proxy_addr,
        'https': proxy_addr,
    }
    try:
        s = requests.session()
        s.keep_alive = False
        res = s.get(url='http://gangkou.00cha.net/gj_china.html', headers=headers, timeout=5, proxies=proxies)
        res.encoding = res.apparent_encoding
        # print(res.text)
        if 'cha.net' in res.text:
            print(proxy_addr)
    except Exception as err:
        pass
        # print(err)

def is_enable(ip, port):
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.settimeout(1)

    try:
        s.connect((ip, int(port)))
        s.shutdown(2)

        print(ip + ":" + port)
    except Exception as err:
        # print(ip + ":" + port + ":" + "fail")
        pass

thread_pool = ThreadPoolExecutor(20)

with open('proxy_list_for_test.txt', 'r') as proxy_file:
    l = proxy_file.readlines()
    proxy_list = [item.replace('\n', '') for item in l]

    for item in proxy_list:
        i = item.split(":")
        # is_enable2(item)
        # thread_pool.submit(is_enable, i[0], i[1])
        # thread_pool.submit(is_enable1, item)
        thread_pool.submit(is_enable2, item)


