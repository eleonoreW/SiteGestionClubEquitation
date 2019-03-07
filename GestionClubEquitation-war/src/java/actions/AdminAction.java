/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.List;
import javabeans.Administrateur;
import javax.servlet.http.HttpServletRequest;
import models.AdministrateurDAO;
import models.ConnectionDB;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author bguil
 */
public class AdminAction {
    
    private Administrateur administrateur;
           
    private AdministrateurDAO administrateurDAO;
 
    public List<Administrateur> AdministrationList;
    
    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private int date_naissance;

    
     public String register() throws Exception {   
        
        HttpServletRequest req = ServletActionContext.getRequest();
        setNom(req.getParameter("admin_prenom"));
        setPrenom(req.getParameter("admin_prenom"));
        setMail(req.getParameter("admin_mail"));
        setTelephone(req.getParameter("admin_tel"));
        setDate_naissance(Integer.parseInt(req.getParameter("admin_datenaissance")));
        

        administrateur =  new Administrateur(nom, prenom, mail, telephone, date_naissance);
             
        setAdministrateur(administrateur);
        administrateurDAO = new AdministrateurDAO(ConnectionDB.getInstance());
        administrateurDAO.create(administrateur);
         
        if(getAdministrateur()!= null){
            return "success";
        }else{
            return "error";
         }
    }
     
     
    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
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
