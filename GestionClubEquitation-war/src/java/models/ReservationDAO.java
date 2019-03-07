package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import javabeans.Activite;
import javabeans.Personne;
import javabeans.Reservation;

public class ReservationDAO extends CommonDAO<Reservation>{
    private Reservation reservation;
    private ArrayList<Reservation> listReservation = new ArrayList<>();
    
    public ReservationDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Reservation create(Reservation object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.INSERT_RESERVATION);

            statement.setInt(1, object.getDate());
            statement.setInt(2, object.getNbPersonne());
            statement.setInt(3, object.getEstActive());
            statement.setInt(4, object.getPersonne().getId());
            statement.setInt(5, object.getActivite().getActivite_id());
            

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return object;    }

    @Override
    public boolean delete(Reservation object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.DELETE_RESERVATION);
            
            statement.setInt(1, object.getReservation_ID());
            
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;    }

    @Override
    public boolean update(Reservation object) {
         try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.UPDATE_RESERVATION);
            
            statement.setInt(1, object.getDate());
            statement.setInt(2, object.getNbPersonne());
            statement.setInt(3, object.getEstActive()); 
            statement.setInt(4, object.getPersonne().getId());
            statement.setInt(5, object.getActivite().getActivite_id());
            statement.setInt(6, object.getReservation_ID());
            
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true; 
    }

    @Override
    public Reservation findById(int id) {
        reservation = null;
        Personne personne = null;
        Activite activite = null;
        
        try{
            PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_RESERVATION_BY_ID);
            statement.setInt(1,id);
            ResultSet res = statement.executeQuery();
            
            PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
            ActiviteDAO activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());

            if(res.next()){
                personne = personneDAO.findById(res.getInt("PersonneID"));
                activite = activiteDAO.findById(res.getInt("ActiviteID"));
                
                reservation = new Reservation(res.getInt("ID"),res.getInt("Date"), res.getInt("NbPersonne"), res.getInt("EstActive"),personne, activite);
            }
            statement.close();
            res.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return reservation; 
    }

    public Reservation findByDatePersAct(int date, Personne personne, Activite activite){
        reservation = null;

        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_RESERVATION_BY_DATE_PERSONNE_ACTIVITE);
            statement.setInt(1, date);
            statement.setObject(2, personne.getId());
            statement.setObject(3,activite.getActivite_id());
            ResultSet res = statement.executeQuery();

            PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
            ActiviteDAO activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());
            

            if (res.next()) {
                personne = personneDAO.findById(res.getInt("PersonneID"));
                activite = activiteDAO.findById(res.getInt("ActiviteID"));
                reservation = new Reservation(res.getInt("ID"),res.getInt("Date"), res.getInt("NbPersonne"), res.getInt("EstActive"),personne, activite);

            }
            statement.close();
            res.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservation;
    }
    @Override
    public ArrayList<Reservation> findAll() {
        listReservation = new ArrayList<>();

        Personne personne = null;
        Activite activite = null;
      
        PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
        ActiviteDAO activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());
        

        try {
            ResultSet res = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeQuery(SQLConstant.SELECT_ALL_RESERVATION);

            while (res.next()) {
                personne = personneDAO.findById(res.getInt("PersonneID"));
                activite = activiteDAO.findById(res.getInt("ActiviteID"));
                
                reservation = new Reservation(res.getInt("ID"),res.getInt("Date"), res.getInt("NbPersonne"), res.getInt("EstActive"),personne, activite);

                listReservation.add(reservation);
            }
            res.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listReservation;    }
    
    
    public static void main(String args[]) {
        List<Reservation> listReservation;
        Reservation reservation2;

        //Personne
        PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
        Personne personne = personneDAO.findByMail("eleo@mail.ca");
        
        //Activite
        ActiviteDAO activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());
        Activite activite = activiteDAO.findByName("Promenade au bord de l'eau");

        Reservation reservation = new Reservation(282828, 43, 1, personne, activite);
        if (personne != null) {
            System.out.println("Personne existe");
            if (activite != null) {
                System.out.println("Activite existe");
                
                //Activite activite = new Activite(personne, lieu, type, "Activite2", "CommentaireAct2", "DetailsAct2", 222, (float) 2., 45, true);
                ReservationDAO reservationDAO = new ReservationDAO(ConnectionDB.getInstance());
                if (reservationDAO.findByDatePersAct(reservation.getDate(),reservation.getPersonne(),reservation.getActivite()) == null) {
                        reservationDAO.create(reservation);
                        reservation = reservationDAO.findByDatePersAct(reservation.getDate(),reservation.getPersonne(),reservation.getActivite());
                        reservation.setNbPersonne((830));
                        reservationDAO.update(reservation);
                        //reservationDAO.delete(reservation);
                        
                }

         
            }

        }

        ReservationDAO reservationDAO = new ReservationDAO(ConnectionDB.getInstance());
        listReservation = reservationDAO.findAll();

        Iterator<Reservation> it = listReservation.iterator();

        while (it.hasNext()) {
            reservation2 = (Reservation) it.next();
            System.out.println(reservation2.getActivite().getNom());
            System.out.println(reservation2.getDate());
            System.out.println(reservation2.getPersonne().getMail());
        }
    }
}
