package models;

public class SQLConstant {
    
    // RACE
    public static final String SELECT_ALL_RACE = "SELECT * FROM Race";
    public static final String SELECT_ALL_RACE_BY_ID = "SELECT * FROM Race WHERE ID=?";
    public static final String SELECT_ALL_RACE_BY_NAME = "SELECT * FROM Race WHERE Nom=?";
    public static final String INSERT_RACE = "INSERT INTO Race (ID, Nom) VALUES (DEFAULT, ?)";
    public static final String UPDATE_RACE = "UPDATE race SET ID = ?, Nom = ? WHERE ID = ?";
    public static final String DELETE_RACE = "DELETE Race WHERE ID = ?";
    
    
    // CHEVAL
    public static final String INSERT_CHEVAL = "INSERT INTO Cheval(ID, RaceID,PersonneID, Nom, DateNaissance,Description,Commentaire,NbHeureMaxSemaine,Taille) VALUES (DEFAULT,?,?,?,?,?,?,?,?)";
	
	 // PERSONNE
    public static final String SELECT_ALL_PERSONNE = "SELECT * FROM Personne";
    public static final String SELECT_ALL_PERSONNE_BY_NAME = "SELECT * FROM Personne WHERE Nom=?";
    public static final String SELECT_PERSONNE_BY_ID = "SELECT * FROM Personne WHERE ID=?";
    public static final String INSERT_PERSONNE = "INSERT INTO Personne (ID,Prenom,Nom,Mail,Telephone,DateNaissance,NbHeureActiviteMaxSemaine,Discriminator) VALUES (DEFAULT,?,?,?,?,?,?,?)";
    public static final String UPDATE_PERSONNE = "UPDATE Personne SET Prenom = ?, Nom = ?,Mail = ?,Telephone = ?,DateNaissance = ?,NbHeureActiviteMaxSemaine = ? WHERE ID = ?";
    public static final String DELETE_PERSONNE = "DELETE FROM Personne WHERE ID = ?";
}
