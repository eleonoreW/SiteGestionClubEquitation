package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javabeans.Client;


public class ClientDAO extends CommonDAO<Client>{
    Client client;
    ArrayList<Client> clientList;
    
    public ClientDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Client create(Client object) {
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(SQLConstant.INSERT_CLIENT);
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
    public boolean delete(Client object) {
        try {
            try (PreparedStatement statement = connection.prepareStatement(SQLConstant.DELETE_CLIENT)) {
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
    public boolean update(Client object) {
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(SQLConstant.UPDATE_CLIENT);
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
    public Client findById(int id) {
        client = null;
        try {
            ResultSet res;
            try (PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_CLIENT_BY_ID)) {
                statement.setString(1, Integer.toString(id));
                res = statement.executeQuery();
                if(res.next()) {
                    client = new Client(res.getInt("ID"), res.getString("Prenom"), res.getString("Nom"),res.getString("Mail"),res.getString("Telephone"),res.getInt("DateNaissance"));
                }
            }
            res.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public Client findByMail(String mail) {
        client = null;
        try {
            ResultSet res;
             try (PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_CLIENT_BY_MAIL)) {
                 statement.setString(1, mail);
                 res = statement.executeQuery();
                 if(res.next()) {
                     client = new Client(res.getInt("ID"), res.getString("Prenom"), res.getString("Nom"),res.getString("Mail"),res.getString("Telephone"),res.getInt("DateNaissance"));
                 }}
            res.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return client;
    }

    @Override
    public ArrayList<Client> findAll() {
        clientList = new ArrayList<>();
        try {
                PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_CLIENT, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                statement.setString(1, Client.class.getName());
                
                ResultSet res = statement.executeQuery();
                while(res.next()) {
                    client = new Client(res.getInt("ID"), res.getString("Prenom"), res.getString("Nom"),res.getString("Mail"),res.getString("Telephone"),res.getInt("DateNaissance"));
                    clientList.add(client);
                }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return clientList;
    }
    
    
    public static void main(String args[]) {
        System.out.println("On est dans le main de ClientDAO");
        List<Client> listClientTest;
        Client clientTest = new Client("ClientTestCreate","Toto","789@ClientTest.com","0607080900",28031998);
        Client clientTest2;
        
        ClientDAO clientDAO = new ClientDAO(ConnectionDB.getInstance());
        if(clientDAO.findByMail(clientTest.getMail()) == null) {
            clientDAO.create(clientTest);
        } 
        
        listClientTest = clientDAO.findAll();
        
        Iterator<Client> it = listClientTest.iterator();
        
        while(it.hasNext()){
            clientTest2 = (Client)it.next();
            System.out.println(clientTest2.getMail() + " " + clientTest2.getNom()+" "+clientTest2.getPrenom());
        }
        clientTest = clientDAO.findByMail(clientTest.getMail());
        Client clientTestUpdate = new Client(clientTest.getId(),"ClientTestUpdate","Bobby","789@ClientTest.com","0699999999",28031998);
        clientDAO.update(clientTestUpdate);
        clientDAO.delete(clientTest);
    }
}
