package ast;

import parser.exprBaseVisitor;
import parser.exprParser;

public class AstCreator extends exprBaseVisitor<Ast> {

    @Override
    public Ast visitProgram(exprParser.ProgramContext ctx){
        Ast child = ctx.getChild(0).accept(this);
        return new Program(child,ctx.getStart().getLine());
    }

    @Override
    public Ast visitExpr(exprParser.ExprContext ctx){
        return ctx.getChild(0).accept(this);
    }


    @Override
    public Ast visitAffectidf(exprParser.AffectidfContext ctx){
        return new IDF(ctx.getChild(0).toString(),ctx.getStart().getLine());
    }

    @Override
    public Ast visitAffectsubscript(exprParser.AffectsubscriptContext ctx){
        Ast laValue = ctx.getChild(0).accept(this);
        Ast expression = ctx.getChild(2).accept(this);
        return new Affectsubscript(laValue,expression,ctx.getStart().getLine());
    }

    @Override
    public  Ast visitAffectfield(exprParser.AffectfieldContext ctx){
        Ast laValue = ctx.getChild(0).accept(this);
        String lident = ctx.getChild(2).toString();
        return new Affectfield(laValue, new IDF(lident,ctx.getStart().getLine()),ctx.getStart().getLine());
    }
    @Override
    public Ast visitAssign(exprParser.AssignContext ctx){
        Ast laValue = ctx.getChild(0).accept(this);
        Ast assignment = ctx.getChild(2).accept(this);
        return new Assign(laValue,assignment,ctx.getStart().getLine());
    }

    @Override
    public Ast visitNoassign(exprParser.NoassignContext ctx){
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitOuExpr(exprParser.OuExprContext ctx){
        Ast noeudTemporaire = ctx.getChild(0).accept(this);


        for (int i=0;2*i<ctx.getChildCount()-1;i++){
            String operation = ctx.getChild(2*i+1).toString();
            Ast right = ctx.getChild(2*(i+1)).accept(this);
            if( operation.equals("|")){
                noeudTemporaire = new OuExpr(noeudTemporaire,right,ctx.getStart().getLine());
            }


        }

        return noeudTemporaire;

    }
    @Override
    public Ast visitEtExpr(exprParser.EtExprContext ctx){
        Ast noeudTemporaire = ctx.getChild(0).accept(this);
        for (int i=0;2*i<ctx.getChildCount()-1;i++){
            String operation = ctx.getChild(2*i+1).toString();
            Ast right = ctx.getChild(2*(i+1)).accept(this);
            if(operation.equals("&")){
                noeudTemporaire = new EtExpr(noeudTemporaire,right,ctx.getStart().getLine());
            }


        }

        return noeudTemporaire;

    }

    @Override
    public Ast visitCompareexpr(exprParser.CompareexprContext ctx){
        Ast noeudtemporaire = ctx.getChild(0).accept(this);
        String operator = ctx.getChild(1).toString();
        Ast droite = ctx.getChild(2).accept(this);
        switch (operator) {
            case "<":
                noeudtemporaire = new Inferieur(noeudtemporaire,droite,ctx.getStart().getLine());
                break;
            case ">":
                 noeudtemporaire =  new Superieur(noeudtemporaire,droite,ctx.getStart().getLine());
                break;
            case ">=":
                noeudtemporaire = new Superieuregal(noeudtemporaire,droite,ctx.getStart().getLine());
                break;
            case "<=":
                noeudtemporaire =  new Inferieuregal(noeudtemporaire,droite,ctx.getStart().getLine());
                break;
            case "=":
                noeudtemporaire =  new egal(noeudtemporaire,droite,ctx.getStart().getLine());
                break;
                case "<>":
                noeudtemporaire = new crochetcrochet(noeudtemporaire,droite,ctx.getStart().getLine());
                break;
            default:
                break;
        }
        return noeudtemporaire;
    }

    @Override
    public Ast visitCompare(exprParser.CompareContext ctx){
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitPlusmoinsExpr(exprParser.PlusmoinsExprContext ctx){
        Ast noeudTemporaire = ctx.getChild(0).accept(this);


        for (int i=0;2*i<ctx.getChildCount()-1;i++){

            String operation = ctx.getChild(2*i+1).toString();
            Ast right = ctx.getChild(2*(i+1)).accept(this);

            switch (operation) {
                case "-":
                    noeudTemporaire = new MinusExpr(noeudTemporaire,right,ctx.getStart().getLine());
                    break;
                case "+":
                    noeudTemporaire = new PlusmoinsExpr(noeudTemporaire,right,ctx.getStart().getLine());
                    break;
                default:
                    break;
            }
        }

        return noeudTemporaire;


    }
    @Override
    public Ast visitMuldivExpr(exprParser.MuldivExprContext ctx){
        Ast noeudTemporaire = ctx.getChild(0).accept(this);


        for (int i=0;2*i<ctx.getChildCount()-1;i++){

            String operation = ctx.getChild(2*i+1).toString();
            Ast right = ctx.getChild(2*(i+1)).accept(this);

            switch (operation) {
                case "*":
                    noeudTemporaire = new Mult(noeudTemporaire,right,ctx.getStart().getLine());
                    break;
                case "/":
                    noeudTemporaire = new Divide(noeudTemporaire,right,ctx.getStart().getLine());
                    break;
                default:
                    break;
            }
        }

        return noeudTemporaire;


    }
    @Override
    public Ast visitNegExpr(exprParser.NegExprContext ctx){
        int n = ctx.getChildCount();
        int pair = n%2;
        if(pair == 0){
            return new NegExpr(ctx.getChild(n-1).accept(this),ctx.getStart().getLine());
        }
        else{
            return ctx.getChild(n-1).accept(this);
        }
    }

    @Override
    public Ast visitNoparenthese(exprParser.NoparentheseContext ctx){
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitParentheseexpr(exprParser.ParentheseexprContext ctx){
        Ast expression = ctx.getChild(1).accept(this);
        Parentheseexpr aretu = new Parentheseexpr(expression,ctx.getStart().getLine());
        for (int i=0;2*i<ctx.getChildCount()-1;i++){
            String operation = ctx.getChild(2*i).toString();
            Ast right = ctx.getChild(2*i+1).accept(this);
            if(operation.equals(";")) {
                aretu.addParentheseExpr(right);
            }
        }
        return aretu;
    }





    @Override
    public Ast visitParenthese(exprParser.ParentheseContext ctx){
        return new Parenthese(ctx.getChild(0).toString(),ctx.getChild(1).toString(),ctx.getStart().getLine());
    }

    @Override
    public Ast visitIf(exprParser.IfContext ctx){
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitWhile(exprParser.WhileContext ctx){
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitFor(exprParser.ForContext ctx){
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitLet(exprParser.LetContext ctx){
        return ctx.getChild(0).accept(this);
    }

    @Override
    public  Ast visitNil(exprParser.NilContext ctx){
        return new Nil(ctx.getStart().getLine());
    }

    @Override
    public  Ast visitBreak(exprParser.BreakContext ctx){
        return new Break(ctx.getStart().getLine());
    }

    @Override
    public  Ast visitInt(exprParser.IntContext ctx){
        String entier = ctx.getChild(0).toString();

        return new INT(entier,ctx.getStart().getLine());
    }

    @Override
    public  Ast visitStrings(exprParser.StringsContext ctx){
        String entier = ctx.getChild(0).toString();
        int n = entier.length();
        String ret = entier.substring(1,n-1);
        return new Strings(ret,ctx.getStart().getLine());
    }

    @Override
    public Ast visitCall(exprParser.CallContext ctx){
        return ctx.getChild(0).accept(this);
    }
    @Override
    public Ast visitArr(exprParser.ArrContext ctx){
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitLvalue(exprParser.LvalueContext ctx){
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitRec(exprParser.RecContext ctx){
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitCallexprexpr(exprParser.CallexprexprContext ctx){
        String noeud1 = ctx.getChild(0).toString();
        IDF ident = new IDF(noeud1,ctx.getStart().getLine());
        Ast noeud2 = ctx.getChild(2).accept(this);
        Callexprexpr noeud = new Callexprexpr(ident,noeud2,ctx.getStart().getLine());
        for (int i=1;2*i<ctx.getChildCount()-2;i++){
            String operation = ctx.getChild(2*i+1).toString();
            Ast right = ctx.getChild(2*(i+1)).accept(this);
            if(operation.equals(",")){
                noeud.addLexpression(right);
            }
        }

        return noeud;
    }

    @Override
    public Ast visitCallexpr(exprParser.CallexprContext ctx){
        String entier = ctx.getChild(0).toString();
        IDF idf = new IDF(entier,ctx.getStart().getLine());
        return new Callexpr(idf,ctx.getStart().getLine());
    }
    @Override
    public Ast visitArrCreate(exprParser.ArrCreateContext ctx){
        String entier = ctx.getChild(0).toString();
        IDF ident = new IDF(entier,ctx.getStart().getLine());
        Ast deuxieme_fils = ctx.getChild(2).accept(this);
        Ast troisieme = ctx.getChild(5).accept(this);
        return new ArrCreate(ident,deuxieme_fils,troisieme,ctx.getStart().getLine());
    }

    @Override
    public Ast visitReccreatefield(exprParser.ReccreatefieldContext ctx){
        String elt = ctx.getChild(0).toString();
        IDF ident = new IDF(elt,ctx.getStart().getLine());
        Ast elt2 = ctx.getChild(2).accept(this);
        Reccreatefield Noeud = new Reccreatefield(ident,elt2,ctx.getStart().getLine());
        for (int i=1;2*i<ctx.getChildCount()-2;i++){
            String operation = ctx.getChild(2*i+1).toString();
            Ast right = ctx.getChild(2*(i+1)).accept(this);
            if(operation.equals(",")){
                Noeud.addReccreatefield(right);
            }
        }
        return Noeud;
    }

    @Override
    public Ast visitReccreate(exprParser.ReccreateContext ctx){
        String elt = ctx.getChild(0).toString();
        IDF idf = new IDF(elt,ctx.getStart().getLine());
        return new Reccreate(idf,ctx.getStart().getLine());
    }
    @Override
    public Ast visitFieldCreate(exprParser.FieldCreateContext ctx){
        String elt = ctx.getChild(0).toString();
        IDF ident = new IDF(elt,ctx.getStart().getLine());
        Ast noeud = ctx.getChild(2).accept(this);

        return new FieldCreate(ident,noeud,ctx.getStart().getLine());
    }
    @Override
    public Ast visitIfthen(exprParser.IfthenContext ctx){
        Ast noeud = ctx.getChild(1).accept(this);
        Ast noeud2 = ctx.getChild(3).accept(this);
        return new Ifthen(noeud,noeud2,ctx.getStart().getLine());
    }
    @Override
    public Ast visitIfthenelse(exprParser.IfthenelseContext ctx){
        Ast noeud = ctx.getChild(1).accept(this);
        Ast noeud2 = ctx.getChild(3).accept(this);
        Ast noeud3 = ctx.getChild(5).accept(this);
        return new Ifthenelse(noeud,noeud2,noeud3,ctx.getStart().getLine());
    }

    @Override
    public Ast visitWhileExpr(exprParser.WhileExprContext ctx){
        Ast noeud = ctx.getChild(1).accept(this);
        Ast noeud2 = ctx.getChild(3).accept(this);
        return new WhileExpr(noeud,noeud2,ctx.getStart().getLine());
    }

    @Override
    public Ast visitForExpr(exprParser.ForExprContext ctx){
        String noeud = ctx.getChild(1).toString();
        IDF noeud1 = new IDF(noeud,ctx.getStart().getLine());
        Ast noeud2 = ctx.getChild(3).accept(this);
        Ast noeud3 = ctx.getChild(5).accept(this);
        Ast noeud4 = ctx.getChild(7).accept(this);
        return new ForExpr(noeud1,noeud2,noeud3,noeud4,ctx.getStart().getLine());
    }

    @Override
    public Ast visitLetexprexpr(exprParser.LetexprexprContext ctx){
        int indicegarder = 0;
        for(int i=0;i< ctx.getChildCount();i++){
            String operator = ctx.getChild(i).toString();
            if(operator.equals("in")){
                indicegarder = i;
                i=ctx.getChildCount();
            }
        }

        Ast elt1 = ctx.getChild(indicegarder+1).accept(this);
        Letexprexpr ret = new Letexprexpr(elt1,ctx.getStart().getLine());
        for(int i=1;i< ctx.getChildCount();i++){
            String operator = ctx.getChild(i).toString();
            if(operator.equals("in")){
                indicegarder = i;
                i=ctx.getChildCount();
            }
            else{
                ret.addLdec(ctx.getChild(i).accept(this));
            }
        }
        for (int i=indicegarder+1;i<ctx.getChildCount()-1;i++){
            if(i+2<=ctx.getChildCount()-1) {
                String operation = ctx.getChild(i + 1).toString();
                Ast right = ctx.getChild(i + 2).accept(this);
                if (operation.equals(";")) {
                    ret.addLexpression(right);
                    i = i + 1;
                }
            }
        }
        return ret;
    }

    /* changer le parenthese expr dans la boucle le switch defaut et changer la borne de depart et d'arivee du parenthese expr*/

    @Override
    public Ast visitLetexpr(exprParser.LetexprContext ctx){

        Letexpr letexpr = new Letexpr(ctx.getStart().getLine());

        for (int i = 1; i<ctx.getChildCount()-2;i++){
            letexpr.addLdec(ctx.getChild(i).accept(this));
        }

        return letexpr;
    }

    @Override
    public Ast visitDec(exprParser.DecContext ctx){
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitTyidf(exprParser.TyidfContext ctx){
        String idfString1 = ctx.getChild(1).toString();
        IDF idf1 = new IDF(idfString1,ctx.getStart().getLine());
        String idfStrin2 = ctx.getChild(3).toString();
        IDF idf2 = new IDF(idfStrin2,ctx.getStart().getLine());

        return new Tyidf(idf1,idf2,ctx.getStart().getLine());
    }


    @Override
    public Ast visitTyarr(exprParser.TyarrContext ctx){
        String idfString1 = ctx.getChild(1).toString();
        IDF idf1 = new IDF(idfString1,ctx.getStart().getLine());
        String idfStrin2 = ctx.getChild(5).toString();
        IDF idf2 = new IDF(idfStrin2,ctx.getStart().getLine());

        return new Tyarr(idf1,idf2,ctx.getStart().getLine());
    }


    @Override
    public Ast visitTyrec(exprParser.TyrecContext ctx){
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Ast visitRectyfield(exprParser.RectyfieldContext ctx){
        String idfString = ctx.getChild(1).toString();
        IDF identidiant = new IDF(idfString,ctx.getStart().getLine());

        Ast fieldeclaration = ctx.getChild(4).accept(this);
        int total = ctx.getChildCount();

        Rectyfield rectyfield = new Rectyfield(identidiant, fieldeclaration,ctx.getStart().getLine());

        for (int i = 1; 2 * i < total - 2; i++) {
            String operation = ctx.getChild(2 * i + 1).toString();
            Ast fieldec = ctx.getChild(2 * (i + 1)).accept(this);
            if (operation.equals(",")) {
                rectyfield.addRectyfield(fieldec);
            }
        }
        return rectyfield;
    }

    @Override
    public Ast visitRecty(exprParser.RectyContext ctx){
        String idfString1 = ctx.getChild(1).toString();
        IDF idf1 = new IDF(idfString1,ctx.getStart().getLine());

        return new Recty(idf1,ctx.getStart().getLine());
    }


    @Override
    public Ast visitFieldDec(exprParser.FieldDecContext ctx){
        String idfString1 = ctx.getChild(0).toString();
        IDF idf1 = new IDF(idfString1,ctx.getStart().getLine());
        String idfStrin2 = ctx.getChild(2).toString();
        IDF idf2 = new IDF(idfStrin2,ctx.getStart().getLine());

        return new FieldDec(idf1,idf2,ctx.getStart().getLine());
    }
    @Override
    public Ast visitVar(exprParser.VarContext ctx){
        String idfString = ctx.getChild(1).toString();
        IDF idf = new IDF(idfString,ctx.getStart().getLine());

        Ast expr = ctx.getChild(3).accept(this);

        return new Var(idf,expr,ctx.getStart().getLine());
    }
    @Override
    public Ast visitVartyid(exprParser.VartyidContext ctx){
        Ast expr = ctx.getChild(5).accept(this);

        String idfString = ctx.getChild(1).toString();
        String idfString2 = ctx.getChild(3).toString();
        IDF idf1 = new IDF(idfString,ctx.getStart().getLine());
        IDF idf2 = new IDF(idfString2,ctx.getStart().getLine());

        return new Vartyid(idf1,idf2,expr,ctx.getStart().getLine());
    }

    /* TIBO */
    @Override
    public Ast visitFunfieldtyid(exprParser.FunfieldtyidContext ctx){
        int total = ctx.getChildCount();
        String idfString = ctx.getChild(1).toString();
        IDF identifiant1 = new IDF(idfString,ctx.getStart().getLine());
        Ast fieldeclaration = ctx.getChild(3).accept(this);
        String idfString2 = ctx.getChild(total-3).toString();
        IDF identifiant2 = new IDF(idfString2,ctx.getStart().getLine());
        Ast expression = ctx.getChild(total-1).accept(this);

        Funfieldtyid funfieldtyid = new Funfieldtyid(identifiant1,fieldeclaration,identifiant2,expression,ctx.getStart().getLine());

        for (int i = 2; 2 * i < total - 1; i++) {
            String operation = ctx.getChild(2 * i).toString();
            Ast fieldec = ctx.getChild(2 * i + 1).accept(this);
            if (operation.equals(",")) {
                funfieldtyid.addfieldeclaration(fieldec);
            }
        }
        return funfieldtyid;

    }

    @Override
    public Ast visitFunfield(exprParser.FunfieldContext ctx) {
        String idfString = ctx.getChild(1).toString();
        IDF identidiant = new IDF(idfString,ctx.getStart().getLine());

        Ast fieldeclaration = ctx.getChild(3).accept(this);
        int total = ctx.getChildCount();
        Ast expression = ctx.getChild(total - 1).accept(this);

        Funfield funfield = new Funfield(identidiant, fieldeclaration, expression,ctx.getStart().getLine());

        for (int i = 2; 2 * i < total - 1; i++) {
            String operation = ctx.getChild(2 * i).toString();
            Ast fieldec = ctx.getChild(2 * i + 1).accept(this);
            if (operation.equals(",")) {
                funfield.addFunfield(fieldec);
            }
        }
        return funfield;
    }

    @Override
    public Ast visitFuntyid(exprParser.FuntyidContext ctx){
        Ast expr = ctx.getChild(7).accept(this);
        String idfString = ctx.getChild(1).toString();
        String idfString2 = ctx.getChild(5).toString();

        IDF idf1 = new IDF(idfString,ctx.getStart().getLine());
        IDF idf2 = new IDF(idfString2,ctx.getStart().getLine());
        return new Funtyid(idf1,idf2,expr,ctx.getStart().getLine());
    }

    @Override
    public Ast visitFun(exprParser.FunContext ctx){
        Ast expr = ctx.getChild(5).accept(this);
        String idfString = ctx.getChild(1).toString();

        IDF idf = new IDF(idfString,ctx.getStart().getLine());
        return new Fun(idf,expr,ctx.getStart().getLine());
    }

}
