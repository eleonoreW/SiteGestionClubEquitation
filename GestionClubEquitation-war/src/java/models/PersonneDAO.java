package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javabeans.Personne;


public class PersonneDAO extends CommonDAO<Personne>{
    Personne personne;
    ArrayList<Personne> personneList;
    
    public PersonneDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Personne create(Personne object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.INSERT_PERSONNE);
            statement.setString(1, object.getPrenom());
            statement.setString(2, object.getNom());
            statement.setString(3, object.getMail());
            statement.setString(4, object.getTelephone());
            statement.setInt(5, object.getDate_naissance());
            statement.setString(6, object.getPassword());
            statement.setString(7, object.getClass().getName());
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return object;
    }

    @Override
    public boolean delete(Personne object) {
        try {
            try (PreparedStatement statement = connection.prepareStatement(SQLConstant.DELETE_PERSONNE)) {
                statement.setString(1, Integer.toString(object.getId()));
                statement.executeUpdate();
            }
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Personne object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.UPDATE_PERSONNE);
            statement.setString(1, object.getPrenom());
            statement.setString(2, object.getNom());
            statement.setString(3, object.getMail());
            statement.setString(4, object.getTelephone());
            statement.setInt(5, object.getDate_naissance());
            statement.setString(6, object.getPassword());
            statement.setString(7, object.getClass().getName());
            statement.setInt(8, object.getId());
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Personne findById(int id) {
        personne = null;
        try {
            ResultSet res;
            try (PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_PERSONNE_BY_ID)) {
                statement.setString(1, Integer.toString(id));
                res = statement.executeQuery();
                if(res.next()) {
                    personne = new Personne(res.getInt("ID"), res.getString("Prenom"), res.getString("Nom"),res.getString("Mail"),res.getString("Telephone"),res.getInt("DateNaissance"), res.getString("Password"));
                }
            }
            res.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return personne;
    }

    public Personne findByMail(String mail) {
        personne = null;
        try {
            ResultSet res;
             try (PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_PERSONNE_BY_MAIL)) {
                 statement.setString(1, mail);
                 res = statement.executeQuery();
                 if(res.next()) {
                     personne = new Personne(res.getInt("ID"), res.getString("Prenom"), res.getString("Nom"),res.getString("Mail"),res.getString("Telephone"),res.getInt("DateNaissance"), res.getString("Password"));
                 }}
            res.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return personne;
    }

    @Override
    public ArrayList<Personne> findAll() {
        personneList = new ArrayList<>();
        try {
            try (ResultSet res = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeQuery(SQLConstant.SELECT_ALL_PERSONNE)) {
                while(res.next()) {
                    personne = new Personne(res.getInt("ID"), res.getString("Prenom"), res.getString("Nom"),res.getString("Mail"),res.getString("Telephone"),res.getInt("DateNaissance"), res.getString("Password"));
                    personneList.add(personne);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return personneList;
    }
    
    
    public static void main(String args[]) {
        System.out.println("On est dans le main de PersonneDAO");
        List<Personne> listPersonneTest;
        Personne personneTest = new Personne("PersonneTestCreate","Toto","789@PersonneTest.com","0607080900",28031998,"pwd");
        Personne personneTest2;
        
        PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
        if(personneDAO.findByMail(personneTest.getMail()) == null) {
            personneDAO.create(personneTest);
        } 
        
        listPersonneTest = personneDAO.findAll();
        
        Iterator<Personne> it = listPersonneTest.iterator();
        
        while(it.hasNext()){
            personneTest2 = (Personne)it.next();
            System.out.println(personneTest2.getMail() + " " + personneTest2.getNom()+" "+personneTest2.getPrenom());
        }
        personneTest = personneDAO.findByMail(personneTest.getMail());
        Personne personneTestUpdate = new Personne(personneTest.getId(),"PersonneTestUpdate","Bobby","789@PersonneTest.com","0699999999",28031998,"pwd");
        personneDAO.update(personneTestUpdate);
        personneDAO.delete(personneTest);
    }
}
