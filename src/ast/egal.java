package ast;

import error.ErrorFlag;
import tds.TDS;

import java.util.ArrayList;

public class egal extends   Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast plusoumoins1;
    public Ast plusoumoins2;

    public egal(Ast plusoumoins1,Ast plusoumoins2, int line){
        super(line);
        this.plusoumoins1 = plusoumoins1;
        this.plusoumoins2 = plusoumoins2;
    }

    public String getTDSandCheck(TDS tds) {
        String leftType;
        String rightType;

        if (plusoumoins1 instanceof IDF){
            leftType = verifdec(plusoumoins1,tds);
        }

        else {
            leftType = this.plusoumoins1.getTDSandCheck(tds);
        }
        if (plusoumoins2 instanceof IDF){
            rightType = verifdec(plusoumoins2,tds);
        }

        else {
            rightType = this.plusoumoins2.getTDSandCheck(tds);
        }
        if (!leftType.equals(rightType)){
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne "+this.line+" : Comparaison de deux types différents");

        }
        return "int";

    }
}
