package CNPM2;

public class Main {
    public static void main(String[] args) {
        PersonalTaskManager manager = new PersonalTaskManager();

        System.out.println("\nTest thêm nhiệm vụ hợp lệ:");
        manager.addNewTask("Đi chợ", "Mua rau củ", "2025-07-23", "Trung bình", false);

        System.out.println("\nTest thêm nhiệm vụ trùng lặp:");
        manager.addNewTask("Đi chợ", "Mua rau củ", "2025-07-23", "Trung bình", false);

        System.out.println("\nTest thêm nhiệm vụ với tiêu đề rỗng:");
        manager.addNewTask("", "Không có tiêu đề", "2025-07-24", "Thấp", false);

        System.out.println("\nTest thêm nhiệm vụ với ngày sai định dạng:");
        manager.addNewTask("Sai ngày", "Ngày sai", "2025/07/25", "Cao", false);

        System.out.println("\nTest thêm nhiệm vụ với mức độ ưu tiên sai:");
        manager.addNewTask("Sai ưu tiên", "Ưu tiên không hợp lệ", "2025-07-26", "Khẩn cấp", false);
    }
}
