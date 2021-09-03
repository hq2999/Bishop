package mytest;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class MyListener extends MyTestBaseListener {

    private ParseTreeProperty<String> expr = new ParseTreeProperty<String>();

    public void setXml(ParseTree node, String value){
        expr.put(node, value);
    }

    public String getXml(ParseTree node){
        return expr.get(node);
    }


    @Override
    public void exitExpr(MyTestParser.ExprContext ctx) {
        setXml(ctx, getXml(ctx.getChild(0)));
    }

    @Override
    public void exitAndValue(MyTestParser.AndValueContext ctx) {

        setXml(ctx, getXml(ctx.and()));
    }

    @Override
    public void exitOrValue(MyTestParser.OrValueContext ctx) {

        setXml(ctx, getXml(ctx.or()));
    }

    @Override
    public void exitString(MyTestParser.StringContext ctx) {
        setXml(ctx, ctx.STRING().getText());
    }

    @Override
    public void exitAllOrValue(MyTestParser.AllOrValueContext ctx) {
        String r  = "(";

        for (MyTestParser.ItemContext valueContext : ctx.item()){
            r = r + getXml(valueContext) + " OR ";
        }

        r = r.replaceAll(" OR $", "");
        r = r + ")";
        setXml(ctx, r);
    }

    @Override
    public void exitAllAndValue(MyTestParser.AllAndValueContext ctx) {
        String r  = "(";

        for (MyTestParser.ItemContext valueContext : ctx.item()){
            r = r + getXml(valueContext) + " AND ";
        }

        r = r.replaceAll(" AND $", "");
        r = r + ")";
        setXml(ctx, r);
    }

}