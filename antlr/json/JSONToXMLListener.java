package json;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class JSONToXMLListener extends JSONBaseListener {

    private ParseTreeProperty<String> xml = new ParseTreeProperty<String>();

    public void setXml(ParseTree node, String value){
        xml.put(node, value);
    }

    public String getXml(ParseTree node){
        return xml.get(node);
    }

    /**
     * 去掉字符串首尾的双引号""
     * @param s
     * @return
     */
    public String stripQuotes(String s) {
        if ( s==null || s.charAt(0)!='"' ) return s;
        return s.substring(1, s.length() - 1);
    }


    @Override
    public void exitJson(JSONParser.JsonContext ctx) {
        setXml(ctx,getXml(ctx.getChild(0)));
    }

    @Override
    public void exitAnObject(JSONParser.AnObjectContext ctx) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (JSONParser.PairContext pairContext : ctx.pair()){
            stringBuilder.append(getXml(pairContext));
        }
        setXml(ctx,stringBuilder.toString());
    }

    @Override
    public void exitEmptyObject(JSONParser.EmptyObjectContext ctx) {
        setXml(ctx,"");
    }

    @Override
    public void exitPair(JSONParser.PairContext ctx) {
        String tag = stripQuotes(ctx.STRING().getText());
        String value = String.format("<%s>%s<%s>\n",tag,getXml(ctx.value()),tag);
        setXml(ctx,value);
    }

    @Override
    public void exitArrayOfValues(JSONParser.ArrayOfValuesContext ctx) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (JSONParser.ValueContext valueContext : ctx.value()){
            stringBuilder.append("<element>");
            stringBuilder.append(getXml(valueContext));
            stringBuilder.append("<element>");
            stringBuilder.append("\n");
        }
        setXml(ctx,stringBuilder.toString());
    }

    @Override
    public void exitEmptyArray(JSONParser.EmptyArrayContext ctx) {
        setXml(ctx,"");
    }

    @Override
    public void exitString(JSONParser.StringContext ctx) {
        setXml(ctx, stripQuotes(ctx.getText()));
    }

    @Override
    public void exitAtom(JSONParser.AtomContext ctx) {
        setXml(ctx, ctx.getText());
    }

    @Override
    public void exitObjectValue(JSONParser.ObjectValueContext ctx) {
        // 类比 String value() { return object(); }
        setXml(ctx,getXml(ctx.object()));
    }

    @Override
    public void exitArrayValue(JSONParser.ArrayValueContext ctx) {
        setXml(ctx,getXml(ctx.array()));
    }
}