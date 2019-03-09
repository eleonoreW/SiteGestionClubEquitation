package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javabeans.Cheval;
import javabeans.Client;
import javabeans.Personne;
import javabeans.Race;
import models.CommonDAO;

public class ChevalDAO extends CommonDAO<Cheval> {

    private Cheval cheval;
    private ArrayList<Cheval> listCheval = new ArrayList<>();
    
    public ChevalDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Cheval create(Cheval object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.INSERT_CHEVAL);

            statement.setInt(1, object.getRace().getRace_id());
            statement.setInt(2, object.getProprietaire().getId());
            statement.setString(3, object.getNom());
            statement.setInt(4, object.getDateNaissance());
            statement.setString(5, object.getDescription());
            statement.setString(6, object.getCommentaire());
            statement.setInt(7, object.getNbHeureMaxSemaine());
            statement.setInt(8, object.getTaille());
            
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return object;
    }

    @Override
    public boolean delete(Cheval object) {
      try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.DELETE_CHEVAL);
            
            statement.setInt(1, object.getCheval_id());
            
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public boolean update(Cheval object) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.UPDATE_CHEVAL);
            
            statement.setInt(1, object.getRace().getRace_id());
            statement.setInt(2, object.getProprietaire().getId());
            statement.setString(3, object.getNom());
            statement.setInt(4, object.getDateNaissance());
            statement.setString(5, object.getDescription());
            statement.setString(6, object.getCommentaire());
            statement.setInt(7, object.getNbHeureMaxSemaine());
            statement.setInt(8, object.getTaille());
            statement.setInt(9, object.getCheval_id());
            
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public Cheval findById(int id) {
        cheval = null;
        Race race = null;
        Personne personne = null;
        try{
            PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_CHEVAL_BY_ID);
            statement.setInt(1,id);
            ResultSet res = statement.executeQuery();
            
            RaceDAO raceDAO = new RaceDAO(ConnectionDB.getInstance());
            PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());

            if(res.next()){
                race = raceDAO.findById(res.getInt("ID"));
                personne = personneDAO.findById(res.getInt("ID"));
                cheval = new Cheval(res.getInt("ID"),race,personne,res.getString("Nom"),res.getInt("dateNaissance"),res.getString("Description"),res.getString("Commentaire"),res.getInt("NbHeureMaxSemaine"),res.getInt("taille"));
            }
            statement.close();
            res.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cheval;
    }

    public Cheval findByName(String name) {
        cheval = null;
        Race race = null;
        Personne personne = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SQLConstant.SELECT_ALL_CHEVAL_BY_NAME);
            statement.setString(1, name);
            ResultSet res = statement.executeQuery();
            
            RaceDAO raceDAO = new RaceDAO(ConnectionDB.getInstance());
            PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
           
            if(res.next()) {
                race = raceDAO.findById(res.getInt("RaceID"));
                personne = personneDAO.findById(res.getInt("PersonneID"));
                cheval = new Cheval(res.getInt("ID"),race,personne, res.getString("Nom"),res.getInt("dateNaissance"),res.getString("Description"),res.getString("Commentaire"),res.getInt("NbHeureMaxSemaine"),res.getInt("taille"));
            }
            statement.close();
            res.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return cheval;
    }

    @Override
    public ArrayList<Cheval> findAll() {
        listCheval = new ArrayList<>();
        Race race = null;
        Personne personne = null;
        
        RaceDAO raceDAO = new RaceDAO(ConnectionDB.getInstance());
        PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
        try {
            ResultSet res = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeQuery(SQLConstant.SELECT_ALL_CHEVAL);
            
            while(res.next()) {
                race = raceDAO.findById(res.getInt("ID"));
                personne = personneDAO.findById(res.getInt("ID"));
                cheval = new Cheval(res.getInt("ID"),race,personne, res.getString("Nom"),res.getInt("dateNaissance"),res.getString("Description"),res.getString("Commentaire"),res.getInt("NbHeureMaxSemaine"),res.getInt("taille"));
                listCheval.add(cheval);
            }
            res.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return listCheval;
    }

    public ArrayList<Cheval> filterBy(String nom, Race race, Personne proprietaire, int dateNaissanceMin, int dateNaissanceMax, int tailleMin, int tailleMax ){
        listCheval = new ArrayList<>();
        Race raceCheval = null;
        Personne personne = null;
        
        RaceDAO raceDAO = new RaceDAO(ConnectionDB.getInstance());
        PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
        String queryString = SQLConstant.SELECT_ALL_CHEVAL +" WHERE ID ";
        // Prepare query
        if(nom != null){
            queryString += " AND " + SQLConstant.WITH_NAME_LIKE+" '%"+nom+"%' ";
        }
        if(race != null){
            race = raceDAO.findByName(race.getNom());
            if(race != null){
                queryString += " AND " + SQLConstant.WITH_RACEID + " " + race.getRace_id() + " ";
            }
            
        }/*
        if(proprietaire != null){
            proprietaire = personneDAO.findByMail(proprietaire.getMail());
            if(proprietaire != null){
                queryString += " AND" + SQLConstant.WITH_RACEID + proprietaire.getRace_id();
            }
        }*/
        queryString += " AND " + SQLConstant.WITH_DATENAISSANCE_GEQ+ " " + dateNaissanceMin + " ";
        queryString += " AND " + SQLConstant.WITH_DATENAISSANCE_LEQ+ " " + dateNaissanceMax + " ";
        
        queryString += " AND" + SQLConstant.WITH_TAILLE_GEQ + " " + tailleMin + " ";
        queryString += " AND" + SQLConstant.WITH_TAILLE_LEQ + " " + tailleMax + " ";
        System.out.println("MyQuery : "+ queryString);
        try {
            PreparedStatement statement = connection.prepareStatement(queryString, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet res = statement.executeQuery();
            while(res.next()) {
                raceCheval = raceDAO.findById(res.getInt("ID"));
                personne = personneDAO.findById(res.getInt("ID"));
                cheval = new Cheval(res.getInt("ID"),raceCheval,personne, res.getString("Nom"),res.getInt("dateNaissance"),res.getString("Description"),res.getString("Commentaire"),res.getInt("NbHeureMaxSemaine"),res.getInt("taille"));
                listCheval.add(cheval);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return listCheval;
    }
    
    
    // PAS FINI
    public static void main(String args[]) {
        
        System.out.println("On est dans le main de ChevalDAO");
        List<Cheval> listCheval;
        Cheval cheval2;
        
        Race race = new Race("Joli Cheval");
        RaceDAO raceDAO = new RaceDAO(ConnectionDB.getInstance());
        race = raceDAO.findByName(race.getNom());
        
        Personne proprietaire = new Personne("DUPONT", "Toto", "duponttoto@toto.com", "0607080900", 28031998,"pwd");
        PersonneDAO personneDAO = new PersonneDAO(ConnectionDB.getInstance());
        proprietaire = personneDAO.findByMail(proprietaire.getMail());
        
        if(race != null){
            if(proprietaire != null){
                Cheval cheval = new Cheval(race, proprietaire, "Zeus", 24101996, "descriptionducheval", "commentairecheval", 10, 175);
                ChevalDAO chevalDAO = new ChevalDAO(ConnectionDB.getInstance());
                if(chevalDAO.findByName(cheval.getNom()) == null){
                   chevalDAO.create(cheval);
                   cheval = chevalDAO.findByName(cheval.getNom());
                   //chevalDAO.delete(cheval);
                   cheval.setDescription(("autre description du super cheval"));
                   chevalDAO.update(cheval);
                }
                
            }
        }
        ChevalDAO chevalDAO = new ChevalDAO(ConnectionDB.getInstance());
        
        listCheval = chevalDAO.findAll();
        
        Iterator<Cheval> it = listCheval.iterator();
        
        while(it.hasNext()){
            cheval2 = (Cheval)it.next();
            System.out.println(cheval2.getNom());
        }
        
        race = new Race("Appaloosa");
        
        
        System.out.println("Tri par taille >160 < 165, race Appaloosa");
        listCheval = chevalDAO.filterBy(null, race, null, 0, 8092019, 160, 165);
        
        it = listCheval.iterator();
        
        while(it.hasNext()){
            cheval2 = (Cheval)it.next();
            System.out.println(cheval2.getNom());
        }
      
        System.out.println("Tri par nom contient \'ie\'");
        listCheval = chevalDAO.filterBy("ie", null, null, 0, 8092019, 0, 5000);
        
        it = listCheval.iterator();
        
        while(it.hasNext()){
            cheval2 = (Cheval)it.next();
            System.out.println(cheval2.getNom());
        }
        
    }
}