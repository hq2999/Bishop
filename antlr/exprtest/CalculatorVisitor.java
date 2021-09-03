package exprtest;

public class CalculatorVisitor extends ExprTestBaseVisitor<Integer> {

    @Override
    public Integer visitAdd(ExprTestParser.AddContext ctx) {
        return visit(ctx.expr(0)) + visit(ctx.expr(1));
    }

    @Override
    public Integer visitMul(ExprTestParser.MulContext ctx) {
        return visit(ctx.expr(0)) * visit(ctx.expr(1));
    }

    @Override
    public Integer visitInt(ExprTestParser.IntContext ctx) {
        // return int value
        return Integer.valueOf(ctx.getText());
    }

    @Override
    public Integer visitSub(ExprTestParser.SubContext ctx) {
        return visit(ctx.expr(0)) - visit(ctx.expr(1));
    }

    @Override
    public Integer visitExp(ExprTestParser.ExpContext ctx) {
        return visit(ctx.expr());
    }


}