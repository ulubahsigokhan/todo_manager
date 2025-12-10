import model.Task;
import model.TaskManager;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        // Add tasks
        manager.addTask(new Task("Buy Groceries", Task.Priority.HIGH, LocalDate.of(2025, 12, 20)));
        manager.addTask(new Task("Go to Gym", Task.Priority.MEDIUM, LocalDate.of(2025, 12, 22)));
        manager.addTask(new Task("Go to Work", Task.Priority.MEDIUM, null));

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

        // === Sorted by due Date ===
        System.out.println("\n=== SORTED BY DUE DATE ===");
        List<Task> sorted = manager.sortByDueDate();
        for (Task t : sorted) {
            System.out.println(t);
        }

        // Toggle one completed
        manager.findById(1).setCompleted(true);

        // === FILTER BY PRIORITY ===
        System.out.println("\n=== FILTER: Priority HIGH ===");
        List<Task> highPriority = manager.filterByPriority(Task.Priority.HIGH);
        manager.printTasks(highPriority);

        // === FILTER BY COMPLETION ===
        System.out.println("\n=== FILTER: Completed ===");
        List<Task> completed = manager.filterByCompletion(true);
        manager.printTasks(completed);

        System.out.println("\n=== FILTER: Not Completed ===");
        List<Task> notCompleted = manager.filterByCompletion(false);
        manager.printTasks(notCompleted);

        // === SORT BY DUE DATE ===
        System.out.println("\n=== SORTED BY DUE DATE ===");
        List<Task> sorted1l = manager.sortByDueDate();
        manager.printTasks(sorted);

        // === EDITED ===
        System.out.println("\n=== EDITED ===");
        boolean edited = manager.editTask(1, "Updated title", Task.Priority.HIGH, LocalDate.of(2025, 1, 10));
        System.out.println("Edit successful? " + edited);

        // === DELETED ===
        System.out.println("\n=== DELETED BY ID ===");
        boolean deleted = manager.deleteTask(2);
        System.out.println("Delete successful? " + deleted);

    }
}
