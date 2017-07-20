public class CreateQL {
     private String sql = "";
   
     public CreateQL(String sql){
          this.sql = sql;
     }
   
     public CreateQL addCondition(String tablename, String paramStr, String param){
          if(!isNullOrEmpty(param)){
              this.sql =  this. sql + " and " + tablename + "." + paramStr + "='" + param.replaceAll("'" , "''" ) + "'" ;
          }
         return this ;
     }

     public CreateQL addFuzzyCondition(String tablename, String paramStr, String param){
          if(!isNullOrEmpty(param)){
              this.sql =  this. sql + " and " + tablename + "." + paramStr + " like '%" + param.replaceAll("'", "''") + "%'" ;
          }
         return this ;
     }
   
     public CreateQL addMultiCondition(String tablename, String paramStr, String param){
         if(!isNullOrEmpty(param)){
             this.sql =  this. sql + " and " + tablename + "." + paramStr + " in (" + wrapperList2Sql(param)+ ")" ;
         }
        return this ;
     }
    
     public CreateQL addDatetimeCondition(String tablename, String time1, String time2, String timeStr){
        
          if(!isNullOrEmpty(time1)){
              this.sql =  this. sql + " and " + tablename + "." + timeStr + ">='" + time1.replaceAll("'" , "''" ) + "'" ;
          }
        
          if(!isNullOrEmpty(time2)){
              this.sql =  this. sql + " and " + tablename + "." + timeStr + "<='" + time2.replaceAll("'" , "''" ) + "'" ;
          }
        
         return this ;
     }
   
    
    
    
     public CreateQL addForceCondition(String tablename, String paramStr, String param){
        this.sql =  this. sql + " and " + tablename + "." + paramStr + "='" + param.replaceAll("'" , "''" ) + "'" ;
        return this ;
    }

    public CreateQL addForceFuzzyCondition(String tablename, String paramStr, String param){
        this.sql =  this. sql + " and " + tablename + "." + paramStr + " like '%" + param.replaceAll("'" , "''" ) + "%'" ;
        return this ;
    }
  
    public CreateQL addForceMultiCondition(String tablename, String paramStr, String param){
       this. sql =  this.sql + " and " + tablename + "." + paramStr + " in (" + wrapperList2Sql(param)+ ")" ;
       return this;
    }
   
    public CreateQL addForceDatetimeCondition(String tablename, String time1, String time2, String timeStr){
       this. sql =  this.sql + " and " + tablename + "." + timeStr + ">='" + time1.replaceAll("'" , "''" ) + "'" ;
        this.sql =  this. sql + " and " + tablename + "." + timeStr + "<='" + time2.replaceAll("'" , "''" ) + "'" ;
        return this ;
    }
    
    
    
     public String toString(){
          return sql ;
     }
    
        private String wrapperList2Sql(String str){
               if(isNullOrEmpty(str)) return "''";
               return "'" + str.replaceAll("'", "''").replaceAll("\\s*" ,"" ).replaceAll(",", "','") + "'" ;
       }
 
        private boolean isNullOrEmpty(String str){
               if(str==null || str.length()==0){
                      return true ;
              } else {
                      return false ;
              }
       }

}
