package javabeans;

public class Employe extends Personne{
    
    public Employe(int personne_id, String nom, String prenom, String mail, String telephone, int date_naissance) {
        super(personne_id, nom, prenom, mail, telephone, date_naissance);
    }

    public Employe(String nom, String prenom, String mail, String telephone, int date_naissance) {
        super(nom, prenom, mail, telephone, date_naissance);
    }
}
