package ast;

import java.util.ArrayList;

import error.ErrorFlag;
import tds.Record;
import tds.TDS;
import tds.Type;

public class Rectyfield extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF identifiant;
    public Ast fieldeclaration;
    public ArrayList<Ast> Lfunfield;


    public Rectyfield(IDF identifiant, Ast fieldeclaration, int line){
        super(line);
        this.identifiant = identifiant;
        this.fieldeclaration = fieldeclaration;
        this.Lfunfield = new ArrayList<>();
    }

    public void addRectyfield(Ast Rectyfield){
        this.Lfunfield.add(Rectyfield);
    }

    public String getTDSandCheck(TDS tds) {
        if (tds.VerifDeclarationPorteeType(identifiant.name)){
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne "+this.line+" : le type "+identifiant.name+" est déjà déclaré");
        }
        else {

            Record record = new Record(identifiant.name);
            if (this.fieldeclaration instanceof FieldDec fieldec && fieldec.identifiant1 instanceof IDF && fieldec.identifiant2 instanceof IDF) {
                record.addElement(fieldec.identifiant1.name, fieldec.identifiant2.name);
            }
            for (Ast ast : this.Lfunfield) {
                if (ast instanceof FieldDec fieldec && fieldec.identifiant1 instanceof IDF && fieldec.identifiant2 instanceof IDF) {
                    if (record.nomElement.contains(fieldec.identifiant1.name)) {
                        ErrorFlag.raiseError();
                        System.out.println("Erreur ligne "+this.line+" : le champ "+fieldec.identifiant1.name+" est déjà déclaré");
                    }
                    else {
                        record.addElement(fieldec.identifiant1.name, fieldec.identifiant2.name);
                    }

                }
            }
            tds.addType(record);
            for (String s : record.typeElement) {
                if (!tds.TypeInTds(s) && !s.equals("int") &&  !s.equals("String")) {
                    ErrorFlag.raiseError();
                    System.out.println("Erreur ligne " + this.line + " : le type " + s + " n'existe pas");
                }
            }

        }
        return null;
    }
}
