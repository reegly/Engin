import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws Throwable {
        for (String i : args) {
            System.out.print(i + " ");
        }
        System.out.println("");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User(1, "John Doe", "jdoe", "sup3rpaZZ"));
        userList.add(new User(2, "Jane Row", "jrow", "Qweqrty12"));

        ArrayList<Roles> roleList = new ArrayList<>();
        roleList.add(new Roles(1, "jdoe", Permissions.READ, "a"));
        roleList.add(new Roles(1, "jdoe", Permissions.WRITE, "a.b"));
        roleList.add(new Roles(1, "jrow", Permissions.EXECUTE, "a.b.c"));
        roleList.add(new Roles(1, "jdoe", Permissions.EXECUTE, "a.bc"));

        ArrayList<Accounting> accList = new ArrayList<>();

        Input input = new Input();
        UserData userData = input.parse(args);

        Logging logging = new Logging();
        logging.executeLogin(accList, userList, roleList, userData);
    }
}
