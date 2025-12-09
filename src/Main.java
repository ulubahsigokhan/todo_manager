import model.Task;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Task task = new Task("Learn Java", Task.Priority.HIGH);
        Task t1 = new Task("Practice Git", Task.Priority.MEDIUM);
        Task t2 = new Task("Test automation study", Task.Priority.LOW);

        // NOW create the list
        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(task);
        tasks.add(t1);
        tasks.add(t2);

        System.out.println("Total tasks stored: " + tasks.size());

        for (Task t : tasks) {
            System.out.println("ID: " + t.getId() + " | Title: " + t.getStatusMessage());
        }
    }
}
