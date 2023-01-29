package ast;

import error.ErrorFlag;
import tds.Fonctions;
import tds.Instance;
import tds.TDS;
public class Vartyid extends Ast {
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF left;
    public IDF middle;
    public Ast right;

    public Vartyid(IDF left, IDF middle, Ast right,int line){
        super(line);
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    public String getTDSandCheck(TDS tds) {

        if (tds.VerifDeclarationPortee(this.left.name)) {
            //erreur
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne " + String.valueOf(this.line) + " : la variable " + this.left.name + " est deja instancie dans le scope");
        }
        else {
            Instance inst = new Instance(this.middle.name, left.name);

            tds.addInstance(inst);

            String typebody = this.right.getTDSandCheck(tds);
            if  (!middle.name.equals(typebody)){
                ErrorFlag.raiseError();
                System.out.println("Erreur ligne "+this.line+" : " + "Le type de l'expression " + " n'est pas du type " + middle.name);
            }

            if (!tds.TypeInTds(middle.name) && !middle.name.equals("int") &&  !middle.name.equals("String")) {
                ErrorFlag.raiseError();
                System.out.println("Erreur ligne " + this.line + " : le type " + middle.name + " n'existe pas");
            }
        }
        return null;
    }
}
