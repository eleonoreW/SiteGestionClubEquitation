/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.util.List;
import javabeans.Professeur;
import javax.servlet.http.HttpServletRequest;
import models.ProfesseurDAO;
import models.ConnectionDB;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author bguil
 */
public class ProfesseurAction {
    
    private Professeur professeur;
           
    private ProfesseurDAO professeurDAO;
 
    public List<Professeur> listAll;
    
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String password;
    private String telephone;
    private int date_naissance;
    private int nbHeureMaxSemaine;

    
     public String register() throws Exception {   
        
        HttpServletRequest req = ServletActionContext.getRequest();
        setNom(req.getParameter("prof_nom"));
        setPrenom(req.getParameter("prof_prenom"));
        setMail(req.getParameter("prof_mail"));
        setPassword(req.getParameter("prof_password"));
        setTelephone(req.getParameter("prof_tel"));
        setDate_naissance(Integer.parseInt(req.getParameter("prof_datenaissance")));
        setNbHeureMaxSemaine(Integer.parseInt(req.getParameter("prof_heureSem")));
        

        professeur =  new Professeur(nom, prenom, mail, telephone, date_naissance,password,nbHeureMaxSemaine);
             
        setProfesseur(professeur);
        professeurDAO = new ProfesseurDAO(ConnectionDB.getInstance());
        professeurDAO.create(professeur);
         
        if(getProfesseur()!= null){
            return "success";
        }else{
            return "error";
         }
    }
     
    public String displayAll(){
        professeurDAO = new ProfesseurDAO(ConnectionDB.getInstance());                    
        listAll = professeurDAO.findAll();
        
        return "success";
    }
     
     
    public String loadProfesseur(){
        HttpServletRequest req = ServletActionContext.getRequest();
        
        professeurDAO = new ProfesseurDAO(ConnectionDB.getInstance());                    
        professeur = professeurDAO.findByMail(req.getParameter("mail"));
        
        setId(professeur.getId());
        setNom(professeur.getNom());
        setPrenom(professeur.getPrenom());
        setMail(professeur.getMail());
        setPassword(professeur.getPassword());
        setTelephone(professeur.getTelephone());
        setDate_naissance(professeur.getDate_naissance());
        setNbHeureMaxSemaine(professeur.getNbHeureMaxSemaine());
        
        return "success";
    }
    
    public String replaceProfesseur() throws Exception {   
        
        HttpServletRequest req = ServletActionContext.getRequest();
        setId(Integer.parseInt(req.getParameter("id")));
        setNom(req.getParameter("prof_nom"));
        setPrenom(req.getParameter("prof_prenom"));
        setMail(req.getParameter("prof_mail"));
        setPassword(req.getParameter("prof_password"));
        setTelephone(req.getParameter("prof_tel"));
        setDate_naissance(Integer.parseInt(req.getParameter("prof_datenaissance")));
        setNbHeureMaxSemaine(Integer.parseInt(req.getParameter("prof_heureSem")));

        professeur =  new Professeur(id,nom, prenom, mail, telephone, date_naissance,password,nbHeureMaxSemaine);
             
        setProfesseur(professeur);
        professeurDAO = new ProfesseurDAO(ConnectionDB.getInstance());
        professeurDAO.update(professeur);
        if(getProfesseur()!= null){
            return "success";
        }else{
            return "error";
         }
    }
    
    public String deleteProfesseur() throws Exception {   
        
        HttpServletRequest req = ServletActionContext.getRequest();
        setId(Integer.parseInt(req.getParameter("id")));
       
        professeurDAO = new ProfesseurDAO(ConnectionDB.getInstance());
        professeur = professeurDAO.findById(id);
        professeurDAO.delete(professeur);
        if(getProfesseur()!= null){
            return "success";
        }else{
            return "error";
         }
    }
    
    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
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

     public int getNbHeureMaxSemaine() {
        return nbHeureMaxSemaine;
    }

    public void setNbHeureMaxSemaine(int nbHeureMaxSemaine) {
        this.nbHeureMaxSemaine = nbHeureMaxSemaine;
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
