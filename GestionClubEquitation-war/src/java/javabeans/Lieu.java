package javabeans;

public class Lieu {
    private int lieu_id;
    private String nom;
    private int capacite;
    private String description;
    
    public Lieu(int lieu_id, String nom, int capacite, String description){
        this.lieu_id = lieu_id;
        this.nom = nom;
        this.capacite = capacite;
        this.description = description;
    }
    
    public Lieu(String nom, int capacite, String description){
        this.lieu_id = -1;
        this.nom = nom;
        this.capacite = capacite;
        this.description = description;
    }

    public int getLieu_id() {
        return lieu_id;
    }

    public String getNom() {
        return nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public String getDescription() {
        return description;
    }
    
    
}
