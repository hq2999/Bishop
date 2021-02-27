from pyquery import PyQuery as pq
import json

qualityLabel = '720p'
with open("html.txt", "r", encoding="utf-8") as f:
    scripts = pq(f.read()).find('script')
    for script in scripts:
        if 'videoplayback' in pq(script).text():
            js_var = pq(script).html()
            js_var = js_var.split('ytInitialPlayerResponse = ')[1]
            js_var = js_var.split(';var')[0]
            json = json.loads(js_var)
            urls = json['streamingData']['formats']
            for url in urls:
                if 'qualityLabel' in url and url['qualityLabel'] == qualityLabel:
                    print(url['url'])


