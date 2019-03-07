package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javabeans.Employe;
import javabeans.Personne;

public class EmployeDAO extends PersonneDAO {

    public EmployeDAO(Connection connection) {
        super(connection);
    }
    
     public static void main(String args[]) {
        System.out.println("On est dans le main de PersonneDAO");
        List<Personne> listPersonneTest;
        Personne employeTest = new Employe("DUPONT","Toto","789@toto.com","0607080900",28031998);
        Personne employeTest2;
        
        PersonneDAO typeDAO = new EmployeDAO(ConnectionDB.getInstance());
        if(typeDAO.findByMail(employeTest.getMail()) == null) {
            typeDAO.create(employeTest);
        } 
        
        listPersonneTest = typeDAO.findAll();
        
        Iterator<Personne> it = listPersonneTest.iterator();
        
        while(it.hasNext()){
            employeTest2 = (Personne)it.next();
            System.out.println(employeTest2.getMail() + " " + employeTest2.getNom()+" "+employeTest2.getPrenom());
        }
        employeTest = typeDAO.findByMail(employeTest.getMail());
        Personne employeTestUpdate = new Employe(employeTest.getPersonne_id(),"DUPONT","Bobby","789@toto.com","0699999999",28031998);
        typeDAO.update(employeTestUpdate);
        typeDAO.delete(employeTest);
    }
}
