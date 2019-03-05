package javabeans;

public class Type {
    private int type_id;
    private String nom;
    private String description;
    
    public Type(int type_id, String nom, String description){
        this.type_id = type_id;
        this.nom = nom;
        this.description = description; 
    }
    
    public Type(String name, String description){
        this.type_id = -1;
        this.nom = name;
        this.description = description; 
    }

    public int getType_id() {
        return type_id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }
    
    
}
