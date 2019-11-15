package app.components;

import java.util.ArrayList;

public class ExitCommand extends Command {
    private ArrayList<String> keys = new ArrayList<String>(){
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
        int result =  model.clearResources();
        if(result == 4){
            CommandWrapper.DisplayMessage(new StringBuilder("File error occured during serialization"));
        }
        return -1;
    }
}
