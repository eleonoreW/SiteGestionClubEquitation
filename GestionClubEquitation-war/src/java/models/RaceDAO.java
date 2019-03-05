package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javabeans.Race;
import models.CommonDAO;

public class RaceDAO extends CommonDAO<Race>{

    private ArrayList<Race> listRace = new ArrayList<>();
    private Race race;
    
    public RaceDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Race create(Race object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.INSERT_RACE);
            
            statement.setString(1, object.getNom());
            
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return object;
    }

    @Override
    public boolean delete(Race object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.DELETE_RACE);
            
            statement.setInt(1, object.getRace_id());
            
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public boolean update(Race object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.UPDATE_RACE);
            
            statement.setString(1, object.getNom());
            statement.setInt(3, object.getRace_id());
            
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public Race findById(int id) {
        race = null;
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

    @Override
    public Race findByName(String name) {
        race = null;
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
        listRace = new ArrayList<>();
        try {
            ResultSet res = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeQuery(SQLConstant.SELECT_ALL_RACE);
            
            while(res.next()) {
                race = new Race(res.getInt("ID"), res.getString("Nom"));
                listRace.add(race);
            }
            res.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return listRace;
    }
    
    
    public static void main(String args[]) {
        List<Race> listRaceTest;
        Race raceTest = new Race("Joli Cheval");
        Race raceTest2;
        
        RaceDAO raceDAO = new RaceDAO(ConnectionDB.getInstance());
        if(raceDAO.findByName(raceTest.getNom()) == null) {
            raceDAO.create(raceTest);
        } 
        
        listRaceTest = raceDAO.findAll();
        
        Iterator<Race> it = listRaceTest.iterator();
        
        while(it.hasNext()){
            raceTest2 = (Race)it.next();
            System.out.println(raceTest2.getNom());
        }
        
        raceTest = raceDAO.findByName(raceTest.getNom());
        raceDAO.delete(raceTest);
    }
}
