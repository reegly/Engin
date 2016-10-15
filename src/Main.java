import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by reegl on 24.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
        System.out.println("");

        ArrayList<User> userList = new ArrayList<>();
        User user1 = new User(1, "John Doe", "jdoe", "sup3rpaZZ");
        userList.add(user1);
        User user2 = new User(2, "Jane Row", "jrow", "Qweqrty12");
        userList.add(user2);

        Input input = new Input(args);
        HashMap<String, String> hashMap = input.parse();

        Logging logging = new Logging();
        logging.authorisation(userList, hashMap);
    }
}
