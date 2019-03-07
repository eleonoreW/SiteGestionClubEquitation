package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javabeans.Administrateur;


public class AdministrateurDAO extends CommonDAO<Administrateur>{
    Administrateur admin;
    ArrayList<Administrateur> adminList;
    
    public AdministrateurDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Administrateur create(Administrateur object) {
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(SQLConstant.INSERT_ADMINISTRATEUR);
            statement.setString(1, object.getPrenom());
            statement.setString(2, object.getNom());
            statement.setString(3, object.getMail());
            statement.setString(4, object.getTelephone());
            statement.setString(5, Integer.toString(object.getDate_naissance()));
            statement.setString(6, object.getClass().getName());
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return object;
    }

    @Override
    public boolean delete(Administrateur object) {
        try {
            try (PreparedStatement statement = connection.prepareStatement(SQLConstant.DELETE_ADMINISTRATEUR)) {
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
    public boolean update(Administrateur object) {
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(SQLConstant.UPDATE_ADMINISTRATEUR);
            statement.setString(1, object.getPrenom());
            statement.setString(2, object.getNom());
            statement.setString(3, object.getMail());
            statement.setString(4, object.getTelephone());
            statement.setString(5, Integer.toString(object.getDate_naissance()));
            statement.setString(6, object.getClass().getName());
            statement.setString(7, Integer.toString(object.getId()));
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Administrateur findById(int id) {
        admin = null;
        try {
            ResultSet res;
            try (PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ADMINISTRATEUR_BY_ID)) {
                statement.setString(1, Integer.toString(id));
                res = statement.executeQuery();
                if(res.next()) {
                    admin = new Administrateur(res.getInt("ID"), res.getString("Prenom"), res.getString("Nom"),res.getString("Mail"),res.getString("Telephone"),res.getInt("DateNaissance"));
                }
            }
            res.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    public Administrateur findByMail(String mail) {
        admin = null;
        try {
            ResultSet res;
             try (PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_ADMINISTRATEUR_BY_MAIL)) {
                 statement.setString(1, mail);
                 res = statement.executeQuery();
                 if(res.next()) {
                     admin = new Administrateur(res.getInt("ID"), res.getString("Prenom"), res.getString("Nom"),res.getString("Mail"),res.getString("Telephone"),res.getInt("DateNaissance"));
                 }}
            res.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return admin;
    }

    @Override
    public ArrayList<Administrateur> findAll() {
        adminList = new ArrayList<>();
        try {
                PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_CLIENT, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                statement.setString(1, Administrateur.class.getName());
                
                ResultSet res = statement.executeQuery();
                while(res.next()) {
                    admin = new Administrateur(res.getInt("ID"), res.getString("Prenom"), res.getString("Nom"),res.getString("Mail"),res.getString("Telephone"),res.getInt("DateNaissance"));
                    adminList.add(admin);
                }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }
    
    
    public static void main(String args[]) {
        System.out.println("On est dans le main de AdministrateurDAO");
        List<Administrateur> listAdministrateurTest;
        Administrateur adminTest = new Administrateur("AdministrateurTestCreate","Toto","789@AdministrateurTest.com","0607080900",28031998);
        Administrateur adminTest2;
        
        AdministrateurDAO adminDAO = new AdministrateurDAO(ConnectionDB.getInstance());
        if(adminDAO.findByMail(adminTest.getMail()) == null) {
            adminDAO.create(adminTest);
        } 
        
        listAdministrateurTest = adminDAO.findAll();
        
        Iterator<Administrateur> it = listAdministrateurTest.iterator();
        
        while(it.hasNext()){
            adminTest2 = (Administrateur)it.next();
            System.out.println(adminTest2.getMail() + " " + adminTest2.getNom()+" "+adminTest2.getPrenom());
        }
        adminTest = adminDAO.findByMail(adminTest.getMail());
        Administrateur adminTestUpdate = new Administrateur(adminTest.getId(),"AdministrateurTestUpdate","Bobby","789@AdministrateurTest.com","0699999999",28031998);
        adminDAO.update(adminTestUpdate);
        adminDAO.delete(adminTest);
    }
}
