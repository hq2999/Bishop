// Generated from C:/Users/RSVPTECH/test_temp/src/main/resources\Xml.g4 by ANTLR 4.9.1
package xml;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XmlParser}.
 */
public interface XmlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XmlParser#xml}.
	 * @param ctx the parse tree
	 */
	void enterXml(XmlParser.XmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlParser#xml}.
	 * @param ctx the parse tree
	 */
	void exitXml(XmlParser.XmlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectofValue}
	 * labeled alternative in {@link XmlParser#element}.
	 * @param ctx the parse tree
	 */
	void enterObjectofValue(XmlParser.ObjectofValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectofValue}
	 * labeled alternative in {@link XmlParser#element}.
	 * @param ctx the parse tree
	 */
	void exitObjectofValue(XmlParser.ObjectofValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link XmlParser#value}.
	 * @param ctx the parse tree
	 */
	void enterString(XmlParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link XmlParser#value}.
	 * @param ctx the parse tree
	 */
	void exitString(XmlParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link XmlParser#value}.
	 * @param ctx the parse tree
	 */
	void enterAtom(XmlParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link XmlParser#value}.
	 * @param ctx the parse tree
	 */
	void exitAtom(XmlParser.AtomContext ctx);
}