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


public class ChevalAction {
    private String race;
    private String proprietaire;
    private String nom;
    private String dateNaissance;
    private String description = "";
    private String commentaire = "";
    private String nbHeureMaxSemaine;
    private String taille;
    
    private List<Personne> listProprietaire;
    private List<Race> listRace;
    private List<Type> listType;
    
    private String proprietaireSelected;
    private String raceSelected;
    
    public String execute() {
        
        HttpServletRequest req = ServletActionContext.getRequest();
        ChevalDAO chevalDAO = new ChevalDAO(ConnectionDB.getInstance());
        if(chevalDAO.findByName(nom) == null){
            PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
            Personne proprietaire = personneDAO.findByMail(proprietaireSelected);

            RaceDAO raceDAO = new RaceDAO(ConnectionDB.getInstance());
            Race race = raceDAO.findByName(raceSelected);

            //TODO addcheval : new Cheval(parameters)s

            Cheval cheval = new Cheval(race,proprietaire,nom,Integer.parseInt(dateNaissance),description,commentaire,Integer.parseInt(nbHeureMaxSemaine), Integer.parseInt(taille));

            chevalDAO.create(cheval);

            if(chevalDAO.findByName(nom) != null){
                return "success";
            }else{
                return "error";
            }  
        }else{
            return "error";
        }
    }
    
    public String prepare(){
        RaceDAO raceDAO = new RaceDAO(ConnectionDB.getInstance());
        listRace = raceDAO.findAll();
        
        PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
        listProprietaire = personneDAO.findAll();
        
        return "success";
    }

    //Getter et setter

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getNbHeureMaxSemaine() {
        return nbHeureMaxSemaine;
    }

    public void setNbHeureMaxSemaine(String nbHeureMaxSemaine) {
        this.nbHeureMaxSemaine = nbHeureMaxSemaine;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
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

    public String getProprietaireSelected() {
        return proprietaireSelected;
    }

    public void setProprietaireSelected(String proprietaireSelected) {
        this.proprietaireSelected = proprietaireSelected;
    }

    public String getRaceSelected() {
        return raceSelected;
    }

    public void setRaceSelected(String raceSelected) {
        this.raceSelected = raceSelected;
    }
   
}
