grammar Assign;
stat : assign;
assign : ID '=' expr ';'
 | ID ':=' expr ';' ;
ID : [a-z]+ ;
expr : NUMBER {System.out.println("found a decl");} ;
NUMBER : [1-9][0-9]*|[0]|([0-9]+[.][0-9]+) ;
WS : [ \t\r\n]+ -> skip ;
