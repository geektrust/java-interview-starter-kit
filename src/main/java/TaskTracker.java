import java.util.*;

public class Main {
    enum TaskStatus {
        PENDING, COMPLETED
    }

    static class Task {
        String description;
        TaskStatus status;

        Task(String description) {
            this.description = description;
            this.status = TaskStatus.PENDING;
        }
    }

    static class TaskTracker {
        private Map<String, List<Task>> userTasks = new HashMap<>();

        public void addUser(String userId) {
            userTasks.putIfAbsent(userId, new ArrayList<>());
        }

        public String addTask(String userId, String taskDescription) {
            if (!userTasks.containsKey(userId)) {
                return "USER NOT FOUND";
            }
            userTasks.get(userId).add(new Task(taskDescription));
            return "TASK ADDED";
        }

        public String completeTask(String userId, String taskDescription) {
            if (!userTasks.containsKey(userId)) {
                return "USER NOT FOUND";
            }
            for (Task task : userTasks.get(userId)) {
                if (task.description.equals(taskDescription)) {
                    task.status = TaskStatus.COMPLETED;
                    return "TASK COMPLETED";
                }
            }
            return "TASK NOT FOUND";
        }

        public List<String> showTasks(String userId) {
            if (!userTasks.containsKey(userId)) {
                return Arrays.asList("USER NOT FOUND");
            }
            List<Task> tasks = userTasks.get(userId);
            List<String> result = new ArrayList<>();
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                result.add((i + 1) + ". " + task.description + " [" + task.status + "]");
            }
            return result.isEmpty() ? Arrays.asList("NO TASKS") : result;
        }
    }

    // ---- CLI Handling ----
    public static void main(String[] args) {
        TaskTracker tracker = new TaskTracker();

        for (String cmdLine : args) {
            String[] parts = cmdLine.split(" ");
            String command = parts[0];

            switch (command) {
                case "ADD_USER":
                    tracker.addUser(parts[1]);
                    break;

                case "ADD_TASK":
                    System.out.println(tracker.addTask(parts[1], parts[2]));
                    break;

                case "COMPLETE_TASK":
                    System.out.println(tracker.completeTask(parts[1], parts[2]));
                    break;

                case "SHOW_TASKS":
                    tracker.showTasks(parts[1]).forEach(System.out::println);
                    break;
            }
        }
    }
}
