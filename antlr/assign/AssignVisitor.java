// Generated from C:/Users/RSVPTECH/test_temp/src/main/resources\Assign.g4 by ANTLR 4.9.1
package assign;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AssignParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AssignVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AssignParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(AssignParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssignParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(AssignParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssignParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(AssignParser.ExprContext ctx);
}