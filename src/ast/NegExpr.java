package ast;

import error.ErrorFlag;
import tds.TDS;


public class NegExpr extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast negexpr;

    public NegExpr(Ast negexpr,int line){
        super(line);
        this.negexpr = negexpr;
    }

    public String getTDSandCheck(TDS tds) {
        String typeNegExpr;
        if (negexpr instanceof IDF){
            typeNegExpr = verifdec(negexpr,tds);
        }

        else {
            typeNegExpr = this.negexpr.getTDSandCheck(tds);
        }
        if (!typeNegExpr.equals("int")) {
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne " + this.line + " : negation d'un non-entier");
        }
        return "int";
    }

}
