package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javabeans.Activite;
import javabeans.Lieu;
import javabeans.Personne;
import javabeans.Type;

public class ActiviteDAO extends CommonDAO<Activite> {

    private Activite activite;
    private ArrayList<Activite> listActivite = new ArrayList<>();

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

    @Override
    public boolean delete(Activite object) {
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

    public static void main(String args[]) {
        List<Activite> listActivite;

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
       
        Activite activite = new Activite(personne, lieu, type, "Activite2", "CommentaireAct2", "DetailsAct2", 222, (float) 2., 45, true);
        if (personne != null) {
            if (lieu != null) {
                if (type != null) {
                    ActiviteDAO activiteDAO = new ActiviteDAO(ConnectionDB.getInstance());
                    if (activiteDAO.findByName(activite.getNom()) == null) {
                        activiteDAO.create(activite);
                        activite = activiteDAO.findByName(activite.getNom());
                        activite.setCommentaire(("Un autre commentaire"));
                        activiteDAO.update(activite);
                        //activiteDAO.delete(activite);
                        
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
        
       
    }
}
