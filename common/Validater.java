
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
     * 判断所有被验证的参数是否存在异常
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
     * 这个方法为验证时首个执行的方法，将参数名称及参数值传入
     * @param paramName 参数名称
     * @param param          参数值
     * @return
     */
     public ValidateParameter setName(String paramName, String param){
          this.paramName = paramName;
          this.param = param;
          return this ;
     }
   
   
     /**验证参数是否为null
     * @return
     */
     public ValidateParameter assertNotEmpty(String info){
          if(isEmpty(this.param)){
               setErrorInfo( this.paramName , info );
          }
          return this ;
     }
   
     /**验证参数是否匹配一个给定的正则表达式
     * @param pattern     正则表达式
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
   
   
     /**验证参数的长度
     * @param oper     判断操作符     [<,<=,>,>=,=]
     * @param len     长度值
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
     * 验证参数中是否包含一个给定的字符串
     * @param str     验证参数中包含的字符串
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
   
   
     /**验证参数中是否不包含一个给定的字符串
     * @param str     验证参数中不包含的字符串
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
   
   
     /**验证参数是否为纯数字
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
   
   
     /**验证参数是否为纯字母
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
   
     /**返回所有的验证错误信息
     * @return
     */
     public String getErrroInfo(){
          return JSON.toJSONString( errorInfo);
     }
   
   
     /**返回错误信息的Map
     * @return
     */
     public Map<String, String> getErrorMap(){
          return this .errorInfo ;
     }
   
     public void clear(){
          this.errorInfo .clear();
     }
   
     /**设置错误信息（将每条新的信息追加在原有信息的最后）
     * @param param               参数名
     * @param errorInfo      错误描述
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
          vp.setName( "a", a).assertNotEmpty("a 不能为空" );
          vp.setName( "b", b).assertAlphabet( "b 不是字母" ).assertLength("<", 3, "b 长度不小于3" ).assertNotContent("1", "b包含1").assertAlphabet( "b 不是字母" );
          vp.setName( "c", c).assertNotEmpty("c 不能为空" ).assertDigit("b 不是数字").assertContains( "c","d 包含 d" ).assertAlphabet ("不是字母" );
             
          System. out.println(vp.getErrroInfo());
                  
     }
    
 
}
