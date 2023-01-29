// Generated from ./expr.g4 by ANTLR 4.9.2

package parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link exprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface exprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link exprParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(exprParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(exprParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code affectidf}
	 * labeled alternative in {@link exprParser#lValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAffectidf(exprParser.AffectidfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code affectsubscript}
	 * labeled alternative in {@link exprParser#lValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAffectsubscript(exprParser.AffectsubscriptContext ctx);
	/**
	 * Visit a parse tree produced by the {@code affectfield}
	 * labeled alternative in {@link exprParser#lValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAffectfield(exprParser.AffectfieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link exprParser#assignExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(exprParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noassign}
	 * labeled alternative in {@link exprParser#assignExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoassign(exprParser.NoassignContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#ouExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOuExpr(exprParser.OuExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#etExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEtExpr(exprParser.EtExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareexpr}
	 * labeled alternative in {@link exprParser#comparerExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareexpr(exprParser.CompareexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compare}
	 * labeled alternative in {@link exprParser#comparerExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(exprParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#plusmoinsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusmoinsExpr(exprParser.PlusmoinsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#muldivExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMuldivExpr(exprParser.MuldivExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#negExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegExpr(exprParser.NegExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noparenthese}
	 * labeled alternative in {@link exprParser#seqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoparenthese(exprParser.NoparentheseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parentheseexpr}
	 * labeled alternative in {@link exprParser#seqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheseexpr(exprParser.ParentheseexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthese}
	 * labeled alternative in {@link exprParser#seqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthese(exprParser.ParentheseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link exprParser#otherExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(exprParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link exprParser#otherExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(exprParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code for}
	 * labeled alternative in {@link exprParser#otherExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(exprParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code let}
	 * labeled alternative in {@link exprParser#otherExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(exprParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nil}
	 * labeled alternative in {@link exprParser#otherExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNil(exprParser.NilContext ctx);
	/**
	 * Visit a parse tree produced by the {@code break}
	 * labeled alternative in {@link exprParser#otherExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(exprParser.BreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link exprParser#otherExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(exprParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strings}
	 * labeled alternative in {@link exprParser#otherExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrings(exprParser.StringsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code call}
	 * labeled alternative in {@link exprParser#otherExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(exprParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arr}
	 * labeled alternative in {@link exprParser#otherExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArr(exprParser.ArrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lvalue}
	 * labeled alternative in {@link exprParser#otherExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue(exprParser.LvalueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rec}
	 * labeled alternative in {@link exprParser#otherExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRec(exprParser.RecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callexprexpr}
	 * labeled alternative in {@link exprParser#callExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallexprexpr(exprParser.CallexprexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callexpr}
	 * labeled alternative in {@link exprParser#callExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallexpr(exprParser.CallexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#arrCreate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrCreate(exprParser.ArrCreateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code reccreatefield}
	 * labeled alternative in {@link exprParser#recCreate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReccreatefield(exprParser.ReccreatefieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code reccreate}
	 * labeled alternative in {@link exprParser#recCreate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReccreate(exprParser.ReccreateContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#fieldCreate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldCreate(exprParser.FieldCreateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifthen}
	 * labeled alternative in {@link exprParser#ifExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfthen(exprParser.IfthenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifthenelse}
	 * labeled alternative in {@link exprParser#ifExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfthenelse(exprParser.IfthenelseContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#whileExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileExpr(exprParser.WhileExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#forExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForExpr(exprParser.ForExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letexprexpr}
	 * labeled alternative in {@link exprParser#letExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetexprexpr(exprParser.LetexprexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letexpr}
	 * labeled alternative in {@link exprParser#letExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetexpr(exprParser.LetexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(exprParser.DecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tyidf}
	 * labeled alternative in {@link exprParser#tyDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyidf(exprParser.TyidfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tyarr}
	 * labeled alternative in {@link exprParser#tyDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyarr(exprParser.TyarrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tyrec}
	 * labeled alternative in {@link exprParser#tyDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyrec(exprParser.TyrecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rectyfield}
	 * labeled alternative in {@link exprParser#recTy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRectyfield(exprParser.RectyfieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code recty}
	 * labeled alternative in {@link exprParser#recTy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecty(exprParser.RectyContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#fieldDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDec(exprParser.FieldDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var}
	 * labeled alternative in {@link exprParser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(exprParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vartyid}
	 * labeled alternative in {@link exprParser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVartyid(exprParser.VartyidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funfieldtyid}
	 * labeled alternative in {@link exprParser#funDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunfieldtyid(exprParser.FunfieldtyidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funfield}
	 * labeled alternative in {@link exprParser#funDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunfield(exprParser.FunfieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funtyid}
	 * labeled alternative in {@link exprParser#funDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuntyid(exprParser.FuntyidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fun}
	 * labeled alternative in {@link exprParser#funDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(exprParser.FunContext ctx);
}