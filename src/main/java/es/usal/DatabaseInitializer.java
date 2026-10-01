package es.usal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public void initialize(DatabaseManager databaseManager) throws SQLException {

        String sql = """
                CREATE TABLE IF NOT EXISTS tasks (
                    id INT PRIMARY KEY,
                    title VARCHAR(255) NOT NULL,
                    description VARCHAR(1000),
                    priority VARCHAR(20) NOT NULL,
                    status VARCHAR(20) NOT NULL
                )
                """;

        try (Connection connection = databaseManager.connect();
             Statement statement = connection.createStatement()) {

            statement.execute(sql);
        }
    }
}