package javabeans;

public class Client extends Personne{
    
    public Client(int personne_id, String nom, String prenom, String mail, String telephone, int date_naissance) {
        super(personne_id, nom, prenom, mail, telephone, date_naissance);
    }

    public Client(String nom, String prenom, String mail, String telephone, int date_naissance) {
        super(nom, prenom, mail, telephone, date_naissance);
    }
}
