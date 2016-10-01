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
        User user1 = new User(1, "John Doe", "jdoe", "sup3rpaZZ");

    }
}
