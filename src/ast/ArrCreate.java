package ast;

import error.ErrorFlag;
import tds.Array;
import tds.TDS;
import tds.Type;

public class ArrCreate extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF Identifiant;
    public Ast expression1;
    public Ast expression2;

    public ArrCreate(IDF Identifiant,Ast expression1,Ast expression2, int line){
        super(line);
        this.Identifiant=Identifiant;
        this.expression1=expression1;
        this.expression2=expression2;
    }

    public String getTDSandCheck(TDS tds) {
        if (!tds.VerifDeclarationPorteeType(Identifiant.name)){
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne "+line+" : le type "+Identifiant.name+" n'a pas été déclaré");
        }
        else {
            Type type = tds.getTypes(Identifiant.name);
            if (!(type instanceof Array)) {
                ErrorFlag.raiseError();
                System.out.println("Erreur ligne " + line + " : le type " + Identifiant.name + " n'est pas de type array");
            }
            String typeexpr1 = this.expression1.getTDSandCheck(tds);
            if (!typeexpr1.equals("int")) {
                ErrorFlag.raiseError();
                System.out.println("Erreur ligne " + line + " : l'indice doit être de type int");
            }
            String typeexpr2 = this.expression2.getTDSandCheck(tds);
            if (type instanceof Array) {
                if (!typeexpr2.equals(((Array) type).type)) {
                    ErrorFlag.raiseError();
                    System.out.println("Erreur ligne " + this.line + " : le type de l'expression doit être de type " + ((Array) type).type);
                }
            }
        }
        return Identifiant.name;
    }
}
