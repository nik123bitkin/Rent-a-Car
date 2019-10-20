package app.components;

import java.util.ArrayList;

public class UserCommand extends Command {
    private ArrayList<String> keys = new ArrayList<>(){
        {
            add("--add");
            add("--remove");
            add("--update");
            add("--list");
            add("--sort");
        }
    };
    @Override
    public boolean hasKey(String key) {
        return keys.contains(key);
    }

    @Override
    public int execute(String[] args) {
        return 0;
    }
}
