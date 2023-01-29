package ast;

import tds.TDS;

public class Break extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }


    public Break(int line) {
        super(line);
    }

    public String getTDSandCheck(TDS tds) {
        /* verify if the break is in a loop */

        return null;
    }

}
