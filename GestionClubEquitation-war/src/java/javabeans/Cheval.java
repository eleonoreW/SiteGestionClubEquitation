package javabeans;

public class Cheval {
    private int cheval_id;
    private Race race;
    private Personne proprietaire;
    private String nom;
    private int dateNaissance;
    private String description;
    private String commentaire;
    private int nbHeureMaxSemaine;
    private int taille;

    public Cheval(int cheval_id, Race race, Personne proprietaire, String nom, int dateNaissance, String description, String commentaire, int nbHeureMaxSemaine, int taille) {
        this.cheval_id = cheval_id;
        this.race = race;
        this.proprietaire = proprietaire;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.description = description;
        this.commentaire = commentaire;
        this.nbHeureMaxSemaine = nbHeureMaxSemaine;
        this.taille = taille;
    }

    public Cheval(Race race, Personne proprietaire, String nom, int dateNaissance, String description, String commentaire, int nbHeureMaxSemaine, int taille) {
        this.race = race;
        this.proprietaire = proprietaire;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.description = description;
        this.commentaire = commentaire;
        this.nbHeureMaxSemaine = nbHeureMaxSemaine;
        this.taille = taille;
    }

    public int getCheval_id() {
        return cheval_id;
    }

    public void setCheval_id(int cheval_id) {
        this.cheval_id = cheval_id;
    }

    public Race getRace() {
        return race;
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

    public String getNom() {
        return nom;
    }

    public int getDateNaissance() {
        return dateNaissance;
    }

    public String getDescription() {
        return description;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public int getNbHeureMaxSemaine() {
        return nbHeureMaxSemaine;
    }

    public int getTaille() {
        return taille;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateNaissance(int dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setNbHeureMaxSemaine(int nbHeureMaxSemaine) {
        this.nbHeureMaxSemaine = nbHeureMaxSemaine;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }
    
    
}
