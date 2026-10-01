package es.usal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskRepository {

    private final DatabaseManager databaseManager;

    public TaskRepository(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void save(Task task) throws SQLException {

        String sql = """
                INSERT INTO tasks (id, title, description, priority, status)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection connection = databaseManager.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, task.getId());
            statement.setString(2, task.getTitle());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getPriority().name());
            statement.setString(5, task.getStatus().name());

            statement.executeUpdate();
        }
    }
}