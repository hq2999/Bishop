#coding:utf-8
import requests
import re
from concurrent.futures import ThreadPoolExecutor, wait, ALL_COMPLETED
import os

tmp_file_path = 'D:\\tmp\\ts_list\\'
output_file_path = 'D:\\tmp\\'

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36',
}

def get_file_list(url):
    response = requests.get(url=url, headers=headers, timeout=20)
    l1 = response.text.split('\n')
    l2 = [i for ix, i in enumerate(l1) if re.match(r'^[^#]', i)]
    return l2

def downloadFile(url, ix, times):
    try:
        matchObj = re.match(r'.*?(\w+\.ts).*', url)
        # matchObj = re.match(r'.*?([^/]+\.m4s).*', url)
        filename = matchObj.group(1)

        response_data_file = requests.get(url, stream=True, headers=headers, timeout=10)
        if response_data_file.status_code == 200:
            with open(tmp_file_path + filename, 'wb') as f:
                for chunk in response_data_file.iter_content(chunk_size=1024):
                    if chunk:
                        f.write(chunk)
            print(str(ix) + "," + url)
        else:
            if times >= 999:
                return
            print(str(ix) + "," + url, "try" + str(times + 1))
            downloadFile(url, ix, times + 1)
    except Exception as err:
        print(err)
        if times >= 999:
            return
        print(str(ix) + "," + url, "try" + str(times + 1))
        downloadFile(url, ix, times + 1)

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

def download(url, output_file_path):

    del_file(tmp_file_path)

    base_url = re.sub(r'(https?://.+?/).*', '\\1', url)
    # base_url = re.sub(r'(https?://.+/).*', '\\1', url)
    file_list = get_file_list(url)

    print('total:' + str(len(file_list)))

    with ThreadPoolExecutor(max_workers=20) as tpe:
        all_task = list()
        for ix, f in enumerate(file_list):
            if f.startswith('http'):
                all_task.append(tpe.submit(downloadFile, f, ix + 1, 0))
            else:
                all_task.append(tpe.submit(downloadFile, base_url + f, ix + 1, 0))

        wait(all_task, return_when=ALL_COMPLETED)
        print('download comeplete...')

    glue(file_list, output_file_path)
    del_file(tmp_file_path)


download('https://mhcdn.mhqiyi.com/20210331/zELSBZ18/1000kb/hls/index.m3u8', 'filename.ts')


