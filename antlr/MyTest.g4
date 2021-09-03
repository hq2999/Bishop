grammar MyTest;

expr : or
     | and
     ;

or : '[' item  (',' item)+ ']' #AllOrValue
   ;

and : '(' item  (',' item)+ ')' #AllAndValue
    ;

item : STRING  #String
     | and     #AndValue
     | or      #OrValue
     ;

STRING : [a-zA-Z]+
       ;


