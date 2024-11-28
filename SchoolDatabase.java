import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SchoolDatabase {
    private List<Student> students;

    public SchoolDatabase() {
        students = new ArrayList<>();
    }

    // Завантажуємо дані з файлу students.txt
    public void loadFromFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 7) {
                    String studentLastName = fields[0].trim();
                    String studentFirstName = fields[1].trim();
                    int grade = Integer.parseInt(fields[2].trim());
                    int classroom = Integer.parseInt(fields[3].trim());
                    int bus = Integer.parseInt(fields[4].trim());
                    String teacherLastName = fields[5].trim();
                    String teacherFirstName = fields[6].trim();

                    Student student = new Student(studentLastName, studentFirstName, grade, classroom, bus, teacherLastName, teacherFirstName);
                    students.add(student);
                }
            }
        }
    }

    // Пошук студентів за прізвищем
    public List<Student> findStudentsByLastName(String lastName) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                result.add(student);
            }
        }
        return result;
    }

    // Пошук студентів за викладачем
    public List<Student> findStudentsByTeacher(String teacherLastName) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getTeacherLastName().equalsIgnoreCase(teacherLastName)) {
                result.add(student);
            }
        }
        return result;
    }

    // Пошук студентів за класом
    public List<Student> findStudentsByClassroom(int classroom) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getClassroom() == classroom) {
                result.add(student);
            }
        }
        return result;
    }

    // Пошук студентів за автобусом
    public List<Student> findStudentsByBus(int busNumber) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getBus() == busNumber) {
                result.add(student);
            }
        }
        return result;
    }

    // Виведення інформації про студентів
    public void printStudentInfo(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Немає студентів за заданим критерієм.");
        } else {
            for (Student student : students) {
                System.out.println(STR."\{student.getFirstName()} \{student.getLastName()}, клас: \{student.getClassroom()}, викладач: \{student.getTeacherFirstName()} \{student.getTeacherLastName()}");
            }
        }
    }

    // Виведення інформації про автобуси студентів
    public void printStudentBusInfo(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Немає студентів за заданим критерієм.");
        } else {
            for (Student student : students) {
                System.out.println(STR."\{student.getFirstName()} \{student.getLastName()}, автобус: \{student.getBus()}");
            }
        }
    }
}
