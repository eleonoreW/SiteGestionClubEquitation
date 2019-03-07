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

public class ClientDAO extends CommonDAO<Client>{

    Client client;
    ArrayList<Client> clientList;
    public ClientDAO(Connection connection) {
        super(connection);
    }
    
    
    public ArrayList<Client> findAll() {
        clientList = new ArrayList<>();
        try {
                PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_CLIENT, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                
                statement.setString(1, Client.class.getName());
                
               
                ResultSet res = statement.executeQuery(SQLConstant.SELECT_ALL_PERSONNE);
                
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
        List<Personne> listPersonneTest;
        Personne clientTest = new Client("DUPONT","Toto","789@toto.com","0607080900",28031998);
        Personne clientTest2;
        
        PersonneDAO typeDAO = new EmployeDAO(ConnectionDB.getInstance());
        if(typeDAO.findByMail(clientTest.getMail()) == null) {
            typeDAO.create(clientTest);
        } 
        
        listPersonneTest = typeDAO.findAll();
        
        Iterator<Personne> it = listPersonneTest.iterator();
        
        while(it.hasNext()){
            clientTest2 = (Personne)it.next();
            System.out.println(clientTest2.getMail() + " " + clientTest2.getNom()+" "+clientTest2.getPrenom());
        }
        clientTest = typeDAO.findByMail(clientTest.getMail());
        Personne clientTestUpdate = new Client(clientTest.getPersonne_id(),"DUPONT","Bobby","789@toto.com","0699999999",28031998);
        typeDAO.update(clientTestUpdate);
        //typeDAO.delete(clientTest);
    }

    @Override
    public Client create(Client object) {
        PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
        Personne p = personneDAO.create(object);
        
        object.setPersonne_id(p.getPersonne_id());
        return object;       
    }

    @Override
    public boolean delete(Client object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Client object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
