package mytest;

public class MyVisitor extends MyTestBaseVisitor<String> {

    @Override
    public String visitString(MyTestParser.StringContext ctx) {
        return ctx.STRING().getText();
    }

    @Override
    public String visitAllOrValue(MyTestParser.AllOrValueContext ctx) {
        String r  = "(";

        for (MyTestParser.ItemContext valueContext : ctx.item()){
            r = r + visit(valueContext) + " OR ";
        }

        r = r.replaceAll(" OR $", "");
        r = r + ")";
        return r;
    }

    @Override
    public String visitAllAndValue(MyTestParser.AllAndValueContext ctx) {
        String r  = "(";

        for (MyTestParser.ItemContext valueContext : ctx.item()){

            r = r + visit(valueContext) + " AND ";
        }

        r = r.replaceAll(" AND $", "");
        r = r + ")";
        return r;
    }
}
