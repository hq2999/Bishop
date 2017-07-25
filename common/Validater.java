
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
* 
*           String a = null;
*          String b = "123";
*          String c = "abc";
*          ValidateParameter vp = new ValidateParameter();
*          vp.setName("a", a).vNull();
*          vp.setName("b", b).vNull().vAlphabet().vLength("<", 3).vNotContent("1");
*          vp.setName("c", c).vNull().vDigit().vContains("d");
*        
*
*/

public class ValidateParameter {
     private String param = null ;
     private Map<String, String> errorInfo = new HashMap<String, String>();
     private String paramName;
   
     /**
     * �ж����б���֤�Ĳ����Ƿ�����쳣
     * @return
     */
     public boolean hasError(){
          if(this .errorInfo .keySet().size()>0){
               return true ;
          } else {
               return false ;
          }
     }

     /**
     * �������Ϊ��֤ʱ�׸�ִ�еķ��������������Ƽ�����ֵ����
     * @param paramName ��������
     * @param param          ����ֵ
     * @return
     */
     public ValidateParameter setName(String paramName, String param){
          this.paramName = paramName;
          this.param = param;
          return this ;
     }
   
   
     /**��֤�����Ƿ�Ϊnull
     * @return
     */
     public ValidateParameter assertNotEmpty(String info){
          if(isEmpty(this.param)){
               setErrorInfo( this.paramName , info );
          }
          return this ;
     }
   
     /**��֤�����Ƿ�ƥ��һ��������������ʽ
     * @param pattern     ������ʽ
     * @return
     */
     public ValidateParameter assertMatch(String pattern, String info){
       if( this.param !=null){ 
             if(!this .param .matches(pattern)){
                   setErrorInfo( this.paramName , info);
               }
       }
         return this ;
     }
   
   
     /**��֤�����ĳ���
     * @param oper     �жϲ�����     [<,<=,>,>=,=]
     * @param len     ����ֵ
     * @return
     */
     public ValidateParameter assertLength(String oper, int len, String info){
        
          if (this .param !=null) {

               if (!oper.matches("[\\<\\>\\=]+" )) {
                    setErrorInfo( "ValidateParameter.class", "oper's pattern error: is not match [<>=]");
               }

               if (">" .equals(oper)) {
                    if (!(this .param .length() > len)) {
                         setErrorInfo( this.paramName , info);
                    }
               }

               if (">=" .equals(oper)) {
                    if (!(this .param .length() >= len)) {
                         setErrorInfo( this.paramName , info);
                    }
               }

               if ("<" .equals(oper)) {
                    if (!(this .param .length() < len)) {
                         setErrorInfo( this.paramName , info);
                    }
               }

               if ("<=" .equals(oper)) {
                    if (!(this .param .length() <= len)) {
                         setErrorInfo( this.paramName , info);
                    }
               }

               if ("=" .equals(oper)) {
                    if (!(this .param .length() == len)) {
                         setErrorInfo( this.paramName , info);
                    }
               }
          }

          return this ;
     }

   
     /**
     * ��֤�������Ƿ����һ���������ַ���
     * @param str     ��֤�����а������ַ���
     * @return ValidateParameter
     */
     public ValidateParameter assertContains(String str, String info){
          if(this .param !=null){
               if(!this .param .contains(str)){
                    setErrorInfo( this.paramName , info);
               }
          }
          return this ;
     }
   
   
     /**��֤�������Ƿ񲻰���һ���������ַ���
     * @param str     ��֤�����в��������ַ���
     * @return
     */
     public ValidateParameter assertNotContent(String str, String info){
          if(this .param !=null){
               if(this .param .contains(str)){
                    setErrorInfo( this.paramName , info);
               }
          }
          return this ;
     }
   
   
     /**��֤�����Ƿ�Ϊ������
     * @return
     */
     public ValidateParameter assertDigit(String info){
          if(this .param !=null){
               if(!this .param .matches("^\\d+$")){
                    setErrorInfo( this.paramName , info);
               }
          }
          return this ;
     }
   
   
     /**��֤�����Ƿ�Ϊ����ĸ
     * @return
     */
     public ValidateParameter assertAlphabet(String info){
          if(this .param !=null){
               if(!this .param .matches("^[A-Z|a-z]+$")){
                    setErrorInfo( this.paramName , info);
               }
          }
          return this ;
     }
   
     /**�������е���֤������Ϣ
     * @return
     */
     public String getErrroInfo(){
          return JSON.toJSONString( errorInfo);
     }
   
   
     /**���ش�����Ϣ��Map
     * @return
     */
     public Map<String, String> getErrorMap(){
          return this .errorInfo ;
     }
   
     public void clear(){
          this.errorInfo .clear();
     }
   
     /**���ô�����Ϣ����ÿ���µ���Ϣ׷����ԭ����Ϣ�����
     * @param param               ������
     * @param errorInfo      ��������
     */
     private void setErrorInfo(String param, String errorInfo){
          if(param!=null){
               String oldInfo = this.errorInfo .get(param);
             
               if(oldInfo==null) {
                    this.errorInfo .put(param, errorInfo);
               } else {
                    this.errorInfo .put(param, oldInfo + "," + errorInfo);
               }   
          }
     }
    
     private boolean isEmpty(String str){
       return (str== null || str.length()==0);
     }
    
     public static void main(String[] args) {
          String a = null;
          String b = null;
          String c = "abc";
          ValidateParameter vp = new ValidateParameter();
          vp.setName( "a", a).assertNotEmpty("a ����Ϊ��" );
          vp.setName( "b", b).assertAlphabet( "b ������ĸ" ).assertLength("<", 3, "b ���Ȳ�С��3" ).assertNotContent("1", "b����1").assertAlphabet( "b ������ĸ" );
          vp.setName( "c", c).assertNotEmpty("c ����Ϊ��" ).assertDigit("b ��������").assertContains( "c","d ���� d" ).assertAlphabet ("������ĸ" );
             
          System. out.println(vp.getErrroInfo());
                  
     }
    
 
}
