package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {
    
    private static Connection connection;
    
    private static String url = "jdbc:mysql://localhost:3306/clubequitation?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "";
    
    private ConnectionDB() {
        try {
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            connection = DriverManager.getConnection(url, user, password);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getInstance() {
        if(connection == null) {
            new ConnectionDB();
        }
        return connection;
    }
}
