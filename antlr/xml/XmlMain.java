package xml;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class XmlMain {
    public static void main(String[] args) throws Exception{

        CharStream inputStream = CharStreams.fromString(
              "<xml>"
            + "<id>1</id>"
            + "<name>Li</name>"
            + "<scores>"
            + "<Chinese>95</Chinese>"
            + "<English>85</English>"
            + "</scores>"
            + "<array>"
            + "<element>1.2</element>"
            + "<element>2.0e1</element>"
            + "<element>-3</element>"
            + "</array>"
            + "</xml>"
        );

        XmlLexer lexer = new XmlLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        XmlParser parser = new XmlParser(tokenStream);
        ParseTree parseTree = parser.xml();

        ParseTreeWalker walker = new ParseTreeWalker();
        Xml2JsonListener listener = new Xml2JsonListener();
        walker.walk(listener, parseTree);
        System.out.println(parseTree);
        String xml = listener.getXml(parseTree);
        System.out.println(xml);
    }
}