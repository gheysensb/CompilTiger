package tds;

import java.util.ArrayList;

public class Fonctions {

    private final String FctName;
    private final String typeResult;
    private ArrayList<Instance> parameter = new ArrayList<Instance>();

    public Fonctions(String FctName, String typeResult){
        this.FctName = FctName;
        this.typeResult = typeResult;
    }

    public boolean VerifDeclaration(String FctName){
        for(Instance inst : this.parameter){
            if(inst.getName().equals(FctName)){
                return true;
            }
        }
        return false;
    }

    public String getFctName() {
        return FctName;
    }

    public ArrayList<Instance> getParameter() {

        return parameter;
    }

    public String getTypeResult(){

        return this.typeResult;
    }

    public String getType(int index){

        return this.parameter.get(index).getType();
    }

    public void addParam(Instance inst){

        this.parameter.add(inst);
    }



    public void print(){
        System.out.println("       "+this.typeResult +" "+this.FctName);
        for(Instance inst : this.parameter){
            inst.simpleprint("      ");
        }
    }
}