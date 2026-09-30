package es.usal;

public class Main {

    public static void main(String[] args) {

        Task task = new Task(
                1,
                "Crear login",
                "Implementar el login de usuarios",
                Priority.HIGH
        );

        System.out.println("ID: " + task.getId());
        System.out.println("Título: " + task.getTitle());
        System.out.println("Descripción: " + task.getDescription());
        System.out.println("Prioridad: " + task.getPriority());
        System.out.println("Estado: " + task.getStatus());

    }
}