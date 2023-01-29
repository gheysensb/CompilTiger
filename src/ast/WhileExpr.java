package ast;

import error.ErrorFlag;
import tds.TDS;

public class WhileExpr extends Ast {
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast exprwhile;

    public Ast exprdo;

    public WhileExpr(Ast exprwhile, Ast exprdo,int line){
        super(line);
        this.exprwhile = exprwhile;
        this.exprdo = exprdo;
    }

    public String getTDSandCheck(TDS tds) {
        String typecondition = this.exprwhile.getTDSandCheck(tds);
        String typebody = this.exprdo.getTDSandCheck(tds);
        if (!typecondition.equals("int")) {
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne "+ this.line +" : la condition du while doit être un entier");
        }
        if (!typebody.equals("void")) {
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne "+ this.line +" : le corps du while doit être de type void");
        }
        return "void";
    }
}
