package ast;

import error.ErrorFlag;
import tds.Array;
import tds.TDS;
import tds.Type;

public class Tyarr extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF left;
    public IDF right;

    public Tyarr(IDF left, IDF right,int line){
        super(line);
        this.left = left;
        this.right = right;
    }

    public String getTDSandCheck(TDS tds) {
        if (tds.VerifDeclarationPorteeType(left.name)) {
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne " + this.line + " : " + left.name + " est déjà déclaré");
        }
        else {
            Type type = new Array(left.name, right.name);
            tds.addType(type);
        }
        if (!tds.TypeInTds(right.name) && !right.name.equals("int") &&  !right.name.equals("String")) {
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne " + this.line + " : le type " + right.name + " n'existe pas");
        }
        return null;
    }

}
