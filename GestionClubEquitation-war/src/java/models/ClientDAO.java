package models;

import java.sql.Connection;

public class ClientDAO extends EmployeDAO{

    public ClientDAO(Connection connection) {
        super(connection);
    }
    
}
