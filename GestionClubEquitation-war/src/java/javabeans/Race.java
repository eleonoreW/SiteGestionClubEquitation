package javabeans;

public class Race {
    
    private int race_id;
    private String nom;
    
    public Race(int race_id, String nom) {
        this.race_id = race_id;
        this.nom = nom;
    }
    
    public Race(String nom) {
        this.race_id = -1;
        this.nom = nom;
    }
    
    public String getNom() {
        return this.nom;
    }

    public int getRace_id() {
        return race_id;
    }
    
}
