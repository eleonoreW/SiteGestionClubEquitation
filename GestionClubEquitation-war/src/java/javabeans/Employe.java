package javabeans;

public class Employe extends Personne{
    
    public Employe(int personne_id, String nom, String prenom, String mail, String telephone, int date_naissance, int nbHeureMaxSemaine, String discriminator) {
        super(personne_id, nom, prenom, mail, telephone, date_naissance, nbHeureMaxSemaine, discriminator);
    }

    public Employe(String nom, String prenom, String mail, String telephone, int date_naissance, int nbHeureMaxSemaine, String discriminator) {
        super(nom, prenom, mail, telephone, date_naissance, nbHeureMaxSemaine, discriminator);
    }
    
}
