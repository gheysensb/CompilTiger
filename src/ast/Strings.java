package ast;

import tds.TDS;

public class Strings extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public String name;

    public Strings(String name,int line) {
        super(line);
        this.name = name;
    }

    public String getTDSandCheck(TDS tds) {
        return "String";
    }
}
