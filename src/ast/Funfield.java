package ast;

import error.ErrorFlag;
import tds.Fonctions;
import tds.Instance;
import tds.TDS;

import java.util.ArrayList;

public class Funfield extends Ast {
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF identifiant;
    public Ast fieldeclaration;
    public ArrayList<Ast> Lfunfield;
    public Ast expression;

    public Funfield(IDF identifiant,Ast fieldeclaration,Ast expression,int line){
        super(line);
        this.identifiant=identifiant;
        this.fieldeclaration = fieldeclaration;
        this.expression=expression;
            this.Lfunfield = new ArrayList<>();
    }

    public void addFunfield(Ast Funfield){
        this.Lfunfield.add(Funfield);
    }

    @Override
    public String getTDSandCheck(TDS tds) {

        if (tds.VerifDeclarationPortee(this.identifiant.name) || this.identifiant.name.equals("print")) {
            //erreur
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne "+ this.line +" : " + this.identifiant.name + " deja defini");
        }
        else {
            TDS childTDS = tds.newChild();
            childTDS.setTypeResult("void");
            Fonctions funct = new Fonctions(this.identifiant.name, "void");

            if (this.fieldeclaration instanceof FieldDec identifiant && identifiant.identifiant1 instanceof IDF){
                if (funct.VerifDeclaration(identifiant.identifiant1.name)) { //On vérifie que le paramètre n'est pas déjà déclaré, la fonction VerfiDeclaration parcoure toutes les instances et vérifie qu'il n'a pas été déclaré
                    //erreur
                    ErrorFlag.raiseError();
                    System.out.println("Erreur ligne "+this.line+" : dans fonction " + this.identifiant.name + " : deux arguments ont le meme nom -> " + identifiant.identifiant1.name);
                } else {
                    Instance inst = new Instance(identifiant.identifiant2.name, identifiant.identifiant1.name, true); //sinon on crée une instance du paramètre avec le boolean functArg sur true car c'est un paramètre de fonction
                    funct.addParam(inst);
                    childTDS.addInstance(inst); //On ajoute l'instance à la TDS de la fonction
                }
            }

            for (Ast ast : this.Lfunfield) { //Lfunfield contient l'ensemble des fielDec de la règle : "'function' IDF '(' (fieldDec(',' fieldDec)*) ')' '=' expr #funfield"
                                            // On va parcourir les paramètres de la fonction qui sont tous de type IDF d'après la règle : fieldDec : IDF ':' IDF;
                if(ast instanceof FieldDec identifiant && identifiant.identifiant1 instanceof IDF ) { //On vérifie que le parametre est bien un FieldDec et que l'identifiant1 est bien un IDF
                                                                                                     //On ne regarde que l'identifiant1 car il correspond au nom du paramètre, le 2ème correspond à son type

                    if (funct.VerifDeclaration(identifiant.identifiant1.name)) { //On vérifie que le paramètre n'est pas déjà déclaré, la fonction VerfiDeclaration parcoure toutes les instances et vérifie qu'il n'a pas été déclaré
                        //erreur
                        ErrorFlag.raiseError();
                        System.out.println("Erreur ligne "+this.line+" : dans fonction " + this.identifiant.name + " : deux arguments ont le meme nom -> " + identifiant.identifiant1.name);
                    } else {
                        Instance inst = new Instance(identifiant.identifiant2.name, identifiant.identifiant1.name, true); //sinon on crée une instance du paramètre avec le boolean functArg sur true car c'est un paramètre de fonction
                        funct.addParam(inst);
                        childTDS.addInstance(inst); //On ajoute l'instance à la TDS de la fonction
                    }
                }
            }
            tds.addFonct(funct);


            String typeBody = this.expression.getTDSandCheck(childTDS);

            if (!typeBody.equals("void")){
                //erreur
                ErrorFlag.raiseError();
                System.out.println("Erreur ligne " + this.line + " : " + "le type de retour de la fonction doit etre void");
            }

        }
        return null;
    }


}
