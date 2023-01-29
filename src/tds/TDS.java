package tds;

import java.util.ArrayList;

public class TDS {
    private final int id;
    private final TDS pere;
    private ArrayList<TDS> fils = new ArrayList<TDS>();

    private ArrayList<Type> types = new ArrayList<Type>();
    private ArrayList<Instance> instance = new ArrayList<Instance>();
    private ArrayList<Fonctions> fonctions = new ArrayList<Fonctions>();
    private ArrayList<Tableau> tableau = new ArrayList<Tableau>();
    private String TypeResult =null;
    private int taille = 0;
    private int tailleNeg =0;

    public TDS(int id, TDS pere){
        this.id = id;
        this.pere = pere;
    }

    public boolean VerifDeclarationPortee(String name){
        for( Instance instance : this.instance){
            if(instance.getName().equals(name)){
                return true;
            }
        }
        for( Fonctions fonct : this.fonctions){
            if(fonct.getFctName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean VerifDeclarationPorteeType(String name){
        for (Type type : this.types){
            if(type.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean TypeInTds(String type){
        for (Type type1 : this.types){
            if(type1.getName().equals(type)){
                return true;
            }
        }
        return false;
    }

    public Type getTypes(String name){
        for (Type type : this.types){
            if(type.getName().equals(name)){
                return type;
            }
        }
        return null;
    }

    public Instance getInstances(String name){
        for (Instance instance : this.instance){
            if(instance.getName().equals(name)){
                return instance;
            }
        }
        return null;
    }

    public boolean VerifDeclarationPorteeTableau(String name){
        for( Tableau tableau : this.tableau){
            if(tableau.getTdsName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public Type getPreviousType(String type){
        for (Type type1 : this.types){
            if(type1.getName().equals(type)){
                return type1;
            }
        }
        return null;
    }

    public void addInstance(Instance instance){
        this.instance.add(instance);
        if(instance.isFunctArg()){
            this.tailleNeg -= instance.getTypeSize();
            instance.setDecalage(this.tailleNeg);
        }
        else{
            instance.setDecalage(taille);
            this.taille += instance.getTypeSize();
        }
    }

    public void addType(Type type){
        this.types.add(type);
    }

    public void addFonct(Fonctions funct){

        this.fonctions.add(funct);
    }

    public void addTableau(Tableau struct){

        this.tableau.add(struct);
    }


    public TDS newChild(){
        TDS childTDS = new TDS(this.getNextId(),this);
        childTDS.TypeResult = this.TypeResult;
        this.fils.add(childTDS);

        return childTDS;
    }

    public void setTypeResult(String res){
        this.TypeResult = res;
    }

    public String getTypeResult(){
        return  this.TypeResult;
    }

    public int getNextId(){
        int size = this.fils.size();
        if(size==0){
            return this.id+1;
        }
        else{
            return this.fils.get(size-1).getNextId();
        }
    }


    public boolean VerifDeclaration(String instanceName){
        for( Instance inst : this.instance){
            if(inst.getName().equals(instanceName)){
                return true;
            }
        }
        for ( Fonctions funct : this.fonctions){
            if(funct.getFctName().equals(instanceName)){
                return true;
            }
        }
        if(pere !=null){
            return pere.VerifDeclaration(instanceName);
        }

        return false;
    }

    public TDS getPere() {
        if (this.pere != null) {
            return this.pere;
        }
        return null;
    }
    public boolean VerifDeclarationType(String instanceName){
        for( Type type : this.types){
            if(type.getName().equals(instanceName)){
                return true;
            }
        }
        if(pere !=null){
            return pere.VerifDeclarationType(instanceName);
        }

        return false;
    }

    public boolean isInt(String instanceName){
        for( Instance inst : this.instance){
            if(inst.getName().equals(instanceName)){
                return inst.isInt();
            }
        }
        if(pere !=null){
            return pere.VerifDeclaration(instanceName);
        }

        return false;
    }

    public  String getType(String instanceName){
        for( Instance inst : this.instance){
            if(inst.getName().equals(instanceName)){
                return inst.getType();
            }
        }
        if(pere !=null){
            return pere.getType(instanceName);
        }

        return null;
    }



    public boolean tableauDeclared(String tableauname){
        for( Tableau tableau : this.tableau){
            if(tableau.getTdsName().equals(tableauname)){
                return true;
            }
        }
        if(pere!=null){
            return pere.tableauDeclared(tableauname);
        }

        return false;
    }

    public Tableau getTableau(String tableauname){
        for( Tableau tableau : this.tableau){
            if(tableau.getTdsName().equals(tableauname)){
                return tableau;
            }
        }
        if(pere!=null){
            return pere.getTableau(tableauname);
        }

        return null;
    }

    public boolean fonctDeclared(String fonctname){
        for( Fonctions fonct : this.fonctions){
            if(fonct.getFctName().equals(fonctname)){
                return true;
            }
        }
        if(pere!=null){
            return pere.fonctDeclared(fonctname);
        }

        return false;
    }

    public Fonctions getFonct(String fonctname){
        for( Fonctions fonct : this.fonctions){
            if(fonct.getFctName().equals(fonctname)){
                return fonct;
            }
        }
        if(pere!=null){
            return pere.getFonct(fonctname);
        }

        return null;
    }

    private String getImbrication(){
        if(this.pere ==null){
            return String.valueOf(this.id);
        }
        else{
            return this.pere.getImbrication()+"."+String.valueOf(this.id);
        }
    }


    public void print(){
        System.out.println("région "+this.id +" --> imbrication "+this.getImbrication());
        if(!this.fonctions.isEmpty()) {
            System.out.println("liste des fonctions déclarées :");
            for (Fonctions f : this.fonctions) {
                f.print();
            }
        }

        if(!this.types.isEmpty()) {
            System.out.println("liste des types déclarés :");
            for (Type t : this.types) {
                t.print();
            }
        }

        if(!this.tableau.isEmpty()) {
            System.out.println("liste des tableaux déclarées :");
            for (Tableau tableau : this.tableau) {
                tableau.print();
            }
        }
        if(!this.instance.isEmpty()) {
            System.out.println("liste des instances déclarées :");
            for (Instance i : this.instance) {
                i.print("");
            }
        }


        System.out.println("---------------------------");
        for(TDS ch : this.fils){
            ch.print();
        }
    }

    public ArrayList<Instance> getInstance(){
        return this.instance;
    }



    public Localisation getLocInfo(String localisation){
        Localisation loc;
        for(Instance inst : this.instance){
            if(inst.getName().equals(localisation)){
                loc = new Localisation(inst.getDecalage(),0);
                return loc;
            }
        }

        loc = this.pere.getLocInfo(localisation);
        loc.InstancierImbrication(loc.numImbrication()+1);
        return loc;
    }
}