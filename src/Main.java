import java.util.HashMap;

/**
 * Created by reegl on 24.09.2016.
 */
public class Main {

    Permissions r = new Permissions("READ", 1);
    Permissions w = new Permissions("WRITE", 2);
    Permissions e = new Permissions("EXECUTE", 3);
    Permissions rw = new Permissions("READ_WRITE", 4);
    Permissions re = new Permissions("READ_EXECUTE", 5);
    Permissions we = new Permissions("WRITE_EXECUTE", 6);
    Permissions rwe = new Permissions("READ_WRITE_EXECUTE", 7);



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
