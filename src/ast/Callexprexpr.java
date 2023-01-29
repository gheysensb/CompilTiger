package ast;

import error.ErrorFlag;
import tds.Fonctions;
import tds.TDS;

import java.util.ArrayList;

public class Callexprexpr extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF Identifiant;
    public Ast expression1;
    public ArrayList<Ast> Lexpression;

    public Callexprexpr(IDF Identifiant,Ast expression1, int line){
        super(line);
        this.Identifiant=Identifiant;
        this.expression1=expression1;
        this.Lexpression= new ArrayList<>();
    }

    public void addLexpression(Ast expres){
        this.Lexpression.add(expres);
    }

    public String getTDSandCheck(TDS tds) {
        Fonctions funct = tds.getFonct(this.Identifiant.name);
        if (Identifiant.name.equals("print")){
            if (this.Lexpression.size() != 0){
                ErrorFlag.raiseError();
                System.out.println("Erreur ligne " +this.line + " : print ne prend qu'un seul argument maximum");
            }
            else {
                String type = this.expression1.getTDSandCheck(tds);
                if (!type.equals("string")){
                    ErrorFlag.raiseError();
                    System.out.println("Erreur ligne " +this.line + " : print ne prend que des String");
                }
            }
            return "void";
        }
        else {
            if (funct == null) {
                //error fonction non trouvée/déclarée
                ErrorFlag.raiseError();
                System.out.println("Erreur ligne " + this.line + " : la fonction " + this.Identifiant.name + " n'est pas définie");
            } else if (funct.getParameter().size() != this.Lexpression.size()+1) {
                //error sur la taille des arguments
                ErrorFlag.raiseError();
                System.out.println("Erreur ligne " + this.line + " : le nombre d'arguments est différent de la valeur prévue : " + String.valueOf((this.Lexpression.size())) + " doit être " + String.valueOf(funct.getParameter().size()));
            }
            else {
                String typeexpr1 = this.expression1.getTDSandCheck(tds);
                if (!typeexpr1.equals(funct.getType(0))) {
                    ErrorFlag.raiseError();
                    System.out.println("Erreur ligne " + this.line + " : le premier argument doit être de type " + funct.getType(0));
                }
                for (int i = 0; i < this.Lexpression.size(); i++) {
                    Ast ast = this.Lexpression.get(i);
                    String type = ast.getTDSandCheck(tds);
                    if (!type.equals(funct.getType(i+1))) {
                        //error
                        ErrorFlag.raiseError();
                        System.out.println("Erreur ligne " + this.line + " : l'argument " + (i+2) +  " doit être de type " + funct.getType(0));
                    }
                }
                return funct.getTypeResult();
            }
        }
        return "void";
    }
}

