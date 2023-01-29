package ast;

import error.ErrorFlag;
import tds.Fonctions;
import tds.Instance;
import tds.TDS;

import java.util.ArrayList;

public class Funfieldtyid extends Ast {
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF identifiant1;
    public Ast fieldeclaration1;
    public ArrayList<Ast> Lfieldeclaration;
    public IDF identifiant2;
    public Ast expression;

    public Funfieldtyid(IDF identifiant1,Ast fieldeclaration1,IDF identifiant2,Ast expression,int line){
        super(line);
        this.identifiant1=identifiant1;
        this.identifiant2=identifiant2;
        this.fieldeclaration1= fieldeclaration1;
        this.expression=expression;
        this.Lfieldeclaration= new ArrayList<>();
    }

    public void addfieldeclaration(Ast fieldeclaration){
        this.Lfieldeclaration.add(fieldeclaration);
    }

    public String getTDSandCheck(TDS tds) {
        if (tds.VerifDeclarationPortee(this.identifiant1.name) || this.identifiant1.name.equals("print")) {
            //erreur
            ErrorFlag.raiseError();
            System.out.println("Erreur : " + this.identifiant1.name + " deja defini");
        }
        //if (tds.VerifDeclarationPortee(this.identifiant2.name)) {
            //erreur
           // ErrorFlag.raiseError();
           // System.out.println("Erreur : " + this.identifiant2.name + " deja defini");
        //}
        else {
            TDS childTDS = tds.newChild();
            childTDS.setTypeResult(identifiant2.name);
            Fonctions funct = new Fonctions(this.identifiant1.name, identifiant2.name);

            if (this.fieldeclaration1 instanceof FieldDec identifiant && identifiant.identifiant1 instanceof IDF){
                if (funct.VerifDeclaration(identifiant.identifiant1.name)) { //On vérifie que le paramètre n'est pas déjà déclaré, la fonction VerfiDeclaration parcoure toutes les instances et vérifie qu'il n'a pas été déclaré
                    //erreur
                    ErrorFlag.raiseError();
                    System.out.println("Erreur ligne "+this.line+" : dans fonction " + this.identifiant1.name + " : deux arguments ont le meme nom -> " + identifiant.identifiant1.name);
                } else {
                    Instance inst = new Instance(identifiant.identifiant2.name, identifiant.identifiant1.name, true); //sinon on crée une instance du paramètre avec le boolean functArg sur true car c'est un paramètre de fonction
                    funct.addParam(inst);
                    childTDS.addInstance(inst); //On ajoute l'instance à la TDS de la fonction
                }
            }

            for (Ast ast : this.Lfieldeclaration) { //Lfunfield contient l'ensemble des fielDec de la règle : "'function' IDF '(' (fieldDec(',' fieldDec)*) ')' '=' expr #funfield"
                // On va parcourir les paramètres de la fonction qui sont tous de type IDF d'après la règle : fieldDec : IDF ':' IDF;
                if(ast instanceof FieldDec identifiant && identifiant.identifiant1 instanceof IDF ) { //On vérifie que le parametre est bien un FieldDec et que l'identifiant1 est bien un IDF
                    //On ne regarde que l'identifiant1 car il correspond au nom du paramètre, le 2ème correspond à son type

                    if (funct.VerifDeclaration(identifiant.identifiant1.name)) { //On vérifie que le paramètre n'est pas déjà déclaré, la fonction VerfiDeclaration parcoure toutes les instances et vérifie qu'il n'a pas été déclaré
                        //erreur
                        ErrorFlag.raiseError();
                        System.out.println("Erreur ligne "+this.line+" : dans fonction " + this.identifiant1.name + " : deux arguments ont le meme nom -> " + identifiant.identifiant1.name);
                    } else {
                        Instance inst = new Instance(identifiant.identifiant2.name, identifiant.identifiant1.name, true); //sinon on crée une instance du paramètre avec le boolean functArg sur true car c'est un paramètre de fonction
                        funct.addParam(inst);
                        childTDS.addInstance(inst); //On ajoute l'instance à la TDS de la fonction
                    }
                }
            }

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
