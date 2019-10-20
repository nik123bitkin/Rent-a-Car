package app.components;

public interface ICommand {
    boolean hasKey(String key);
    int execute(String[] args);
}
