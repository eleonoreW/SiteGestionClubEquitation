package actions;

import java.util.ArrayList;
import java.util.List;
import javabeans.Cheval;
import javabeans.Lieu;
import javabeans.Professeur;
import javabeans.Type;
import javax.servlet.http.HttpServletRequest;
import models.ConnectionDB;
import models.LieuDAO;
import models.ProfesseurDAO;
import org.apache.struts2.ServletActionContext;


public class AddActiviteAction {
    
    private String nom;
    private String commentaire = "";
    private String details;
    private int date;
    private int duree;
    private int capacite;
    private boolean estActive = true;
    
    private List<Professeur> listProf;
    private List<Lieu> listLieu;
    private List<Type> listType;
    private List<Cheval> listCheval;
    
    private String[] listStr = new String[1];
    
    private Professeur profSelected;
    private Lieu lieuSelected;
    private Type typeSelected;
    private List<Cheval> listChevalSelected = new ArrayList<>();
//    private String str;
    
//    private List<String> colors;
    
    public String execute() {
        
        HttpServletRequest req = ServletActionContext.getRequest();
        
        // TODO
        
        return "success";
    }
    
    public String prepare(){
        LieuDAO lieuDAO = new LieuDAO(ConnectionDB.getInstance());
        listLieu = lieuDAO.findAll();
        
        ProfesseurDAO profDAO = new ProfesseurDAO(ConnectionDB.getInstance());
        listProf = profDAO.findAll();
        
        

        
        return "success";
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
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

    public String[] getListStr() {
        return listStr;
    }

    public void setListStr(String[] listStr) {
        this.listStr = listStr;
    }

    public Professeur getProfSelected() {
        return profSelected;
    }

    public void setProfSelected(Professeur profSelected) {
        this.profSelected = profSelected;
    }

    public Lieu getLieuSelected() {
        return lieuSelected;
    }

    public void setLieuSelected(Lieu lieuSelected) {
        this.lieuSelected = lieuSelected;
    }

    public Type getTypeSelected() {
        return typeSelected;
    }

    public void setTypeSelected(Type typeSelected) {
        this.typeSelected = typeSelected;
    }

    public List<Cheval> getListChevalSelected() {
        return listChevalSelected;
    }

    public void setListChevalSelected(List<Cheval> listChevalSelected) {
        this.listChevalSelected = listChevalSelected;
    }
    
}
