package ast;

import tds.TDS;

public class Parenthese extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public String left;
    public String right;

    public Parenthese(String left, String right,int line){
        super(line);
        this.left = left;
        this.right = right;
    }

    public String getTDSandCheck(TDS tds) {
        return "void";

    }
}
