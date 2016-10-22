public class Roles {
    private int id;
    private String login;
    private Permissions role;
    private String resource;

    Roles (int id, String login, Permissions role, String resource) {
        this.id = id;
        this.login = login;
        this.role = role;
        this.resource = resource;
    }

    public String getLogin() { return login; }

    public Permissions getRole() { return role; }

    public String getResource() { return resource; }
}
