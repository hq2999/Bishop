import base64
import socket
import sys
import time
import threading
import math
import urllib.request

import sqlite3

conn = sqlite3.connect('ssr.db', check_same_thread=False, isolation_level=None)
c = conn.cursor()

def main():
    urls = [
            "https://muma16fx.netlify.com/",
            "https://git.io/autossr_recent"
           ]
           
    ssr_list = []
    for url in urls:

        headers = {'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0'}  
        req = urllib.request.Request(url=url, headers=headers)
        html = '';
        
        try:
            html = urllib.request.urlopen(req, timeout=30).read()
        except socket.error:
           continue
        
        if len(html)>0:
            html = urllib.request.urlopen(req, timeout=30).read()
            html  = fixB64(html.decode())
            #print(html)

            code_str = str(base64.urlsafe_b64decode(html), "utf-8")
            #print(code_str)

            ssr_list = code_str.split("\n")
            
            for ssr_item in ssr_list:
                if len(ssr_item)==0:
                    continue
                ssr_url = ssr_item
                 
                ssr_item = ssr_item[6:]
                ssr_item = fixB64(ssr_item)
                ssr_item = str(base64.urlsafe_b64decode(ssr_item.strip()), "utf-8") 
            
                now = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())
                
                cursor = c.execute("SELECT count(*) from r where ssr='" + ssr_url + "'").fetchone()
                
                p = ssr_item.split("?")   
                p0 = p[0].split(":")
              
                ip = p0[0]
                port = p0[1]
                ori = p0[2]
                sec = p0[3]
                plain = p0[4]
                other = p0[5]
                param_map = url2map(p[1])
                remarks = param_map.get("remarks")
                group = param_map.get("group")          
                
                if int(cursor[0])==0:
                    c.execute("INSERT INTO r (title,createtime,source_url,ssr) VALUES ('" + remarks + "', '"+ now +"', '" + url + "','"+ ssr_url +"')");
                    #conn.commit()

    cursor = c.execute("SELECT id,ssr from r")
    for row in cursor: 
        ix = row[0]
        ssr_url = row[1]
        ssr_item = row[1][6:]
        ssr_item = fixB64(ssr_item)
    
        ssr_item = str(base64.urlsafe_b64decode(ssr_item.strip()), "utf-8")
        
        p = ssr_item.split("?")
                
        p0 = p[0].split(":")
      
        ip = p0[0]
        port = p0[1]
        ori = p0[2]
        sec = p0[3]
        plain = p0[4]
        other = p0[5]
        param_map = url2map(p[1])
        remarks = param_map.get("remarks")
        group = param_map.get("group")                
        
        checkThread(ip, port, remarks, ix, ssr_url, conn).start() 

    
    
def fixB64(_str):

    missing_padding = 4 - len(_str) % 4
    if missing_padding<4:
        _str += '='* missing_padding

    return _str


def url2map(_str):
    r=dict()

    params = _str.split("&")

    for parsm in params:
        p = parsm.split("=")
        r[p[0]]=str(base64.urlsafe_b64decode(fixB64(p[1])), "utf-8")
    return r

class checkThread (threading.Thread):
    def __init__(self, ip, port, title, ix, url, conn):
        threading.Thread.__init__(self)
        self.self = self
        self.ip = ip
        self.port = port
        self.title = title
        self.ix = ix
        self.url = url
        self.conn=conn
  
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
    
        now = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())
        self.conn.cursor().execute("update r set testtime='"+now+"' where id='"+str(self.ix)+"'")
    
        t1 = time.time()
        flag = self.isHostConnectable(self.ip, self.port)

        r="True"
        if(flag==False):
            r="Flase"
        t2 = time.time()

        if(r=="True"):
            delay = str(math.ceil((t2-t1)*1000))
            now = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())
            self.conn.cursor().execute("update r set delay='"+delay+"' where id='"+str(self.ix)+"'")
            print(self.title, 'delay:' + delay , "ix:" + str(self.ix))
            #self.conn.commit()

main()
#conn.close()
    

#print(datetime.datetime.now().strftime('%f')*1 - datetime.datetime.now().strftime('%f')*1)

#['remarks', 'U1NSVE9PTF_ml6XmnKwtVG9reW8tNDI2MTQ6MDI']
#['group', 'V1dXLlNTUlRPT0wuQ09N']