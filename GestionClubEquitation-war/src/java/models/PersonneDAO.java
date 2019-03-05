package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javabeans.Client;
import javabeans.Personne;


public class PersonneDAO extends CommonDAO<Personne>{
    private Personne personne;
    private ArrayList<Personne> personneList;
    
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

    @Override
    public boolean delete(Personne object) {
        try {
            try (PreparedStatement statement = connection.prepareStatement(SQLConstant.DELETE_PERSONNE)) {
                statement.setString(1, Integer.toString(object.getPersonne_id()));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                    personne = new Personne(res.getInt("ID"), res.getString("Prenom"), res.getString("Nom"),res.getString("Mail"),res.getString("Telephone"),res.getInt("DateNaissance"),res.getInt("NbHeureActiviteMaxSemaine"),res.getString("Discriminator"));
                }
            }
            res.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return personne;
    }

    @Override
    public Personne findByName(String name) {
         personne = null;
        try {
            ResultSet res;
             try (PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_PERSONNE_BY_NAME)) {
                 statement.setString(1, name);
                 res = statement.executeQuery();
                 if(res.next()) {
                     personne = new Personne(res.getInt("ID"), res.getString("Prenom"), res.getString("Nom"),res.getString("Mail"),res.getString("Telephone"),res.getInt("DateNaissance"),res.getInt("NbHeureActiviteMaxSemaine"),res.getString("Discriminator"));
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
                    personne = new Personne(res.getInt("ID"), res.getString("Prenom"), res.getString("Nom"),res.getString("Mail"),res.getString("Telephone"),res.getInt("DateNaissance"),res.getInt("NbHeureActiviteMaxSemaine"),res.getString("Discriminator"));
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
        Personne typeTest = new Personne("DUPONT","Toto","duponttoto@toto.com","0607080900",28031998,10,Client.class.getName());
        Personne typeTest2;
        
        PersonneDAO typeDAO = new PersonneDAO(ConnectionDB.getInstance());
        if(typeDAO.findByName(typeTest.getNom()) == null) {
            typeDAO.create(typeTest);
        } 
        
        listPersonneTest = typeDAO.findAll();
        
        Iterator<Personne> it = listPersonneTest.iterator();
        
        while(it.hasNext()){
            typeTest2 = (Personne)it.next();
            System.out.println(typeTest2.getNom() + " " + typeTest2.getPrenom());
        }
        
        typeTest = typeDAO.findByName(typeTest.getNom());
        typeDAO.delete(typeTest);
    }
}
