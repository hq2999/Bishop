// Generated from C:/Users/RSVPTECH/test_temp/src/main/resources\MyTest.g4 by ANTLR 4.9.1
package mytest;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyTestParser}.
 */
public interface MyTestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MyTestParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MyTestParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AllOrValue}
	 * labeled alternative in {@link MyTestParser#or}.
	 * @param ctx the parse tree
	 */
	void enterAllOrValue(MyTestParser.AllOrValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AllOrValue}
	 * labeled alternative in {@link MyTestParser#or}.
	 * @param ctx the parse tree
	 */
	void exitAllOrValue(MyTestParser.AllOrValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AllAndValue}
	 * labeled alternative in {@link MyTestParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAllAndValue(MyTestParser.AllAndValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AllAndValue}
	 * labeled alternative in {@link MyTestParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAllAndValue(MyTestParser.AllAndValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link MyTestParser#item}.
	 * @param ctx the parse tree
	 */
	void enterString(MyTestParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link MyTestParser#item}.
	 * @param ctx the parse tree
	 */
	void exitString(MyTestParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndValue}
	 * labeled alternative in {@link MyTestParser#item}.
	 * @param ctx the parse tree
	 */
	void enterAndValue(MyTestParser.AndValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndValue}
	 * labeled alternative in {@link MyTestParser#item}.
	 * @param ctx the parse tree
	 */
	void exitAndValue(MyTestParser.AndValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrValue}
	 * labeled alternative in {@link MyTestParser#item}.
	 * @param ctx the parse tree
	 */
	void enterOrValue(MyTestParser.OrValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrValue}
	 * labeled alternative in {@link MyTestParser#item}.
	 * @param ctx the parse tree
	 */
	void exitOrValue(MyTestParser.OrValueContext ctx);
}