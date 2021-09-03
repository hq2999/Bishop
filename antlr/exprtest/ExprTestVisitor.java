// Generated from C:/Users/RSVPTECH/test_temp/src/main/resources\ExprTest.g4 by ANTLR 4.9.1
package exprtest;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprTestParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprTestVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprTestParser#cal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCal(ExprTestParser.CalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(ExprTestParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(ExprTestParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(ExprTestParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Exp}
	 * labeled alternative in {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(ExprTestParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(ExprTestParser.IntContext ctx);
}