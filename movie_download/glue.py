import os
import re

f = open('url.txt', 'r', encoding='utf-8')
lines = f.readlines()

with open('D:\\tmp\\25.ts', 'wb') as fout:
    i = 0
    for line in lines:
        line = line.replace('\n', '')
        print(line, i)
        fin = open('D:\\tmp\\ts_list\\' + line,  "rb")
        data = fin.read()
        fout.write(data)
        fin.close()
        i = i+1



