package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javabeans.Race;
import models.CommonDAO;

public class RaceDAO extends CommonDAO<Race>{

    private Race race;
    
    public RaceDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Race create(Race object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.INSERT_RACE);
            
            statement.setString(1, object.getName());
            
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return object;
    }

    @Override
    public boolean delete(Race object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Race object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Race findById(int id) {
        // race = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_RACE_BY_ID);
            
            statement.setInt(1, id);
            
            ResultSet res = statement.executeQuery();
            
            if(res.next()) {
                race = new Race(res.getInt("ID"), res.getString("Nom"));
            }
            statement.close();
            res.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return race;
    }

    
    public Race findByName(String name) {
        // race = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_RACE_BY_NAME);
            
            statement.setString(1, name);
            
            ResultSet res = statement.executeQuery();
            
            if(res.next()) {
                race = new Race(res.getInt("ID"), res.getString("Nom"));
            }
            statement.close();
            res.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return race;
    }

    @Override
    public ArrayList<Race> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static void main(String args[]) {
        System.out.println("On est dans le main");
        
            Race race = new Race("Cheval Brun");
        
        RaceDAO raceDAO = new RaceDAO(ConnectionDB.getInstance());
        
        if(raceDAO.findByName(race.getName()) == null) {
            System.out.println("Toto");
            raceDAO.create(race);
        }
        
        
    }
}
