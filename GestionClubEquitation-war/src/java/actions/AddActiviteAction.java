package actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javabeans.Cheval;
import javabeans.Lieu;
import javabeans.Professeur;
import javabeans.Type;
import javabeans.Activite;
import javax.servlet.http.HttpServletRequest;
import models.ActiviteDAO;
import models.ChevalDAO;
import models.ConnectionDB;
import models.LieuDAO;
import models.ProfesseurDAO;
import models.TypeDAO;
import org.apache.struts2.ServletActionContext;


public class AddActiviteAction {
    
    private Activite activite;
    private ActiviteDAO activiteDAO;
    public List<Activite> listActivite;
    
    private String nom;
    private String commentaire = "";
    private String details;
    private String date;
    
    private String duree;
    private String capacite;
    private boolean estActive = true;
    
    private List<Professeur> listProf;
    private List<Lieu> listLieu;
    private List<Type> listType;
    private List<Cheval> listCheval;
    
    private String profSelected;
    private String lieuSelected;
    private String typeSelected;
    private List<String> listChevalSelected = new ArrayList<>();
    
    
    public String execute() {
        
        HttpServletRequest req = ServletActionContext.getRequest();
        
        ProfesseurDAO professeurDAO = new ProfesseurDAO(ConnectionDB.getInstance());
        Professeur prof = professeurDAO.findByMail(profSelected);
        
        TypeDAO typeDAO = new TypeDAO(ConnectionDB.getInstance());
        Type type = typeDAO.findByName(typeSelected);
        
        LieuDAO lieuDAO = new LieuDAO(ConnectionDB.getInstance());
        Lieu lieu = lieuDAO.findByName(lieuSelected);
        
        
        
//        setNom(req.getParameter("activite_nom"));
//        setDetails(req.getParameter("activite_details"));
//        setDate(Integer.parseInt(req.getParameter("date")));
//        setDuree(Integer.parseInt(req.getParameter("activite_duree")));
//        setCapacite(Integer.parseInt(req.getParameter("activite_capacite")));
       
        
        activite = new Activite(prof, lieu, type, nom, commentaire, details, Integer.parseInt(date), Integer.parseInt(duree), Integer.parseInt(capacite), estActive);
        
        setActivite(activite);
        activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());
        
        ChevalDAO chevalDAO = new ChevalDAO(ConnectionDB.getInstance());
        
        List<Cheval> listChevaux = new ArrayList<>();
        for(String s : listChevalSelected) {
            listChevaux.add(chevalDAO.findByName(s));
        }
        
        activiteDAO.create(activite, listChevaux);
        
        if(getActivite()!=null){
            return "success";
        }else{
            return "error";
        }  
    }
    
    public String prepare(){
        LieuDAO lieuDAO = new LieuDAO(ConnectionDB.getInstance());
        listLieu = lieuDAO.findAll();
        
        ProfesseurDAO profDAO = new ProfesseurDAO(ConnectionDB.getInstance());
        listProf = profDAO.findAll();
        
        TypeDAO typeDAO = new TypeDAO(ConnectionDB.getInstance());
        listType = typeDAO.findAll();
        
        ChevalDAO chevalDAO = new ChevalDAO(ConnectionDB.getInstance());
        listCheval = chevalDAO.findAll();
        
        return "success";
    }

    //Getter et setter
    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public ActiviteDAO getActiviteDAO() {
        return activiteDAO;
    }

    public void setActiviteDAO(ActiviteDAO activiteDAO) {
        this.activiteDAO = activiteDAO;
    }

    public List<Activite> getListActivite() {
        return listActivite;
    }

    public void setListActivite(List<Activite> listActivite) {
        this.listActivite = listActivite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    public boolean isEstActive() {
        return estActive;
    }

    public void setEstActive(boolean estActive) {
        this.estActive = estActive;
    }

    public List<Professeur> getListProf() {
        return listProf;
    }

    public void setListProf(List<Professeur> listProf) {
        this.listProf = listProf;
    }

    public List<Lieu> getListLieu() {
        return listLieu;
    }

    public void setListLieu(List<Lieu> listLieu) {
        this.listLieu = listLieu;
    }

    public List<Type> getListType() {
        return listType;
    }

    public void setListType(List<Type> listType) {
        this.listType = listType;
    }

    public List<Cheval> getListCheval() {
        return listCheval;
    }

    public void setListCheval(List<Cheval> listCheval) {
        this.listCheval = listCheval;
    }

    public String getProfSelected() {
        return profSelected;
    }

    public void setProfSelected(String profSelected) {
        this.profSelected = profSelected;
    }

    public String getLieuSelected() {
        return lieuSelected;
    }

    public void setLieuSelected(String lieuSelected) {
        this.lieuSelected = lieuSelected;
    }

    public String getTypeSelected() {
        return typeSelected;
    }

    public void setTypeSelected(String typeSelected) {
        this.typeSelected = typeSelected;
    }

    public List<String> getListChevalSelected() {
        return listChevalSelected;
    }

    public void setListChevalSelected(List<String> listChevalSelected) {
        this.listChevalSelected = listChevalSelected;
    }
}
