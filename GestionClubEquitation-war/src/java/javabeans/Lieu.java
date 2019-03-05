package javabeans;

public class Lieu {
    private int lieu_id;
    private String name;
    private int capacite;
    private String description;
    
    public Lieu(int lieu_id, String name, int capacite, String description){
        this.lieu_id = lieu_id;
        this.name = name;
        this.capacite = capacite;
        this.description = description;
    }
    
    public Lieu(String name, int capacite, String description){
        this.lieu_id = -1;
        this.name = name;
        this.capacite = capacite;
        this.description = description;
    }
}
