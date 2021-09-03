package exprtest;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class ExprTestMain {
    public static void main(String[] args){

        CharStream inputStream = CharStreams.fromString("(1+2)*3+4");

        ExprTestLexer lexer = new ExprTestLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ExprTestParser parser = new ExprTestParser(tokenStream);
        ParseTree parseTree = parser.cal();
        System.out.println(parseTree.toStringTree(parser));

        CalculatorVisitor visitor = new CalculatorVisitor();
        int result = visitor.visit(parseTree);
        System.out.println("Visitor calculate result: "+result);
    }
}