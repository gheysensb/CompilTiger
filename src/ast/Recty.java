package ast;

import error.ErrorFlag;
import tds.Record;
import tds.TDS;
import tds.Type;


public class Recty extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF IDF;

    public Recty(IDF IDF,int line){
        super(line);
        this.IDF = IDF;
    }

    public String getTDSandCheck(TDS tds) {
        if (tds.VerifDeclarationPorteeType(IDF.name)){
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne "+this.line+" : le type "+IDF.name+" est déjà déclaré");
        }
        else {
            Type type = new Record(IDF.name);
            tds.addType(type);
        }
        return null;
    }
}
