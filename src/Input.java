import org.apache.commons.cli.*;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by reegl on 30.09.2016.
 */

public class Input {
    private static final Logger log = Logger.getLogger(Input.class.getName());
    private String[] args = null;
    private Options options = new Options();

    public Input(String[] args) {

        this.args = args;

        options.addOption("h", "help", false, "Show help.");
        options.addOption("l", "login", true, "Login.");
        options.addOption("p", "password", true, "Password.");

    }

    public void parse() {
        CommandLineParser parser = new BasicParser();

        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);

            if (cmd.hasOption("h"))
                help();

            if (cmd.hasOption("l")) {
                System.out.println("You trying to login as " + args[0]);
                // Whatever you want to do with the setting goes here
            } else {
                log.log(Level.SEVERE, "Missing option");
                help();
            }

        } catch (ParseException e) {
            log.log(Level.SEVERE, "Failed to parse command line properties", e);
            help();
        }
    }

    private void help() {
        // This prints out some help
        HelpFormatter formater = new HelpFormatter();

        formater.printHelp("Main", options);
        System.exit(0);
    }
}
