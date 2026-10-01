package es.usal;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseInitializerTest {

    @Test
    void debeCrearLaTablaTasks() throws Exception {

        DatabaseManager databaseManager = new DatabaseManager();
        DatabaseInitializer initializer = new DatabaseInitializer();

        initializer.initialize(databaseManager);

        try (Connection connection = databaseManager.connect();
             ResultSet resultSet = connection.getMetaData()
                     .getTables(null, null, "TASKS", null)) {

            assertTrue(resultSet.next());
        }
    }
}