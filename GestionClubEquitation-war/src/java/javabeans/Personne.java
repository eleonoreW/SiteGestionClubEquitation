package javabeans;

public class Personne {
    private int personne_id;
    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private int date_naissance;
    private int nbHeureMaxSemaine;
    private String discriminator;
   
    public Personne(){}
    
    public Personne(int personne_id, String nom, String prenom, String mail, String telephone, int date_naissance, int nbHeureMaxSemaine, String discriminator){
        this.personne_id = personne_id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.telephone = telephone;
        this.date_naissance = date_naissance;
        this.nbHeureMaxSemaine = nbHeureMaxSemaine;
        this.discriminator = discriminator;
    }
    
    public Personne(String nom, String prenom, String mail, String telephone, int date_naissance, int nbHeureMaxSemaine, String discriminator){
        this.personne_id = -1;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.telephone = telephone;
        this.telephone = telephone;
        this.date_naissance = date_naissance;
        this.nbHeureMaxSemaine = nbHeureMaxSemaine;
        this.discriminator = discriminator;
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

    public int getNbHeureMaxSemaine() {
        return nbHeureMaxSemaine;
    }

    public String getDiscriminator() {
        return discriminator;
    }
    
}

