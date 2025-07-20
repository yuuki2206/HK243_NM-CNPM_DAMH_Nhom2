package CNPM2;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PersonalTaskManager {

    public JSONObject addNewTask(String title, String description, String dueDateStr, String priorityLevel, boolean isRecurring) {

        if (!TaskValidator.validateTitle(title)) {
            System.out.println("Lỗi: Tiêu đề không được để trống.");
            return null;
        }

        LocalDate dueDate;
        try {
            dueDate = TaskValidator.validateDueDate(dueDateStr);
        } catch (DateTimeParseException e) {
            System.out.println("Lỗi: Ngày đến hạn không hợp lệ. Vui lòng sử dụng định dạng YYYY-MM-DD.");
            return null;
        }

        if (!TaskValidator.validatePriority(priorityLevel)) {
            System.out.println("Lỗi: Mức độ ưu tiên không hợp lệ. Vui lòng chọn từ: Thấp, Trung bình, Cao.");
            return null;
        }

        JSONArray tasks = TaskDatabase.loadTasks();

        if (TaskDuplicateChecker.isDuplicate(tasks, title, dueDate)) {
            System.out.println(String.format("Lỗi: Nhiệm vụ '%s' đã tồn tại với cùng ngày đến hạn.", title));
            return null;
        }

        JSONObject newTask = Task.createTask(title, description, dueDate, priorityLevel, isRecurring);

        tasks.add(newTask);
        TaskDatabase.saveTasks(tasks);

        System.out.println(String.format("Đã thêm nhiệm vụ mới thành công với ID: %s", newTask.get("id")));
        return newTask;
    }
}
