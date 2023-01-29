package ast;

import java.util.ArrayList;
import tds.TDS;
import tds.Tableau;


public class Letexprexpr extends Ast {
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> Ldec;
    public Ast expression;
    public ArrayList<Ast> Lexpression;

    public Letexprexpr(Ast expression, int line){
        super(line);
        this.Ldec= new ArrayList<>();
        this.Lexpression = new ArrayList<>();
        this.expression = expression;
    }
    public void addLdec(Ast Declaration){
        this.Ldec.add(Declaration);
    }
    public void addLexpression(Ast expression){
        this.Lexpression.add(expression);
    }

    public String getTDSandCheck(TDS tds) {
        TDS newtds = tds.newChild();
        newtds.setTypeResult("void");
        Tableau tab = new Tableau(tds.getNextId()-1+"");
        tds.addTableau(tab);
        for (Ast Declaration : this.Ldec) {

            Declaration.getTDSandCheck(newtds);
        }
        if (this.Lexpression.size() == 0) {
            return this.expression.getTDSandCheck(newtds);
        }
        else {
            expression.getTDSandCheck(newtds);
            for (int i=0;i<this.Lexpression.size()-1;i++){
                this.Lexpression.get(i).getTDSandCheck(newtds);

            }
            return this.Lexpression.get(this.Lexpression.size() - 1).getTDSandCheck(newtds);
        }
    }
}
