package mytest;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MyTestMain {
    public static void main(String[] args){

//        CharStream inputStream = CharStreams.fromString("[a,b,c,(d,e,[x,y,z],f)]");
//
//        MyTestLexer lexer = new MyTestLexer(inputStream);
//        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//        MyTestParser parser = new MyTestParser(tokenStream);
//        ParseTree parseTree = parser.expr();
//
//        ParseTreeWalker walker = new ParseTreeWalker();
//        MyListener listener = new MyListener();
//        walker.walk(listener, parseTree);
//        String result = listener.getXml(parseTree);
//        System.out.println("");
//        System.out.println(result);

        CharStream inputStream = CharStreams.fromString("[a,b,c,(d,e,[x,y,z],f)]");
        MyTestLexer lexer = new MyTestLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        MyTestParser parser = new MyTestParser(tokenStream);
        ParseTree parseTree = parser.expr();
        MyVisitor visitor = new MyVisitor();
        String result = visitor.visit(parseTree);
        System.out.println();
        System.out.println(result);

    }
}