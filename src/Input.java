import org.apache.commons.cli.*;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by reegl on 30.09.2016.
 */

public class Input {
    private static final Logger log = Logger.getLogger(Input.class.getName());
    private String[] args = null;
    private Options options = new Options();
    private HashMap<String, String> hashMap = new HashMap<>();

    public Input(String[] args) {
        this.args = args;

        options.addOption("h", "help", false, "Show help.");
        options.addOption("l", "login", true, "Login.");
        options.addOption("p", "password", true, "Password.");

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

    private void help() {
        // This prints out some help
        HelpFormatter formater = new HelpFormatter();

        formater.printHelp("Main", options);
        System.exit(0);
    }
}
