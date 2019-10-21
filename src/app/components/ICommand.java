package app.components;

/**
 * Basic command interface with two main methods
 */
public interface ICommand {
    boolean hasKey(String key);
    int execute(String[] args);
}
