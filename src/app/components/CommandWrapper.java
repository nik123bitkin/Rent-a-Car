package app.components;

import java.util.Map;

public class CommandWrapper{
    private final UserCommand userCommand = new UserCommand();
    private final CarCommand carCommand = new CarCommand();
    private final HelpCommand helpCommand = new HelpCommand();
    private final Map<String, ICommand> commands = Map.of(
            "user", userCommand,
            "car", carCommand,
            "help", helpCommand);

    public boolean hasCommand(String command){
        return commands.containsKey(command);
    }

    public boolean hasKey(String command, String key){
        return commands.get(command).hasKey(key);
    }

    public int execute(String[] args) {
        return commands.get(args[0]).execute(args);
    }

    public CommandWrapper(){}
}
