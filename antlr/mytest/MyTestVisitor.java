// Generated from C:/Users/RSVPTECH/test_temp/src/main/resources\MyTest.g4 by ANTLR 4.9.1
package mytest;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MyTestParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MyTestVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MyTestParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MyTestParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AllOrValue}
	 * labeled alternative in {@link MyTestParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllOrValue(MyTestParser.AllOrValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AllAndValue}
	 * labeled alternative in {@link MyTestParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllAndValue(MyTestParser.AllAndValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link MyTestParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(MyTestParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndValue}
	 * labeled alternative in {@link MyTestParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndValue(MyTestParser.AndValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrValue}
	 * labeled alternative in {@link MyTestParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrValue(MyTestParser.OrValueContext ctx);
}