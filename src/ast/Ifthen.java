package ast;
import error.ErrorFlag;
import tds.TDS;

public class Ifthen extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast expression1;
    public Ast expression2;

    public Ifthen(Ast expression1,Ast expression2,int line){
        super(line);
        this.expression1=expression1;
        this.expression2=expression2;
    }

    public String getTDSandCheck(TDS tds) {
        String ConditionType = this.expression1.getTDSandCheck(tds);
        String ThenClauseType = this.expression2.getTDSandCheck(tds);
        if(!ConditionType.equals("int")){
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne "+this.getLine()+ " : la condition doit être de type int");
        }
        if(!ThenClauseType.equals("void")){
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne "+this.getLine()+ " : le corps doit être de type void");
        }
        return "void";
    }
}
