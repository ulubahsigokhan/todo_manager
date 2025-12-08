package model;

public class Task {

    private String title;
    private boolean completed;
    private Priority priority;
    private static int idCounter = 1;
    private int id;

    public Task(String title, Priority priority) {
        this.title = title;
        this.priority = priority;
        this.completed = false;
        this.id = idCounter++;// default when new task created
    }

    public void complete(boolean status) {
        this.completed = status;
    }

    public boolean isCompleted(){
        return completed;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task ID: " + id +
                " | Task: " + title +
                " | Priority: " + priority +
                " | Completed: " + completed;
    }

    public void toggleCompleted() {
        this.completed = !this.completed;
    }

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getStatusMessage() {
        if (completed) {
            return "✔ Task '" + title + "' is completed.";
        } else {
            return "✖ Task '" + title + "' is not completed.";
        }
    }
}
