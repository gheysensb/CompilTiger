package ast;

import java.util.ArrayList;
import tds.TDS;
import tds.Tableau;


public class Letexpr extends Ast {
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> Ldec;

    public Letexpr(int line){
        super(line);
        this.Ldec= new ArrayList<>();
    }
    public void addLdec(Ast Declaration){
        this.Ldec.add(Declaration);
    }

    public String getTDSandCheck(TDS tds) {
        TDS newtds = tds.newChild();
        newtds.setTypeResult("void");
        Tableau tab = new Tableau(tds.getNextId()-1+"");
        tds.addTableau(tab);
        for (Ast Declaration : this.Ldec) {
            Declaration.getTDSandCheck(newtds);
        }
        return "void";
    }
}
