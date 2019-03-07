package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javabeans.Professeur;


public class ProfesseurDAO extends CommonDAO<Professeur> {

    Professeur prof;
    ArrayList<Professeur> profList;
    public ProfesseurDAO(Connection connection) {
        super(connection);
    }
    @Override
    public Professeur create(Professeur object) {
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(SQLConstant.INSERT_PROFESSEUR);
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
    public boolean update(Professeur object) {
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(SQLConstant.UPDATE_PROFESSEUR);
            statement.setString(1, object.getPrenom());
            statement.setString(2, object.getNom());
            statement.setString(3, object.getMail());
            statement.setString(4, object.getTelephone());
            statement.setInt(5, object.getDate_naissance());
            statement.setInt(6, object.getNbHeureMaxSemaine());
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
    public ArrayList<Professeur> findAll() {
        profList = new ArrayList<>();
        try {
                PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_PROFESSEUR, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                statement.setString(1, Professeur.class.getName());
                
                ResultSet res = statement.executeQuery();
                while(res.next()) {
                    prof = new Professeur(res.getInt("ID"), res.getString("Prenom"), res.getString("Nom"),res.getString("Mail"),res.getString("Telephone"),res.getInt("DateNaissance"), res.getInt("NbHeureActiviteMaxSemaine"));
                    profList.add(prof);
                }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return profList;
    }
    
    @Override
    public boolean delete(Professeur object) {
        try {
            try (PreparedStatement statement = connection.prepareStatement(SQLConstant.DELETE_PROFESSEUR)) {
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
    public Professeur findById(int id) {
        prof = null;
        try {
            ResultSet res;
            try (PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_PROFESSEUR_BY_ID)) {
                statement.setString(1, Integer.toString(id));
                res = statement.executeQuery();
                if(res.next()) {
                    prof = new Professeur(res.getInt("ID"), res.getString("Prenom"), res.getString("Nom"),res.getString("Mail"),res.getString("Telephone"),res.getInt("DateNaissance"), res.getInt("NbHeureActiviteMaxSemaine"));
                    }
            }
            res.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return prof;
    }

    public Professeur findByMail(String mail) {
        prof = null;
        try {
            ResultSet res;
             try (PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_PROFESSEUR_BY_MAIL)) {
                 statement.setString(1, mail);
                 res = statement.executeQuery();
                 if(res.next()) {
                     prof = new Professeur(res.getInt("ID"), res.getString("Prenom"), res.getString("Nom"),res.getString("Mail"),res.getString("Telephone"),res.getInt("DateNaissance"), res.getInt("NbHeureActiviteMaxSemaine"));
                    }}
            res.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return prof;
}
    
    public static void main(String args[]) {
        System.out.println("On est dans le main de PersonneDAO");
        List<Professeur> listProfesseurTest;
        Professeur profTest = new Professeur("DUPONT","Toto","789@toto.com","0607080900",28031998,15);
        Professeur EmployeTest2;
        
        ProfesseurDAO profDAO = new ProfesseurDAO(ConnectionDB.getInstance());
        if(profDAO.findByMail(profTest.getMail()) == null) {
            profDAO.create(profTest);
        } 
        
        listProfesseurTest = profDAO.findAll();
        
        Iterator<Professeur> it = listProfesseurTest.iterator();
        
        while(it.hasNext()){
            EmployeTest2 = (Professeur)it.next();
            System.out.println(EmployeTest2.getMail() + " " + EmployeTest2.getNom()+" "+EmployeTest2.getPrenom());
        }
        profTest = profDAO.findByMail(profTest.getMail());
        Professeur profTestUpdate = new Professeur(profTest.getId(),"DUPONT","Bobby","789@toto.com","0699999999",28031998,15);
        profDAO.update(profTestUpdate);
        profDAO.delete(profTest);
    }
}