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

    public Task findById(int id) throws SQLException {

        String sql = """
            SELECT id, title, description, priority, status
            FROM tasks
            WHERE id = ?
            """;

        try (Connection connection = databaseManager.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (var resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    Task task = new Task(
                            resultSet.getInt("id"),
                            resultSet.getString("title"),
                            resultSet.getString("description"),
                            Priority.valueOf(resultSet.getString("priority"))
                    );

                    task.changeStatus(
                            Status.valueOf(resultSet.getString("status"))
                    );

                    return task;
                }

                return null;
            }
        }
    }

    public void update(Task task) throws SQLException {

        String sql = """
            UPDATE tasks
            SET title = ?,
                description = ?,
                priority = ?,
                status = ?
            WHERE id = ?
            """;

        try (Connection connection = databaseManager.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getPriority().name());
            statement.setString(4, task.getStatus().name());
            statement.setInt(5, task.getId());

            statement.executeUpdate();
        }
    }

}