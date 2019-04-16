package javabeans;

public class Client extends Personne{

    public Client(int id, String nom, String prenom, String mail, String telephone, int date_naissance, String password) {
        super(id, nom, prenom, mail, telephone, date_naissance, password);
    }

    public Client() {
    }

    public Client(String nom, String prenom, String mail, String telephone, int date_naissance, String password) {
        super(nom, prenom, mail, telephone, date_naissance, password);
    }
    
    
}
