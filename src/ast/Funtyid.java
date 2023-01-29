package ast;

import error.ErrorFlag;
import tds.Fonctions;
import tds.Instance;
import tds.TDS;

public class Funtyid extends Ast {
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF identifiant1;
    public IDF identifiant2;
    public Ast expression;

    public Funtyid(IDF identifiant1,IDF identifiant2, Ast expression,int line){
        super(line);
        this.identifiant1=identifiant1;
        this.identifiant2=identifiant2;
        this.expression=expression;
    }

    public String getTDSandCheck(TDS tds) {
        if (tds.VerifDeclarationPortee(this.identifiant1.name)|| this.identifiant1.name.equals("print")) {
            //erreur
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne " +this.line +": " +this.identifiant1.name + " deja defini");
        }
        else {
            TDS childTDS = tds.newChild();
            childTDS.setTypeResult(identifiant2.name);
            Fonctions funct = new Fonctions(this.identifiant1.name, identifiant2.name);

            tds.addFonct(funct);

            String typebody = this.expression.getTDSandCheck(childTDS);
            if  (!identifiant2.name.equals(typebody)){
                ErrorFlag.raiseError();
                System.out.println("Erreur ligne "+this.line+" : " + "Le type de l'expression " + " n'est pas du type " + identifiant2.name);
            }

            if (!tds.TypeInTds(identifiant2.name) && !identifiant2.name.equals("int") &&  !identifiant2.name.equals("String")) {
                ErrorFlag.raiseError();
                System.out.println("Erreur ligne " + this.line + " : le type " + identifiant2.name + " n'existe pas");
            }
        }
        return null;
    }
}
