package es.usal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:h2:mem:agile_tasks;DB_CLOSE_DELAY=-1";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}