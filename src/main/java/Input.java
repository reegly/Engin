import org.apache.commons.cli.*;
import java.util.logging.Level;
import java.util.logging.Logger;


class Input {
    private static final Logger log = Logger.getLogger(Input.class.getName());
    private Options options = new Options();

    public Input() {
        options.addOption("h", "help", false, "Show help.")
            .addOption("l", "login", true, "Login.")
            .addOption("p", "pass", true, "Password.")
            .addOption("res", "resource", true, "Resource.")
            .addOption("role", "role", true, "Role.")
            .addOption("ds", "start_date", true, "Start.")
            .addOption("de", "end_date", true, "End.")
            .addOption("vol", "volume_resource", true, "Resource.");
    }

    public UserData parse(String[] args) {
        CommandLineParser parser = new DefaultParser();
        UserData temp = new UserData();

        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("h")) {
                help();
            }
            if (cmd.hasOption("l")) {
                temp.setLogin(cmd.getOptionValue("l"));
            }
            if (cmd.hasOption("p")) {
                temp.setPassword(cmd.getOptionValue("p"));
            }
            if (cmd.hasOption("res")) {
                temp.setResource(cmd.getOptionValue("res"));
            }
            if (cmd.hasOption("role")) {
                temp.setRole(cmd.getOptionValue("role"));
            }
            if (cmd.hasOption("ds")) {
                temp.setStartDate(cmd.getOptionValue("ds"));
            }
            if (cmd.hasOption("de")) {
                temp.setEndDate(cmd.getOptionValue("de"));
            }
            if (cmd.hasOption("vol")) {
                temp.setVolumeResource(cmd.getOptionValue("vol"));
            }
        } catch (ParseException e) {
            log.log(Level.SEVERE, "Failed to parse command line properties", e);
            help();
        }
        if (temp.isEmpty()) {
            log.log(Level.SEVERE, "Missing options");
            help();
        }

        return temp;
    }

    public static void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Main", new Input().options);
        System.exit(0);
    }
}
