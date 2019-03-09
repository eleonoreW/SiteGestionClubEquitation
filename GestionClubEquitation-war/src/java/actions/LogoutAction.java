package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;


public class LogoutAction extends ActionSupport {
    
     public String execute() throws Exception { 
        Map session = ActionContext.getContext().getSession();
        session.remove("email"); 
        session.remove("password");        
        return SUCCESS;
    }
    
    
}
