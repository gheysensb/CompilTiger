package ast;

public interface AstVisitor<T> {

    public T visit(Affectfield affect);
    public T visit(Affectsubscript affect);
    public T visit(ArrCreate affect);
    public T visit(Assign affect);
    public T visit(Callexprexpr affect);
    public T visit(Callexpr affect);
    public T visit(crochetcrochet affect);
    public T visit(Divide affect);
    public T visit(egal affect);
    public T visit(EtExpr affect);
    public T visit(FieldCreate affect);
    public T visit(FieldDec affect);
    public T visit(ForExpr affect);
    public T visit(Fun affect);
    public T visit(Funfield affect);
    public T visit(Funfieldtyid affect);
    public T visit(Funtyid affect);
    public T visit(IDF affect);
    public T visit(Ifthen affect);
    public T visit(Ifthenelse affect);
    public T visit(Inferieur affect);
    public T visit(Inferieuregal affect);
    public T visit(INT affect);
    public T visit(Letexpr affect);
    public T visit(Letexprexpr affect);
    public T visit(MinusExpr affect);
    public T visit(Mult affect);
    public T visit(NegExpr affect);
    public T visit(Nil affect);
    public T visit(OuExpr affect);
    public T visit(Parenthese affect);
    public T visit(Parentheseexpr affect);
    public T visit(PlusmoinsExpr affect);
    public T visit(Program affect);
    public T visit(Reccreate affect);
    public T visit(Reccreatefield affect);
    public T visit(Recty affect);
    public T visit(Rectyfield affect);
    public T visit(Strings affect);
    public T visit(Superieur affect);
    public T visit(Superieuregal affect);
    public T visit(Tyarr affect);
    public T visit(Tyidf affect);
    public T visit(Var affect);
    public T visit(Vartyid affect);
    public T visit(WhileExpr affect);
    public T visit(Break affect);



}
