grammar Xml;

// 一个JSON文件可以是一个对象，或者是由若干个值组成的数组
xml : '<xml>' element+ '</xml>'
    ;

// 一个对象是一组无序的键值对集合。一个对象以一个左花括号{开始，且以右花括号}结束。
// 每个键后跟一个冒号：，键值对之间由逗号,分隔
element : '<' STRING '>' value '</' STRING'>' #ObjectofValue
       | '<' STRING '>' element* '</' STRING'>' #ObjectofValue
       ;


value : STRING  #String
      | NUMBER  #Atom
      ;

// 一个字符串就是一个由零个或多个Unicode字符组成的序列，它由双引号包围，其中的字符使用反斜杠转义。
// 单个字符由长度为1的字符串表示
STRING :  (ESC | [0-9a-zA-Z])*;
fragment ESC : '\\' (["\\/bfnrt] | UNICODE);
fragment UNICODE : 'u' HEX HEX HEX HEX;
fragment HEX : [0-9a-fA-F];
// 一个数字和C/Java中的数字非常相似，除了一点之外：不允许使用八进制和十六进制
NUMBER
    :   '-'? INT '.' [0-9]+ EXP? // 1.35, 1.35E-9, 0.3, -4.5
    |   '-'? INT EXP             // 1e10 -3e4
    |   '-'? INT                 // -3, 45
    ;
fragment INT :   '0' | [1-9] [0-9]* ; // no leading zeros
fragment EXP :   [Ee] [+\-]? INT ; // \- since - means "range" inside [...]
WS  :   [ \t\n\r]+ -> skip ;
