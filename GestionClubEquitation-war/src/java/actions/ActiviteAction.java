package actions;

import java.util.ArrayList;
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


public class ActiviteAction {
    
    private Activite activite;
    private ActiviteDAO activiteDAO;
    private int nbPlaceDispo;
    public List<Activite> listActivite;
    
    private int id;
    private String nom;
    private String commentaire = "";
    private String details;
    private String date;
    private String duree;
    private String capacite;
    private boolean estActive;
    private int nbinscrit;
    
    private List<Professeur> listProf;
    private List<Lieu> listLieu;
    private List<Type> listType;
    private List<Cheval> listCheval;
    
    private String profSelected;
    private String lieuSelected;
    private String typeSelected;
    private List<String> listChevalSelected = new ArrayList<>();
    
    
    public String addActivite() {  
        ProfesseurDAO professeurDAO = new ProfesseurDAO(ConnectionDB.getInstance());
        Professeur prof = professeurDAO.findByMail(profSelected);
        
        TypeDAO typeDAO = new TypeDAO(ConnectionDB.getInstance());
        Type type = typeDAO.findByName(typeSelected);
        
        LieuDAO lieuDAO = new LieuDAO(ConnectionDB.getInstance());
        Lieu lieu = lieuDAO.findByName(lieuSelected);
             
        activite = new Activite(prof, lieu, type, nom, commentaire, details, Integer.parseInt(date), Integer.parseInt(duree), Integer.parseInt(capacite), true);
        
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
    
     public String displayAll(){
        activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());                    
        listActivite = activiteDAO.findAll();
        return "success";
    }
     
    public String loadActivite(){
        HttpServletRequest req = ServletActionContext.getRequest();
        prepare();
        activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());                    
        activite = activiteDAO.findByName(req.getParameter("nom"));
        
        //activite = activiteDAO.findById(Integer.parseInt(req.getParameter("id")));
        setId(activite.getActivite_id());
        setNom(activite.getNom());
        setCommentaire(activite.getCommentaire());
        setDetails(activite.getDetails());
        setDate(Integer.toString(activite.getDate()));
        setDuree(Integer.toString((int)activite.getDuree()));
        setCapacite(Integer.toString(activite.getCapacite()));
        setEstActive(activite.getEst_active());
        
        
        return "success";
    }
    
    
    public String updateActivite() throws Exception {   
        
        HttpServletRequest req = ServletActionContext.getRequest();
        setId(Integer.parseInt(req.getParameter("id")));
       
        ActiviteDAO activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());
        activite = activiteDAO.findById(Integer.parseInt(req.getParameter("id")));
        
        setId(Integer.parseInt(req.getParameter("id")));
        setNom(req.getParameter("nom"));
        setDetails(req.getParameter("details"));
        setDate(req.getParameter("date"));
        setDuree(req.getParameter("duree"));
        setCapacite(req.getParameter("capacite"));
        setCommentaire(req.getParameter("commentaire"));
        setEstActive(Boolean.parseBoolean(req.getParameter("estActive")));
        setNbinscrit(activiteDAO.nbPlaceDejaReserver(activite.getActivite_id()));
        
        ProfesseurDAO professeurDAO = new ProfesseurDAO(ConnectionDB.getInstance());
        Professeur prof = professeurDAO.findByMail(req.getParameter("profSelected"));
        
        TypeDAO typeDAO = new TypeDAO(ConnectionDB.getInstance());
        Type type = typeDAO.findByName(req.getParameter("typeSelected"));
        
        LieuDAO lieuDAO = new LieuDAO(ConnectionDB.getInstance());
        Lieu lieu = lieuDAO.findByName(req.getParameter("lieuSelected"));
       
        activite = new Activite(id,prof, lieu, type, nom, commentaire, details, Integer.parseInt(date), Integer.parseInt(duree), Integer.parseInt(capacite), estActive);
           
        activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());
        activiteDAO.update(activite);
        ChevalDAO chevalDAO = new ChevalDAO(ConnectionDB.getInstance());
        
        List<Cheval> listChevaux = new ArrayList<>();
        for(String s : listChevalSelected) {
            listChevaux.add(chevalDAO.findByName(s));
            activiteDAO.addChevalActivite(chevalDAO.findByName(s), activite);
            
        }
        if(getActivite()!= null){
            return "success";
        }else{
            return "error";
         }
    }
    
    public String deleteActivite() throws Exception {   
        
        HttpServletRequest req = ServletActionContext.getRequest();
        setId(Integer.parseInt(req.getParameter("id")));
       
        activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());
        activite = activiteDAO.findById(id);
        activiteDAO.delete(activite);
        if(getActivite()!= null){
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

    public String displayAllFuturDateNotCanceled() {
        ActiviteDAO activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());
        listActivite = activiteDAO.findAllFuturDateNotCanceled();
        
        return "success";
    }
    
    public String loadActiviteClient() {
        HttpServletRequest req = ServletActionContext.getRequest();
        
        activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());                    
        activite = activiteDAO.findById(Integer.parseInt(req.getParameter("activite_id")));
        
        
        setId(activite.getActivite_id());
        setNom(activite.getNom());
        setCommentaire(activite.getCommentaire());
        setDetails(activite.getDetails());
        setDate(Integer.toString(activite.getDate()));
        setDuree(Integer.toString((int)activite.getDuree()));
        setCapacite(Integer.toString(activite.getCapacite()));
        
        setProfSelected(activite.getPersonne().getNom());
        setLieuSelected(activite.getLieu().getNom());
        setTypeSelected(activite.getType().getNom());
        
        
        // calcul du nombre de places dispo
        nbPlaceDispo = activiteDAO.getNbPlaceDispo(activite.getActivite_id());
        
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

    public int getNbPlaceDispo() {
        return nbPlaceDispo;
    }

    public void setNbPlaceDispo(int nbPlaceDispo) {
        this.nbPlaceDispo = nbPlaceDispo;
    }

    public int getNbinscrit() {
        return nbinscrit;
    }

    public void setNbinscrit(int nbinscrit) {
        this.nbinscrit = nbinscrit;
    }
    
    
}
