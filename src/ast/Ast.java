package ast;


import error.ErrorFlag;
import tds.TDS;

public abstract class Ast {

    protected int line;
    public abstract  <T> T accept(AstVisitor<T> visitor);

    public abstract String getTDSandCheck(TDS tds);

    protected Ast(int line){
        this.line = line;
    }

    public int getLine(){
        return this.line;
    }

    public String verifdec(Ast LaValue, TDS tds) {
        if (LaValue instanceof IDF) {
            TDS declarredtds = tds;

            if (!tds.VerifDeclarationPortee(((IDF) LaValue).name)) {


                if (tds.getPere() != null) {
                    TDS previoustds = tds.getPere();
                    while (!previoustds.VerifDeclarationPortee(((IDF) LaValue).name)) {
                        if (previoustds.getPere() == null) {
                            ErrorFlag.raiseError();
                            System.out.println("Erreur ligne " + this.line + " : la variable " + ((IDF) LaValue).name + " n'est pas déclarée");
                            return "void";
                        } else {
                            previoustds = previoustds.getPere();
                        }
                    }
                    declarredtds = previoustds;

                } else {
                    ErrorFlag.raiseError();
                    System.out.println("Erreur ligne " + this.line + " : la variable " + ((IDF) LaValue).name + " n'est pas déclarée");
                    return "void";
                }


            }String typelavalue = declarredtds.getInstances(((IDF) LaValue).name).getType();
            return typelavalue;
        }
        return "void";
    }

}
