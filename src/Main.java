import model.Task;

public class Main {
    public static void main(String[] args) {
        Task t1 = new Task("Learn Java", Task.Priority.HIGH);
        System.out.println(t1.getStatusMessage());

        t1.setCompleted(true);
        System.out.println(t1.getStatusMessage());
    }
}
