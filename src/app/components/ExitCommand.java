package app.components;

import java.util.ArrayList;

public class ExitCommand extends Command {
    private ArrayList<String> keys = new ArrayList<>(){
        {
            add("--all");
        }
    };

    @Override
    public boolean hasKey(String key) {
        return keys.contains(key);
    }

    @Override
    public int execute(String[] args) {
        return model.clearResources();
    }
}
