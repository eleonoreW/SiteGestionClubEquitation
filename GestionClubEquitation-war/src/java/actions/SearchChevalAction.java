package actions;

import java.util.ArrayList;
import java.util.List;
import javabeans.Race;
import javabeans.Type;
import javabeans.Cheval;
import javabeans.Personne;
import javax.servlet.http.HttpServletRequest;
import models.ChevalDAO;
import models.ConnectionDB;
import models.RaceDAO;
import models.PersonneDAO;
import org.apache.struts2.ServletActionContext;


public class SearchChevalAction {
    private String nom="";
    private String raceSelected="";
    private String proprietaireSelected;
    private String STRdateNaissanceMin;
    private String STRdateNaissanceMax;
    private String STRtailleMin;
    private String STRtailleMax;
    
    
    private int dateNaissanceMin;
    private int dateNaissanceMax;
    private int tailleMin;
    private int tailleMax;
    
    private Race queryRace;
    private Personne queryProprietaire;
    private int queryDateNaissance;
    private int queryTaille;
    
    private List<Personne> listProprietaire;
    private List<Race> listRace;
    private List<Type> listType;
    
    private List<Cheval> listChevalResult;
    
     public String gotoSearchCheval(){
        RaceDAO raceDAO = new RaceDAO(ConnectionDB.getInstance());
        listRace = raceDAO.findAll();
        
        PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
        listProprietaire = personneDAO.findAll();
        
        ChevalDAO chevalDAO = new ChevalDAO(ConnectionDB.getInstance());
        listChevalResult = chevalDAO.findAll();
        return "success";
    }
     
     
    public String prepare(){
        RaceDAO raceDAO = new RaceDAO(ConnectionDB.getInstance());
        listRace = raceDAO.findAll();
        
        PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
        listProprietaire = personneDAO.findAll();
        
        HttpServletRequest req = ServletActionContext.getRequest();
        
        ChevalDAO chevalDAO = new ChevalDAO(ConnectionDB.getInstance());
        
        
        if(STRdateNaissanceMin.equals(""))
            dateNaissanceMin =0;
        else
            dateNaissanceMin=Integer.parseInt(STRdateNaissanceMin);
        
        if(STRdateNaissanceMax.equals(""))
            dateNaissanceMax =99999999;
        else
            dateNaissanceMax=Integer.parseInt(STRdateNaissanceMax);
        
        if(STRtailleMin.equals(""))
            tailleMin =0;
        else
            tailleMin=Integer.parseInt(STRtailleMin);
        
        if(STRtailleMax.equals(""))
            tailleMax =5000;
        else
            tailleMax=Integer.parseInt(STRtailleMax);
        
        // On recupere la race
        Race queryRace = raceDAO.findByName(raceSelected);
        queryProprietaire = personneDAO.findByMail(proprietaireSelected);
        // On récupere la liste de chevaux avec les paramètres de recherche
        
        listChevalResult = chevalDAO.filterBy(nom, queryRace, queryProprietaire, dateNaissanceMin, dateNaissanceMax, tailleMin, tailleMax);
        
        return "success";
    }

    //Getter et setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRaceSelected() {
        return raceSelected;
    }

    public void setRaceSelected(String raceSelected) {
        this.raceSelected = raceSelected;
    }

    public String getProprietaireSelected() {
        return proprietaireSelected;
    }

    public void setProprietaireSelected(String proprietaireSelected) {
        this.proprietaireSelected = proprietaireSelected;
    }

    public Race getQueryRace() {
        return queryRace;
    }

    public void setQueryRace(Race queryRace) {
        this.queryRace = queryRace;
    }

    public Personne getQueryProprietaire() {
        return queryProprietaire;
    }

    public void setQueryProprietaire(Personne queryProprietaire) {
        this.queryProprietaire = queryProprietaire;
    }

    public int getQueryDateNaissance() {
        return queryDateNaissance;
    }

    public void setQueryDateNaissance(int queryDateNaissance) {
        this.queryDateNaissance = queryDateNaissance;
    }

    public int getQueryTaille() {
        return queryTaille;
    }

    public void setQueryTaille(int queryTaille) {
        this.queryTaille = queryTaille;
    }

    public List<Personne> getListProprietaire() {
        return listProprietaire;
    }

    public void setListProprietaire(List<Personne> listProprietaire) {
        this.listProprietaire = listProprietaire;
    }

    public List<Race> getListRace() {
        return listRace;
    }

    public void setListRace(List<Race> listRace) {
        this.listRace = listRace;
    }

    public List<Type> getListType() {
        return listType;
    }

    public void setListType(List<Type> listType) {
        this.listType = listType;
    }

    public List<Cheval> getListChevalResult() {
        return listChevalResult;
    }

    public void setListChevalResult(List<Cheval> listChevalResult) {
        this.listChevalResult = listChevalResult;
    }

    public String getSTRdateNaissanceMin() {
        return STRdateNaissanceMin;
    }

    public void setSTRdateNaissanceMin(String STRdateNaissanceMin) {
        this.STRdateNaissanceMin = STRdateNaissanceMin;
    }

    public String getSTRdateNaissanceMax() {
        return STRdateNaissanceMax;
    }

    public void setSTRdateNaissanceMax(String STRdateNaissanceMax) {
        this.STRdateNaissanceMax = STRdateNaissanceMax;
    }

    public String getSTRtailleMin() {
        return STRtailleMin;
    }

    public void setSTRtailleMin(String STRtailleMin) {
        this.STRtailleMin = STRtailleMin;
    }

    public String getSTRtailleMax() {
        return STRtailleMax;
    }

    public void setSTRtailleMax(String STRtailleMax) {
        this.STRtailleMax = STRtailleMax;
    }

    public int getDateNaissanceMin() {
        return dateNaissanceMin;
    }

    public void setDateNaissanceMin(int dateNaissanceMin) {
        this.dateNaissanceMin = dateNaissanceMin;
    }

    public int getDateNaissanceMax() {
        return dateNaissanceMax;
    }

    public void setDateNaissanceMax(int dateNaissanceMax) {
        this.dateNaissanceMax = dateNaissanceMax;
    }

    public int getTailleMin() {
        return tailleMin;
    }

    public void setTailleMin(int tailleMin) {
        this.tailleMin = tailleMin;
    }

    public int getTailleMax() {
        return tailleMax;
    }

    public void setTailleMax(int tailleMax) {
        this.tailleMax = tailleMax;
    }

    
    
}
