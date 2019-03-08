package javabeans;

public class Administrateur extends Employe{

    public Administrateur(int id, String nom, String prenom, String mail, String telephone, int date_naissance, String password) {
        super(id, nom, prenom, mail, telephone, date_naissance, password);
    }

    public Administrateur() {
    }

    public Administrateur(String nom, String prenom, String mail, String telephone, int date_naissance, String password) {
        super(nom, prenom, mail, telephone, date_naissance, password);
    }
}
