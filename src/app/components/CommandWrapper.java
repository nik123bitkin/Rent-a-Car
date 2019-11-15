package app.components;

import java.util.HashMap;
import java.util.Map;

/**
 * Class-wpapper for system of commands that redirects control to command specified by used
 */
public class CommandWrapper{
    private final UserCommand userCommand = new UserCommand();
    private final CarCommand carCommand = new CarCommand();
    private final HelpCommand helpCommand = new HelpCommand();
    private final ExitCommand exitCommand = new ExitCommand();
    private Map<String, ICommand> commands;

    /**
     * Method tests the availability of command
     * @param command first word entered by user
     * @return true, if such command name available, false otherwise
     */
    public boolean hasCommand(String command){
        return commands.containsKey(command);
    }

    /**
     * Method tests the availability of command
     * @param command first word entered by user
     * @param key second word entered by user
     * @return true, if specified command has such key available
     */
    public boolean hasKey(String command, String key){
        return commands.get(command).hasKey(key);
    }

    /**
     * This method gives control to specified command and returns result of execution
     * @param args command, key and additional arguments
     * @return command result
     */
    public int execute(String[] args) {
        return commands.get(args[0]).execute(args);
    }

    /**
     * This is the auxiliary tool for displaying console messages
     * @param message any string message
     */
    static void DisplayMessage(StringBuilder message){
        System.out.println(message);
    }

    /**
     * Creates an instance of CommandWrapper class
     */
    public CommandWrapper(){
        commands = new HashMap<>();
        commands.put("user", userCommand);
        commands.put("car", carCommand);
        commands.put("help", helpCommand);
        commands.put("exit", exitCommand);
    }

    /**
     * Class of additional auxiliary tools
     */
    static class Utility{
        /**
         * Method implements try-parse logic for unsigned integer
         * @param string string representation
         * @return number, if string is correct, -1 otherwise
         */
        static int tryParseUnsignedInt(String string){
            try {
                return Integer.parseUnsignedInt(string);
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }
}
