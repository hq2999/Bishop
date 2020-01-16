import base64
import socket
import sys
import time
import threading
import math
import urllib.request


def main():
    
    ix=0
    ssr_list=list()
    filename = 'data.txt'
    with open(filename) as file_object:
        for line in file_object:
            ssr_list.append(line.strip())

    for ssr_item in ssr_list:
        if len(ssr_item)==0:
            continue
        ssr_url = ssr_item
        ssr_item = ssr_item[6:]
        ssr_item = fixB64(ssr_item)
    
        ssr_item = str(base64.urlsafe_b64decode(ssr_item.strip()), "utf-8")
        #print(ssr_item)
        
        p = ssr_item.split("?")
				
        p0 = p[0].split(":")
      
        ip = p0[0]
        port = p0[1]
        ori = p0[2]
        sec = p0[3]
        plain = p0[4]
        other = p0[5]
        
        param_map = utl2map(p[1])
        remarks = param_map.get("remarks")
        group = param_map.get("group")

        checkThread(ip, port, remarks, ix, ssr_url).start()

        ix=ix+1


def fixB64(_str):

    missing_padding = 4 - len(_str) % 4
    if missing_padding<4:
        _str += '='* missing_padding

    return _str


def utl2map(_str):
    r=dict()

    params = _str.split("&")

    for parsm in params:
        p = parsm.split("=")
        r[p[0]]=str(base64.urlsafe_b64decode(fixB64(p[1])), "utf-8")
    return r

class checkThread (threading.Thread):
    def __init__(self, ip, port, title, ix, url):
        threading.Thread.__init__(self)
        self.self = self
        self.ip = ip
        self.port = port
        self.title = title
        self.ix = ix
        self.url = url
  
    def isHostConnectable(self, ip, port):
        socket.setdefaulttimeout(5)
        tcp_client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        flag=False
        try:
            tcp_client.connect((self.ip, int(self.port)))
            flag=True
        except socket.error:
           flag=False
        finally:
           tcp_client.close()
        
        return flag

    def run(self):
        t1 = time.time()
        flag = self.isHostConnectable(self.ip, self.port)

        r="True"
        if(flag==False):
            r="Flase"
        t2 = time.time()

        if(r=="True"):
            print(self.ip, self.port, self.title, math.ceil((t2-t1)*1000) , r , self.ix)
            #print(self.url)
            #print('\n')
main()


#print(datetime.datetime.now().strftime('%f')*1 - datetime.datetime.now().strftime('%f')*1)

#['remarks', 'U1NSVE9PTF_ml6XmnKwtVG9reW8tNDI2MTQ6MDI']
#['group', 'V1dXLlNTUlRPT0wuQ09N']