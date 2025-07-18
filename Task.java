package CNPM;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import org.json.simple.JSONObject;

public class Task {

    public static JSONObject createTask(String title, String description, LocalDate dueDate, String priorityLevel, boolean isRecurring) {
        String taskId = UUID.randomUUID().toString();
        JSONObject newTask = new JSONObject();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        newTask.put("id", taskId);
        newTask.put("title", title);
        newTask.put("description", description);
        newTask.put("due_date", dueDate.format(formatter));
        newTask.put("priority", priorityLevel);
        newTask.put("status", "Chưa hoàn thành");
        newTask.put("created_at", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        newTask.put("last_updated_at", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        newTask.put("is_recurring", isRecurring);

        if (isRecurring) {
            newTask.put("recurrence_pattern", "Chưa xác định");
        }

        return newTask;
    }
}