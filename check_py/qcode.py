import sys
import qrcode
import sqlite3

conn = sqlite3.connect('ssr.db', check_same_thread=False, isolation_level=None)

#if len(sys.argv)<2:
#    print("need index")
#    exit()

#ix=sys.argv[1]

ix = input("Enter ix:")

print(ix)
cursor = conn.cursor().execute("SELECT ssr from r where id='" + ix + "'").fetchone()
ssr=cursor[0]              


# 生成二维码
img = qrcode.make(data=ssr)
# 直接显示二维码
img.show()
# 保存二维码为文件
# img.save("baidu.jpg")