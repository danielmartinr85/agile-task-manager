package es.usal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:h2:./data/agile_tasks";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}