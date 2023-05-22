package by.fpmibsu.bystro_i_tochka.entity;

public class User {
    public User(String name, String login, String password, int id) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.id = id;
    }

    public User() {
        this.name = "";
        this.login = "";
        this.password = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    private String login;

    private String password;

    private int id;
}
