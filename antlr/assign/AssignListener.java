// Generated from C:/Users/RSVPTECH/test_temp/src/main/resources\Assign.g4 by ANTLR 4.9.1
package assign;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AssignParser}.
 */
public interface AssignListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AssignParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(AssignParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssignParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(AssignParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssignParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(AssignParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssignParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(AssignParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssignParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(AssignParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssignParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(AssignParser.ExprContext ctx);
}