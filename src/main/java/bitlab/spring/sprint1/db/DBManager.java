package bitlab.spring.sprint1.db;

import bitlab.spring.sprint1.entity.Student;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Student> students = new ArrayList<>();
    private static Long id = 5L;
    static {
        students.add(new Student(1L, "Madi", "Abdrakhmanov", 100, "A"));
        students.add(new Student(2L, "Amir", "Gaisin", 87, "B"));
        students.add(new Student(3L, "Tair", "Dimbayev", 71, "C"));
        students.add(new Student(4L, "Dimash", "Baratov", 49, "F"));
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void addStudent(String name, String surname, int exam) {
        if (!StringUtils.isEmpty(name) || !StringUtils.isEmpty(surname)) {

            String mark;
            if (exam < 50) {
                mark = "F";
            } else if (exam < 60) {
                mark = "D";
            } else if (exam < 75) {
                mark = "C";
            } else if (exam < 90) {
                mark = "B";
            } else {
                mark = "A";
            }

            Student student = new Student(id++, name, surname, exam, mark);
            students.add(student);
        }
    }

}
