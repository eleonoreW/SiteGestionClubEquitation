package models;

import java.sql.Connection;
import java.util.ArrayList;


public abstract class CommonDAO<T> {

    protected Connection connection;
    
    public CommonDAO(Connection connection){
        this.connection = connection;
    }
    
    public abstract T create(T object);
    
    public abstract boolean delete(T object);
    
    public abstract boolean update(T object);
    
    public abstract T findById(int id);
    
    public abstract T findByName(String name);
    
    public abstract ArrayList<T> findAll();
}
