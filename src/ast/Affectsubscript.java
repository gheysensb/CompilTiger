package ast;

import error.ErrorFlag;
import tds.*;
import tds.Record;

public class Affectsubscript extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast LaValue;
    public Ast expression;

    public Affectsubscript(Ast LaValue,Ast expression,int line){
        super(line);
        this.LaValue=LaValue;
        this.expression=expression;
    }

    public String getTDSandCheck(TDS tds) {
        if (this.LaValue instanceof IDF) {
            TDS declarredtds=tds;

            if (!tds.VerifDeclarationPortee(((IDF) this.LaValue).name)) {
                if (tds.getPere() != null){
                    TDS previoustds = tds.getPere();
                    while (!previoustds.VerifDeclarationPortee(((IDF) this.LaValue).name)) {
                        if (previoustds.getPere() == null) {
                            ErrorFlag.raiseError();
                            System.out.println("Erreur ligne " + this.line + " : la variable " + ((IDF) this.LaValue).name + " n'est pas déclarée");
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
                    System.out.println("Erreur ligne " + this.line + " : la variable " + ((IDF) this.LaValue).name + " n'est pas déclarée");
                    return "void";
                }
            }
            else {
                Instance inst = declarredtds.getInstances(((IDF) this.LaValue).name);
                String typeinst = inst.getType();
                Type type = declarredtds.getTypes(typeinst);

                if (!(type instanceof Array)) {
                    ErrorFlag.raiseError();
                    System.out.println("Erreur ligne " + this.line + " : le type " + typeinst + " n'est pas un array");

                } else {
                    Array array = (Array) type;
                    String typearray = array.getType();
                    String typeexpr = this.expression.getTDSandCheck(tds);
                    if (!typeexpr.equals("int")) {
                        ErrorFlag.raiseError();
                        System.out.println("Erreur ligne " + this.line + " : l'expression à l'intérieur des crochets n'est pas un entier");
                    }
                    return typearray;

                }
            }
        }
        return "void";
    }
}

