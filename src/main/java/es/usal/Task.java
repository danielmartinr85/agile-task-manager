package es.usal;

public class Task {

    private int id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;

    public Task(int id, String title, String description, Priority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = Status.TODO;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public void changeStatus(Status newStatus) {
        this.status = newStatus;
    }
}