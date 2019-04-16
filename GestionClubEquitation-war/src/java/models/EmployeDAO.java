package models;

import java.sql.Connection;



public class EmployeDAO extends PersonneDAO{
    public EmployeDAO(Connection connection) {
            super(connection);
        }
}
