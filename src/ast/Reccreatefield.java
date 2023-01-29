package ast;

import java.util.ArrayList;

import error.ErrorFlag;
import tds.*;
import tds.Record;


public class Reccreatefield extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF Identifiant;
    public Ast expression1;
    public ArrayList<Ast> Lexpression;

    public Reccreatefield(IDF Identifiant,Ast expression1,int line){
        super(line);
        this.Identifiant=Identifiant;
        this.expression1=expression1;
        this.Lexpression= new ArrayList<>();
    }

    public void addReccreatefield(Ast expres){
        this.Lexpression.add(expres);
    }

    public String getTDSandCheck(TDS tds) {
        if (!tds.VerifDeclarationPorteeType(Identifiant.name)){
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne "+line+" : le type "+Identifiant.name+" n'a pas été déclaré");
        }
        else {
            Type type = tds.getTypes(Identifiant.name);
            if (!(type instanceof Record)) {
                ErrorFlag.raiseError();
                System.out.println("Erreur ligne " + line + " : le type " + Identifiant.name + " n'est pas de type record");
            } else {
                Record record = (Record) type;

                int taillefieldcreate = this.Lexpression.size() + 1;
                int taillefielddec = record.nomElement.size();
                if (taillefieldcreate != taillefielddec) {
                    ErrorFlag.raiseError();
                    System.out.println("Erreur ligne " + line + " : le nombre d'éléments du record ne correspond pas");
                } else {
                    String typeexpr1 = this.expression1.getTDSandCheck(tds);
                    if (this.expression1 instanceof FieldCreate field && field.identifiant instanceof IDF) {
                        if (!field.identifiant.name.equals(record.nomElement.get(0))) {
                            ErrorFlag.raiseError();
                            System.out.println("Erreur ligne " + this.line + " : le 1er élément (" + field.identifiant.name + ") ne correspond pas au nom " + record.nomElement.get(0));
                        }

                        if (!typeexpr1.equals(record.typeElement.get(0))) {
                            ErrorFlag.raiseError();
                            System.out.println("Erreur ligne " + this.line + " : le 1er élément (" + field.identifiant.name + ") ne correspond pas au type " + record.typeElement.get(0));
                        }
                    }

                    for (int i = 1; i < record.nomElement.size(); i++) {
                        String typeexpr = this.Lexpression.get(i - 1).getTDSandCheck(tds);
                        if (this.Lexpression.get(i - 1) instanceof FieldCreate field && field.identifiant instanceof IDF) {
                            if (!field.identifiant.name.equals(record.nomElement.get(i))) {
                                ErrorFlag.raiseError();
                                System.out.println("Erreur ligne " + this.line + " : l'élément " + (i+1) + " (" + field.identifiant.name + ") ne correspond pas au nom " + record.nomElement.get(i));
                            }
                            if (!typeexpr.equals(record.typeElement.get(i))) {
                                ErrorFlag.raiseError();
                                System.out.println("Erreur ligne " + this.line + " : l'élément " + (i+1) + " (" + field.identifiant.name + ") ne correspond pas au type " + record.typeElement.get(i));
                            }
                        }
                    }
                }
            }
        }
        return Identifiant.name;
    }
}
