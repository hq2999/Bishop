import os
import re

base_path = 'D:\\tmp\\'

for i in range(7, 11):
    file_name = "zzbj" + str(i)

    f = open(base_path + 'ts_list\\' + file_name + '.filelist.txt', 'r', encoding='utf-8')
    lines = f.readlines()

    with open(base_path + file_name + '.ts', 'wb') as fout:
        i = 0
        for line in lines:
            line = line.replace('\n', '')
            print(line, i)

            if os.path.exists(base_path + 'ts_list\\out\\' + file_name + '\\' + line):
                fin = open(base_path + 'ts_list\\out\\' + file_name + '\\' + line,  "rb")
                data = fin.read()
                fout.write(data)
                fin.close()
                i = i+1
