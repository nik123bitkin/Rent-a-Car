package app.components;

import model.Model;

/**
 * Base class for all commands, holds model as static field to provide access for all children.
 */
public abstract class Command implements ICommand {
    protected static Model model = new Model();
    @Override
    public boolean hasKey(String key) {
        return false;
    }

    @Override
    public int execute(String[] args) {
        return 0;
    }

    public Command(){
        model.Init();
    }
}
