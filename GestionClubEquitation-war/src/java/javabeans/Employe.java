package javabeans;

public class Employe extends Personne{
    int nbHeureMaxSemaine;
    
    public Employe(int personne_id, String nom, String prenom, String mail, String telephone, int date_naissance, int nbHeureMaxSemaine) {
        super(personne_id, nom, prenom, mail, telephone, date_naissance);
        this.nbHeureMaxSemaine = nbHeureMaxSemaine; 
    }

    public Employe(String nom, String prenom, String mail, String telephone, int date_naissance, int nbHeureMaxSemaine) {
        super(nom, prenom, mail, telephone, date_naissance);
        this.nbHeureMaxSemaine = nbHeureMaxSemaine; 
    }

    public int getNbHeureMaxSemaine() {
        return nbHeureMaxSemaine;
    }
    
}
