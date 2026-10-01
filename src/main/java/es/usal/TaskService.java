package es.usal;

import java.sql.SQLException;

public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void createTask(Task task) throws SQLException {
        repository.save(task);
    }

    public Task getTask(int id) throws SQLException {
        return repository.findById(id);
    }

    public void updateTask(Task task) throws SQLException {
        repository.update(task);
    }

    public void changeStatus(int taskId, Status newStatus) throws SQLException {

        Task task = repository.findById(taskId);

        if (task == null) {
            return;
        }

        if (task.getStatus() == Status.TODO && newStatus == Status.DONE) {
            return;
        }

        task.changeStatus(newStatus);
        repository.update(task);
    }

}