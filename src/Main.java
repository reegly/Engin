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

        User user1 = new User(1, "John Doe", "jdoe", "sup3rpaZZ");
        Input input = new Input(args);
        HashMap<String, String> hashMap = input.parse(user1);

        if (user1.getLogin().equals(hashMap.get("login"))) {
            if (user1.getPassword().equals(hashMap.get("pass"))) {
                System.out.println("Logged successfully.");
                System.exit(0);
            } else {
                System.out.println("Wrong password!");
                System.exit(2);
            }
        } else {
            System.out.println("Wrong login!");
            System.exit(1);
        }
    }
}
