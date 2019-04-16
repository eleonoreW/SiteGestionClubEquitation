package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javabeans.Activite;
import javabeans.Cheval;
import javabeans.Lieu;
import javabeans.Personne;
import javabeans.Type;

public class ActiviteDAO extends CommonDAO<Activite> {

    private Activite activite;
    private ArrayList<Activite> listActivite = new ArrayList<>();
    private ArrayList<Cheval> listCheval = new ArrayList<>();
    
    public ActiviteDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Activite create(Activite object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.INSERT_ACTIVITE);

            statement.setInt(1, object.getPersonne().getId());
            statement.setInt(2, object.getLieu().getLieu_id());
            statement.setInt(3, object.getType().getType_id());
            statement.setString(4, object.getNom());
            statement.setString(5, object.getCommentaire());
            statement.setString(6, object.getDetails());
            statement.setInt(7, object.getDate());
            statement.setFloat(8, object.getDuree());
            statement.setInt(9, object.getCapacite());
            statement.setBoolean(10, object.getEst_active());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return object;
    }
    
    public Activite create(Activite object, List<Cheval> listeCheval){
        Cheval cheval;
        try{
            PreparedStatement statement = connection.prepareStatement((SQLConstant.INSERT_ACTIVITE));
            statement.setInt(1, object.getPersonne().getId());
            statement.setInt(2, object.getLieu().getLieu_id());
            statement.setInt(3, object.getType().getType_id());
            statement.setString(4, object.getNom());
            statement.setString(5, object.getCommentaire());
            statement.setString(6, object.getDetails());
            statement.setInt(7, object.getDate());
            statement.setFloat(8, object.getDuree());
            statement.setInt(9, object.getCapacite());
            statement.setBoolean(10, object.getEst_active());
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();        
        }  
        
        ActiviteDAO activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());
        activite = activiteDAO.findByName(object.getNom());
        try{
            PreparedStatement statement2 = connection.prepareStatement((SQLConstant.ADD_CHEVAL_ACTIVITE));
            Iterator<Cheval> it = listeCheval.iterator();
            statement2.setObject(2,activite.getActivite_id());
            while (it.hasNext()){
                cheval = (Cheval) it.next();
                statement2.setInt(1, cheval.getCheval_id());
                statement2.executeUpdate();
            }
            statement2.close();
        }catch(SQLException e){
            e.printStackTrace();
                
        }  
        return object;
    }
    

    @Override
    public boolean delete(Activite object) {
        //Supression des reservation liées à l'activie
        try{
            PreparedStatement statement = connection.prepareStatement(SQLConstant.DELETE_RESERVATION);
            statement.setInt(1,object.getActivite_id());
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        //Supression des chevaux liés à l'activite
        try{
            PreparedStatement statement = connection.prepareStatement(SQLConstant.DELETE_CHEVAL_ACTIVITE);
            statement.setInt(1,object.getActivite_id());
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        //Supression de l'activite
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.DELETE_ACTIVITE);
            statement.setInt(1, object.getActivite_id());
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public boolean update(Activite object) {
        try{
            PreparedStatement statement = connection.prepareStatement(SQLConstant.DELETE_CHEVAL_ACTIVITE);
            statement.setInt(1, object.getActivite_id());
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.UPDATE_ACTIVITE);
            
            statement.setInt(1, object.getPersonne().getId());
            statement.setInt(2, object.getLieu().getLieu_id());
            statement.setInt(3, object.getType().getType_id());
            statement.setString(4, object.getNom());
            statement.setString(5, object.getCommentaire());
            statement.setString(6, object.getDetails());
            statement.setInt(7, object.getDate());
            statement.setFloat(8, object.getDuree());
            statement.setInt(9, object.getCapacite());
            statement.setBoolean(10, object.getEst_active());
            statement.setInt(11, object.getActivite_id());
            
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;    
    }

    @Override
    public Activite findById(int id) {
        activite = null;
        Personne personne = null;
        Lieu lieu = null;
        Type type = null;
        try{
            PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_ACTIVITE_BY_ID);
            statement.setInt(1,id);
            ResultSet res = statement.executeQuery();
            
            PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
            LieuDAO lieuDAO = new LieuDAO(ConnectionDB.getInstance());
            TypeDAO typeDAO = new TypeDAO(ConnectionDB.getInstance());

            if(res.next()){
                personne = personneDAO.findById(res.getInt("PersonneID"));
                lieu = lieuDAO.findById(res.getInt("LieuID"));
                type = typeDAO.findById(res.getInt("TypeID"));
                activite = new Activite(res.getInt("ID"), personne, lieu, type, res.getString("Nom"), res.getString("Commentaire"), res.getString("Details"), res.getInt("Date"), res.getFloat("Duree"), res.getInt("Capacite"), res.getBoolean("EstActive"));
            }
            statement.close();
            res.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return activite;    
    }

    public Activite findByName(String name) {
        activite = null;

        Personne personne = null;
        Lieu lieu = null;
        Type type = null;

        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_ACTIVITE_BY_NAME);
            statement.setString(1, name);
            ResultSet res = statement.executeQuery();

            PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
            LieuDAO lieuDAO = new LieuDAO(ConnectionDB.getInstance());
            TypeDAO typeDAO = new TypeDAO(ConnectionDB.getInstance());

            if (res.next()) {
                personne = personneDAO.findById(res.getInt("PersonneID"));
                lieu = lieuDAO.findById(res.getInt("LieuID"));
                type = typeDAO.findById(res.getInt("TypeID"));
                activite = new Activite(res.getInt("ID"), personne, lieu, type, res.getString("Nom"), res.getString("Commentaire"), res.getString("Details"), res.getInt("Date"), res.getFloat("Duree"), res.getInt("Capacite"), res.getBoolean("EstActive"));

            }
            statement.close();
            res.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return activite;
    }
    
    public Activite findByNameDate(String name, int date){
        activite = null;
        Personne personne = null;
        Lieu lieu = null;
        Type type = null;

        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_ACTIVITE_BY_NAME_DATE);
            statement.setString(1, name);
            statement.setInt(2, date);
            ResultSet res = statement.executeQuery();

            PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
            LieuDAO lieuDAO = new LieuDAO(ConnectionDB.getInstance());
            TypeDAO typeDAO = new TypeDAO(ConnectionDB.getInstance());

            if (res.next()) {
                personne = personneDAO.findById(res.getInt("PersonneID"));
                lieu = lieuDAO.findById(res.getInt("LieuID"));
                type = typeDAO.findById(res.getInt("TypeID"));
                activite = new Activite(res.getInt("ID"), personne, lieu, type, res.getString("Nom"), res.getString("Commentaire"), res.getString("Details"), res.getInt("Date"), res.getFloat("Duree"), res.getInt("Capacite"), res.getBoolean("EstActive"));

            }
            statement.close();
            res.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return activite;
        
    }
    
    
    public ArrayList<Activite> findAllFuturDateNotCanceled() {
        listActivite = new ArrayList<>();

        Personne personne = null;
        Lieu lieu = null;
        Type type = null;

        PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
        LieuDAO lieuDAO = new LieuDAO(ConnectionDB.getInstance());
        TypeDAO typeDAO = new TypeDAO(ConnectionDB.getInstance());

        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_ACTIVITE_FUTUR_DATE_NOT_CANCELED, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            // get the current date
            String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
                        
            statement.setInt(1, Integer.parseInt(timeStamp)); 
            ResultSet res = statement.executeQuery();
                    
            while (res.next()) {
                personne = personneDAO.findById(res.getInt("PersonneID"));
                lieu = lieuDAO.findById(res.getInt("LieuID"));
                type = typeDAO.findById(res.getInt("TypeID"));
                activite = new Activite(res.getInt("ID"), personne, lieu, type, res.getString("Nom"), res.getString("Commentaire"), res.getString("Details"), res.getInt("Date"), res.getFloat("Duree"), res.getInt("Capacite"), res.getBoolean("EstActive"));

                listActivite.add(activite);
            }
            res.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listActivite;
    }
    
    public int getNbPlaceDispo(int id) {  
        activite = findById(id);
        
        int nbPlaceReserv = 0;
        try {
        PreparedStatement statement = connection.prepareStatement(SQLConstant.SUM_PLACE_RESERVEES);
        statement.setInt(1, id);
        
        ResultSet res = statement.executeQuery();
        
        if(res.next()) {
            nbPlaceReserv = res.getInt("Count");
        }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return activite.getCapacite() - nbPlaceReserv;
    }

    public ArrayList<Cheval> findAllChevalActivite(int act_id){
        listCheval = new ArrayList<>();
        Cheval cheval = null;
        
        try{
            PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_CHEVAL_ACTIVITE);
            statement.setInt(1, act_id);
            ResultSet res = statement.executeQuery();

            while (res.next()) {
                ChevalDAO chevalDAO = new ChevalDAO(ConnectionDB.getInstance());
                cheval = chevalDAO.findById(res.getInt("ChevalID"));
                listCheval.add(cheval);
            }
            res.close();
            
        }catch(SQLException e){
             e.printStackTrace();
        }
        return listCheval;
    }
    @Override
    public ArrayList<Activite> findAll() {
        listActivite = new ArrayList<>();

        Personne personne = null;
        Lieu lieu = null;
        Type type = null;

        PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
        LieuDAO lieuDAO = new LieuDAO(ConnectionDB.getInstance());
        TypeDAO typeDAO = new TypeDAO(ConnectionDB.getInstance());

        try {
            ResultSet res = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeQuery(SQLConstant.SELECT_ALL_ACTIVITE);

            while (res.next()) {
                personne = personneDAO.findById(res.getInt("PersonneID"));
                lieu = lieuDAO.findById(res.getInt("LieuID"));
                type = typeDAO.findById(res.getInt("TypeID"));
                activite = new Activite(res.getInt("ID"), personne, lieu, type, res.getString("Nom"), res.getString("Commentaire"), res.getString("Details"), res.getInt("Date"), res.getFloat("Duree"), res.getInt("Capacite"), res.getBoolean("EstActive"));

                listActivite.add(activite);
            }
            res.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listActivite;
    }
    
    public boolean addChevalActivite(Cheval cheval, Activite activite){
        try{
            PreparedStatement statement = connection.prepareStatement(SQLConstant.ADD_CHEVAL_ACTIVITE);
            
            statement.setInt(1,cheval.getCheval_id());
            statement.setInt(2,activite.getActivite_id());
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    
    public int nbPlaceDejaReserver(int id){
        int nbPlaceReserv = 0;
        try{
           PreparedStatement statement = connection.prepareStatement(SQLConstant.SUM_PLACE_RESERVEES);
           statement.setInt(1, id);
           ResultSet res = statement.executeQuery();
        
        if(res.next()) {
            nbPlaceReserv = res.getInt("Count");
        }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return nbPlaceReserv;
    }
    
    public static void main(String args[]) {
        List<Activite> listActivite;
        List<Cheval> listCheval;
        Activite activite2;

        //Personne
        PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
        Personne personne = personneDAO.findByMail("eleo@mail.ca");
        //Lieu
        LieuDAO lieuDAO = new LieuDAO(ConnectionDB.getInstance());
        Lieu lieu = lieuDAO.findByName("Pré Ouest");        
        
        //Type
        TypeDAO typeDAO = new TypeDAO(ConnectionDB.getInstance());
        Type type = typeDAO.findByName("Promenade au bord de l'eau");
       
        //Chevaux
        //List<Cheval> listCheval;
        ChevalDAO chevalDAO = new ChevalDAO(ConnectionDB.getInstance());
        listCheval = chevalDAO.findAll();
        
        Activite activite = new Activite(personne, lieu, type, "Activite2", "CommentaireAct2", "DetailsAct2", 222, (float) 2., 45, true);
        if (personne != null) {
            if (lieu != null) {
                if (type != null) {
                    ActiviteDAO activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());
                    if (activiteDAO.findByName(activite.getNom()) == null) {
                        
                        activiteDAO.create(activite,listCheval);
                        activite = activiteDAO.findByNameDate(activite.getNom(),activite.getDate());
                        activite.setCommentaire(("Un autre commentaire"));
                        activiteDAO.update(activite);
                        activiteDAO.delete(activite);
                 
                    }
                }
            }

        }

        ActiviteDAO activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());
        listActivite = activiteDAO.findAll();

        Iterator<Activite> it = listActivite.iterator();

        while (it.hasNext()) {
            activite2 = (Activite) it.next();
            System.out.println(activite2.getNom());
        }
        
        //Ajout d'un cheval à une activite
        
        //ChevalDAO chevalDAO = new ChevalDAO(ConnectionDB.getInstance());
        Cheval cheval = chevalDAO.findByName("Cookie");
        //ActiviteDAO activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());
        Activite activitetest = activiteDAO.findByName("Activite2");
        System.out.println("Liste cheval");
        listCheval = activiteDAO.findAllChevalActivite(1);
        
        //activiteDAO.addChevalActivite(cheval, activitetest);
        
        
        
       
    }
}
