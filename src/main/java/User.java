import java.security.NoSuchAlgorithmException;

public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private String salt;

    User(int id, String name, String login, String password) throws NoSuchAlgorithmException {
        this.id = id;
        this.name = name;
        this.login = login;
        this.salt = Hash.makeSalt();
        this.password = Hash.getHash(Hash.getHash(password) + salt);
    }

    public String getSalt() { return salt; }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
