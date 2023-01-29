package ast;

import error.ErrorFlag;
import tds.TDS;


public class MinusExpr extends Ast {
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;

    public MinusExpr(Ast left, Ast right,int line){
        super(line);
        this.left = left;
        this.right = right;
    }

    public String getTDSandCheck(TDS tds) {
        String leftType;
        String rightType;

        if (left instanceof IDF){
            leftType = verifdec(left,tds);
        }

        else {
            leftType = this.left.getTDSandCheck(tds);
        }
        if (right instanceof IDF){
            rightType = verifdec(right,tds);
        }

        else {
            rightType = this.right.getTDSandCheck(tds);
        }
        if (leftType.equals("int") && rightType.equals("int")) {
            return "int";
        }
        else {
            System.out.println("Erreur ligne "+ this.getLine() +" : les deux membres de la soustraction doivent être de type entier");
            return "int";
        }
    }
}
