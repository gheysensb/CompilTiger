package ast;

import error.ErrorFlag;
import tds.Instance;
import tds.TDS;

public class Var extends Ast {
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF idf;
    public Ast expr;

    public Var(IDF idf, Ast expr,int line){
        super(line);
        this.idf = idf;
        this.expr = expr;
    }

    @Override
    public String getTDSandCheck(TDS tds) {
                if(tds.VerifDeclarationPortee(idf.name)){
                    //error
                    ErrorFlag.raiseError();
                    System.out.println("Erreur ligne "+String.valueOf(this.line)+" : la variable "+idf.name + " est deja instancie dans le scope");
                }
                else{
                    String typeexpr = this.expr.getTDSandCheck(tds);
                    tds.addInstance(new Instance(typeexpr,idf.name));
                }
        return null;
    }
}
