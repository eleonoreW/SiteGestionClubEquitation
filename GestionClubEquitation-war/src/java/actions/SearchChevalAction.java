package actions;

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
    private String raceSelected;
    private String proprietaireSelected;
    private String dateNaissanceMin;
    private String dateNaissanceMax;
    private String tailleMin;
    private String tailleMax;
    
    private Race queryRace;
    private Personne queryProprietaire;
    private int queryDateNaissance;
    private int queryTaille;
    
    private List<Personne> listProprietaire;
    private List<Race> listRace;
    private List<Type> listType;
    
    private List<Cheval> listChevalResult;
    
    
    
    public String execute() {
        
        HttpServletRequest req = ServletActionContext.getRequest();
        
        ChevalDAO chevalDAO = new ChevalDAO(ConnectionDB.getInstance());
        
        // On recupere la race
        RaceDAO raceDAO = new RaceDAO(ConnectionDB.getInstance());
        Race queryRace = raceDAO.findByName(raceSelected);
        
        PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
        queryProprietaire = personneDAO.findByMail(proprietaireSelected);
        // On récupere la liste de chevaux avec les paramètres de recherche
        listChevalResult = chevalDAO.filterBy(nom, queryRace, queryProprietaire, Integer.parseInt(dateNaissanceMin), Integer.parseInt(dateNaissanceMax), Integer.parseInt(tailleMin), Integer.parseInt(tailleMax));
        
        return "success";
    }
    
    public String prepare(){
        RaceDAO raceDAO = new RaceDAO(ConnectionDB.getInstance());
        listRace = raceDAO.findAll();
        
        PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
        listProprietaire = personneDAO.findAll();
        
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

    public String getDateNaissanceMin() {
        return dateNaissanceMin;
    }

    public void setDateNaissanceMin(String dateNaissanceMin) {
        this.dateNaissanceMin = dateNaissanceMin;
    }

    public String getDateNaissanceMax() {
        return dateNaissanceMax;
    }

    public void setDateNaissanceMax(String dateNaissanceMax) {
        this.dateNaissanceMax = dateNaissanceMax;
    }

    public String getTailleMin() {
        return tailleMin;
    }

    public void setTailleMin(String tailleMin) {
        this.tailleMin = tailleMin;
    }

    public String getTailleMax() {
        return tailleMax;
    }

    public void setTailleMax(String tailleMax) {
        this.tailleMax = tailleMax;
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

}
