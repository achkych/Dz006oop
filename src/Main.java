import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        // Создание студента
        controller.createStudent("John", "Doe", "Smith");

        // Получение всех студентов
        System.out.println("All Students:");
        controller.getAllStudents();

        // Фильтрация студентов по фамилии
        System.out.println("Filtered Students:");
        controller.filterStudentsBySurname("Doe");
    }
}