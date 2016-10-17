/**
 * Created by reegl on 29.09.2016.
 */
public class User {
    private int id;
    private String name;
    private String login;
    private String password;

    User(int id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = Hash.makeHash(password);
    }

    public String getLogin() { return login; }

    public String getPassword() { return password; }

    public String getName() { return name; }
}
