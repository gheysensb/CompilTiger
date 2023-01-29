package ast;

import error.ErrorFlag;
import tds.Primitive;
import tds.TDS;
import tds.Type;

public class Tyidf extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF left;
    public IDF right;

    public Tyidf(IDF left, IDF right,int line){
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
            Type type1 = new Primitive(left.name, right.name);
            tds.addType(type1);
        }
        if (!tds.TypeInTds(right.name) && !right.name.equals("int") &&  !right.name.equals("String")) {
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne " + this.line + " : le type " + right.name + " n'existe pas");
        }
        return null;
    }
}
