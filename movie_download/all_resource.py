from selenium import webdriver
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities
from selenium.webdriver.support.ui import WebDriverWait  # available since 2.4.0
from selenium.webdriver.support import expected_conditions as EC  # available since 2.26.0
import json

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

        driver.get(url)

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

                    url = msg['params']['request']['url']

                    if '1200kb/hls/index.m3u8' in url:
                        return url

                except Exception as err:
                    # print(err)
                    pass

for i in range(26, 39):
    print(getUrl('http://www.vipdy1.com/play/142567-1-' + str(i) + '.html') + '  ' + str(i))
