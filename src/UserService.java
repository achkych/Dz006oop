import java.util.ArrayList;
import java.util.List;

public class UserService implements DataService {

    private final List<User> userList;

    public UserService() {
        userList = new ArrayList<>();
    }
    // Принцип единственной ответственности (SRP): класс отвечает за операции создания студентов и преподавателей
    @Override
    public void create(String name, String surname, String patron, Type type) {
        int id = getFreeId(type);
        if (Type.STUDENT == type) {
            Student student = new Student(name, surname, patron, id);
            userList.add(student);
        }
        if (Type.TEACHER == type) {
            Teacher teacher = new Teacher(name, surname, patron, id);
            userList.add(teacher);
        }
    }

    private int getFreeId(Type type) {
        int lastId = 0;
        boolean isStudent = Type.STUDENT == type;
        for (User user : userList) {
            if (user instanceof Teacher && !isStudent) {
                lastId++;
            }
            if (user instanceof Student && isStudent) {
                lastId++;
            }
        }
        return ++lastId;
    }

    @Override
    public List<User> read() {
        return userList;
    }

    // Принцип единственной ответственности (SRP): класс отвечает за операцию получения всех студентов
    @Override
    public List<User> readOnlyStudent() {
        List<User> students = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Student) {
                students.add(user);
            }
        }
        return students;
    }
    // Принцип единственной ответственности (SRP): класс отвечает за операцию фильтрации студентов по фамилии
    public List<User> filterStudentsBySurname(String surname) {
        List<User> filteredStudents = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Student) {
                Student student = (Student) user;
                if (student.getSurname().equalsIgnoreCase(surname)) {
                    filteredStudents.add(student);
                }
            }
        }
        return filteredStudents;
    }
}
