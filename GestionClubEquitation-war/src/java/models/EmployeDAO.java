package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javabeans.Administrateur;
import javabeans.Employe;
import javabeans.Personne;

public class EmployeDAO extends PersonneDAO {

    public EmployeDAO(Connection connection) {
        super(connection);
    }
    
    public Employe create(Employe object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.INSERT_EMPLOYE);
            statement.setString(1, object.getPrenom());
            statement.setString(2, object.getNom());
            statement.setString(3, object.getMail());
            statement.setString(4, object.getTelephone());
            statement.setString(5, Integer.toString(object.getDate_naissance()));
            statement.setString(6, Integer.toString(object.getNbHeureMaxSemaine()));
            statement.setString(7, object.getClass().getName());
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return object;
    }
    
    
    public boolean update(Employe object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.UPDATE_EMPLOYE);
            statement.setString(1, object.getPrenom());
            statement.setString(2, object.getNom());
            statement.setString(3, object.getMail());
            statement.setString(4, object.getTelephone());
            statement.setString(5, Integer.toString(object.getDate_naissance()));
            statement.setString(6, Integer.toString(object.getNbHeureMaxSemaine()));
            statement.setString(7, object.getClass().getName());
            statement.setString(8, Integer.toString(object.getPersonne_id()));
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    
     public static void main(String args[]) {
        System.out.println("On est dans le main de PersonneDAO");
        List<Personne> listPersonneTest;
        Personne typeTest = new Administrateur("DUPONT","Toto","789@toto.com","0607080900",28031998,15);
        Personne typeTest2;
        
        PersonneDAO typeDAO = new PersonneDAO(ConnectionDB.getInstance());
        if(typeDAO.findByMail(typeTest.getMail()) == null) {
            typeDAO.create(typeTest);
        } 
        
        listPersonneTest = typeDAO.findAll();
        
        Iterator<Personne> it = listPersonneTest.iterator();
        
        while(it.hasNext()){
            typeTest2 = (Personne)it.next();
            System.out.println(typeTest2.getMail() + " " + typeTest2.getNom()+" "+typeTest2.getPrenom());
        }
        typeTest = typeDAO.findByMail(typeTest.getMail());
        Personne typeTestUpdate = new Administrateur(typeTest.getPersonne_id(),"DUPONT","Bobby","789@toto.com","0699999999",28031998,15);
        typeDAO.update(typeTestUpdate);
       // typeDAO.delete(typeTest);
    }
}
