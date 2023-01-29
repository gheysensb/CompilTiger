package ast;

import tds.TDS;

public class INT extends Ast {
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public String value;

    public INT(String value, int line) {
        super(line);
        this.value = value;
    }

    public String getTDSandCheck(TDS tds) {

        return "int";
    }
}
