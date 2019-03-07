package models;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import javabeans.Administrateur;
import javabeans.Personne;

public class AdministrateurDAO extends EmployeDAO{

    public AdministrateurDAO(Connection connection) {
        super(connection);
    }
    public static void main(String args[]) {
        System.out.println("On est dans le main de PersonneDAO");
        List<Personne> listPersonneTest;
        Personne adminTest = new Administrateur("DUPONT","Toto","789@toto.com","0607080900",28031998);
        Personne adminTest2;
        
        PersonneDAO typeDAO = new AdministrateurDAO(ConnectionDB.getInstance());
        if(typeDAO.findByMail(adminTest.getMail()) == null) {
            typeDAO.create(adminTest);
        } 
        
        listPersonneTest = typeDAO.findAll();
        
        Iterator<Personne> it = listPersonneTest.iterator();
        
        while(it.hasNext()){
            adminTest2 = (Personne)it.next();
            System.out.println(adminTest2.getMail() + " " + adminTest2.getNom()+" "+adminTest2.getPrenom());
        }
        adminTest = typeDAO.findByMail(adminTest.getMail());
        Personne adminTestUpdate = new Administrateur(adminTest.getPersonne_id(),"DUPONT","Bobby","789@toto.com","0699999999",28031998);
        typeDAO.update(adminTestUpdate);
        typeDAO.delete(adminTest);
    }
}
