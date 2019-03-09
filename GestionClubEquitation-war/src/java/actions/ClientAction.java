/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.util.List;
import javabeans.Client;
import javax.servlet.http.HttpServletRequest;
import models.ClientDAO;
import models.ConnectionDB;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author bguil
 */
public class ClientAction {
    
    private Client client;
           
    private ClientDAO clientDAO;
 
    public List<Client> listAll;
    
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String password;
    private String telephone;
    private int date_naissance;

    
     public String register() throws Exception {   
        
        HttpServletRequest req = ServletActionContext.getRequest();
        setNom(req.getParameter("client_nom"));
        setPrenom(req.getParameter("client_prenom"));
        setMail(req.getParameter("client_mail"));
        setPassword(req.getParameter("client_password"));
        setTelephone(req.getParameter("client_tel"));
        setDate_naissance(Integer.parseInt(req.getParameter("client_datenaissance")));
        

        client =  new Client(nom, prenom, mail, telephone, date_naissance,password);
             
        setClient(client);
        clientDAO = new ClientDAO(ConnectionDB.getInstance());
        clientDAO.create(client);
         
        if(getClient()!= null){
            return "success";
        }else{
            return "error";
         }
    }
     
    public String displayAll(){
        clientDAO = new ClientDAO(ConnectionDB.getInstance());                    
        listAll = clientDAO.findAll();
        
        return "success";
    }
     
     
    public String loadClient(){
        HttpServletRequest req = ServletActionContext.getRequest();
        
        clientDAO = new ClientDAO(ConnectionDB.getInstance());                    
        client = clientDAO.findByMail(req.getParameter("mail"));
        
        setId(client.getId());
        setNom(client.getNom());
        setPrenom(client.getPrenom());
        setMail(client.getMail());
        setPassword(client.getPassword());
        setTelephone(client.getTelephone());
        setDate_naissance(client.getDate_naissance());
        
        return "success";
    }
    
    public String replaceClient() throws Exception {   
        
        HttpServletRequest req = ServletActionContext.getRequest();
        setId(Integer.parseInt(req.getParameter("id")));
        setNom(req.getParameter("client_nom"));
        setPrenom(req.getParameter("client_prenom"));
        setMail(req.getParameter("client_mail"));
        setPassword(req.getParameter("client_password"));
        setTelephone(req.getParameter("client_tel"));
        setDate_naissance(Integer.parseInt(req.getParameter("client_datenaissance")));

        client =  new Client(id,nom, prenom, mail, telephone, date_naissance,password);
             
        setClient(client);
        clientDAO = new ClientDAO(ConnectionDB.getInstance());
        clientDAO.update(client);
        if(getClient()!= null){
            return "success";
        }else{
            return "error";
         }
    }
    
    public String deleteClient() throws Exception {   
        
        HttpServletRequest req = ServletActionContext.getRequest();
        setId(Integer.parseInt(req.getParameter("id")));
       
        clientDAO = new ClientDAO(ConnectionDB.getInstance());
        client = clientDAO.findById(id);
        clientDAO.delete(client);
        if(getClient()!= null){
            return "success";
        }else{
            return "error";
         }
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

       public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(int date_naissance) {
        this.date_naissance = date_naissance;
    }
    
   
    
}
