package es.usal;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskRepositoryTest {

    @Test
    void debeGuardarUnaTarea() throws Exception {

        DatabaseManager databaseManager = new DatabaseManager();
        DatabaseInitializer initializer = new DatabaseInitializer();
        TaskRepository repository = new TaskRepository(databaseManager);

        initializer.initialize(databaseManager);

        Task task = new Task(
                10,
                "Crear API",
                "Implementar los endpoints",
                Priority.HIGH
        );

        repository.save(task);

        String sql = "SELECT title, priority, status FROM tasks WHERE id = 10";

        try (Connection connection = databaseManager.connect();
             var statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            resultSet.next();

            assertEquals("Crear API", resultSet.getString("title"));
            assertEquals("HIGH", resultSet.getString("priority"));
            assertEquals("TODO", resultSet.getString("status"));
        }
    }
}