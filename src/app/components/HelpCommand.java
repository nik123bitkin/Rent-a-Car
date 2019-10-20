package app.components;

import java.util.ArrayList;

public class HelpCommand extends Command{
    private ArrayList<String> keys = new ArrayList<>(){
        {
            add("--all");
            add("--car");
            add("--user");
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
