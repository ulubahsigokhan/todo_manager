import model.Task;

public class Main {
    public static void main(String[] args) {
        Task task = new Task("Learn Java");
        System.out.println(task);

        task.setCompleted(true);

        System.out.println("Is task done? " + task.isCompleted());
        System.out.println(task);
    }
}
