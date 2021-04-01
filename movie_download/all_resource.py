from selenium import webdriver
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities
from selenium.webdriver.support.ui import WebDriverWait  # available since 2.4.0
from selenium.webdriver.support import expected_conditions as EC  # available since 2.26.0
import json
import re

caps = DesiredCapabilities.CHROME

caps['loggingPrefs'] = {
    'browser':'ALL',
    'performance':'ALL',
}

caps['perfLoggingPrefs'] = {
    'enableNetwork' : True,
    'enablePage' : False,
    'enableTimeline' : False
}

option = webdriver.ChromeOptions()
# option.add_argument('--no-sandbox')
option.add_argument('--headless')
# option.add_argument("--disable-extensions")
# option.add_argument("--allow-running-insecure-content")
# option.add_argument("--ignore-certificate-errors")
option.add_argument("--disable-single-click-autofill")
option.add_argument("--disable-autofill-keyboard-accessory-view[8]")
option.add_argument("--disable-full-form-autofill-ios")
option.add_argument('user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36')
option.add_experimental_option('w3c',False)
option.add_experimental_option('perfLoggingPrefs',{
    'enableNetwork': True,
    'enablePage': False,
})

def getUrl(url):
    with webdriver.Chrome(options=option, desired_capabilities=caps, executable_path=r"F:\softwares\chromedriver\chromedriver.exe") as driver:
        driver.set_page_load_timeout(20)
        driver.get(url)

        true_url = ''
        for typelog in driver.log_types:
            perfs = driver.get_log(typelog)
            for row in perfs:
                t = row['message']
                try:
                    jon = json.loads(t)
                    msg = jon['message']
                    method = msg['method']
                    if 'Network.requestWillBeSent' != method:
                        continue

                    tt = msg['params']['request']['url']

                    if re.match(r'https://zkcdn.wb699.com/2018/10/08/[^/]+/playlist.m3u8', tt):
                        true_url = tt

                except Exception as err:
                    pass

        if true_url is None or true_url == '':
            return getUrl(url)
        else:
            return true_url

# //https://v2.dious.cc/20200909/ZIylMfpv/1000kb/hls/index.m3u8

pages = """
https://www.hk7k.com/vodplay/92400/1/6.html
https://www.hk7k.com/vodplay/92400/1/5.html
https://www.hk7k.com/vodplay/92400/1/4.html
https://www.hk7k.com/vodplay/92400/1/3.html
https://www.hk7k.com/vodplay/92400/1/2.html
https://www.hk7k.com/vodplay/92400/1/1.html
"""

# for i in range(26, 39):
#     print(getUrl('http://www.vipdy1.com/play/142567-1-' + str(i) + '.html') + '  ' + str(i))

for ix, page in enumerate(pages.split('\n')):
    if len(page) == 0:
        continue

    print(str(getUrl(page)) + '  ' + '亚洲怪谈(S1)' + str(ix))

