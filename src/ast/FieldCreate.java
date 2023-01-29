package ast;

import tds.TDS;

public class FieldCreate extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public IDF identifiant;
    public Ast expression;

    public FieldCreate(IDF identifiant,Ast expression,int line){
        super(line);
        this.identifiant=identifiant;
        this.expression=expression;
    }

    public String getTDSandCheck(TDS tds) {

        String type = this.expression.getTDSandCheck(tds);
        return type;
    }
}
