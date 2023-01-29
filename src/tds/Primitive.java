package tds;




public class Primitive extends Type {
    public String name;
    public String type;


    public Primitive(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public void print(){
        System.out.println("        " + this.name + " " + this.type);
    }




}