package model;

import java.util.ArrayList;
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
        for (Task t : tasks){
            if (t.getId() == id){
                tasks.remove(t);
                return true;
            }
        }
        return false;
    }

    public List<Task> searchTasks(String keyword) {
        List<Task> results = new ArrayList<>();

        for (Task t : tasks) {
            if (t.getTitle().toLowerCase().contains(keyword.toLowerCase())){
                results.add(t);
            }
        }
        return results;
    }
    public List<Task> getTasks() {
        return tasks;
    }
}
