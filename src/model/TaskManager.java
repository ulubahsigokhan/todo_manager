package model;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;

public class TaskManager {

    private final List<Task> tasks = new ArrayList<>();

    // -------------------------
    // BASIC OPERATIONS
    // -------------------------

    public void addTask(Task task) {
        tasks.add(task);
    }

    public boolean deleteTask(int id) {
        return tasks.removeIf(t -> t.getId() == id);
    }

    public Task findById(int id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // -------------------------
    // UPDATE OPERATIONS
    // -------------------------

    public boolean toggleCompleted(int id) {
        Task task = findById(id);
        if (task == null) return false;

        task.toggleCompleted();
        System.out.println("Task " + id + " is now " +
                (task.isCompleted() ? "COMPLETED" : "ACTIVE"));
        return true;
    }

    public boolean editTask(int id, String newTitle,
                            Task.Priority newPriority,
                            LocalDate newDueDate) {

        Task task = findById(id);
        if (task == null) return false;

        task.setTitle(newTitle);
        task.setPriority(newPriority);
        task.setDueDate(newDueDate);
        return true;
    }

    // -------------------------
    // SEARCH & FILTER
    // -------------------------

    public List<Task> search(String keyword) {
        String lower = keyword.toLowerCase();
        List<Task> results = new ArrayList<>();

        for (Task t : tasks) {
            if (t.getTitle().toLowerCase().contains(lower)) {
                results.add(t);
            }
        }
        return results;
    }

    public List<Task> filterByPriority(Task.Priority priority) {
        List<Task> results = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getPriority() == priority) {
                results.add(t);
            }
        }
        return results;
    }

    public List<Task> getCompletedTasks() {
        List<Task> out = new ArrayList<>();
        for (Task t : tasks) if (t.isCompleted()) out.add(t);
        return out;
    }

    public List<Task> getActiveTasks() {
        List<Task> out = new ArrayList<>();
        for (Task t : tasks) if (!t.isCompleted()) out.add(t);
        return out;
    }

    public List<Task> sortByDueDate() {
        return tasks.stream()
                .filter(t -> t.getDueDate() != null)
                .sorted(Comparator.comparing(Task::getDueDate))
                .toList();
    }

    // -------------------------
    // PRINT HELPERS
    // -------------------------

    public void print(List<Task> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        list.forEach(System.out::println);
    }

    public void printAll() {
        print(tasks);
    }

    // -------------------------
    // SAVE / LOAD
    // -------------------------

    public void saveToFile(String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            for (Task t : tasks) {
                out.println(
                        t.getId() + "|" +
                                t.getTitle() + "|" +
                                t.getPriority() + "|" +
                                t.isCompleted() + "|" +
                                (t.getDueDate() == null ? "null" : t.getDueDate())
                );
            }
            System.out.println("Tasks saved to " + filename);
        } catch (Exception e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (Scanner file = new Scanner(new java.io.File(filename))) {

            tasks.clear();

            while (file.hasNextLine()) {
                String[] parts = file.nextLine().split("\\|");

                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                Task.Priority priority = Task.Priority.valueOf(parts[2]);
                boolean completed = Boolean.parseBoolean(parts[3]);

                LocalDate dueDate = parts[4].equals("null")
                        ? null
                        : LocalDate.parse(parts[4]);

                tasks.add(new Task(id, title, priority, dueDate, completed));
            }

            System.out.println("Tasks loaded from " + filename);

        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }

    // -------------------------
    // CONSOLE INPUT (OPTIONAL)
    // -------------------------

    public void addTaskFromConsole(Scanner scanner) {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter priority (LOW, MEDIUM, HIGH): ");
        Task.Priority priority;
        try {
            priority = Task.Priority.valueOf(scanner.nextLine().trim().toUpperCase());
        } catch (Exception e) {
            System.out.println("Invalid priority, defaulting to LOW.");
            priority = Task.Priority.LOW;
        }

        System.out.print("Enter due date (YYYY-MM-DD or leave blank): ");
        String dateInput = scanner.nextLine();
        LocalDate dueDate = null;

        if (!dateInput.isBlank()) {
            try {
                dueDate = LocalDate.parse(dateInput);
            } catch (Exception e) {
                System.out.println("Invalid date. Setting due date = null.");
            }
        }

        addTask(new Task(title, priority, dueDate));
        System.out.println("Task added successfully!");
    }

    public List<Task> getTasks() {
        return tasks;
    }
}



