package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class TaskManager {

    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void listTasks() {
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    public boolean removeTask(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                tasks.remove(t);
                return true;
            }
        }
        return false;
    }

    public List<Task> searchTasks(String keyword) {
        List<Task> results = new ArrayList<>();

        for (Task t : tasks) {
            if (t.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(t);
            }
        }
        return results;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public boolean markTaskCompleted(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setCompleted(true);
                return true;
            }
        }
        return false;
    }

    public List<Task> getCompletedTasks() {
        List<Task> completed = new ArrayList<>();
        for (Task t : tasks) {
            if (t.isCompleted()) {
                completed.add(t);
            }
        }
        return completed;
    }

    public List<Task> getActiveTasks() {
        List<Task> active = new ArrayList<>();
        for (Task t : tasks) {
            if (!t.isCompleted()) {
                active.add(t);
            }
        }
        return active;
    }

    public Task findById(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public Task findByTitle(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                return task;
            }
        }
        return null;
    }

    public List<Task> searchByKeyword(String keyword) {
        List<Task> results = new ArrayList<>();

        for (Task task : tasks) {
            if (task.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(task);
            }
        }
        return results;
    }

    public boolean updateTitle(int taskId, String newTitle) {
        for (Task t : tasks) {
            if (t.getId() == taskId) {
                t.setTitle(newTitle);
                return true;
            }
        }
        return false;
    }

    public boolean updatePriority(int taskId, Task.Priority newPriority) {
        for (Task t : tasks) {
            if (t.getId() == taskId) {
                t.setPriority(newPriority);
                return true;
            }
        }
        return false;
    }

    public void printAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (Task t : tasks) {
            if (t != null) {
                System.out.println(
                        "Task ID: " + t.getId() +
                                " | Task: " + t.getTitle() +
                                " | Priority: " + t.getPriority() +
                                " | Completed: " + t.isCompleted());
            }
        }
    }

    public List<Task> sortByDueDate() {
        return tasks.stream().filter(t -> t.getDueDate() != null)
                .sorted(Comparator.comparing(Task::getDueDate))
                .toList();
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


    public List<Task> filterByCompletion(boolean completed) {
        List<Task> results = new ArrayList<>();

        for (Task t : tasks) {
            if (t.isCompleted() == completed) {
                results.add(t);
            }
        }

        return results;
    }

    public void printTasks(List<Task> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (Task t : list) {
            System.out.println(t);
        }
    }

    public boolean editTask(int id, String newTitle, Task.Priority newPriority, LocalDate newDueDate) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTitle(newTitle);
                task.setPriority(newPriority);
                task.setDueDate(newDueDate);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTask(int id) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}



