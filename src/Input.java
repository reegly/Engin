import org.apache.commons.cli.*;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Input {
    private static final Logger log = Logger.getLogger(Input.class.getName());
    private String[] args = null;
    private static Options options = new Options();
    private HashMap<String, String> hashMap = new HashMap<>();

    public Input(String[] args) {
        this.args = args;

        options.addOption("h", "help", false, "Show help.");
        options.addOption("l", "login", true, "Login.");
        options.addOption("p", "password", true, "Password.");
        options.addOption("res", "resource", true, "Resource.");
        options.addOption("role", "role", true, "Role.");
    }

    public HashMap<String, String> parse() {
        CommandLineParser parser = new BasicParser();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);

            if (cmd.hasOption("h")) {
                help();
            }
            if (cmd.hasOption("l")) {
                hashMap.put("login", cmd.getOptionValue("l"));
            }
            if (cmd.hasOption("p")) {
                hashMap.put("pass", cmd.getOptionValue("p"));
            }
            if (cmd.hasOption("res")) {
                hashMap.put("resource", cmd.getOptionValue("res"));
            }
            if (cmd.hasOption("role")) {
                hashMap.put("role", cmd.getOptionValue("role"));
            }

        } catch (ParseException e) {
            log.log(Level.SEVERE, "Failed to parse command line properties", e);
            help();
        }

        if(hashMap.isEmpty()) {
            log.log(Level.SEVERE, "Missing options");
            help();
        }

        return hashMap;
    }

    public static void help() {
        // This prints out some help
        HelpFormatter formatter = new HelpFormatter();

        formatter.printHelp("Main", options);
        System.exit(0);
    }
}
