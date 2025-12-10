import model.Task;
import model.TaskManager;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        // Add tasks
        manager.addTask(new Task("Buy Groceries", Task.Priority.HIGH, LocalDate.of(2025, 12, 20)));
        manager.addTask(new Task("Go to Gym", Task.Priority.MEDIUM, LocalDate.of(2025, 12, 22)));

        // === BEFORE UPDATE ===
        System.out.println("=== BEFORE UPDATE ===");
        manager.printAllTasks();

        // Update the tasks
        manager.updateTitle(1, "Buy Milk");
        manager.updatePriority(2, Task.Priority.HIGH);
        manager.markTaskCompleted(1);  // Only works if you added this earlier

        // === AFTER UPDATE ===
        System.out.println("\n=== AFTER UPDATE ===");
        manager.printAllTasks();
    }
}
