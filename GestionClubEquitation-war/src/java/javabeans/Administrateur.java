package javabeans;

public class Administrateur extends Employe{

    public Administrateur(int personne_id, String nom, String prenom, String mail, String telephone, int date_naissance, int nbHeureMaxSemaine) {
        super(personne_id, nom, prenom, mail, telephone, date_naissance, nbHeureMaxSemaine);
    }

    public Administrateur(String nom, String prenom, String mail, String telephone, int date_naissance, int nbHeureMaxSemaine) {
        super(nom, prenom, mail, telephone, date_naissance, nbHeureMaxSemaine);
    }
    
}
