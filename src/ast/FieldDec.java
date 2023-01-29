package ast;

import tds.TDS;

import java.util.ArrayList;

public class FieldDec extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF identifiant1;
    public IDF identifiant2;

    public FieldDec(IDF identifiant1,IDF identifiant2,int line){
        super(line);
        this.identifiant1=identifiant1;
        this.identifiant2=identifiant2;
    }

    public String getTDSandCheck(TDS tds) {

        return null;
    }
}
