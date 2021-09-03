package xml;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Xml2JsonListener extends XmlBaseListener {
    // 将每棵子树翻译完的字符串存储在该子树的根节点中
    private ParseTreeProperty<String> xml = new ParseTreeProperty<String>();

    public void setXml(ParseTree node, String value){
        xml.put(node, value);
    }

    public String getXml(ParseTree node){
        return xml.get(node);
    }


    @Override
    public void enterXml(XmlParser.XmlContext ctx) {

    }

    @Override
    public void exitXml(XmlParser.XmlContext ctx) {

    }

    @Override
    public void enterObjectofValue(XmlParser.ObjectofValueContext ctx) {

    }

    @Override
    public void exitObjectofValue(XmlParser.ObjectofValueContext ctx) {
        System.out.println(ctx.STRING());
    }

    @Override
    public void enterString(XmlParser.StringContext ctx) {
        System.out.println(ctx.STRING());
    }

    @Override
    public void exitString(XmlParser.StringContext ctx) {

    }

    @Override
    public void enterAtom(XmlParser.AtomContext ctx) {

    }

    @Override
    public void exitAtom(XmlParser.AtomContext ctx) {
        System.out.println(ctx.NUMBER());
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode node) {

    }

    @Override
    public void visitErrorNode(ErrorNode node) {

    }
}