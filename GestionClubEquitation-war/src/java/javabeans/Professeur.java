package javabeans;

public class Professeur extends Employe{
    int nbHeureMaxSemaine;

    public Professeur(int id, String nom, String prenom, String mail, String telephone, int date_naissance, String password, int nbHeureMaxSemaine ) {
        super(id, nom, prenom, mail, telephone, date_naissance, password);
        this.nbHeureMaxSemaine = nbHeureMaxSemaine;
    }

    public Professeur(int nbHeureMaxSemaine) {
        this.nbHeureMaxSemaine = nbHeureMaxSemaine;
    }

    public Professeur(String nom, String prenom, String mail, String telephone, int date_naissance, String password, int nbHeureMaxSemaine ) {
        super(nom, prenom, mail, telephone, date_naissance, password);
        this.nbHeureMaxSemaine = nbHeureMaxSemaine;
    }
 
    public int getNbHeureMaxSemaine() {
        return nbHeureMaxSemaine;
    }

    public void setNbHeureMaxSemaine(int nbHeureMaxSemaine) {
        this.nbHeureMaxSemaine = nbHeureMaxSemaine;
    }
     
}
