package es.usal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskServiceTest {

    @Test
    void debeCrearYRecuperarUnaTarea() throws Exception {

        DatabaseManager databaseManager = new DatabaseManager();
        DatabaseInitializer initializer = new DatabaseInitializer();
        TaskRepository repository = new TaskRepository(databaseManager);
        TaskService service = new TaskService(repository);

        initializer.initialize(databaseManager);

        Task task = new Task(
                40,
                "Crear servicio",
                "Implementar la capa de servicio",
                Priority.HIGH
        );

        service.createTask(task);

        Task foundTask = service.getTask(40);

        assertEquals(40, foundTask.getId());
        assertEquals("Crear servicio", foundTask.getTitle());
        assertEquals("Implementar la capa de servicio", foundTask.getDescription());
        assertEquals(Priority.HIGH, foundTask.getPriority());
        assertEquals(Status.TODO, foundTask.getStatus());
    }

    @Test
    void noDebePermitirPasarDirectamenteDeTodoADone() throws Exception {

        DatabaseManager databaseManager = new DatabaseManager();
        DatabaseInitializer initializer = new DatabaseInitializer();
        TaskRepository repository = new TaskRepository(databaseManager);
        TaskService service = new TaskService(repository);

        initializer.initialize(databaseManager);

        Task task = new Task(
                50,
                "Crear validaciones",
                "Añadir validaciones de negocio",
                Priority.HIGH
        );

        service.createTask(task);

        service.changeStatus(50, Status.DONE);

        Task foundTask = service.getTask(50);

        assertEquals(Status.TODO, foundTask.getStatus());
    }

    @Test
    void debePermitirPasarDeTodoAEnProgresoYDespuesADone() throws Exception {

        DatabaseManager databaseManager = new DatabaseManager();
        DatabaseInitializer initializer = new DatabaseInitializer();
        TaskRepository repository = new TaskRepository(databaseManager);
        TaskService service = new TaskService(repository);

        initializer.initialize(databaseManager);

        Task task = new Task(
                60,
                "Completar documentación",
                "Documentar el funcionamiento del proyecto",
                Priority.MEDIUM
        );

        service.createTask(task);

        service.changeStatus(60, Status.IN_PROGRESS);

        Task inProgressTask = service.getTask(60);

        assertEquals(Status.IN_PROGRESS, inProgressTask.getStatus());

        service.changeStatus(60, Status.DONE);

        Task completedTask = service.getTask(60);

        assertEquals(Status.DONE, completedTask.getStatus());
    }
}