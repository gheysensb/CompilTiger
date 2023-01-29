package ast;


import error.ErrorFlag;
import tds.Fonctions;
import tds.TDS;

public class Callexpr extends Ast {
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF IDF;

    public Callexpr(IDF IDF, int line){
        super(line);
        this.IDF = IDF;
    }

    public String getTDSandCheck(TDS tds) {
        Fonctions funct = tds.getFonct(this.IDF.name);
        if (IDF.name.equals("print")) {
            return "void";
        }
        else {
            if (funct == null) {
                //error fonction non trouvée/déclarée
                ErrorFlag.raiseError();
                System.out.println("Erreur ligne " + this.line + " : la fonction " + this.IDF.name + " n'est pas définie");
            }
            else if (funct.getParameter()== null) {
                //error sur la taille des arguments
                ErrorFlag.raiseError();
                System.out.println("Erreur ligne " + this.line + " : le nombre d'arguments est différent de la valeur prévue : 0, nombre d'arguments de la fonction : " + String.valueOf(funct.getParameter().size()));
                return funct.getTypeResult();

            }
        }
        return "void";
    }
}

