import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TaskTrackerTest {

    @Test
    void testAddUserAndShowTasks() {
        Main.TaskTracker tracker = new Main.TaskTracker();
        tracker.addUser("101");
        tracker.addTask("101", "Task1");
        tracker.addTask("101", "Task2");

        List<String> tasks = tracker.showTasks("101");
        assertEquals("1. Task1 [PENDING]", tasks.get(0));
        assertEquals("2. Task2 [PENDING]", tasks.get(1));
    }

    @Test
    void testCompleteTask() {
        Main.TaskTracker tracker = new Main.TaskTracker();
        tracker.addUser("102");
        tracker.addTask("102", "Task1");
        tracker.completeTask("102", "Task1");

        List<String> tasks = tracker.showTasks("102");
        assertEquals("1. Task1 [COMPLETED]", tasks.get(0));
    }

    @Test
    void testUserNotFound() {
        Main.TaskTracker tracker = new Main.TaskTracker();
        List<String> result = tracker.showTasks("999");
        assertEquals("USER NOT FOUND", result.get(0));
    }

    @Test
    void testTaskNotFound() {
        Main.TaskTracker tracker = new Main.TaskTracker();
        tracker.addUser("104");
        String result = tracker.completeTask("104", "TaskX");
        assertEquals("TASK NOT FOUND", result);
    }
}
