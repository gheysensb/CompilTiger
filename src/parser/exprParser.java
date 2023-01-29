// Generated from ./expr.g4 by ANTLR 4.9.2

package parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class exprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, STRINGS=41, IDF=42, INT=43, WS=44, COMMENT=45;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_lValue = 2, RULE_assignExpr = 3, 
		RULE_ouExpr = 4, RULE_etExpr = 5, RULE_comparerExpr = 6, RULE_plusmoinsExpr = 7, 
		RULE_muldivExpr = 8, RULE_negExpr = 9, RULE_seqExpr = 10, RULE_otherExpr = 11, 
		RULE_callExpr = 12, RULE_arrCreate = 13, RULE_recCreate = 14, RULE_fieldCreate = 15, 
		RULE_ifExpr = 16, RULE_whileExpr = 17, RULE_forExpr = 18, RULE_letExpr = 19, 
		RULE_dec = 20, RULE_tyDec = 21, RULE_recTy = 22, RULE_fieldDec = 23, RULE_varDec = 24, 
		RULE_funDec = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "lValue", "assignExpr", "ouExpr", "etExpr", "comparerExpr", 
			"plusmoinsExpr", "muldivExpr", "negExpr", "seqExpr", "otherExpr", "callExpr", 
			"arrCreate", "recCreate", "fieldCreate", "ifExpr", "whileExpr", "forExpr", 
			"letExpr", "dec", "tyDec", "recTy", "fieldDec", "varDec", "funDec"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "'.'", "':='", "'|'", "'&'", "'<'", "'>'", "'>='", 
			"'<='", "'='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'('", "';'", "')'", 
			"'nil'", "'break'", "','", "'of'", "'{'", "'}'", "'if'", "'then'", "'else'", 
			"'while'", "'do'", "'for'", "'to'", "'let'", "'in'", "'end'", "'type'", 
			"'array'", "':'", "'var'", "'function'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "STRINGS", "IDF", "INT", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public exprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(exprParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			expr();
			setState(53);
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

	public static class ExprContext extends ParserRuleContext {
		public AssignExprContext assignExpr() {
			return getRuleContext(AssignExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			assignExpr();
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

	public static class LValueContext extends ParserRuleContext {
		public LValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lValue; }
	 
		public LValueContext() { }
		public void copyFrom(LValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AffectidfContext extends LValueContext {
		public TerminalNode IDF() { return getToken(exprParser.IDF, 0); }
		public AffectidfContext(LValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitAffectidf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AffectsubscriptContext extends LValueContext {
		public LValueContext lValue() {
			return getRuleContext(LValueContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AffectsubscriptContext(LValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitAffectsubscript(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AffectfieldContext extends LValueContext {
		public LValueContext lValue() {
			return getRuleContext(LValueContext.class,0);
		}
		public TerminalNode IDF() { return getToken(exprParser.IDF, 0); }
		public AffectfieldContext(LValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitAffectfield(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LValueContext lValue() throws RecognitionException {
		return lValue(0);
	}

	private LValueContext lValue(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LValueContext _localctx = new LValueContext(_ctx, _parentState);
		LValueContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_lValue, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AffectidfContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(58);
			match(IDF);
			}
			_ctx.stop = _input.LT(-1);
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(68);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						_localctx = new AffectsubscriptContext(new LValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_lValue);
						setState(60);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(61);
						match(T__0);
						setState(62);
						expr();
						setState(63);
						match(T__1);
						}
						break;
					case 2:
						{
						_localctx = new AffectfieldContext(new LValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_lValue);
						setState(65);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(66);
						match(T__2);
						setState(67);
						match(IDF);
						}
						break;
					}
					} 
				}
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AssignExprContext extends ParserRuleContext {
		public AssignExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignExpr; }
	 
		public AssignExprContext() { }
		public void copyFrom(AssignExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NoassignContext extends AssignExprContext {
		public OuExprContext ouExpr() {
			return getRuleContext(OuExprContext.class,0);
		}
		public NoassignContext(AssignExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitNoassign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends AssignExprContext {
		public LValueContext lValue() {
			return getRuleContext(LValueContext.class,0);
		}
		public OuExprContext ouExpr() {
			return getRuleContext(OuExprContext.class,0);
		}
		public AssignContext(AssignExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignExprContext assignExpr() throws RecognitionException {
		AssignExprContext _localctx = new AssignExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignExpr);
		try {
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(73);
				lValue(0);
				{
				setState(74);
				match(T__3);
				setState(75);
				ouExpr();
				}
				}
				}
				break;
			case 2:
				_localctx = new NoassignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				ouExpr();
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

	public static class OuExprContext extends ParserRuleContext {
		public List<EtExprContext> etExpr() {
			return getRuleContexts(EtExprContext.class);
		}
		public EtExprContext etExpr(int i) {
			return getRuleContext(EtExprContext.class,i);
		}
		public OuExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ouExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitOuExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OuExprContext ouExpr() throws RecognitionException {
		OuExprContext _localctx = new OuExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ouExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			etExpr();
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(81);
					match(T__4);
					setState(82);
					etExpr();
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
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

	public static class EtExprContext extends ParserRuleContext {
		public List<ComparerExprContext> comparerExpr() {
			return getRuleContexts(ComparerExprContext.class);
		}
		public ComparerExprContext comparerExpr(int i) {
			return getRuleContext(ComparerExprContext.class,i);
		}
		public EtExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_etExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitEtExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EtExprContext etExpr() throws RecognitionException {
		EtExprContext _localctx = new EtExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_etExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			comparerExpr();
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(89);
					match(T__5);
					setState(90);
					comparerExpr();
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
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

	public static class ComparerExprContext extends ParserRuleContext {
		public ComparerExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparerExpr; }
	 
		public ComparerExprContext() { }
		public void copyFrom(ComparerExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CompareContext extends ComparerExprContext {
		public PlusmoinsExprContext plusmoinsExpr() {
			return getRuleContext(PlusmoinsExprContext.class,0);
		}
		public CompareContext(ComparerExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitCompare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareexprContext extends ComparerExprContext {
		public List<PlusmoinsExprContext> plusmoinsExpr() {
			return getRuleContexts(PlusmoinsExprContext.class);
		}
		public PlusmoinsExprContext plusmoinsExpr(int i) {
			return getRuleContext(PlusmoinsExprContext.class,i);
		}
		public CompareexprContext(ComparerExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitCompareexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparerExprContext comparerExpr() throws RecognitionException {
		ComparerExprContext _localctx = new ComparerExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_comparerExpr);
		int _la;
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new CompareexprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				plusmoinsExpr();
				{
				setState(97);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(98);
				plusmoinsExpr();
				}
				}
				break;
			case 2:
				_localctx = new CompareContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				plusmoinsExpr();
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

	public static class PlusmoinsExprContext extends ParserRuleContext {
		public List<MuldivExprContext> muldivExpr() {
			return getRuleContexts(MuldivExprContext.class);
		}
		public MuldivExprContext muldivExpr(int i) {
			return getRuleContext(MuldivExprContext.class,i);
		}
		public PlusmoinsExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusmoinsExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitPlusmoinsExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlusmoinsExprContext plusmoinsExpr() throws RecognitionException {
		PlusmoinsExprContext _localctx = new PlusmoinsExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_plusmoinsExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			muldivExpr();
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(104);
					_la = _input.LA(1);
					if ( !(_la==T__12 || _la==T__13) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(105);
					muldivExpr();
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
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

	public static class MuldivExprContext extends ParserRuleContext {
		public List<NegExprContext> negExpr() {
			return getRuleContexts(NegExprContext.class);
		}
		public NegExprContext negExpr(int i) {
			return getRuleContext(NegExprContext.class,i);
		}
		public MuldivExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_muldivExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitMuldivExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MuldivExprContext muldivExpr() throws RecognitionException {
		MuldivExprContext _localctx = new MuldivExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_muldivExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			negExpr();
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(112);
					_la = _input.LA(1);
					if ( !(_la==T__14 || _la==T__15) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(113);
					negExpr();
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
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

	public static class NegExprContext extends ParserRuleContext {
		public SeqExprContext seqExpr() {
			return getRuleContext(SeqExprContext.class,0);
		}
		public NegExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitNegExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegExprContext negExpr() throws RecognitionException {
		NegExprContext _localctx = new NegExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_negExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(119);
				match(T__13);
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
			seqExpr();
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

	public static class SeqExprContext extends ParserRuleContext {
		public SeqExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seqExpr; }
	 
		public SeqExprContext() { }
		public void copyFrom(SeqExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NoparentheseContext extends SeqExprContext {
		public OtherExprContext otherExpr() {
			return getRuleContext(OtherExprContext.class,0);
		}
		public NoparentheseContext(SeqExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitNoparenthese(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParentheseContext extends SeqExprContext {
		public ParentheseContext(SeqExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitParenthese(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParentheseexprContext extends SeqExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ParentheseexprContext(SeqExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitParentheseexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeqExprContext seqExpr() throws RecognitionException {
		SeqExprContext _localctx = new SeqExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_seqExpr);
		int _la;
		try {
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new NoparentheseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				otherExpr();
				}
				break;
			case 2:
				_localctx = new ParentheseexprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(T__16);
				{
				setState(129);
				expr();
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17) {
					{
					{
					setState(130);
					match(T__17);
					setState(131);
					expr();
					}
					}
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(137);
				match(T__18);
				}
				break;
			case 3:
				_localctx = new ParentheseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				match(T__16);
				setState(140);
				match(T__18);
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

	public static class OtherExprContext extends ParserRuleContext {
		public OtherExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherExpr; }
	 
		public OtherExprContext() { }
		public void copyFrom(OtherExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NilContext extends OtherExprContext {
		public NilContext(OtherExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitNil(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallContext extends OtherExprContext {
		public CallExprContext callExpr() {
			return getRuleContext(CallExprContext.class,0);
		}
		public CallContext(OtherExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrContext extends OtherExprContext {
		public ArrCreateContext arrCreate() {
			return getRuleContext(ArrCreateContext.class,0);
		}
		public ArrContext(OtherExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitArr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RecContext extends OtherExprContext {
		public RecCreateContext recCreate() {
			return getRuleContext(RecCreateContext.class,0);
		}
		public RecContext(OtherExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitRec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LvalueContext extends OtherExprContext {
		public LValueContext lValue() {
			return getRuleContext(LValueContext.class,0);
		}
		public LvalueContext(OtherExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitLvalue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringsContext extends OtherExprContext {
		public TerminalNode STRINGS() { return getToken(exprParser.STRINGS, 0); }
		public StringsContext(OtherExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitStrings(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakContext extends OtherExprContext {
		public BreakContext(OtherExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForContext extends OtherExprContext {
		public ForExprContext forExpr() {
			return getRuleContext(ForExprContext.class,0);
		}
		public ForContext(OtherExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitFor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetContext extends OtherExprContext {
		public LetExprContext letExpr() {
			return getRuleContext(LetExprContext.class,0);
		}
		public LetContext(OtherExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileContext extends OtherExprContext {
		public WhileExprContext whileExpr() {
			return getRuleContext(WhileExprContext.class,0);
		}
		public WhileContext(OtherExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends OtherExprContext {
		public IfExprContext ifExpr() {
			return getRuleContext(IfExprContext.class,0);
		}
		public IfContext(OtherExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends OtherExprContext {
		public TerminalNode INT() { return getToken(exprParser.INT, 0); }
		public IntContext(OtherExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherExprContext otherExpr() throws RecognitionException {
		OtherExprContext _localctx = new OtherExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_otherExpr);
		try {
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				ifExpr();
				}
				break;
			case 2:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				whileExpr();
				}
				break;
			case 3:
				_localctx = new ForContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				forExpr();
				}
				break;
			case 4:
				_localctx = new LetContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(146);
				letExpr();
				}
				break;
			case 5:
				_localctx = new NilContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(147);
				match(T__19);
				}
				break;
			case 6:
				_localctx = new BreakContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(148);
				match(T__20);
				}
				break;
			case 7:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(149);
				match(INT);
				}
				break;
			case 8:
				_localctx = new StringsContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(150);
				match(STRINGS);
				}
				break;
			case 9:
				_localctx = new CallContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(151);
				callExpr();
				}
				break;
			case 10:
				_localctx = new ArrContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(152);
				arrCreate();
				}
				break;
			case 11:
				_localctx = new LvalueContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(153);
				lValue(0);
				}
				break;
			case 12:
				_localctx = new RecContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(154);
				recCreate();
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

	public static class CallExprContext extends ParserRuleContext {
		public CallExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callExpr; }
	 
		public CallExprContext() { }
		public void copyFrom(CallExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CallexprexprContext extends CallExprContext {
		public TerminalNode IDF() { return getToken(exprParser.IDF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CallexprexprContext(CallExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitCallexprexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallexprContext extends CallExprContext {
		public TerminalNode IDF() { return getToken(exprParser.IDF, 0); }
		public CallexprContext(CallExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitCallexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallExprContext callExpr() throws RecognitionException {
		CallExprContext _localctx = new CallExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_callExpr);
		int _la;
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new CallexprexprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(IDF);
				setState(158);
				match(T__16);
				{
				setState(159);
				expr();
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__21) {
					{
					{
					setState(160);
					match(T__21);
					setState(161);
					expr();
					}
					}
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(167);
				match(T__18);
				}
				break;
			case 2:
				_localctx = new CallexprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(IDF);
				setState(170);
				match(T__16);
				setState(171);
				match(T__18);
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

	public static class ArrCreateContext extends ParserRuleContext {
		public TerminalNode IDF() { return getToken(exprParser.IDF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrCreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrCreate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitArrCreate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrCreateContext arrCreate() throws RecognitionException {
		ArrCreateContext _localctx = new ArrCreateContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arrCreate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(IDF);
			setState(175);
			match(T__0);
			setState(176);
			expr();
			setState(177);
			match(T__1);
			setState(178);
			match(T__22);
			setState(179);
			expr();
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

	public static class RecCreateContext extends ParserRuleContext {
		public RecCreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recCreate; }
	 
		public RecCreateContext() { }
		public void copyFrom(RecCreateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReccreateContext extends RecCreateContext {
		public TerminalNode IDF() { return getToken(exprParser.IDF, 0); }
		public ReccreateContext(RecCreateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitReccreate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReccreatefieldContext extends RecCreateContext {
		public TerminalNode IDF() { return getToken(exprParser.IDF, 0); }
		public List<FieldCreateContext> fieldCreate() {
			return getRuleContexts(FieldCreateContext.class);
		}
		public FieldCreateContext fieldCreate(int i) {
			return getRuleContext(FieldCreateContext.class,i);
		}
		public ReccreatefieldContext(RecCreateContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitReccreatefield(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecCreateContext recCreate() throws RecognitionException {
		RecCreateContext _localctx = new RecCreateContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_recCreate);
		int _la;
		try {
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new ReccreatefieldContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(IDF);
				setState(182);
				match(T__23);
				{
				setState(183);
				fieldCreate();
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__21) {
					{
					{
					setState(184);
					match(T__21);
					setState(185);
					fieldCreate();
					}
					}
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(191);
				match(T__24);
				}
				break;
			case 2:
				_localctx = new ReccreateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				match(IDF);
				setState(194);
				match(T__23);
				setState(195);
				match(T__24);
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

	public static class FieldCreateContext extends ParserRuleContext {
		public TerminalNode IDF() { return getToken(exprParser.IDF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FieldCreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldCreate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitFieldCreate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldCreateContext fieldCreate() throws RecognitionException {
		FieldCreateContext _localctx = new FieldCreateContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fieldCreate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(IDF);
			setState(199);
			match(T__10);
			setState(200);
			expr();
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

	public static class IfExprContext extends ParserRuleContext {
		public IfExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifExpr; }
	 
		public IfExprContext() { }
		public void copyFrom(IfExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfthenelseContext extends IfExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IfthenelseContext(IfExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitIfthenelse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfthenContext extends IfExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IfthenContext(IfExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitIfthen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfExprContext ifExpr() throws RecognitionException {
		IfExprContext _localctx = new IfExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifExpr);
		try {
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new IfthenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				match(T__25);
				setState(203);
				expr();
				setState(204);
				match(T__26);
				setState(205);
				expr();
				}
				break;
			case 2:
				_localctx = new IfthenelseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				match(T__25);
				setState(208);
				expr();
				setState(209);
				match(T__26);
				setState(210);
				expr();
				setState(211);
				match(T__27);
				setState(212);
				expr();
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

	public static class WhileExprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public WhileExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitWhileExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileExprContext whileExpr() throws RecognitionException {
		WhileExprContext _localctx = new WhileExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whileExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(T__28);
			setState(217);
			expr();
			setState(218);
			match(T__29);
			setState(219);
			expr();
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

	public static class ForExprContext extends ParserRuleContext {
		public TerminalNode IDF() { return getToken(exprParser.IDF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitForExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForExprContext forExpr() throws RecognitionException {
		ForExprContext _localctx = new ForExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_forExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(T__30);
			setState(222);
			match(IDF);
			setState(223);
			match(T__3);
			setState(224);
			expr();
			setState(225);
			match(T__31);
			setState(226);
			expr();
			setState(227);
			match(T__29);
			setState(228);
			expr();
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

	public static class LetExprContext extends ParserRuleContext {
		public LetExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letExpr; }
	 
		public LetExprContext() { }
		public void copyFrom(LetExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LetexprexprContext extends LetExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public LetexprexprContext(LetExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitLetexprexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetexprContext extends LetExprContext {
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public LetexprContext(LetExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitLetexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetExprContext letExpr() throws RecognitionException {
		LetExprContext _localctx = new LetExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_letExpr);
		int _la;
		try {
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new LetexprexprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				match(T__32);
				setState(232); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(231);
					dec();
					}
					}
					setState(234); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__38) | (1L << T__39))) != 0) );
				setState(236);
				match(T__33);
				{
				setState(237);
				expr();
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17) {
					{
					{
					setState(238);
					match(T__17);
					setState(239);
					expr();
					}
					}
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(245);
				match(T__34);
				}
				break;
			case 2:
				_localctx = new LetexprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				match(T__32);
				setState(249); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(248);
					dec();
					}
					}
					setState(251); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__38) | (1L << T__39))) != 0) );
				setState(253);
				match(T__33);
				setState(254);
				match(T__34);
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

	public static class DecContext extends ParserRuleContext {
		public TyDecContext tyDec() {
			return getRuleContext(TyDecContext.class,0);
		}
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public FunDecContext funDec() {
			return getRuleContext(FunDecContext.class,0);
		}
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_dec);
		try {
			setState(261);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				tyDec();
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				varDec();
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
				funDec();
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

	public static class TyDecContext extends ParserRuleContext {
		public TyDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tyDec; }
	 
		public TyDecContext() { }
		public void copyFrom(TyDecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TyrecContext extends TyDecContext {
		public RecTyContext recTy() {
			return getRuleContext(RecTyContext.class,0);
		}
		public TyrecContext(TyDecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitTyrec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TyarrContext extends TyDecContext {
		public List<TerminalNode> IDF() { return getTokens(exprParser.IDF); }
		public TerminalNode IDF(int i) {
			return getToken(exprParser.IDF, i);
		}
		public TyarrContext(TyDecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitTyarr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TyidfContext extends TyDecContext {
		public List<TerminalNode> IDF() { return getTokens(exprParser.IDF); }
		public TerminalNode IDF(int i) {
			return getToken(exprParser.IDF, i);
		}
		public TyidfContext(TyDecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitTyidf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TyDecContext tyDec() throws RecognitionException {
		TyDecContext _localctx = new TyDecContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_tyDec);
		try {
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new TyidfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				match(T__35);
				setState(264);
				match(IDF);
				setState(265);
				match(T__10);
				setState(266);
				match(IDF);
				}
				break;
			case 2:
				_localctx = new TyarrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				match(T__35);
				setState(268);
				match(IDF);
				setState(269);
				match(T__10);
				setState(270);
				match(T__36);
				setState(271);
				match(T__22);
				setState(272);
				match(IDF);
				}
				break;
			case 3:
				_localctx = new TyrecContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(273);
				recTy();
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

	public static class RecTyContext extends ParserRuleContext {
		public RecTyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recTy; }
	 
		public RecTyContext() { }
		public void copyFrom(RecTyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RectyContext extends RecTyContext {
		public TerminalNode IDF() { return getToken(exprParser.IDF, 0); }
		public RectyContext(RecTyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitRecty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RectyfieldContext extends RecTyContext {
		public TerminalNode IDF() { return getToken(exprParser.IDF, 0); }
		public List<FieldDecContext> fieldDec() {
			return getRuleContexts(FieldDecContext.class);
		}
		public FieldDecContext fieldDec(int i) {
			return getRuleContext(FieldDecContext.class,i);
		}
		public RectyfieldContext(RecTyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitRectyfield(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecTyContext recTy() throws RecognitionException {
		RecTyContext _localctx = new RecTyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_recTy);
		int _la;
		try {
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new RectyfieldContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				match(T__35);
				setState(277);
				match(IDF);
				setState(278);
				match(T__10);
				setState(279);
				match(T__23);
				{
				setState(280);
				fieldDec();
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__21) {
					{
					{
					setState(281);
					match(T__21);
					setState(282);
					fieldDec();
					}
					}
					setState(287);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(288);
				match(T__24);
				}
				break;
			case 2:
				_localctx = new RectyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				match(T__35);
				setState(291);
				match(IDF);
				setState(292);
				match(T__10);
				setState(293);
				match(T__23);
				setState(294);
				match(T__24);
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

	public static class FieldDecContext extends ParserRuleContext {
		public List<TerminalNode> IDF() { return getTokens(exprParser.IDF); }
		public TerminalNode IDF(int i) {
			return getToken(exprParser.IDF, i);
		}
		public FieldDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitFieldDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDecContext fieldDec() throws RecognitionException {
		FieldDecContext _localctx = new FieldDecContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_fieldDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(IDF);
			setState(298);
			match(T__37);
			setState(299);
			match(IDF);
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

	public static class VarDecContext extends ParserRuleContext {
		public VarDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDec; }
	 
		public VarDecContext() { }
		public void copyFrom(VarDecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VartyidContext extends VarDecContext {
		public List<TerminalNode> IDF() { return getTokens(exprParser.IDF); }
		public TerminalNode IDF(int i) {
			return getToken(exprParser.IDF, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VartyidContext(VarDecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitVartyid(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarContext extends VarDecContext {
		public TerminalNode IDF() { return getToken(exprParser.IDF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarContext(VarDecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecContext varDec() throws RecognitionException {
		VarDecContext _localctx = new VarDecContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_varDec);
		try {
			setState(311);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new VarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(301);
				match(T__38);
				setState(302);
				match(IDF);
				setState(303);
				match(T__3);
				setState(304);
				expr();
				}
				break;
			case 2:
				_localctx = new VartyidContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(305);
				match(T__38);
				setState(306);
				match(IDF);
				setState(307);
				match(T__37);
				setState(308);
				match(IDF);
				setState(309);
				match(T__3);
				setState(310);
				expr();
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

	public static class FunDecContext extends ParserRuleContext {
		public FunDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDec; }
	 
		public FunDecContext() { }
		public void copyFrom(FunDecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuntyidContext extends FunDecContext {
		public List<TerminalNode> IDF() { return getTokens(exprParser.IDF); }
		public TerminalNode IDF(int i) {
			return getToken(exprParser.IDF, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FuntyidContext(FunDecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitFuntyid(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunContext extends FunDecContext {
		public TerminalNode IDF() { return getToken(exprParser.IDF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunContext(FunDecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitFun(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunfieldtyidContext extends FunDecContext {
		public List<TerminalNode> IDF() { return getTokens(exprParser.IDF); }
		public TerminalNode IDF(int i) {
			return getToken(exprParser.IDF, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<FieldDecContext> fieldDec() {
			return getRuleContexts(FieldDecContext.class);
		}
		public FieldDecContext fieldDec(int i) {
			return getRuleContext(FieldDecContext.class,i);
		}
		public FunfieldtyidContext(FunDecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitFunfieldtyid(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunfieldContext extends FunDecContext {
		public TerminalNode IDF() { return getToken(exprParser.IDF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<FieldDecContext> fieldDec() {
			return getRuleContexts(FieldDecContext.class);
		}
		public FieldDecContext fieldDec(int i) {
			return getRuleContext(FieldDecContext.class,i);
		}
		public FunfieldContext(FunDecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitFunfield(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunDecContext funDec() throws RecognitionException {
		FunDecContext _localctx = new FunDecContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_funDec);
		int _la;
		try {
			setState(361);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new FunfieldtyidContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				match(T__39);
				setState(314);
				match(IDF);
				setState(315);
				match(T__16);
				{
				setState(316);
				fieldDec();
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__21) {
					{
					{
					setState(317);
					match(T__21);
					setState(318);
					fieldDec();
					}
					}
					setState(323);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(324);
				match(T__18);
				{
				setState(325);
				match(T__37);
				setState(326);
				match(IDF);
				}
				setState(328);
				match(T__10);
				setState(329);
				expr();
				}
				break;
			case 2:
				_localctx = new FunfieldContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(331);
				match(T__39);
				setState(332);
				match(IDF);
				setState(333);
				match(T__16);
				{
				setState(334);
				fieldDec();
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__21) {
					{
					{
					setState(335);
					match(T__21);
					setState(336);
					fieldDec();
					}
					}
					setState(341);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(342);
				match(T__18);
				setState(343);
				match(T__10);
				setState(344);
				expr();
				}
				break;
			case 3:
				_localctx = new FuntyidContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(346);
				match(T__39);
				setState(347);
				match(IDF);
				setState(348);
				match(T__16);
				setState(349);
				match(T__18);
				{
				setState(350);
				match(T__37);
				setState(351);
				match(IDF);
				}
				setState(353);
				match(T__10);
				setState(354);
				expr();
				}
				break;
			case 4:
				_localctx = new FunContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(355);
				match(T__39);
				setState(356);
				match(IDF);
				setState(357);
				match(T__16);
				setState(358);
				match(T__18);
				setState(359);
				match(T__10);
				setState(360);
				expr();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return lValue_sempred((LValueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean lValue_sempred(LValueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u016e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\7\4G\n\4\f\4\16\4J\13\4\3\5\3\5\3\5\3\5\3\5\5\5Q\n\5\3"+
		"\6\3\6\3\6\7\6V\n\6\f\6\16\6Y\13\6\3\7\3\7\3\7\7\7^\n\7\f\7\16\7a\13\7"+
		"\3\b\3\b\3\b\3\b\3\b\5\bh\n\b\3\t\3\t\3\t\7\tm\n\t\f\t\16\tp\13\t\3\n"+
		"\3\n\3\n\7\nu\n\n\f\n\16\nx\13\n\3\13\7\13{\n\13\f\13\16\13~\13\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\7\f\u0087\n\f\f\f\16\f\u008a\13\f\3\f\3\f\3"+
		"\f\3\f\5\f\u0090\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5"+
		"\r\u009e\n\r\3\16\3\16\3\16\3\16\3\16\7\16\u00a5\n\16\f\16\16\16\u00a8"+
		"\13\16\3\16\3\16\3\16\3\16\3\16\5\16\u00af\n\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\7\20\u00bd\n\20\f\20\16\20\u00c0"+
		"\13\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c7\n\20\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00d9"+
		"\n\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\6\25\u00eb\n\25\r\25\16\25\u00ec\3\25\3\25\3\25\3\25\7"+
		"\25\u00f3\n\25\f\25\16\25\u00f6\13\25\3\25\3\25\3\25\3\25\6\25\u00fc\n"+
		"\25\r\25\16\25\u00fd\3\25\3\25\3\25\5\25\u0103\n\25\3\26\3\26\3\26\5\26"+
		"\u0108\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27"+
		"\u0115\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u011e\n\30\f\30\16"+
		"\30\u0121\13\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u012a\n\30\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32"+
		"\u013a\n\32\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u0142\n\33\f\33\16\33\u0145"+
		"\13\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\7\33\u0154\n\33\f\33\16\33\u0157\13\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33"+
		"\u016c\n\33\3\33\2\3\6\34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\64\2\5\3\2\t\16\3\2\17\20\3\2\21\22\2\u017f\2\66\3\2\2\2\4"+
		"9\3\2\2\2\6;\3\2\2\2\bP\3\2\2\2\nR\3\2\2\2\fZ\3\2\2\2\16g\3\2\2\2\20i"+
		"\3\2\2\2\22q\3\2\2\2\24|\3\2\2\2\26\u008f\3\2\2\2\30\u009d\3\2\2\2\32"+
		"\u00ae\3\2\2\2\34\u00b0\3\2\2\2\36\u00c6\3\2\2\2 \u00c8\3\2\2\2\"\u00d8"+
		"\3\2\2\2$\u00da\3\2\2\2&\u00df\3\2\2\2(\u0102\3\2\2\2*\u0107\3\2\2\2,"+
		"\u0114\3\2\2\2.\u0129\3\2\2\2\60\u012b\3\2\2\2\62\u0139\3\2\2\2\64\u016b"+
		"\3\2\2\2\66\67\5\4\3\2\678\7\2\2\38\3\3\2\2\29:\5\b\5\2:\5\3\2\2\2;<\b"+
		"\4\1\2<=\7,\2\2=H\3\2\2\2>?\f\4\2\2?@\7\3\2\2@A\5\4\3\2AB\7\4\2\2BG\3"+
		"\2\2\2CD\f\3\2\2DE\7\5\2\2EG\7,\2\2F>\3\2\2\2FC\3\2\2\2GJ\3\2\2\2HF\3"+
		"\2\2\2HI\3\2\2\2I\7\3\2\2\2JH\3\2\2\2KL\5\6\4\2LM\7\6\2\2MN\5\n\6\2NQ"+
		"\3\2\2\2OQ\5\n\6\2PK\3\2\2\2PO\3\2\2\2Q\t\3\2\2\2RW\5\f\7\2ST\7\7\2\2"+
		"TV\5\f\7\2US\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\13\3\2\2\2YW\3\2\2"+
		"\2Z_\5\16\b\2[\\\7\b\2\2\\^\5\16\b\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3"+
		"\2\2\2`\r\3\2\2\2a_\3\2\2\2bc\5\20\t\2cd\t\2\2\2de\5\20\t\2eh\3\2\2\2"+
		"fh\5\20\t\2gb\3\2\2\2gf\3\2\2\2h\17\3\2\2\2in\5\22\n\2jk\t\3\2\2km\5\22"+
		"\n\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\21\3\2\2\2pn\3\2\2\2qv\5"+
		"\24\13\2rs\t\4\2\2su\5\24\13\2tr\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2"+
		"w\23\3\2\2\2xv\3\2\2\2y{\7\20\2\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2"+
		"\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080\5\26\f\2\u0080\25\3\2\2\2\u0081"+
		"\u0090\5\30\r\2\u0082\u0083\7\23\2\2\u0083\u0088\5\4\3\2\u0084\u0085\7"+
		"\24\2\2\u0085\u0087\5\4\3\2\u0086\u0084\3\2\2\2\u0087\u008a\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0088\3\2"+
		"\2\2\u008b\u008c\7\25\2\2\u008c\u0090\3\2\2\2\u008d\u008e\7\23\2\2\u008e"+
		"\u0090\7\25\2\2\u008f\u0081\3\2\2\2\u008f\u0082\3\2\2\2\u008f\u008d\3"+
		"\2\2\2\u0090\27\3\2\2\2\u0091\u009e\5\"\22\2\u0092\u009e\5$\23\2\u0093"+
		"\u009e\5&\24\2\u0094\u009e\5(\25\2\u0095\u009e\7\26\2\2\u0096\u009e\7"+
		"\27\2\2\u0097\u009e\7-\2\2\u0098\u009e\7+\2\2\u0099\u009e\5\32\16\2\u009a"+
		"\u009e\5\34\17\2\u009b\u009e\5\6\4\2\u009c\u009e\5\36\20\2\u009d\u0091"+
		"\3\2\2\2\u009d\u0092\3\2\2\2\u009d\u0093\3\2\2\2\u009d\u0094\3\2\2\2\u009d"+
		"\u0095\3\2\2\2\u009d\u0096\3\2\2\2\u009d\u0097\3\2\2\2\u009d\u0098\3\2"+
		"\2\2\u009d\u0099\3\2\2\2\u009d\u009a\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009c\3\2\2\2\u009e\31\3\2\2\2\u009f\u00a0\7,\2\2\u00a0\u00a1\7\23\2"+
		"\2\u00a1\u00a6\5\4\3\2\u00a2\u00a3\7\30\2\2\u00a3\u00a5\5\4\3\2\u00a4"+
		"\u00a2\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00aa\7\25\2\2\u00aa"+
		"\u00af\3\2\2\2\u00ab\u00ac\7,\2\2\u00ac\u00ad\7\23\2\2\u00ad\u00af\7\25"+
		"\2\2\u00ae\u009f\3\2\2\2\u00ae\u00ab\3\2\2\2\u00af\33\3\2\2\2\u00b0\u00b1"+
		"\7,\2\2\u00b1\u00b2\7\3\2\2\u00b2\u00b3\5\4\3\2\u00b3\u00b4\7\4\2\2\u00b4"+
		"\u00b5\7\31\2\2\u00b5\u00b6\5\4\3\2\u00b6\35\3\2\2\2\u00b7\u00b8\7,\2"+
		"\2\u00b8\u00b9\7\32\2\2\u00b9\u00be\5 \21\2\u00ba\u00bb\7\30\2\2\u00bb"+
		"\u00bd\5 \21\2\u00bc\u00ba\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2"+
		"\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1"+
		"\u00c2\7\33\2\2\u00c2\u00c7\3\2\2\2\u00c3\u00c4\7,\2\2\u00c4\u00c5\7\32"+
		"\2\2\u00c5\u00c7\7\33\2\2\u00c6\u00b7\3\2\2\2\u00c6\u00c3\3\2\2\2\u00c7"+
		"\37\3\2\2\2\u00c8\u00c9\7,\2\2\u00c9\u00ca\7\r\2\2\u00ca\u00cb\5\4\3\2"+
		"\u00cb!\3\2\2\2\u00cc\u00cd\7\34\2\2\u00cd\u00ce\5\4\3\2\u00ce\u00cf\7"+
		"\35\2\2\u00cf\u00d0\5\4\3\2\u00d0\u00d9\3\2\2\2\u00d1\u00d2\7\34\2\2\u00d2"+
		"\u00d3\5\4\3\2\u00d3\u00d4\7\35\2\2\u00d4\u00d5\5\4\3\2\u00d5\u00d6\7"+
		"\36\2\2\u00d6\u00d7\5\4\3\2\u00d7\u00d9\3\2\2\2\u00d8\u00cc\3\2\2\2\u00d8"+
		"\u00d1\3\2\2\2\u00d9#\3\2\2\2\u00da\u00db\7\37\2\2\u00db\u00dc\5\4\3\2"+
		"\u00dc\u00dd\7 \2\2\u00dd\u00de\5\4\3\2\u00de%\3\2\2\2\u00df\u00e0\7!"+
		"\2\2\u00e0\u00e1\7,\2\2\u00e1\u00e2\7\6\2\2\u00e2\u00e3\5\4\3\2\u00e3"+
		"\u00e4\7\"\2\2\u00e4\u00e5\5\4\3\2\u00e5\u00e6\7 \2\2\u00e6\u00e7\5\4"+
		"\3\2\u00e7\'\3\2\2\2\u00e8\u00ea\7#\2\2\u00e9\u00eb\5*\26\2\u00ea\u00e9"+
		"\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\u00ef\7$\2\2\u00ef\u00f4\5\4\3\2\u00f0\u00f1\7\24"+
		"\2\2\u00f1\u00f3\5\4\3\2\u00f2\u00f0\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4"+
		"\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00f4\3\2"+
		"\2\2\u00f7\u00f8\7%\2\2\u00f8\u0103\3\2\2\2\u00f9\u00fb\7#\2\2\u00fa\u00fc"+
		"\5*\26\2\u00fb\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\7$\2\2\u0100\u0101\7%\2"+
		"\2\u0101\u0103\3\2\2\2\u0102\u00e8\3\2\2\2\u0102\u00f9\3\2\2\2\u0103)"+
		"\3\2\2\2\u0104\u0108\5,\27\2\u0105\u0108\5\62\32\2\u0106\u0108\5\64\33"+
		"\2\u0107\u0104\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0106\3\2\2\2\u0108+"+
		"\3\2\2\2\u0109\u010a\7&\2\2\u010a\u010b\7,\2\2\u010b\u010c\7\r\2\2\u010c"+
		"\u0115\7,\2\2\u010d\u010e\7&\2\2\u010e\u010f\7,\2\2\u010f\u0110\7\r\2"+
		"\2\u0110\u0111\7\'\2\2\u0111\u0112\7\31\2\2\u0112\u0115\7,\2\2\u0113\u0115"+
		"\5.\30\2\u0114\u0109\3\2\2\2\u0114\u010d\3\2\2\2\u0114\u0113\3\2\2\2\u0115"+
		"-\3\2\2\2\u0116\u0117\7&\2\2\u0117\u0118\7,\2\2\u0118\u0119\7\r\2\2\u0119"+
		"\u011a\7\32\2\2\u011a\u011f\5\60\31\2\u011b\u011c\7\30\2\2\u011c\u011e"+
		"\5\60\31\2\u011d\u011b\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2\2"+
		"\u011f\u0120\3\2\2\2\u0120\u0122\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0123"+
		"\7\33\2\2\u0123\u012a\3\2\2\2\u0124\u0125\7&\2\2\u0125\u0126\7,\2\2\u0126"+
		"\u0127\7\r\2\2\u0127\u0128\7\32\2\2\u0128\u012a\7\33\2\2\u0129\u0116\3"+
		"\2\2\2\u0129\u0124\3\2\2\2\u012a/\3\2\2\2\u012b\u012c\7,\2\2\u012c\u012d"+
		"\7(\2\2\u012d\u012e\7,\2\2\u012e\61\3\2\2\2\u012f\u0130\7)\2\2\u0130\u0131"+
		"\7,\2\2\u0131\u0132\7\6\2\2\u0132\u013a\5\4\3\2\u0133\u0134\7)\2\2\u0134"+
		"\u0135\7,\2\2\u0135\u0136\7(\2\2\u0136\u0137\7,\2\2\u0137\u0138\7\6\2"+
		"\2\u0138\u013a\5\4\3\2\u0139\u012f\3\2\2\2\u0139\u0133\3\2\2\2\u013a\63"+
		"\3\2\2\2\u013b\u013c\7*\2\2\u013c\u013d\7,\2\2\u013d\u013e\7\23\2\2\u013e"+
		"\u0143\5\60\31\2\u013f\u0140\7\30\2\2\u0140\u0142\5\60\31\2\u0141\u013f"+
		"\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		"\u0146\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u0147\7\25\2\2\u0147\u0148\7"+
		"(\2\2\u0148\u0149\7,\2\2\u0149\u014a\3\2\2\2\u014a\u014b\7\r\2\2\u014b"+
		"\u014c\5\4\3\2\u014c\u016c\3\2\2\2\u014d\u014e\7*\2\2\u014e\u014f\7,\2"+
		"\2\u014f\u0150\7\23\2\2\u0150\u0155\5\60\31\2\u0151\u0152\7\30\2\2\u0152"+
		"\u0154\5\60\31\2\u0153\u0151\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3"+
		"\2\2\2\u0155\u0156\3\2\2\2\u0156\u0158\3\2\2\2\u0157\u0155\3\2\2\2\u0158"+
		"\u0159\7\25\2\2\u0159\u015a\7\r\2\2\u015a\u015b\5\4\3\2\u015b\u016c\3"+
		"\2\2\2\u015c\u015d\7*\2\2\u015d\u015e\7,\2\2\u015e\u015f\7\23\2\2\u015f"+
		"\u0160\7\25\2\2\u0160\u0161\7(\2\2\u0161\u0162\7,\2\2\u0162\u0163\3\2"+
		"\2\2\u0163\u0164\7\r\2\2\u0164\u016c\5\4\3\2\u0165\u0166\7*\2\2\u0166"+
		"\u0167\7,\2\2\u0167\u0168\7\23\2\2\u0168\u0169\7\25\2\2\u0169\u016a\7"+
		"\r\2\2\u016a\u016c\5\4\3\2\u016b\u013b\3\2\2\2\u016b\u014d\3\2\2\2\u016b"+
		"\u015c\3\2\2\2\u016b\u0165\3\2\2\2\u016c\65\3\2\2\2\37FHPW_gnv|\u0088"+
		"\u008f\u009d\u00a6\u00ae\u00be\u00c6\u00d8\u00ec\u00f4\u00fd\u0102\u0107"+
		"\u0114\u011f\u0129\u0139\u0143\u0155\u016b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}