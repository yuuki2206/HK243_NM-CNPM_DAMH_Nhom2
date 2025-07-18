package CNPM;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TaskValidator {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static boolean validateTitle(String title) {
        return title != null && !title.trim().isEmpty();
    }

    public static LocalDate validateDueDate(String dueDateStr) throws DateTimeParseException {
        return LocalDate.parse(dueDateStr, DATE_FORMATTER);
    }

    public static boolean validatePriority(String priority) {
        String[] validPriorities = {"Thấp", "Trung bình", "Cao"};
        for (String p : validPriorities) {
            if (p.equals(priority)) return true;
        }
        return false;
    }
}