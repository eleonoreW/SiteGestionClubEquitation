
package actions;

import java.util.ArrayList;
import java.util.List;
import javabeans.Cheval;
import javabeans.Lieu;
import javabeans.Professeur;
import javabeans.Type;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;


public class AddActiviteAction {
    
    private String nom;
    private String commentaire = "";
    private String details;
    private int date;
    private int duree;
    private int capacite;
    private boolean estActive = true;
    
    private List<Professeur> listProf = new ArrayList<>();
    private List<Lieu> listLieu = new ArrayList<>();
    private List<Type> listType = new ArrayList<>();
    private List<Cheval> listCheval = new ArrayList<>();
    
    private Professeur profSelected;
    private Lieu lieuSelected;
    private Type typeSelected;
    private List<Cheval> listChevalSelected = new ArrayList<>();
    
    public String execute() {
        
        HttpServletRequest req = ServletActionContext.getRequest();
        
        // TODO
        
        return "success";
    }
    
    
}
