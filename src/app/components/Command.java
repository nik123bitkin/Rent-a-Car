package app.components;

import model.Model;

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
}
