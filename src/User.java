
// Принцип подстановки Барбары Лисков (LSP): класс Student и Teacher являются подклассами класса User

public abstract class User {
    String name;
    String surname;
    String patron;

    public User() {
    }

    public User(String name, String surname, String patron) {
        this.name = name;
        this.surname = surname;
        this.patron = patron;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }
}
