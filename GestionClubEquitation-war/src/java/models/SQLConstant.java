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
    public static final String SELECT_ALL_CHEVAL = "SELECT * FROM Cheval";
    public static final String SELECT_ALL_CHEVAL_BY_NAME = "SELECT * FROM Cheval WHERE Nom=?";
    public static final String SELECT_ALL_CHEVAL_BY_ID = "SELECT * FROM Cheval WHERE ID=?";
    public static final String INSERT_CHEVAL = "INSERT INTO Cheval(ID, RaceID,PersonneID, Nom, DateNaissance,Description,Commentaire,NbHeureMaxSemaine,Taille) VALUES (DEFAULT,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_CHEVAL = "UPDATE Cheval SET RaceID = ?, PersonneID = ?, Nom = ?, DateNaissance = ?, Description = ?, Commentaire = ?, NbHeureMaxSemaine = ?, Taille = ?  WHERE ID = ?";
    public static final String DELETE_CHEVAL = "DELETE FROM Cheval WHERE ID = ?";
    
    // TYPE
    public static final String SELECT_ALL_TYPE = "SELECT * FROM Type";
    public static final String SELECT_ALL_TYPE_BY_ID = "SELECT * FROM Type";
    public static final String SELECT_ALL_TYPE_BY_NAME = "SELECT * FROM Type WHERE Nom = ?";
    public static final String INSERT_TYPE = "INSERT INTO Type(ID, Nom, Description) VALUES (DEFAULT, ?, ?)";
    public static final String UPDATE_TYPE = "UPDATE Type SET Nom = ?, Description = ? WHERE ID = ?";
    public static final String DELETE_TYPE = "DELETE FROM Type WHERE ID = ?";
    
	
    // PERSONNE
    public static final String SELECT_ALL_PERSONNE = "SELECT * FROM Personne";
    public static final String SELECT_ALL_PERSONNE_BY_NAME = "SELECT * FROM Personne WHERE Nom=?";
    public static final String SELECT_ALL_PERSONNE_BY_MAIL = "SELECT * FROM Personne WHERE Mail=?";
    public static final String SELECT_PERSONNE_BY_ID = "SELECT * FROM Personne WHERE ID=?";
    public static final String INSERT_PERSONNE = "INSERT INTO Personne (ID,Prenom,Nom,Mail,Telephone,DateNaissance,Discriminator) VALUES (DEFAULT,?,?,?,?,?,?)";
    public static final String UPDATE_PERSONNE = "UPDATE Personne SET Prenom = ?, Nom = ?,Mail = ?,Telephone = ?,DateNaissance = ?,Discriminator = ? WHERE ID = ?";
    public static final String DELETE_PERSONNE = "DELETE FROM Personne WHERE ID = ?";
    
    // PERSONNE
    public static final String INSERT_EMPLOYE = "INSERT INTO Personne (ID,Prenom,Nom,Mail,Telephone,DateNaissance,NbHeureMaxSemaine,Discriminator) VALUES (DEFAULT,?,?,?,?,?,?,?)";
    public static final String UPDATE_EMPLOYE = "UPDATE Personne SET Prenom = ?, Nom = ?,Mail = ?,Telephone = ?,DateNaissance = ?,NbHeureMaxSemaine =?, Discriminator = ? WHERE ID = ?";
    
}
