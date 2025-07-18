package CNPM2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 1. Khởi tạo các thành phần
        TaskRepository repository = new TaskRepository();
        TaskService service = new TaskService(repository);

        System.out.println("--- Bắt đầu Quản lý Task ---");
        // Dọn dẹp file db cũ để chạy demo từ đầu
     // Trong Main.java
        repository.saveAll(new ArrayList<>()); // Ghi một danh sách rỗng để xóa sạch file


        // 2. THÊM CÁC TASK MỚI
        System.out.println("\n 2. THÊM TASK ");
        Task task1 = null, task2 = null, task3 = null;
        try {
            task1 = service.addTask("Học về Refactoring", "Đọc sách Clean Code.", "2025-08-01", Task.Priority.HIGH);
            System.out.println("Thêm thành công: " + task1);
            task2 = service.addTask("Làm bài tập lớn CNPM", "Hoàn thành phần thiết kế.", "2025-08-15", Task.Priority.HIGH);
            System.out.println("Thêm thành công: " + task2);
            task3 = service.addTask("Đi siêu thị", "Mua sữa và bánh mì.", "2025-07-28", Task.Priority.MEDIUM);
            System.out.println("Thêm thành công: " + task3);

            System.out.println("\nThử thêm task trùng lặp...");
            service.addTask("Học về Refactoring", "Mô tả khác", "2025-08-01", Task.Priority.LOW);

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // 3. HIỂN THỊ TẤT CẢ TASK
        System.out.println("\n 3. DANH SÁCH TASK HIỆN TẠI ");
        repository.findAll().forEach(System.out::println);

        // 4. CẬP NHẬT TRẠNG THÁI CỦA MỘT TASK
        System.out.println("\n 4. CẬP NHẬT TASK ");
        if (task1 != null) {
            try {
                System.out.println("Cập nhật trạng thái cho task '" + task1.getTitle() + "'...");
                service.updateTaskStatus(task1.getId(), Task.Status.COMPLETED);
                System.out.println("Cập nhật thành công!");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        
        System.out.println("\n DANH SÁCH TASK SAU KHI CẬP NHẬT ");
        repository.findAll().forEach(System.out::println);

        // 5. TÌM KIẾM TASK THEO ĐỘ ƯU TIÊN
        System.out.println("\n 5. TÌM KIẾM TASK ƯU TIÊN CAO ");
        List<Task> highPriorityTasks = service.findTasksByPriority(Task.Priority.HIGH);
        System.out.println("Tìm thấy " + highPriorityTasks.size() + " task có độ ưu tiên cao:");
        highPriorityTasks.forEach(System.out::println);
        

        // 6. XÓA MỘT TASK
        System.out.println("\n 6. XÓA TASK ");
        if (task3 != null) {
            try {
                System.out.println("Xóa task '" + task3.getTitle() + "'...");
                service.deleteTask(task3.getId());
                System.out.println("Xóa thành công!");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

        System.out.println("\n DANH SÁCH TASK CUỐI CÙNG ");
        repository.findAll().forEach(System.out::println);
    }
}