package json;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class JSONMain {
    public static void main(String[] args) throws Exception{
//        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\RSVPTECH\\test_temp\\src\\main\\resources\\json.txt"));
//        ANTLRInputStream inputStream = new ANTLRInputStream(reader);
        CharStream inputStream = CharStreams.fromFileName("C:\\Users\\RSVPTECH\\test_temp\\src\\main\\resources\\json.txt");

        JSONLexer lexer = new JSONLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokenStream);
        ParseTree parseTree = parser.json();
//        System.out.println(parseTree.toStringTree());
//
        ParseTreeWalker walker = new ParseTreeWalker();
        JSONToXMLListener listener = new JSONToXMLListener();
        walker.walk(listener, parseTree);
        System.out.println(parseTree);
        String xml = listener.getXml(parseTree);
        System.out.println(xml);
    }
}