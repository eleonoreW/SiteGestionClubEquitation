package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javabeans.Type;

public class TypeDAO extends CommonDAO<Type> {

    private Type type;
    private ArrayList<Type> listType = new ArrayList<>();
    
    public TypeDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Type create(Type object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.INSERT_TYPE);
            
            statement.setString(1, object.getNom());
            statement.setString(2, object.getDescription());
            
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return object;
    }

    @Override
    public boolean delete(Type object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.DELETE_TYPE);
            
            statement.setInt(1, object.getType_id());
            
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public boolean update(Type object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.UPDATE_TYPE);
            
            statement.setString(1, object.getNom());
            statement.setString(2, object.getDescription());
            statement.setInt(3, object.getType_id());
            
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public Type findById(int id) {
        type = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_RACE_BY_ID);
            
            statement.setInt(1, id);
            
            ResultSet res = statement.executeQuery();
            
            if(res.next()) {
                type = new Type(res.getInt("ID"), res.getString("Nom"), res.getString("Description"));
            }
            statement.close();
            res.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return type;
    }

    @Override
    public Type findByName(String name) {
        type = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_TYPE_BY_NAME);
            
            statement.setString(1, name);
                        
            ResultSet res = statement.executeQuery();
            
            if(res.next()) {
                type = new Type(res.getInt("ID"), res.getString("Nom"), res.getString("Description"));
            }
            statement.close();
            res.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return type;
    }

    @Override
    public ArrayList<Type> findAll() {
        listType = new ArrayList<>();
        try {
            ResultSet res = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeQuery(SQLConstant.SELECT_ALL_TYPE);
            
            while(res.next()) {
                type = new Type(res.getInt("ID"), res.getString("Nom"), res.getString("Description"));
                listType.add(type);
            }
            res.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return listType;
    }
    
    public static void main(String[] args) {
        List<Type> listTypeTest;
        Type typeTest = new Type("Randonnée", "Belle randonnée dans la forêt d'à côté");
        Type typeTest2;
        
        TypeDAO typeDAO = new TypeDAO(ConnectionDB.getInstance());
        if(typeDAO.findByName(typeTest.getNom()) == null) {
            typeDAO.create(typeTest);
        } 
        
        listTypeTest = typeDAO.findAll();
        
        Iterator<Type> it = listTypeTest.iterator();
        
        while(it.hasNext()){
            typeTest2 = (Type)it.next();
            System.out.println(typeTest2.getNom() + " " + typeTest2.getDescription());
        }
        
        typeTest = typeDAO.findByName(typeTest.getNom());
        typeDAO.delete(typeTest);
    }    
}
