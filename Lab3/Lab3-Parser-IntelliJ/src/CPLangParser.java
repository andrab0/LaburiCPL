// Generated from F:/FACULTATE/MASTER II/CPL/LAB3/Lab3-Parser-IntelliJ\CPLangParser.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CPLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, THEN=2, ELSE=3, FI=4, BOOL=5, TYPE=6, ID=7, INT=8, FLOAT=9, STRING=10, 
		SEMI=11, COMMA=12, ASSIGN=13, LPAREN=14, RPAREN=15, LBRACE=16, RBRACE=17, 
		PLUS=18, MINUS=19, MULT=20, DIV=21, EQUAL=22, LT=23, LE=24, LINE_COMMENT=25, 
		BLOCK_COMMENT=26, WS=27;
	public static final int
		RULE_prog = 0, RULE_definition = 1, RULE_expr = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "definition", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'then'", "'else'", "'fi'", null, null, null, null, null, 
			null, "';'", "','", "'='", "'('", "')'", "'{'", "'}'", "'+'", "'-'", 
			"'*'", "'/'", "'=='", "'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "THEN", "ELSE", "FI", "BOOL", "TYPE", "ID", "INT", "FLOAT", 
			"STRING", "SEMI", "COMMA", "ASSIGN", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"PLUS", "MINUS", "MULT", "DIV", "EQUAL", "LT", "LE", "LINE_COMMENT", 
			"BLOCK_COMMENT", "WS"
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
	public String getGrammarFileName() { return "CPLangParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CPLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CPLangParser.EOF, 0); }
		public List<TerminalNode> SEMI() { return getTokens(CPLangParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(CPLangParser.SEMI, i);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPLangParserListener ) ((CPLangParserListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPLangParserListener ) ((CPLangParserListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPLangParserVisitor ) return ((CPLangParserVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << ID) | (1L << INT) | (1L << SEMI))) != 0)) {
				{
				{
				setState(8);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SEMI:
					{
					setState(6);
					definition();
					}
					break;
				case IF:
				case ID:
				case INT:
					{
					setState(7);
					expr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(10);
				match(SEMI);
				}
				}
				setState(16);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(17);
			match(EOF);
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

	public static class DefinitionContext extends ParserRuleContext {
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPLangParserListener ) ((CPLangParserListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPLangParserListener ) ((CPLangParserListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPLangParserVisitor ) return ((CPLangParserVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(CPLangParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPLangParserListener ) ((CPLangParserListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPLangParserListener ) ((CPLangParserListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPLangParserVisitor ) return ((CPLangParserVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends ExprContext {
		public ExprContext cond;
		public ExprContext thenBranch;
		public ExprContext elseBranch;
		public TerminalNode IF() { return getToken(CPLangParser.IF, 0); }
		public TerminalNode THEN() { return getToken(CPLangParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(CPLangParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(CPLangParser.FI, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IfContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPLangParserListener ) ((CPLangParserListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPLangParserListener ) ((CPLangParserListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPLangParserVisitor ) return ((CPLangParserVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(CPLangParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPLangParserListener ) ((CPLangParserListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPLangParserListener ) ((CPLangParserListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPLangParserVisitor ) return ((CPLangParserVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		try {
			setState(31);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(21);
				match(IF);
				setState(22);
				((IfContext)_localctx).cond = expr();
				setState(23);
				match(THEN);
				setState(24);
				((IfContext)_localctx).thenBranch = expr();
				setState(25);
				match(ELSE);
				setState(26);
				((IfContext)_localctx).elseBranch = expr();
				setState(27);
				match(FI);
				}
				break;
			case ID:
				_localctx = new IdContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				match(ID);
				}
				break;
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				match(INT);
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
		"\u0004\u0001\u001b\"\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0003\u0000\t\b\u0000\u0001"+
		"\u0000\u0001\u0000\u0005\u0000\r\b\u0000\n\u0000\f\u0000\u0010\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002 \b\u0002\u0001\u0002\u0000\u0000"+
		"\u0003\u0000\u0002\u0004\u0000\u0000\"\u0000\u000e\u0001\u0000\u0000\u0000"+
		"\u0002\u0013\u0001\u0000\u0000\u0000\u0004\u001f\u0001\u0000\u0000\u0000"+
		"\u0006\t\u0003\u0002\u0001\u0000\u0007\t\u0003\u0004\u0002\u0000\b\u0006"+
		"\u0001\u0000\u0000\u0000\b\u0007\u0001\u0000\u0000\u0000\t\n\u0001\u0000"+
		"\u0000\u0000\n\u000b\u0005\u000b\u0000\u0000\u000b\r\u0001\u0000\u0000"+
		"\u0000\f\b\u0001\u0000\u0000\u0000\r\u0010\u0001\u0000\u0000\u0000\u000e"+
		"\f\u0001\u0000\u0000\u0000\u000e\u000f\u0001\u0000\u0000\u0000\u000f\u0011"+
		"\u0001\u0000\u0000\u0000\u0010\u000e\u0001\u0000\u0000\u0000\u0011\u0012"+
		"\u0005\u0000\u0000\u0001\u0012\u0001\u0001\u0000\u0000\u0000\u0013\u0014"+
		"\u0001\u0000\u0000\u0000\u0014\u0003\u0001\u0000\u0000\u0000\u0015\u0016"+
		"\u0005\u0001\u0000\u0000\u0016\u0017\u0003\u0004\u0002\u0000\u0017\u0018"+
		"\u0005\u0002\u0000\u0000\u0018\u0019\u0003\u0004\u0002\u0000\u0019\u001a"+
		"\u0005\u0003\u0000\u0000\u001a\u001b\u0003\u0004\u0002\u0000\u001b\u001c"+
		"\u0005\u0004\u0000\u0000\u001c \u0001\u0000\u0000\u0000\u001d \u0005\u0007"+
		"\u0000\u0000\u001e \u0005\b\u0000\u0000\u001f\u0015\u0001\u0000\u0000"+
		"\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f\u001e\u0001\u0000\u0000"+
		"\u0000 \u0005\u0001\u0000\u0000\u0000\u0003\b\u000e\u001f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}