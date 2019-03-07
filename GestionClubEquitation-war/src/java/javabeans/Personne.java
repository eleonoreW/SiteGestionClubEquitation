package javabeans;

public class Personne {
    private int personne_id;
    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private int date_naissance;
   
    public Personne(){}
    
    public Personne(int personne_id, String nom, String prenom, String mail, String telephone, int date_naissance){
        this.personne_id = personne_id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.telephone = telephone;
        this.date_naissance = date_naissance;
    }
    
    public Personne(String nom, String prenom, String mail, String telephone, int date_naissance){
        this.personne_id = -1;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.telephone = telephone;
        this.telephone = telephone;
        this.date_naissance = date_naissance;
    }
    
    public int getPersonne_id() {
        return personne_id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public int getDate_naissance() {
        return date_naissance;
    }

    public void setPersonne_id(int personne_id) {
        this.personne_id = personne_id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setDate_naissance(int date_naissance) {
        this.date_naissance = date_naissance;
    }
    
}