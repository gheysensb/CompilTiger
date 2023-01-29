package ast;

import error.ErrorFlag;
import tds.Fonctions;
import tds.TDS;

public class Fun extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF identifiant;
    public Ast expression;

    public Fun(IDF identifiant,Ast expression,int line){
        super(line);
        this.identifiant=identifiant;
        this.expression=expression;
    }

    public String getTDSandCheck(TDS tds) {
        this.identifiant.getTDSandCheck(tds);

        if (tds.VerifDeclarationPortee(this.identifiant.name) || this.identifiant.name.equals("print")) {
            //erreur
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne "+this.line+" : " + this.identifiant.name + " deja defini");
        }
        else {
            TDS childTDS = tds.newChild();
            childTDS.setTypeResult("void");
            Fonctions funct = new Fonctions(this.identifiant.name, "void");
            tds.addFonct(funct);

            String typeBody = this.expression.getTDSandCheck(childTDS);

            if (!typeBody.equals("void")) {
                ErrorFlag.raiseError();
                System.out.println("Erreur ligne "+this.line+" : " + this.identifiant.name + " n'est pas du type void");
            }
        }
        return null;
    }
}
