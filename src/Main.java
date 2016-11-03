import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        for (String i : args) {
            System.out.print(i + " ");
        }
        System.out.println("");

        ArrayList<User> userList = new ArrayList<>();
        User user1 = new User(1, "John Doe", "jdoe", "sup3rpaZZ");              userList.add(user1);
        User user2 = new User(2, "Jane Row", "jrow", "Qweqrty12");              userList.add(user2);

        ArrayList<Roles> roleList = new ArrayList<>();
        Roles role1 = new Roles(1, "jdoe", Permissions.READ, "a");              roleList.add(role1);
        Roles role2 = new Roles(1, "jdoe", Permissions.WRITE, "a.b");           roleList.add(role2);
        Roles role3 = new Roles(1, "jrow", Permissions.EXECUTE, "a.b.c");       roleList.add(role3);
        Roles role4 = new Roles(1, "jdoe", Permissions.EXECUTE, "a.bc");        roleList.add(role4);

        Input input = new Input(args);
        HashMap<String, String> hashMap = input.parse();

        //System.out.println("Time of session: " + Time.sestime(hashMap) + " days");

        Logging logging = new Logging();
        logging.executeLogin(userList, roleList, hashMap);


    }
}
