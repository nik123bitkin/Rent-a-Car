package app.components;

import java.util.ArrayList;

public class HelpCommand extends Command {
    private ArrayList<String> keys = new ArrayList<>() {
        {
            add("--car");
            add("--user");
            add("--exit");
        }
    };

    @Override
    public boolean hasKey(String key) {
        return keys.contains(key);
    }

    @Override
    public int execute(String[] args) {
        switch (args[1]) {
            case "--car":
                CommandWrapper.DisplayMessage(
                        new StringBuilder(
                                "user: \n\t--add <model> <make> - add new car" +
                                        "\n\t--remove <id> - remove car by id, use --list to get id" +
                                        "\n\t--update <id> [key=value] - update fields by id" +
                                        "\n\t--list - list all cars" +
                                        "\n\t--sort <key> - sort by key(any field you want)"
                        ));
                break;
            case "--user":
                CommandWrapper.DisplayMessage(
                        new StringBuilder(
                                "user: \n\t--add <name> <surname> - add new user" +
                                        "\n\t--remove <id> - remove user by id, use --list to get id" +
                                        "\n\t--update <id> [key=value] - update fields by id" +
                                        "\n\t--list - list all users" +
                                        "\n\t--sort <key> - sort by key(any field you want)"
                        ));
                break;
            case "--exit":
                CommandWrapper.DisplayMessage(
                        new StringBuilder(
                                "exit:\n\t --all - close program and clear resources"
                        ));
                break;
        }
        return 0;
    }
}
