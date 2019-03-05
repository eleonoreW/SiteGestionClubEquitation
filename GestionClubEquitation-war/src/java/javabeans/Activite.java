package javabeans;

public class Activite {
    private int activite_id;
    private Personne personne;
    private Lieu lieu;
    private Type type;
    private String nom;
    private String commentaire;
    private String details;
    private int date;
    private float duree;
    private int capacite;
    private boolean est_active;
    
    public Activite(int activite_id, Personne personne, Lieu lieu, Type type, String nom, String commentaire,
            String details,int date, float duree, int capacite, boolean est_active){
        this.activite_id = activite_id;
        this.personne = personne;
        this.lieu = lieu;
        this.type = type;
        this.nom = nom;
        this.commentaire = commentaire;
        this.details = details;
        this.date = date;
        this.duree = duree;
        this.capacite = capacite;
        this.est_active = est_active;
    }

    public Activite(Personne personne, Lieu lieu, Type type, String nom, String commentaire, String details, int date, float duree, int capacite, boolean est_active) {
        this.personne = personne;
        this.lieu = lieu;
        this.type = type;
        this.nom = nom;
        this.commentaire = commentaire;
        this.details = details;
        this.date = date;
        this.duree = duree;
        this.capacite = capacite;
        this.est_active = est_active;
    }
    
    
}
    
