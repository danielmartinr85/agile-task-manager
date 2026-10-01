package es.usal;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


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

    @Test
    void debeEncontrarUnaTareaPorId() throws Exception {

        DatabaseManager databaseManager = new DatabaseManager();
        DatabaseInitializer initializer = new DatabaseInitializer();
        TaskRepository repository = new TaskRepository(databaseManager);

        initializer.initialize(databaseManager);

        Task task = new Task(
                20,
                "Crear frontend",
                "Implementar la interfaz de usuario",
                Priority.MEDIUM
        );

        task.changeStatus(Status.IN_PROGRESS);

        repository.save(task);

        Task foundTask = repository.findById(20);

        assertEquals(20, foundTask.getId());
        assertEquals("Crear frontend", foundTask.getTitle());
        assertEquals("Implementar la interfaz de usuario", foundTask.getDescription());
        assertEquals(Priority.MEDIUM, foundTask.getPriority());
        assertEquals(Status.IN_PROGRESS, foundTask.getStatus());
    }

    @Test
    void debeDevolverNullSiLaTareaNoExiste() throws Exception {

        DatabaseManager databaseManager = new DatabaseManager();
        DatabaseInitializer initializer = new DatabaseInitializer();
        TaskRepository repository = new TaskRepository(databaseManager);

        initializer.initialize(databaseManager);

        Task foundTask = repository.findById(999);

        assertEquals(null, foundTask);
    }
}