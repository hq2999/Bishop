// Generated from C:/Users/RSVPTECH/test_temp/src/main/resources\MyTest.g4 by ANTLR 4.9.1
package mytest;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyTestParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, STRING=6;
	public static final int
		RULE_expr = 0, RULE_or = 1, RULE_and = 2, RULE_item = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"expr", "or", "and", "item"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "','", "']'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "STRING"
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
	public String getGrammarFileName() { return "MyTest.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MyTestParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExprContext extends ParserRuleContext {
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyTestListener ) ((MyTestListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyTestListener ) ((MyTestListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyTestVisitor ) return ((MyTestVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		try {
			setState(10);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(8);
				or();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(9);
				and();
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

	public static class OrContext extends ParserRuleContext {
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
	 
		public OrContext() { }
		public void copyFrom(OrContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AllOrValueContext extends OrContext {
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public AllOrValueContext(OrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyTestListener ) ((MyTestListener)listener).enterAllOrValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyTestListener ) ((MyTestListener)listener).exitAllOrValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyTestVisitor ) return ((MyTestVisitor<? extends T>)visitor).visitAllOrValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_or);
		int _la;
		try {
			_localctx = new AllOrValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			match(T__0);
			setState(13);
			item();
			setState(16); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14);
				match(T__1);
				setState(15);
				item();
				}
				}
				setState(18); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			setState(20);
			match(T__2);
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

	public static class AndContext extends ParserRuleContext {
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
	 
		public AndContext() { }
		public void copyFrom(AndContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AllAndValueContext extends AndContext {
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public AllAndValueContext(AndContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyTestListener ) ((MyTestListener)listener).enterAllAndValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyTestListener ) ((MyTestListener)listener).exitAllAndValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyTestVisitor ) return ((MyTestVisitor<? extends T>)visitor).visitAllAndValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_and);
		int _la;
		try {
			_localctx = new AllAndValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(T__3);
			setState(23);
			item();
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24);
				match(T__1);
				setState(25);
				item();
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			setState(30);
			match(T__4);
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

	public static class ItemContext extends ParserRuleContext {
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
	 
		public ItemContext() { }
		public void copyFrom(ItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OrValueContext extends ItemContext {
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public OrValueContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyTestListener ) ((MyTestListener)listener).enterOrValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyTestListener ) ((MyTestListener)listener).exitOrValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyTestVisitor ) return ((MyTestVisitor<? extends T>)visitor).visitOrValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndValueContext extends ItemContext {
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public AndValueContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyTestListener ) ((MyTestListener)listener).enterAndValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyTestListener ) ((MyTestListener)listener).exitAndValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyTestVisitor ) return ((MyTestVisitor<? extends T>)visitor).visitAndValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ItemContext {
		public TerminalNode STRING() { return getToken(MyTestParser.STRING, 0); }
		public StringContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyTestListener ) ((MyTestListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyTestListener ) ((MyTestListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyTestVisitor ) return ((MyTestVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_item);
		try {
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				match(STRING);
				}
				break;
			case T__3:
				_localctx = new AndValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				and();
				}
				break;
			case T__0:
				_localctx = new OrValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				or();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b(\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\5\2\r\n\2\3\3\3\3\3\3\3\3\6\3\23\n\3\r\3\16"+
		"\3\24\3\3\3\3\3\4\3\4\3\4\3\4\6\4\35\n\4\r\4\16\4\36\3\4\3\4\3\5\3\5\3"+
		"\5\5\5&\n\5\3\5\2\2\6\2\4\6\b\2\2\2(\2\f\3\2\2\2\4\16\3\2\2\2\6\30\3\2"+
		"\2\2\b%\3\2\2\2\n\r\5\4\3\2\13\r\5\6\4\2\f\n\3\2\2\2\f\13\3\2\2\2\r\3"+
		"\3\2\2\2\16\17\7\3\2\2\17\22\5\b\5\2\20\21\7\4\2\2\21\23\5\b\5\2\22\20"+
		"\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\26\3\2\2\2\26\27"+
		"\7\5\2\2\27\5\3\2\2\2\30\31\7\6\2\2\31\34\5\b\5\2\32\33\7\4\2\2\33\35"+
		"\5\b\5\2\34\32\3\2\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37 \3"+
		"\2\2\2 !\7\7\2\2!\7\3\2\2\2\"&\7\b\2\2#&\5\6\4\2$&\5\4\3\2%\"\3\2\2\2"+
		"%#\3\2\2\2%$\3\2\2\2&\t\3\2\2\2\6\f\24\36%";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}