package CNPM2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Lớp POJO (Plain Old Java Object) biểu diễn một đối tượng Task.
 * - Sử dụng Enum cho Priority và Status để đảm bảo an toàn kiểu dữ liệu.
 * - Tách biệt constructor cho việc tạo mới và tái tạo từ dữ liệu.
 */
public class Task {

    // Enum cho Mức độ ưu tiên
    public enum Priority {
        LOW("Thấp"),
        MEDIUM("Trung bình"),
        HIGH("Cao");

        private final String displayName;
        Priority(String displayName) { this.displayName = displayName; }
        public String getDisplayName() { return displayName; }
    }

    // Enum cho Trạng thái
    public enum Status {
        PENDING("Chưa hoàn thành"),
        COMPLETED("Đã hoàn thành");

        private final String displayName;
        Status(String displayName) { this.displayName = displayName; }
        public String getDisplayName() { return displayName; }
    }

    private String id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Priority priority;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;

    /**
     * Constructor để TẠO MỚI một task.
     * Tự động tạo ID, gán trạng thái và thời gian mặc định.
     */
    public Task(String title, String description, LocalDate dueDate, Priority priority) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = Status.PENDING; // Mặc định là "Chưa hoàn thành"
        this.createdAt = LocalDateTime.now();
        this.lastUpdatedAt = LocalDateTime.now();
    }

    /**
     * Constructor để TÁI TẠO một task từ dữ liệu đã có (ví dụ: từ file).
     * Nhận đầy đủ các tham số để khôi phục đối tượng một cách chính xác.
     */
    public Task(String id, String title, String description, LocalDate dueDate, Priority priority, Status status, LocalDateTime createdAt, LocalDateTime lastUpdatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    // --- Getters và Setters ---

    public String getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) {
        this.status = status;
        this.lastUpdatedAt = LocalDateTime.now();
    }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getLastUpdatedAt() { return lastUpdatedAt; }

    @Override
    public String toString() {
        return String.format("Task[id=%s, title='%s', dueDate=%s, priority=%s, status=%s]",
                id.substring(0, 8), title, dueDate, priority.getDisplayName(), status.getDisplayName());
    }
}