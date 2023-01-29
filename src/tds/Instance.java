package tds;

public class Instance {
    private final String type;
    private final String name;
    private int decalage = 0;
    private final boolean functArg;

    public Instance(String type, String name) {
        this.type = type;
        this.name = name;
        this.functArg = false;
    }

    public Instance(String type, String name, boolean b) {
        this.type = type;
        this.name = name;
        this.functArg = b;

    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getDecalage() {
        return this.decalage;
    }

    public void setDecalage(int dec) {
        this.decalage = dec;
    }

    public boolean isFunctArg() {
        return this.functArg;
    }

    public boolean isInt() {
        return this.type.equals("int");
    }

    public void print(String decalage) {
        System.out.println(decalage + "        " + this.type + " " + this.name + " " + this.decalage + " " + (this.functArg ? "argument" : ""));
    }

    public void simpleprint(String decalage) {
        System.out.println(decalage + "        " + this.type + " " + this.name);
    }

    public int getTypeSize() {
        return 4; //size int = 4
    }
}
