#coding:utf-8
import requests
import re
from concurrent.futures import ThreadPoolExecutor, wait, ALL_COMPLETED
import os
from pathlib import Path

tmp_file_path = 'D:\\tmp\\ts_list\\'
output_file_path = 'D:\\tmp\\'

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36',
}

def get_file_list(url, file_name):
    response = requests.get(url=url, headers=headers, timeout=30)
    l1 = response.text.split('\n')

    burl = re.sub(r'(https?://[^/]+).*', '\\1', url)

    for l in l1:
        if 'EXT-X-KEY' in l:
            key_url = re.sub(r'.*"(.+)".*', '\\1', l)

            if key_url.startswith('http'):
                resp = requests.get(key_url, stream=True, headers=headers, timeout=10)
            else:
                resp = requests.get(burl + '/' + key_url, stream=True, headers=headers, timeout=10)

            with open(tmp_file_path + file_name + '.key.txt', 'w') as f_url:
                f_url.write(resp.text.encode().hex())

            break

    l2 = [i for ix, i in enumerate(l1) if re.match(r'^[^#]', i)]

    l3 = [re.sub(r'.*?([^/]+\.\w+)$', '\\1', i) for i in l2]

    with open(tmp_file_path + file_name + '.filelist.txt', 'w') as f_url:
        f_url.write('\n'.join(l3))

    return l2

def downloadFile(url, ix, times, file_name):
    try:
        matchObj = re.match(r'.*?(\w+\.ts).*', url)
        # matchObj = re.match(r'.*?([^/]+\.m4s).*', url)
        filename = matchObj.group(1)

        response_data_file = requests.get(url, stream=True, headers=headers, timeout=10)
        if response_data_file.status_code == 200:
            my_file = Path(tmp_file_path + file_name)
            if not my_file.exists():
                os.makedirs(tmp_file_path + file_name)

            with open(tmp_file_path + file_name + '\\' + filename, 'wb') as f:
                for chunk in response_data_file.iter_content(chunk_size=1024):
                    if chunk:
                        f.write(chunk)
            print(str(ix) + "," + filename)
        else:
            if times >= 999:
                return
            print(str(ix) + "," + filename, "try" + str(times + 1))
            downloadFile(url, ix, times + 1, file_name)
    except Exception as err:
        print(err)
        if times >= 999:
            return
        print(str(ix) + "," + filename, "try" + str(times + 1))
        downloadFile(url, ix, times + 1, file_name)

def glue(file_list, out_filename):
    print('gluing...')

    fout = open(output_file_path + out_filename, 'wb')

    for ix, f in enumerate(file_list):
        f = re.sub(r'.*?([^/]+\.\w+)$', '\\1', f)
        print(f, ix)
        fin = open(tmp_file_path + f,  "rb")
        data = fin.read()
        fout.write(data)
        fin.close()
    fout.close()
    print('gluing complete...')

def del_file(file_path):
    for i in os.listdir(file_path):
        path = file_path + i
        if os.path.isfile(path) == True:
            os.remove(path)


def download(url, file_name):

    base_url = re.sub(r'(https?://.+?/).*', '\\1', url)
    file_list = get_file_list(url, file_name)

    print('total:' + str(len(file_list)))

    with ThreadPoolExecutor(max_workers=20) as tpe:
        all_task = list()
        for ix, f in enumerate(file_list):
            if f.startswith('http'):
                all_task.append(tpe.submit(downloadFile, f, ix + 1, 0, file_name))
            else:
                all_task.append(tpe.submit(downloadFile, base_url + '/' + f, ix + 1, 0, file_name))

        wait(all_task, return_when=ALL_COMPLETED)
        print('download comeplete...')

# download('https://v3.dious.cc/20201210/LOflchP0/1000kb/hls/index.m3u8', 'zzbj1')
# download('https://v3.dious.cc/20201210/2kDn7ttH/1000kb/hls/index.m3u8', 'zzbj2')
# download('https://v3.dious.cc/20201210/bXgNE4qU/1000kb/hls/index.m3u8', 'zzbj3')
# download('https://v3.dious.cc/20201210/b226DSPS/1000kb/hls/index.m3u8', 'zzbj4')
# download('https://v3.dious.cc/20201210/5e4xUbwG/1000kb/hls/index.m3u8', 'zzbj5')
# download('https://v3.dious.cc/20201210/YwgbN5PW/1000kb/hls/index.m3u8', 'zzbj6')
download('https://v3.dious.cc/20201210/FA95ijYm/1000kb/hls/index.m3u8', 'zzbj7')
download('https://v3.dious.cc/20201210/7MCEevFl/1000kb/hls/index.m3u8?_t=1616866527727', 'zzbj8')
download('https://v3.dious.cc/20201211/ZvM22mwr/1000kb/hls/index.m3u8', 'zzbj9')
download('https://v3.dious.cc/20201211/TgmmVO2W/1000kb/hls/index.m3u8', 'zzbj10')
download('https://v3.dious.cc/20201212/CceyjUr2/1000kb/hls/index.m3u8', 'zzbj11')
download('https://v3.dious.cc/20201212/Uk05U5oY/1000kb/hls/index.m3u8', 'zzbj12')
download('https://v3.dious.cc/20201217/x0B1FfbQ/1000kb/hls/index.m3u8', 'zzbj13')
download('https://v3.dious.cc/20201217/wwdStcUZ/1000kb/hls/index.m3u8', 'zzbj14')
download('https://v3.dious.cc/20201218/8dpzjr9t/1000kb/hls/index.m3u8', 'zzbj15')
download('https://v3.dious.cc/20201218/k6lKyckN/1000kb/hls/index.m3u8', 'zzbj16')
download('https://v3.dious.cc/20201219/QYm7hnyH/1000kb/hls/index.m3u8', 'zzbj17')
download('https://v3.dious.cc/20201219/dFvfDk8H/1000kb/hls/index.m3u8', 'zzbj18')
download('https://v3.dious.cc/20201224/Lob3pPuk/1000kb/hls/index.m3u8', 'zzbj19')
download('https://v3.dious.cc/20201224/SBUgPPHM/1000kb/hls/index.m3u8', 'zzbj20')
download('https://v3.dious.cc/20201225/sic8zCFG/1000kb/hls/index.m3u8?_t=1616864835905', 'zzbj21')
download('https://v3.dious.cc/20201225/EBJG3Bcw/1000kb/hls/index.m3u8', 'zzbj22')
download('https://v3.dious.cc/20201226/1YM3VdGQ/1000kb/hls/index.m3u8?skipl=1', 'zzbj23')
download('https://v3.dious.cc/20201226/XNA6XvN9/1000kb/hls/index.m3u8', 'zzbj24')
download('https://v3.dious.cc/20201231/scV3pVK4/1000kb/hls/index.m3u8', 'zzbj25')
download('https://v3.dious.cc/20201231/zgA6zC4r/1000kb/hls/index.m3u8', 'zzbj26')
download('https://v3.dious.cc/20210101/A0NIVkLX/1000kb/hls/index.m3u8', 'zzbj27')
download('https://v3.dious.cc/20210101/zlrWRaTG/1000kb/hls/index.m3u8', 'zzbj28')
download('https://v3.dious.cc/20210102/7PpoLOAs/1000kb/hls/index.m3u8', 'zzbj29')
download('https://v3.dious.cc/20210102/mZ7qM9Ul/1000kb/hls/index.m3u8', 'zzbj30')
download('https://v3.dious.cc/20210102/jA95XYyb/1000kb/hls/index.m3u8', 'zzbj31')
download('https://v3.dious.cc/20210102/ilp4U5EW/1000kb/hls/index.m3u8', 'zzbj32')
download('https://v3.dious.cc/20210102/xQKNECTW/1000kb/hls/index.m3u8', 'zzbj33')
download('https://v3.dious.cc/20210102/QlAvcfcl/1000kb/hls/index.m3u8', 'zzbj34')
download('https://v3.dious.cc/20210102/XbM5iNG6/1000kb/hls/index.m3u8', 'zzbj35')
download('https://v3.dious.cc/20210102/JUdAXYCc/1000kb/hls/index.m3u8', 'zzbj36')

