package ast;

import error.ErrorFlag;
import tds.Array;
import tds.Record;
import tds.TDS;
import tds.Type;


public class Reccreate extends Ast {
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF IDF;

    public Reccreate(IDF IDF,int line){
        super(line);
        this.IDF = IDF;
    }

    public String getTDSandCheck(TDS tds) {
        if (!tds.VerifDeclarationPorteeType(IDF.name)){
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne "+line+" : le type "+IDF.name+" n'a pas été déclaré");
        }
        else{
            Type type = tds.getTypes(IDF.name);

            if (!(type instanceof Record)) {
                ErrorFlag.raiseError();
                System.out.println("Erreur ligne " + line + " : le type " + IDF.name + " n'est pas de type record");
            }
        }
        return IDF.name;
    }
}
