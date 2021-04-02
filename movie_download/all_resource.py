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
    with webdriver.Chrome(options=option, desired_capabilities=caps, executable_path=r"D:\software\chromedriver\chromedriver.exe") as driver:
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

                    if '1000kb' in tt and 'index.m3u8' in tt:
                        true_url = tt

                except Exception as err:
                    pass

        if true_url is None or true_url == '':
            return getUrl(url)
        else:
            return true_url

# //https://v2.dious.cc/20200909/ZIylMfpv/1000kb/hls/index.m3u8

pages = """
# https://jx.618g.com/?url=https://www.iqiyi.com/v_1hgyraojqjc.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_1j7l72yty8g.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_12flj204iu4.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_23s59wf6g10.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_1ebayyi5uw4.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_18fb74d42jg.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_1bcpql0f8w8.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_1lzqp1ask64.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_2beok23sz9k.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_bbqxgb0xhg.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_1y1q7pj9e2g.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_swn163vbd4.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_1n750pqze4s.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_u53ruv8wwk.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_bzqv040sac.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_bz3qr9s50w.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_154ts7hgu0g.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_sjehvbtseg.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_1czt5zk7n14.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
# https://jx.618g.com/?url=https://www.iqiyi.com/v_10yg6sh4m28.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
https://jx.618g.com/?url=https://www.iqiyi.com/v_12r43hmhduo.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
https://jx.618g.com/?url=https://www.iqiyi.com/v_1oozhxbsw7o.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
https://jx.618g.com/?url=https://www.iqiyi.com/v_gl64o3s70w.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
https://jx.618g.com/?url=https://www.iqiyi.com/v_20pqayc135c.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
https://jx.618g.com/?url=https://www.iqiyi.com/v_n7z9bxwmv8.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
https://jx.618g.com/?url=https://www.iqiyi.com/v_u6i23bzoxs.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
https://jx.618g.com/?url=https://www.iqiyi.com/v_1v5okhg65k4.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
https://jx.618g.com/?url=https://www.iqiyi.com/v_rivz8vmg5k.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
https://jx.618g.com/?url=https://www.iqiyi.com/v_uzbhjou5nk.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
https://jx.618g.com/?url=https://www.iqiyi.com/v_1oc1t66e4tg.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
https://jx.618g.com/?url=https://www.iqiyi.com/v_2gdlipdh9cc.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
https://jx.618g.com/?url=https://www.iqiyi.com/v_26l0z0lw4w4.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
https://jx.618g.com/?url=https://www.iqiyi.com/v_1llfttieay0.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
https://jx.618g.com/?url=https://www.iqiyi.com/v_2eoguh28byg.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
https://jx.618g.com/?url=https://www.iqiyi.com/v_oln460nta0.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
https://jx.618g.com/?url=https://www.iqiyi.com/v_1o4sdpzn0tk.html?vfrm=pcw_playpage&amp;vfrmblk=D&amp;vfrmrst=80521_listbox_positive
"""

# for i in range(26, 39):
#     print(getUrl('http://www.vipdy1.com/play/142567-1-' + str(i) + '.html') + '  ' + str(i))

for ix, page in enumerate(pages.split('\n')):
    if len(page) == 0:
        continue

    if page.startswith('#'):
        ix = ix + 1
        continue

    print(str(getUrl(page)) + '  ' + '终级笔记' + str(ix))

