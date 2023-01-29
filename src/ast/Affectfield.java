package ast;

import error.ErrorFlag;
import tds.*;
import tds.Record;

public class Affectfield extends Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast laValue;
    public IDF Identifiant;

    public Affectfield(Ast laValue, IDF Identifiant, int line) {
        super(line);
        this.laValue = laValue;
        this.Identifiant = Identifiant;
    }

    public String getTDSandCheck(TDS tds) {


        if (this.laValue instanceof IDF) {
            TDS declarredtds=tds;

            if (!tds.VerifDeclarationPortee(((IDF) this.laValue).name)) {

                if (tds.getPere() != null){
                    TDS previoustds = tds.getPere();
                    while (!previoustds.VerifDeclarationPortee(((IDF) this.laValue).name)) {
                        if (previoustds.getPere() == null) {
                            ErrorFlag.raiseError();
                            System.out.println("Erreur ligne " + this.line + " : la variable " + ((IDF) this.laValue).name + " n'est pas déclarée");
                            return "void";
                        }
                        else {
                            previoustds = previoustds.getPere();
                        }
                    }
                    declarredtds=previoustds;
                }
                else {
                    ErrorFlag.raiseError();
                    System.out.println("Erreur ligne " + this.line + " : la variable " + ((IDF) this.laValue).name + " n'est pas déclarée");
                    return "void";
                }
            }
            else {
                Instance inst = declarredtds.getInstances(((IDF) this.laValue).name);
                String typeinst = inst.getType();
                Type type = declarredtds.getTypes(typeinst);

                if (!(type instanceof Record)) {
                    ErrorFlag.raiseError();
                    System.out.println("Erreur ligne " + this.line + " : le type " + typeinst + " n'est pas un record");

                } else {
                    Record record = (Record) type;
                    for (int i = 0; i < record.nomElement.size(); i++) {
                        if (record.nomElement.get(i).equals(this.Identifiant.name)) {
                            return record.typeElement.get(i);
                        }
                    }
                    ErrorFlag.raiseError();
                    System.out.println("Erreur ligne " + this.line + " : le champ " + this.Identifiant.name + " n'existe pas dans le record " + ((IDF) this.laValue).name);
                }
            }
        }
        return "void";
    }
}

