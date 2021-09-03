// Generated from C:/Users/RSVPTECH/test_temp/src/main/resources\Xml.g4 by ANTLR 4.9.1
package xml;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XmlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, STRING=6, NUMBER=7, WS=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "STRING", "ESC", "UNICODE", "HEX", 
			"NUMBER", "INT", "EXP", "WS"
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


	public XmlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Xml.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\nu\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\7\7\64\n\7\f\7\16\7\67"+
		"\13\7\3\b\3\b\3\b\5\b<\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\5\13G"+
		"\n\13\3\13\3\13\3\13\6\13L\n\13\r\13\16\13M\3\13\5\13Q\n\13\3\13\5\13"+
		"T\n\13\3\13\3\13\3\13\3\13\5\13Z\n\13\3\13\5\13]\n\13\3\f\3\f\3\f\7\f"+
		"b\n\f\f\f\16\fe\13\f\5\fg\n\f\3\r\3\r\5\rk\n\r\3\r\3\r\3\16\6\16p\n\16"+
		"\r\16\16\16q\3\16\3\16\2\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\2\21\2\23\2"+
		"\25\t\27\2\31\2\33\n\3\2\n\5\2\62;C\\c|\n\2$$\61\61^^ddhhppttvv\5\2\62"+
		";CHch\3\2\62;\3\2\63;\4\2GGgg\4\2--//\5\2\13\f\17\17\"\"\2}\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\25\3"+
		"\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5#\3\2\2\2\7*\3\2\2\2\t,\3\2\2\2\13."+
		"\3\2\2\2\r\65\3\2\2\2\178\3\2\2\2\21=\3\2\2\2\23C\3\2\2\2\25\\\3\2\2\2"+
		"\27f\3\2\2\2\31h\3\2\2\2\33o\3\2\2\2\35\36\7>\2\2\36\37\7z\2\2\37 \7o"+
		"\2\2 !\7n\2\2!\"\7@\2\2\"\4\3\2\2\2#$\7>\2\2$%\7\61\2\2%&\7z\2\2&\'\7"+
		"o\2\2\'(\7n\2\2()\7@\2\2)\6\3\2\2\2*+\7>\2\2+\b\3\2\2\2,-\7@\2\2-\n\3"+
		"\2\2\2./\7>\2\2/\60\7\61\2\2\60\f\3\2\2\2\61\64\5\17\b\2\62\64\t\2\2\2"+
		"\63\61\3\2\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2"+
		"\66\16\3\2\2\2\67\65\3\2\2\28;\7^\2\29<\t\3\2\2:<\5\21\t\2;9\3\2\2\2;"+
		":\3\2\2\2<\20\3\2\2\2=>\7w\2\2>?\5\23\n\2?@\5\23\n\2@A\5\23\n\2AB\5\23"+
		"\n\2B\22\3\2\2\2CD\t\4\2\2D\24\3\2\2\2EG\7/\2\2FE\3\2\2\2FG\3\2\2\2GH"+
		"\3\2\2\2HI\5\27\f\2IK\7\60\2\2JL\t\5\2\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2"+
		"MN\3\2\2\2NP\3\2\2\2OQ\5\31\r\2PO\3\2\2\2PQ\3\2\2\2Q]\3\2\2\2RT\7/\2\2"+
		"SR\3\2\2\2ST\3\2\2\2TU\3\2\2\2UV\5\27\f\2VW\5\31\r\2W]\3\2\2\2XZ\7/\2"+
		"\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[]\5\27\f\2\\F\3\2\2\2\\S\3\2\2\2\\Y\3"+
		"\2\2\2]\26\3\2\2\2^g\7\62\2\2_c\t\6\2\2`b\t\5\2\2a`\3\2\2\2be\3\2\2\2"+
		"ca\3\2\2\2cd\3\2\2\2dg\3\2\2\2ec\3\2\2\2f^\3\2\2\2f_\3\2\2\2g\30\3\2\2"+
		"\2hj\t\7\2\2ik\t\b\2\2ji\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\5\27\f\2m\32\3"+
		"\2\2\2np\t\t\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\b"+
		"\16\2\2t\34\3\2\2\2\20\2\63\65;FMPSY\\cfjq\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}