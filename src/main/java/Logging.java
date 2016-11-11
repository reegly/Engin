import java.util.ArrayList;


public class Logging {
    public void executeLogin(ArrayList<Accounting> accountsList, ArrayList<User> userList, ArrayList<Roles> roleList, UserData userData) {
        switch (userData.size()) {
            case 2: {
                if (authenticationCheck(userData)) {
                    authentication(userList, userData);
                } else {
                    printHelp();
                }
                break;
            }
            case 4: {
                if (authorizationCheck(userData)) {
                    authentication(userList, userData);
                    authorization(roleList, userData);
                } else {
                    printHelp();
                }
                break;
            }
            case 7: {
                if (accountingCheck(userData)) {
                    authentication(userList, userData);
                    authorization(roleList, userData);
                    accounting(accountsList, userData);
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

    private void authentication(ArrayList<User> userList, UserData userData) {
        boolean userFound = false;
        User currentUser = null;

        for (User user : userList) {
            if (user.getLogin().equals(userData.getLogin())) {
                userFound = true;
                currentUser = user;
                System.out.println("You're trying to login as " + user.getName());
            }
        }
        if (!userFound) {
            System.out.println("User not found");
            System.exit(1);
        }

        if (currentUser.getPassword().equals(Hash.makeHash(userData.getPassword()))) {
            System.out.println("Logged successfully.");
        } else {
            System.out.println("Wrong password!");
            System.exit(2);
        }
    }

    private void authorization(ArrayList<Roles> roleList, UserData userData) {
        Permissions parsedRole = null;
        boolean roleFound = false;
        String userResource;

        switch (userData.getRole().toUpperCase()) {
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
                System.out.println(userData.getRole() + " is unknown role!");
                System.exit(3);
            }
        }

        for (Roles roles : roleList) {
            if (roles.getLogin().equals(userData.getLogin()) && roles.getRole().equals(parsedRole)) {
                userResource = roles.getResource();
                if (resourceCheck(userData, userResource)) {
                    System.out.println("Access granted!");
                    roleFound = true;
                }
            }
        }
        if (!roleFound) {
            System.out.println("Access denied!");
            System.exit(4);
        }
    }


    private void accounting(ArrayList<Accounting> accountList, UserData userData) {
        boolean valid = true;

        if (!Accounting.validTime(userData)) {
            System.out.println("Data has a wrong format!");
            valid = false;
        }
        if (!Accounting.validValue(userData)) {
            System.out.println("Value is incorrect!");
            valid = false;
        }
        if (!valid) {
            System.out.println("Invalid activity!");
            System.exit(5);
        }

        Accounting acc = new Accounting(userData);
        accountList.add(acc);
    }

    private void printHelp() {
        System.out.println("Missing options");
        Input.help();
    }

    private static boolean authenticationCheck(UserData userData) {
        return (userData.getLogin() != null) && (userData.getPassword() != null);
    }

    private static boolean authorizationCheck(UserData userData) {
        return (userData.getResource() != null)
                && (userData.getRole() != null)
                && (authenticationCheck(userData));
    }

    private static boolean accountingCheck(UserData userData) {
        return (userData.getStartDate() != null)
                && (userData.getEndDate() != null)
                && (userData.getVolumeResource() != null)
                && authorizationCheck(userData);
    }

    private boolean resourceCheck(UserData userData, String userResource) {
        String parsedRes[] = userData.getResource().split("\\.");
        String currentRes[] = userResource.split("\\.");
        if (parsedRes.length < currentRes.length) {
            return false;
        } else {
            for (int i = 0; i < currentRes.length; i++) {
                if (!parsedRes[i].equals(currentRes[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
