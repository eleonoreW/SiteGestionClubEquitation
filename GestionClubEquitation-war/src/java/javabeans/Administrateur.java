package javabeans;

public class Administrateur extends Personne{

    public Administrateur(int personne_id, String nom, String prenom, String mail, String telephone, int date_naissance, int nbHeureMaxSemaine, String discriminator) {
        super(personne_id, nom, prenom, mail, telephone, date_naissance, nbHeureMaxSemaine, discriminator);
    }

    public Administrateur(String nom, String prenom, String mail, String telephone, int date_naissance, int nbHeureMaxSemaine, String discriminator) {
        super(nom, prenom, mail, telephone, date_naissance, nbHeureMaxSemaine, discriminator);
    }
    
}
