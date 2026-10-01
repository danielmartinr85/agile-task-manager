package es.usal;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DatabaseManagerTest {

    @Test
    void debePoderConectarse() throws Exception {

        DatabaseManager databaseManager = new DatabaseManager();

        Connection connection = databaseManager.connect();

        assertNotNull(connection);

        connection.close();
    }
}