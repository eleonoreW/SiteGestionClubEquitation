package javabeans;

public class Professeur extends Employe{
    int nbHeureMaxSemaine;
    
    public Professeur(int personne_id, String nom, String prenom, String mail, String telephone, int date_naissance, int nbHeureMaxSemaine) {
        super(personne_id, nom, prenom, mail, telephone, date_naissance);
        this.nbHeureMaxSemaine = nbHeureMaxSemaine; 
    }

    public Professeur(String nom, String prenom, String mail, String telephone, int date_naissance, int nbHeureMaxSemaine) {
        super(nom, prenom, mail, telephone, date_naissance);
        this.nbHeureMaxSemaine = nbHeureMaxSemaine; 
    }

    public int getNbHeureMaxSemaine() {
        return nbHeureMaxSemaine;
    }
    
}
