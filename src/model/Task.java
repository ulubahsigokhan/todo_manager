package model;

import java.time.LocalDate;

public class Task {

    private String title;
    private boolean completed;
    private Priority priority;
    private static int idCounter = 1;
    private int id;
    private LocalDate dueDate;

    // Constructor for new tasks (no ID passed in)
    public Task(String title, Priority priority, LocalDate dueDate) {
        this.id = idCounter++;
        this.title = title;
        this.priority = priority;
        this.completed = false;
        this.dueDate = dueDate;
    }

    // Constructor for loading from file (ID + completed flag)
    public Task(int id, String title, Priority priority, LocalDate dueDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.completed = completed;
        this.dueDate = dueDate;

        // Ensure the counter stays ahead of loaded IDs
        if (id >= idCounter) {
            idCounter = id + 1;
        }
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public void complete(boolean status) { this.completed = status; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public int getId() { return id; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public void toggleCompleted() {
        this.completed = !this.completed;
    }

    public String getStatusMessage() {
        return completed
                ? "✔ Task '" + title + "' is completed."
                : "✖ Task '" + title + "' is not completed.";
    }

    @Override
    public String toString() {
        return "Task ID: " + id +
                " | Task: " + title +
                " | Priority: " + priority +
                " | Completed: " + completed +
                " | Due Date: " + dueDate;
    }

    public enum Priority {
        LOW, MEDIUM, HIGH
    }
}
