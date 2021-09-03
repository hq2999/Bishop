package assign;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class AssignMain {
    public static void run(String expr) throws Exception{
        // 新建一个CharStream，读取数据
//        ANTLRInputStream input = new ANTLRInputStream(expr);

        CharStream input = CharStreams.fromString(expr);

        // 新建一个词法分析器，处理输入的字符流CharStream
        AssignLexer lexer = new AssignLexer(input);

        // 新建一个词法符号的缓冲区，用于存储词法分析器生成的词法符号（Token）
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // 新建一个语法分析器，用于分析词法符号缓冲区中的词法符号
        AssignParser parser = new AssignParser(tokens);
        // 对assign规则进行语法分析，生成语法分析树
        ParseTree tree = parser.assign();
        // 使用LISP风格打印生成的树
        System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        MyListener listener = new MyListener();
        walker.walk(listener, tree);

    }

    public static void main(String[] args) throws Exception{
        run("sp = 100;");
    }
}
