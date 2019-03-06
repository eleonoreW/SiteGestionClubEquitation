package models;

public class SQLConstant {
    
    // RACE
    public static final String SELECT_ALL_RACE = "SELECT * FROM Race";
    public static final String SELECT_ALL_RACE_BY_ID = "SELECT * FROM Race WHERE ID=?";
    public static final String SELECT_ALL_RACE_BY_NAME = "SELECT * FROM Race WHERE Nom=?";
    public static final String INSERT_RACE = "INSERT INTO Race (ID, Nom) VALUES (DEFAULT, ?)";
    public static final String UPDATE_RACE = "UPDATE race SET Nom = ? WHERE ID = ?";
    public static final String DELETE_RACE = "DELETE FROM Race WHERE ID = ?";
    
    
    // CHEVAL
    public static final String INSERT_CHEVAL = "INSERT INTO Cheval(ID, RaceID,PersonneID, Nom, DateNaissance,Description,Commentaire,NbHeureMaxSemaine,Taille) VALUES (DEFAULT,?,?,?,?,?,?,?,?)";
    
    
    // TYPE
    public static final String SELECT_ALL_TYPE = "SELECT * FROM Type";
    public static final String SELECT_ALL_TYPE_BY_ID = "SELECT * FROM Type WHERE ID = ?";
    public static final String SELECT_ALL_TYPE_BY_NAME = "SELECT * FROM Type WHERE Nom = ?";
    public static final String INSERT_TYPE = "INSERT INTO Type(ID, Nom, Description) VALUES (DEFAULT, ?, ?)";
    public static final String UPDATE_TYPE = "UPDATE Type SET Nom = ?, Description = ? WHERE ID = ?";
    public static final String DELETE_TYPE = "DELETE FROM Type WHERE ID = ?";
    
    // LIEU
    public static final String SELECT_ALL_LIEU = "SELECT * FROM Lieu";
    public static final String SELECT_ALL_LIEU_BY_ID = "SELECT * FROM Lieu WHERE ID = ?";
    public static final String SELECT_ALL_LIEU_BY_NAME = "SELECT * FROM Lieu WHERE Nom = ?";
    public static final String INSERT_LIEU = "INSERT INTO Lieu(ID, Nom, Capacite, Description) VALUES (DEFAULT, ?, ?, ?)";
    public static final String UPDATE_LIEU = "UPDATE Lieu SET Nom = ?, Capacite = ?, Description = ? WHERE ID = ?";
    public static final String DELETE_LIEU = "DELETE FROM Lieu WHERE ID = ?";
    
}
