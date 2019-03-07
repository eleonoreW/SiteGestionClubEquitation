package javabeans;

public class Administrateur extends Employe{

    public Administrateur(int personne_id, String nom, String prenom, String mail, String telephone, int date_naissance) {
        super(personne_id, nom, prenom, mail, telephone, date_naissance);
    }

    public Administrateur(String nom, String prenom, String mail, String telephone, int date_naissance) {
        super(nom, prenom, mail, telephone, date_naissance);
    }
    
}
