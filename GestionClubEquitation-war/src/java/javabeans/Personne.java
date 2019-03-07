package javabeans;

public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private int date_naissance;
    private String password;

    public Personne(int id, String nom, String prenom, String mail, String telephone, int date_naissance, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.telephone = telephone;
        this.date_naissance = date_naissance;
        this.password = password;
    }
   
    public Personne(){}
    
    public Personne(String nom, String prenom, String mail, String telephone, int date_naissance, String password){
        this.id = -1;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.telephone = telephone;
        this.telephone = telephone;
        this.date_naissance = date_naissance;
        this.password = password;
    }
    
    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}