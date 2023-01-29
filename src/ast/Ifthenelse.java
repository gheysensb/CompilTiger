package ast;
import tds.TDS;
import error.ErrorFlag;

public class Ifthenelse extends Ast{
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast expression1;
    public Ast expression2;
    public Ast expression3;

    public Ifthenelse(Ast expression1,Ast expression2,Ast expression3,int line){
        super(line);
        this.expression1=expression1;
        this.expression2=expression2;
        this.expression3=expression3;
    }

    public String getTDSandCheck(TDS tds) {
        String ConditionType = this.expression1.getTDSandCheck(tds);
        String ThenClauseType = this.expression2.getTDSandCheck(tds);
        String ElseClauseType = this.expression3.getTDSandCheck(tds);

        //The condition type must be int, and
        //the then-clause and else-clause must have the same
        //type,  becomes the result type.
        if(!ConditionType.equals("int")){
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne "+this.getLine()+" : la condition doit être de type int");
        }
        if(!ThenClauseType.equals(ElseClauseType)){
            ErrorFlag.raiseError();
            System.out.println("Erreur ligne "+this.getLine()+" : le Then et le Else doivent être de même type");
        }

        return ThenClauseType;
    }
}
