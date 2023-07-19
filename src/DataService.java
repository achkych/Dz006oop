import java.util.List;

public interface DataService {
    void create(String name, String surname, String patron, Type type);

    List<User> read();

    List<User> readOnlyStudent();
}
