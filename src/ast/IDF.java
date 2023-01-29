package ast;

import tds.TDS;

public class IDF extends Ast {
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public String name;

    public IDF(String name,int line) {
        super(line);
        this.name = name;
    }

    public String getTDSandCheck(TDS tds) {
        return name;
    }
}
