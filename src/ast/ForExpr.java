package ast;

import error.ErrorFlag;
import tds.TDS;

import java.lang.reflect.Type;

public class ForExpr extends Ast {
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF identifiant;
    public Ast expression1;
    public Ast expression2;
    public Ast expression3;

    public ForExpr(IDF identifiant,Ast expression1,Ast expression2,Ast expression3,int line){
        super(line);
        this.identifiant=identifiant;
        this.expression1=expression1;
        this.expression2=expression2;
        this.expression3=expression3;
    }

    public String getTDSandCheck(TDS tds) {
        this.identifiant.getTDSandCheck(tds);
        String TypeExpr1 = this.expression1.getTDSandCheck(tds);
        String TypeExpr2 = this.expression2.getTDSandCheck(tds);
        String TypeBody = this.expression3.getTDSandCheck(tds);

        if(!TypeExpr1.equals("int")){
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne " + this.line + " : l'indice de départ doit être de type int");
        }
        if(!TypeExpr2.equals("int")){
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne " + this.line + " : l'indice de fin doit être de type int");
        }
        if/*(!TypeBody.equals("void"))*/ (TypeBody != null) {
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne "+this.line + " : le corps doit être de type void");
        }
        return "void";



    }
}
