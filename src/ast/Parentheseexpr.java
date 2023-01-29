package ast;

import java.util.ArrayList;
import tds.TDS;


public class Parentheseexpr extends Ast {
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast left;
    public ArrayList<Ast> listexpr;

    public Parentheseexpr(Ast left,int line){
        super(line);
        this.left = left;
        this.listexpr= new ArrayList<>();
    }

    public void addParentheseExpr(Ast expr){
        this.listexpr.add(expr);
    }

    public String getTDSandCheck(TDS tds) {
        if (this.listexpr.size() == 0) {
            return this.left.getTDSandCheck(tds);
        }
        else {
            this.left.getTDSandCheck(tds);
            for (int i=0;i<this.listexpr.size()-1;i++){
                this.listexpr.get(i).getTDSandCheck(tds);
            }
            return this.listexpr.get(this.listexpr.size() - 1).getTDSandCheck(tds);
        }
    }
}
