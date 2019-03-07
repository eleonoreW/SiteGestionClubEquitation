package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javabeans.Employe;
import javabeans.Personne;
import javabeans.Professeur;


public class ProfesseurDAO extends EmployeDAO {

    public ProfesseurDAO(Connection connection) {
        super(connection);
    }
    public Professeur create(Professeur object) {
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
    
    
    public boolean update(Professeur object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.UPDATE_EMPLOYE);
            statement.setString(1, object.getPrenom());
            statement.setString(2, object.getNom());
            statement.setString(3, object.getMail());
            statement.setString(4, object.getTelephone());
            statement.setInt(5, object.getDate_naissance());
            statement.setInt(6, object.getNbHeureMaxSemaine());
            statement.setString(7, object.getClass().getName());
            statement.setInt(8, object.getPersonne_id());
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    public ArrayList<Personne> findAll() {
        personneList = new ArrayList<>();
        try {
            try (ResultSet res = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeQuery(SQLConstant.SELECT_ALL_PERSONNE)) {
                while(res.next()) {
                    personne = new Professeur(res.getInt("ID"), res.getString("Prenom"), res.getString("Nom"),res.getString("Mail"),res.getString("Telephone"),res.getInt("DateNaissance"),res.getInt("NbHeureActiviteMaxSemaine"));
                    personneList.add(personne);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return personneList;
    }
    
    public static void main(String args[]) {
//        System.out.println("On est dans le main de PersonneDAO");
//        List<Personne> listPersonneTest;
//        Personne adminTest = new Professeur("DUPONT","Toto","789@toto.com","0607080900",28031998,15);
//        Personne EmployeTest2;
//        
//        ProfesseurDAO typeDAO = new ProfesseurDAO(ConnectionDB.getInstance());
//        if(typeDAO.findByMail(adminTest.getMail()) == null) {
//            typeDAO.create(adminTest);
//        } 
//        
//        listPersonneTest = typeDAO.findAll();
//        
//        Iterator<Personne> it = listPersonneTest.iterator();
//        
//        while(it.hasNext()){
//            EmployeTest2 = (Personne)it.next();
//            System.out.println(EmployeTest2.getMail() + " " + EmployeTest2.getNom()+" "+EmployeTest2.getPrenom());
//        }
//        adminTest = typeDAO.findByMail(adminTest.getMail());
//        Personne adminTestUpdate = new Professeur(adminTest.getPersonne_id(),"DUPONT","Bobby","789@toto.com","0699999999",28031998,15);
//        typeDAO.update(adminTestUpdate);
//        typeDAO.delete(adminTest);
    }

}
