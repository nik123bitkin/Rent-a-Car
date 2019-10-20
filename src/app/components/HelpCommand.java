package app.components;

import java.util.ArrayList;

public class HelpCommand extends Command{
    private ArrayList<String> keys = new ArrayList<>(){
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
        System.out.println("Help executed");
        return 0;
    }
}
