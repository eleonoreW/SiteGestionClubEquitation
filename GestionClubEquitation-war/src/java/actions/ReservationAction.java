package actions;

import com.opensymphony.xwork2.ActionContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javabeans.Activite;
import javabeans.Personne;
import javabeans.Reservation;
import javax.servlet.http.HttpServletRequest;
import models.ActiviteDAO;
import models.ConnectionDB;
import models.PersonneDAO;
import models.ReservationDAO;
import org.apache.struts2.ServletActionContext;


public class ReservationAction {
    
    private Reservation reservation;  
    private List<Reservation> listReservation;
    
    private List<Activite> listActivite;
    
    
    public String displayReservationsPourPersonneConnectee() {
        
        ReservationDAO reservationDAO = new ReservationDAO(ConnectionDB.getInstance());
        PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
        // get mail client
        Map<String, Object> session;
        // get the current session
        session = ActionContext.getContext().getSession();
        // get the client mail
        String mailClient = (String) session.get("email");
        Personne p = personneDAO.findByMail(mailClient);
        listReservation = reservationDAO.findAllFuturDateByPersonne(p.getId());
        
        // ajoute les activites des reservations dans la liste d'activite
        ActiviteDAO activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());
        listActivite = new ArrayList<>();
        for(Reservation r : listReservation) {
            listActivite.add(activiteDAO.findById(r.getReservation_ID()));
        }
        
        return "success";
    }
    
    public String annulerReservation() {
        HttpServletRequest req = ServletActionContext.getRequest();
        
        ReservationDAO reservationDAO = new ReservationDAO(ConnectionDB.getInstance());
        reservation = reservationDAO.findById(Integer.parseInt(req.getParameter("reservation_id")));
        reservationDAO.annulerReservation(reservation);
        
        // reload reservation
        return displayReservationsPourPersonneConnectee();
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public List<Reservation> getListReservation() {
        return listReservation;
    }

    public void setListReservation(List<Reservation> listReservation) {
        this.listReservation = listReservation;
    }

    public List<Activite> getListActivite() {
        return listActivite;
    }

    public void setListActivite(List<Activite> listActivite) {
        this.listActivite = listActivite;
    }
    
    
}
