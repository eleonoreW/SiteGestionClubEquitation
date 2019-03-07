package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javabeans.Lieu;

public class LieuDAO extends CommonDAO<Lieu> {

    ArrayList<Lieu> listLieu = new ArrayList<>();
    Lieu lieu;
    
    public LieuDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Lieu create(Lieu object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.INSERT_LIEU);
            
            statement.setString(1, object.getNom());
            statement.setInt(2, object.getCapacite());
            statement.setString(3, object.getDescription());
            
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return object;
    }

    @Override
    public boolean delete(Lieu object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.DELETE_LIEU);
            
            statement.setInt(1, object.getLieu_id());
            
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public boolean update(Lieu object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.UPDATE_LIEU);
            
            statement.setString(1, object.getNom());
            statement.setInt(2, object.getCapacite());
            statement.setString(3, object.getDescription());
            statement.setInt(4, object.getLieu_id());
            
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public Lieu findById(int id) {
        lieu = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_LIEU_BY_ID);
            
            statement.setInt(1, id);
            
            ResultSet res = statement.executeQuery();
            
            if(res.next()) {
                lieu = new Lieu(res.getInt("ID"), res.getString("Nom"), res.getInt("Capacite"), res.getString("Description"));
            }
            statement.close();
            res.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return lieu;
    }

    public Lieu findByName(String name) {
        lieu = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_LIEU_BY_NAME);
            
            statement.setString(1, name);
            
            ResultSet res = statement.executeQuery();
            
            if(res.next()) {
                lieu = new Lieu(res.getInt("ID"), res.getString("Nom"), res.getInt("Capacite"), res.getString("Description"));
            }
            statement.close();
            res.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return lieu;
    }

    @Override
    public ArrayList<Lieu> findAll() {
        listLieu = new ArrayList<>();
        try {
            ResultSet res = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeQuery(SQLConstant.SELECT_ALL_LIEU);
            
            while(res.next()) {
                lieu = new Lieu(res.getInt("ID"), res.getString("Nom"), res.getInt("Capacite"), res.getString("Description"));
                listLieu.add(lieu);
            }
            res.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return listLieu;
    }
    
    public static void main(String[] args) {
        List<Lieu> listLieuTest;
        Lieu lieuTest = new Lieu("Forêt", 1000, "Dans les bois du parc nationnal, sur les petits sentiers, en pleine nature...");
        Lieu lieuTest2;
        
        LieuDAO lieuDAO = new LieuDAO(ConnectionDB.getInstance());
        if(lieuDAO.findByName(lieuTest.getNom()) == null) {
            lieuDAO.create(lieuTest);
        } 
        
        listLieuTest = lieuDAO.findAll();
        
        Iterator<Lieu> it = listLieuTest.iterator();
        
        while(it.hasNext()){
            lieuTest2 = (Lieu)it.next();
            System.out.println(lieuTest2.getNom() + " " + lieuTest2.getDescription());
        }
        
        lieuTest = lieuDAO.findByName(lieuTest.getNom());
        lieuDAO.delete(lieuTest);
    }    
    
}
