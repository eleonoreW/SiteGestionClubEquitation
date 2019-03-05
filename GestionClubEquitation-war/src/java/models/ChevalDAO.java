package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javabeans.Cheval;
import javabeans.Personne;
import javabeans.Race;
import models.CommonDAO;


public class ChevalDAO extends CommonDAO<Cheval>{
    
    private Cheval cheval;
    
    public ChevalDAO(Connection connection){
        super(connection);
    }
    
    @Override
    public Cheval create(Cheval object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.INSERT_CHEVAL);
            
            //statement.setString(1, object.getRace());
            statement.setInt(1, object.getRace().getRace_id());
            statement.setObject(2, object.getProprietaire().getPersonne_id());
            statement.setString(3, object.getNom());
            statement.setString(4, object.getDateNaissance());
            statement.setString(5, object.getDescription());
            statement.setString(6, object.getCommentaire());
            statement.setInt(7, object.getNbHeureMaxSemaine());
            statement.setInt(8, object.getTaille());
            
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return object;
    }

    @Override
    public boolean delete(Cheval object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Cheval object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cheval findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cheval findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cheval> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // PAS FINI
    public static void main(String args[]) {
        System.out.println("On est dans le main");
        
        Race race = new Race("cheval rouge");
        Personne proprietaire = new Personne("DUPONT","Toto","duponttoto@toto.com","0607080900",28031998,10,"client");
        
        Cheval cheval = new Cheval(race, proprietaire, "Zeus", "241096", "descriptionducheval","commentairecheval", 10, 175);
        
        ChevalDAO chevalDAO = new ChevalDAO(ConnectionDB.getInstance());
        
        if(chevalDAO.findByName(cheval.getNom()) == null) {
            System.out.println("Toto");
            chevalDAO.create(cheval);
        }
    }
}