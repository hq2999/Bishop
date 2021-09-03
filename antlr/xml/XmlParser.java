// Generated from C:/Users/RSVPTECH/test_temp/src/main/resources\Xml.g4 by ANTLR 4.9.1
package xml;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XmlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, STRING=6, NUMBER=7, WS=8;
	public static final int
		RULE_xml = 0, RULE_element = 1, RULE_value = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"xml", "element", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<xml>'", "'</xml>'", "'<'", "'>'", "'</'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "STRING", "NUMBER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Xml.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XmlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class XmlContext extends ParserRuleContext {
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public XmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlListener ) ((XmlListener)listener).enterXml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlListener ) ((XmlListener)listener).exitXml(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XmlVisitor ) return ((XmlVisitor<? extends T>)visitor).visitXml(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XmlContext xml() throws RecognitionException {
		XmlContext _localctx = new XmlContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_xml);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			match(T__0);
			setState(8); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(7);
				element();
				}
				}
				setState(10); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(12);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementContext extends ParserRuleContext {
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
	 
		public ElementContext() { }
		public void copyFrom(ElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ObjectofValueContext extends ElementContext {
		public List<TerminalNode> STRING() { return getTokens(XmlParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(XmlParser.STRING, i);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public ObjectofValueContext(ElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlListener ) ((XmlListener)listener).enterObjectofValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlListener ) ((XmlListener)listener).exitObjectofValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XmlVisitor ) return ((XmlVisitor<? extends T>)visitor).visitObjectofValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_element);
		int _la;
		try {
			setState(34);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new ObjectofValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				match(T__2);
				setState(15);
				match(STRING);
				setState(16);
				match(T__3);
				setState(17);
				value();
				setState(18);
				match(T__4);
				setState(19);
				match(STRING);
				setState(20);
				match(T__3);
				}
				break;
			case 2:
				_localctx = new ObjectofValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				match(T__2);
				setState(23);
				match(STRING);
				setState(24);
				match(T__3);
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(25);
					element();
					}
					}
					setState(30);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(31);
				match(T__4);
				setState(32);
				match(STRING);
				setState(33);
				match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringContext extends ValueContext {
		public TerminalNode STRING() { return getToken(XmlParser.STRING, 0); }
		public StringContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlListener ) ((XmlListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlListener ) ((XmlListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XmlVisitor ) return ((XmlVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomContext extends ValueContext {
		public TerminalNode NUMBER() { return getToken(XmlParser.NUMBER, 0); }
		public AtomContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlListener ) ((XmlListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlListener ) ((XmlListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XmlVisitor ) return ((XmlVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_value);
		try {
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				match(STRING);
				}
				break;
			case NUMBER:
				_localctx = new AtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\n+\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\6\2\13\n\2\r\2\16\2\f\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\3\3\3\3\3\5\3%"+
		"\n\3\3\4\3\4\5\4)\n\4\3\4\2\2\5\2\4\6\2\2\2+\2\b\3\2\2\2\4$\3\2\2\2\6"+
		"(\3\2\2\2\b\n\7\3\2\2\t\13\5\4\3\2\n\t\3\2\2\2\13\f\3\2\2\2\f\n\3\2\2"+
		"\2\f\r\3\2\2\2\r\16\3\2\2\2\16\17\7\4\2\2\17\3\3\2\2\2\20\21\7\5\2\2\21"+
		"\22\7\b\2\2\22\23\7\6\2\2\23\24\5\6\4\2\24\25\7\7\2\2\25\26\7\b\2\2\26"+
		"\27\7\6\2\2\27%\3\2\2\2\30\31\7\5\2\2\31\32\7\b\2\2\32\36\7\6\2\2\33\35"+
		"\5\4\3\2\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37!\3\2"+
		"\2\2 \36\3\2\2\2!\"\7\7\2\2\"#\7\b\2\2#%\7\6\2\2$\20\3\2\2\2$\30\3\2\2"+
		"\2%\5\3\2\2\2&)\7\b\2\2\')\7\t\2\2(&\3\2\2\2(\'\3\2\2\2)\7\3\2\2\2\6\f"+
		"\36$(";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}