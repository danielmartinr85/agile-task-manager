package es.usal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {

    @Test
    void nuevaTareaDebeEmpezarEnTodo() {

        Task task = new Task(
                1,
                "Crear login",
                "Implementar el login de usuarios",
                Priority.HIGH
        );

        assertEquals(Status.TODO, task.getStatus());
    }

    @Test
    void tareaDebeGuardarSusDatos() {

        Task task = new Task(
                2,
                "Crear base de datos",
                "Diseñar las tablas de la aplicación",
                Priority.MEDIUM
        );

        assertEquals(2, task.getId());
        assertEquals("Crear base de datos", task.getTitle());
        assertEquals("Diseñar las tablas de la aplicación", task.getDescription());
        assertEquals(Priority.MEDIUM, task.getPriority());
    }

    @Test
    void tareaPuedePasarAEnProgreso() {

        Task task = new Task(
                3,
                "Implementar API",
                "Crear los endpoints de la aplicación",
                Priority.HIGH
        );

        task.changeStatus(Status.IN_PROGRESS);

        assertEquals(Status.IN_PROGRESS, task.getStatus());
    }
}