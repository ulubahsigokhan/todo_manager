import model.Task;
import model.TaskManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        Task t1 = new Task("Learn Java", Task.Priority.HIGH);
        Task t2 = new Task("Go to Gym", Task.Priority.MEDIUM);

        manager.addTask(t1);
        manager.addTask(t2);

        System.out.println("Tasks added successfully!");

        manager.listTasks();

        boolean removed = manager.removeTask(1);
        System.out.println("Removed Task 1? " + removed);

        manager.listTasks();

        System.out.println("\nSearch results for 'Gym':");
        List<Task> found = manager.searchTasks("Gym");
        for (Task t : found) {
            System.out.println(t);
        }

    }
}
