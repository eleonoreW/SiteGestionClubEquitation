package javabeans;

public class Employe extends Personne{

    public Employe(int id, String nom, String prenom, String mail, String telephone, int date_naissance, String password) {
        super(id, nom, prenom, mail, telephone, date_naissance, password);
    }

    public Employe() {
    }

    public Employe(String nom, String prenom, String mail, String telephone, int date_naissance, String password) {
        super(nom, prenom, mail, telephone, date_naissance, password);
    }
}
