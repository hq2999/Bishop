// Generated from C:/Users/RSVPTECH/test_temp/src/main/resources\ExprTest.g4 by ANTLR 4.9.1
package exprtest;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprTestParser}.
 */
public interface ExprTestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprTestParser#cal}.
	 * @param ctx the parse tree
	 */
	void enterCal(ExprTestParser.CalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprTestParser#cal}.
	 * @param ctx the parse tree
	 */
	void exitCal(ExprTestParser.CalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdd(ExprTestParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdd(ExprTestParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSub(ExprTestParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSub(ExprTestParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMul(ExprTestParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMul(ExprTestParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exp}
	 * labeled alternative in {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExp(ExprTestParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exp}
	 * labeled alternative in {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExp(ExprTestParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(ExprTestParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(ExprTestParser.IntContext ctx);
}