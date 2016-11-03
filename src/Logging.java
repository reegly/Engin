import java.util.ArrayList;
import java.util.HashMap;


public class Logging {
    public void executeLogin(ArrayList<User> userList, ArrayList<Roles> roleList, HashMap<String, String> hashMap) {
        switch (hashMap.size()) {
            case 2: {
                if (authenticationCheck(hashMap)) {
                    authentication(userList, hashMap);
                } else {
                    printHelp();
                }
                break;
            }
            case 4: {
                if (authorizationCheck(hashMap)) {
                    authentication(userList, hashMap);
                    authorization(roleList, hashMap);
                } else {
                    printHelp();
                }
                break;
            }
            case 7: {
                if (accountingCheck(hashMap)) {
                    authentication(userList, hashMap);
                    authorization(roleList, hashMap);
                    //accounting
                } else {
                    printHelp();
                }
                break;
            }
            default: {
                printHelp();
                break;
            }
        }
        System.exit(0);
    }

    private void authentication(ArrayList<User> userList, HashMap<String, String> hashMap) {
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

        if (currentUser.getPassword().equals(Hash.makeHash(hashMap.get("pass")))) {
            System.out.println("Logged successfully.");
        } else {
            System.out.println("Wrong password!");
            System.exit(2);
        }
    }

    private void authorization(ArrayList<Roles> roleList, HashMap<String, String> hashMap) {
        Permissions parsedRole = null;
        Roles currentRole = null;
        boolean roleFound = false;

        switch (hashMap.get("role").toUpperCase()) {
            case "READ": {
                parsedRole = Permissions.READ;
                break;
            }
            case "WRITE": {
                parsedRole = Permissions.WRITE;
                break;
            }
            case "EXECUTE": {
                parsedRole = Permissions.EXECUTE;
                break;
            }
            default: {
                System.out.println(hashMap.get("role") + " is unknown role!");
                System.exit(3);
            }
        }

        for (Roles roles : roleList) {
            if (roles.getLogin().equals(hashMap.get("login")) && roles.getRole().equals(parsedRole)) {
                System.out.println("HOLY FUCK YOU HAVE " + parsedRole.toString() + " PERMISSION");
                //Проверка доступа...
                roleFound = true;
            }
        }
        if (!roleFound) {
            System.out.println("Access denied!");
            System.exit(4);
        }
    }

    private void printHelp() {
        System.out.println("Missing options");
        Input.help();
    }

    private static boolean authenticationCheck(HashMap<String, String> hashMap) {
        return hashMap.containsKey("login") && hashMap.containsKey("pass");
    }

    private static boolean authorizationCheck(HashMap<String, String> hashMap) {
        return hashMap.containsKey("role")
                && hashMap.containsKey("resource")
                && authenticationCheck(hashMap);
    }

    private static boolean accountingCheck(HashMap<String, String> hashMap) {
        return hashMap.containsKey("ds")
                && hashMap.containsKey("de")
                && hashMap.containsKey("vol")
                && authorizationCheck(hashMap);
    }
}
