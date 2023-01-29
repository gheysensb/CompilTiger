package tds;
import java.util.ArrayList;

public class Tableau {
    private String TdsName;
    private ArrayList<Instance> instances = new ArrayList<>();
    private int size=0;

    public Tableau(String name){

        this.TdsName = name;
    }



    public String getTdsName(){

        return this.TdsName;
    }

    public int getsize(){
        return this.size;
    }

    public boolean VerifDeclaration(String instName){
        for(Instance inst :this.instances){
            if(inst.getName().equals(instName)){
                return true;
            }
        }
        return false;
    }

    public Instance get(String s){
        for(Instance inst : instances){
            if(inst.getName().equals(s)){
                return  inst;
            }
        }
        return null;
    }

    public String getType(String instName){
        for(Instance inst :this.instances){
            if(inst.getName().equals(instName)){
                return inst.getType();
            }
        }
        return null;
    }

    public void print(){
        System.out.println("       "+this.TdsName +" a un décalage égal à : "+String.valueOf(this.size));
        for(Instance i : this.instances){
            i.print("      ");
        }
    }


    public void addInstance(Instance instance, TDS tds){
        this.instances.add(instance);
        instance.setDecalage(this.size);
        this.size += instance.getTypeSize();
    }
}