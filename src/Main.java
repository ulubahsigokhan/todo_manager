import model.Task;
import model.TaskManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        manager.addTask(new Task("Buy Groceries", Task.Priority.HIGH));
        manager.addTask(new Task("Go to Gym", Task.Priority.MEDIUM));
        manager.addTask(new Task("Call Mom", Task.Priority.LOW));

        manager.markTaskCompleted(2); // mark gym as completed

        System.out.println("Completed:");
        for (Task t : manager.getCompletedTasks()) {
            System.out.println(t);
        }

        System.out.println("Active:");
        for (Task t : manager.getActiveTasks()) {
            System.out.println(t);
        }


    }
}
