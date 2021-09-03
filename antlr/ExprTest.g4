grammar ExprTest;
 
cal : expr;
 
expr : expr MUL expr    # Mul
     | expr ADD expr    # Add
     | expr SUB expr    # Sub
     | INT              # Int
     | '(' expr ')'     # Exp
     ;

MUL : '*';
ADD : '+';
SUB : '-';
 
INT : '0' | [1-9][0-9]*;
NEWLINE : '\r'?'\n';
 
WS : [ \t\n] -> skip;
