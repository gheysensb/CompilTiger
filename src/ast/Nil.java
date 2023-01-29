package ast;

import tds.TDS;


public class Nil extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }


    public Nil(int line) {
        super(line);
    }

    public String getTDSandCheck(TDS tds) {
        return "nil";
    }

}
