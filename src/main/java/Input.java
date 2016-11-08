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
        options.addOption("p", "pass", true, "Password.");
        options.addOption("res", "resource", true, "Resource.");
        options.addOption("role", "role", true, "Role.");
        options.addOption("ds", "start_date", true, "Start.");
        options.addOption("de", "end_date", true, "End.");
        options.addOption("vol", "volume_resource", true, "Resource.");
    }

    public HashMap<String, String> parse() {
        CommandLineParser parser = new BasicParser();
        CommandLine cmd;

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

            if (cmd.hasOption("ds")) {
                hashMap.put("startDate", cmd.getOptionValue("ds"));
            }

            if (cmd.hasOption("de")) {
                hashMap.put("endDate", cmd.getOptionValue("de"));
            }

            if (cmd.hasOption("vol")) {
                hashMap.put("volumeResource", cmd.getOptionValue("vol"));
            }

        } catch (ParseException e) {
            log.log(Level.SEVERE, "Failed to parse command line properties", e);
            help();
        }

        if (hashMap.isEmpty()) {
            log.log(Level.SEVERE, "Missing options");
            help();
        }

        return hashMap;
    }

    public static void help() {
        HelpFormatter formatter = new HelpFormatter();

        formatter.printHelp("Main", options);
        System.exit(0);
    }
}
