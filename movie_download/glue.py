import os
import re

f = open('url.txt', 'r', encoding='utf-8')
lines = f.readlines()

file_name = 'db'

with open('D:\\tmp\\' + file_name + '.ts', 'wb') as fout:
    i = 0
    for line in lines:
        line = line.replace('\n', '')
        print(line, i)

        if os.path.exists('D:\\tmp\\ts_list\\out\\' + file_name + '\\' + line):
            fin = open('D:\\tmp\\ts_list\\out\\' + file_name + '\\' + line,  "rb")
            data = fin.read()
            fout.write(data)
            fin.close()
            i = i+1



