import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by reegl on 07.10.2016.
 */
public class Logging {
    public void authorisation (ArrayList<User> userList, HashMap<String, String> hashMap) {
        boolean userFound = false;
        User currentUser = null;

        for (User user : userList) {
            if (user.getLogin().equals(hashMap.get("login"))) {
                userFound = true;
                currentUser = user;
                System.out.println("You're trying to login as " + user.getName());
            }
        }
        if (!userFound) {
            System.out.println("User not found");
            System.exit(1);
        }

        if (currentUser.getPassword().equals(hashMap.get("pass"))) {
            System.out.println("Logged successfully.");
            System.exit(0);
        } else {
            System.out.println("Wrong password!");
            System.exit(2);
        }
    }
}
