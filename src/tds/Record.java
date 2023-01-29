package tds;

import java.util.ArrayList;

public class Record extends Type{

    public String name;
    public String type;
    public ArrayList<String> nomElement = new ArrayList<String>();
    public ArrayList<String> typeElement = new ArrayList<String>();

    public Record(String name) {
        this.name = name;
        this.type = "record";
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<String> getFieldType(){
        return this.typeElement;
    }

    public void addElement(String nom, String type){
        this.nomElement.add(nom);
        this.typeElement.add(type);
    }

    public void print(){
        System.out.println("        " + this.name + " " + this.type);
        for(int i = 0; i < this.nomElement.size(); i++){
            System.out.println("            " + this.nomElement.get(i) + " " + this.typeElement.get(i));
        }
    }



}