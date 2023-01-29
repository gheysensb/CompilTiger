package ast;

import tds.Fonctions;
import tds.Instance;
import tds.TDS;


public class Program extends Ast{
    public <T> T accept(AstVisitor<T> visitor) {return visitor.visit(this);}

    public Ast expression;

    public Program(Ast expr, int line) {
        super(line);
        this.expression = expr;
    }


    public String getTDSandCheck(TDS tds) {
        this.expression.getTDSandCheck(tds);
        return null;
    }

}
