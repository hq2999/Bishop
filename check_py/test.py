import qrcode

# 二维码内容
data = "https://www.baidu.com"
# 生成二维码
img = qrcode.make(data=data)
# 直接显示二维码
img.show()
# 保存二维码为文件
# img.save("baidu.jpg")