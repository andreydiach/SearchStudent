public class Student {
    private String lastName;
    private String firstName;
    private int grade;
    private int classroom;
    private int bus;
    private String teacherLastName;
    private String teacherFirstName;

    // Конструктор
    public Student(String lastName, String firstName, int grade, int classroom, int bus, String teacherLastName, String teacherFirstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.grade = grade;
        this.classroom = classroom;
        this.bus = bus;
        this.teacherLastName = teacherLastName;
        this.teacherFirstName = teacherFirstName;
    }

    // Геттери
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getGrade() {
        return grade;
    }

    public int getClassroom() {
        return classroom;
    }

    public int getBus() {
        return bus;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }
}
