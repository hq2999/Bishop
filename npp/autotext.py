# coding = utf-8

from Npp import *
import re
import os
import datetime

now = datetime.datetime.now()
now_str = now.strftime('%Y-%m-%d %H:%M:%S')

#all_the_text = open(os.path.abspath('.') + '\plugins\PythonScript\script_txt.py').read()
#exec(all_the_text)

try:
    currentline = editor.getCurLine()
    code = eval(currentline)
    if(len(code)>0):
        editor.lineDelete()
        editor.addText(code)
except Exception,e:
    console.write(str(e) + "\r\n")    
    

def help():
    
    d = globals()
    
    index=[]
    
    console.write('\r\n')
    
    for k in d:
        if(hasattr(d[k],'func_name')):
            index.append(k + '\r\n')
  
    index.sort()
  
    for text in index:
        console.write(text)

#----------------------------------------------txt---------------------------------------------------
      
def to_camel():
    text = editor.getSelText()
    text = text.lower()
  
    str_list = text.split("\r\n")
  
    r=""
  
    for line in str_list:
        words = line.split('_')
        for i,word in list(enumerate(words)):
            if(i>0):
                r+=word[0].upper() + word[1:]
            else:
                r+=word
      
        r+='\n'
      
 
    editor.deleteBack()  
    editor.addText(r)
      
      
def str_glue():
    text = editor.getSelText()
    str_list = text.split("\r\n")
    r=""
    for i,line in list(enumerate(str_list)):
      
        if(len(line)==0):
            continue
      
        if(i==0):
            r+= '"' + line + '"\r\n'
        else:
            r+= ' + "' + line + '"\r\n'
          
    editor.deleteBack()  
    editor.addText(r)

  
def to_m(span):
    text = editor.getSelText()
    str_list = text.split(span)
  
    r=""
  
    for i,line in list(enumerate(str_list)):
        r += line+"\r\n"
  
    editor.deleteBack()  
    editor.addText(r)
  
  
def to_l(span):  
    text = editor.getSelText()
    str_list = text.split("\r\n")
  
    r=""
  
    for i,line in list(enumerate(str_list)):
        r += line + span
  
    editor.deleteBack()  
    editor.addText(r)

  
#------------------------------------------jquery---------------------------------------------------
  
def jq_ajax():

    text = editor.getSelText()
    str_list = text.split("\r\n")
    str_list = [elem for elem in str_list if len(elem) > 0]

    r = ""
    for i,line in list(enumerate(str_list)):
        if(i<len(str_list)-1):
            r += line + ':' + '$(\'#' + line + '\').val(),\r\n'
        else:
            r += line + ':' + '$(\'#' + line + '\').val()\r\n'
          
    code = """$.post("",
        {
       """  + r + \
       """  },
       function(data){
            alert(data.name);
            console.log(data.time);
       }, "json");"""
    editor.deleteBack()  
    editor.addText(code)


def jq_checked(chks):
    code=""
    code += "var " + chks + "='';\r\n" \
    + "$(':checkbox[name=" + chks + "]:checked').each(function(){ \r\n" \
    + chks + " += $(this).val()+','; \r\n" \
    + " }); \r\n" \
    + chks + " = " + chks + ".substr(0," + chks + ".length-1);\r\n\r\n"
  
    #editor.addText(code)
    return code   
       
def jq_checkall(chka,chks):
    code = ""
    code += "$(\"#" + chka + "\").click(function(){ \r\n"
    code += "   $(\":checkbox[name=" + chks + "]\").prop(\"checked\",$(this).is(\":checked\"));  \r\n"           
    code += "});"     
    #editor.addText(code) 
    return code
   
def create_line(rng):
    p = re.compile(r'\*\d+')
    max = p.findall(rng)
    for i in eval("range(" + max[0][1:] + ")"):
        editor.addText(re.sub(p, str(i), rng) + "\r\n")


def java_readfile():
    code="""
    InputStream in = new FileInputStream(new File(""));
    byte[] buffer = new byte[2048];
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    int c = 0; 
    while ((c = in.read(buffer)) != -1) {
        if(c<2048){
            byte[] tmp_buffer = new byte[c];
            System.arraycopy(buffer, 0, tmp_buffer, 0, c );
            bout.write(tmp_buffer);
        } else {
            bout.write(buffer);
        }
    }
    bout.toByteArray();
    """
    editor.addText(code)
    

def css():
    code="""
    *{
     -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
   }

    {
     padding: 1em;
      -moz-column-count: 3;
      -moz-column-gap: 1em;
      -webkit-column-count: 3;
      -webkit-column-gap: 1em;
      column-count: 3;
      column-gap: 1em;
    }
    """
    return code
        


    


console.write(now_str + " script load completed!\r\n")
