// Generated from C:/Users/RSVPTECH/test_temp/src/main/resources\Xml.g4 by ANTLR 4.9.1
package xml;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XmlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XmlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XmlParser#xml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXml(XmlParser.XmlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectofValue}
	 * labeled alternative in {@link XmlParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectofValue(XmlParser.ObjectofValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link XmlParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(XmlParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link XmlParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(XmlParser.AtomContext ctx);
}