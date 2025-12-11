import model.Task;
import model.TaskManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {

            System.out.println("\n=== TASK MANAGER ===");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Show All Tasks");
            System.out.println("4. Filter by Priority");
            System.out.println("5. Sort by Due Date");
            System.out.println("6. Edit Task");
            System.out.println("7. Toggle Completed");
            System.out.println("8. Search by Keyword");
            System.out.println("9. Show Completed Tasks");
            System.out.println("10. Show Active Tasks");
            System.out.println("11. Save to File");
            System.out.println("12. Load from File");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear leftover newline

            switch (choice) {

                case 1:
                    manager.addTaskFromConsole(scanner);
                    break;

                case 2:
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    if (!manager.deleteTask(deleteId)) {
                        System.out.println("Task not found!");
                    }
                    break;

                case 3:
                    manager.printAll();
                    break;

                case 4:
                    System.out.print("Enter priority (LOW, MEDIUM, HIGH): ");
                    String pStr = scanner.nextLine().trim().toUpperCase();
                    try {
                        Task.Priority p = Task.Priority.valueOf(pStr);
                        List<Task> filtered = manager.filterByPriority(p);
                        manager.print(filtered);
                    } catch (Exception e) {
                        System.out.println("Invalid priority!");
                    }
                    break;

                case 5:
                    List<Task> sorted = manager.sortByDueDate();
                    manager.print(sorted);
                    break;

                case 6:
                    System.out.print("Enter task ID to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("New title: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("New priority (LOW, MEDIUM, HIGH): ");
                    Task.Priority newPriority;
                    try {
                        newPriority = Task.Priority.valueOf(scanner.nextLine().trim().toUpperCase());
                    } catch (Exception e) {
                        System.out.println("Invalid priority. Edit cancelled.");
                        break;
                    }

                    System.out.print("New due date (YYYY-MM-DD or blank): ");
                    String dd = scanner.nextLine();
                    LocalDate newDueDate = null;
                    if (!dd.isBlank()) {
                        try {
                            newDueDate = LocalDate.parse(dd);
                        } catch (Exception e) {
                            System.out.println("Invalid date. Setting null.");
                        }
                    }

                    if (!manager.editTask(editId, newTitle, newPriority, newDueDate)) {
                        System.out.println("Task not found!");
                    }
                    break;

                case 7:
                    System.out.print("Enter task ID to toggle: ");
                    int tid = scanner.nextInt();
                    scanner.nextLine();
                    if (!manager.toggleCompleted(tid)) {
                        System.out.println("Task not found!");
                    }
                    break;

                case 8:
                    System.out.print("Enter keyword: ");
                    String keyword = scanner.nextLine();
                    List<Task> results = manager.search(keyword);
                    manager.print(results);
                    break;

                case 9:
                    manager.print(manager.getCompletedTasks());
                    break;

                case 10:
                    manager.print(manager.getActiveTasks());
                    break;

                case 11:
                    System.out.print("File name: ");
                    String sf = scanner.nextLine();
                    manager.saveToFile(sf);
                    break;

                case 12:
                    System.out.print("File name: ");
                    String lf = scanner.nextLine();
                    manager.loadFromFile(lf);
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
