import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SearchStudent {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SchoolDatabase schoolDatabase = new SchoolDatabase();

        try {
            // Завантажуємо дані з файлу
            schoolDatabase.loadFromFile("src/students.txt");

            System.out.println("S [tudent]: <lastname>");
            System.out.println("S [tudent]: <lastname> B[us]");
            System.out.println("T [eacher]: <lastname>");
            System.out.println("C [lassroom]: <number>");
            System.out.println("B [us]: <number>");
            System.out.println("Q[uit] - для завершення");

            while (true) {
                System.out.print("> ");
                String command = scanner.nextLine().trim();

                // Перевірка на команду Quit
                if (command.equalsIgnoreCase("Q") || command.equalsIgnoreCase("Quit")) {
                    System.out.println("Завершення роботи програми.");
                    break;
                }

                long startTime = System.nanoTime(); // Початок часу пошуку

                String[] parts = command.split("\\s+"); // Розбиваємо команду через пробіл

                if (parts.length == 0) {
                    System.out.println("Невірний формат команди. Повторіть спробу.");
                    continue;
                }

                if (parts[0].equalsIgnoreCase("S")) {
                    // Пошук за прізвищем студента
                    if (parts.length == 2) {
                        String lastName = parts[1];
                        List<Student> students = schoolDatabase.findStudentsByLastName(lastName);
                        schoolDatabase.printStudentInfo(students);
                    } else if (parts.length == 3 && parts[2].equalsIgnoreCase("B")) {
                        String lastName = parts[1];
                        List<Student> students = schoolDatabase.findStudentsByLastName(lastName);
                        schoolDatabase.printStudentBusInfo(students);
                    } else {
                        System.out.println("Невірний формат команди для пошуку студента. Використовуйте: S <lastname> або S <lastname> B");
                    }
                } else if (parts[0].equalsIgnoreCase("T")) {
                    // Пошук за прізвищем викладача
                    if (parts.length == 2) {
                        String teacherLastName = parts[1];
                        List<Student> students = schoolDatabase.findStudentsByTeacher(teacherLastName);
                        schoolDatabase.printStudentInfo(students);
                    } else {
                        System.out.println("Невірний формат команди для пошуку викладача. Використовуйте: T <lastname>");
                    }
                } else if (parts[0].equalsIgnoreCase("C")) {
                    // Пошук за номером класу
                    if (parts.length == 2) {
                        try {
                            int classroom = Integer.parseInt(parts[1]);
                            List<Student> students = schoolDatabase.findStudentsByClassroom(classroom);
                            schoolDatabase.printStudentInfo(students);
                        } catch (NumberFormatException e) {
                            System.out.println("Номер класу має бути цілим числом.");
                        }
                    } else {
                        System.out.println("Невірний формат команди для пошуку класу. Використовуйте: C <number>");
                    }
                } else if (parts[0].equalsIgnoreCase("B")) {
                    // Пошук за номером автобуса
                    if (parts.length == 2) {
                        try {
                            int busNumber = Integer.parseInt(parts[1]);
                            List<Student> students = schoolDatabase.findStudentsByBus(busNumber);
                            schoolDatabase.printStudentBusInfo(students);
                        } catch (NumberFormatException e) {
                            System.out.println("Номер автобуса має бути цілим числом.");
                        }
                    } else {
                        System.out.println("Невірний формат команди для пошуку автобуса. Використовуйте: B <number>");
                    }
                } else {
                    System.out.println("Неправильна команда! Перевірте правильність вводу.");
                }

                long endTime = System.nanoTime(); // Кінець часу пошуку
                long duration = endTime - startTime; // Час виконання пошуку
                System.out.println("Час пошуку: " + duration / 1000000 + " мс\n"); // Виведення часу в мілісекундах
            }
        } catch (IOException e) {
            System.out.println("Помилка при завантаженні даних з файлу: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
