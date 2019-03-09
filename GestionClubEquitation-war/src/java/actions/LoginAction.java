package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import models.*;
import javabeans.*;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;


public class LoginAction extends ActionSupport {
    
    	private static final long serialVersionUID = 1L;
 
	private String mail;
        private String password;
        
        private ProfesseurDAO professeurDAO;
        private AdministrateurDAO administrateurDAO;
        private ClientDAO clientDAO;
        
        private Professeur professeur;
        private Administrateur administrateur;
        private Client client;
 
        public String execute()
	{            
                
            HttpServletRequest req = ServletActionContext.getRequest();
            setMail(req.getParameter("mail"));
            setPassword(req.getParameter("password"));
            
            // verifie dans les Administrateurs
            administrateurDAO = new AdministrateurDAO(ConnectionDB.getInstance());
            professeurDAO = new ProfesseurDAO(ConnectionDB.getInstance());
            clientDAO = new ClientDAO(ConnectionDB.getInstance());
            
            if (administrateurDAO.validate(getMail(), getPassword())){
                Map<String, Object> session;
                //open the current session
                session = ActionContext.getContext().getSession();
                //register mail and password as session var
                session.put("mail", mail);
                session.put("password", password);
                
                addActionMessage("Connecté en tant qu'administrateur");
                return "success";
            }
            else if (professeurDAO.validate(getMail(), getPassword())){
                Map<String, Object> session;
                //open the current session
                session = ActionContext.getContext().getSession();
                //register mail and password as session var
                session.put("mail", mail);
                session.put("password", password);
                
                addActionMessage("Connecté en tant que professeur");
                return "success";
            }
            else if (clientDAO.validate(getMail(), getPassword())){
                Map<String, Object> session;
                //open the current session
                session = ActionContext.getContext().getSession();
                //register mail and password as session var
                session.put("mail", mail);
                session.put("password", password);
                
                addActionMessage("Connecté en tant que client");
                return "success";
            }
            else{
                addActionError("UNKNOW USER!");
                addFieldError("mail", "Enter your Mail again");
                addFieldError("password", "Enter your Password again");
                System.out.println("error");
                Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, "Invalid user error");
                return ERROR;                 
            }
        }
        
        
	public String getMail() {
		return mail;
	}
        
        public String getPassword() {
		return password;
	}
        
        public void setMail(String mail) {
            this.mail = mail;
	}
    
        public void setPassword(String password) {
		this.password = password;
	}
       
}
