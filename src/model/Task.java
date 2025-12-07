package model;

public class Task {

    private String title;
    private boolean completed;

    public Task(String title) {
        this.title = title;
        this.completed = false; // default when new task created
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
        return "Task: " + title + ", Completed: " + completed;
    }
}
