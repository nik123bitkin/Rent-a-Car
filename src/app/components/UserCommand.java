package app.components;

import entities.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class UserCommand extends Command {
    private ArrayList<String> keys = new ArrayList<String>(){
        {
            add("--add");
            add("--remove");
            add("--update");
            add("--list");
            add("--sort");
        }
    };

    private int add(String[] args){
        return args.length > 3 ? model.addUser(new User(args[2], args[3], -1)) : 1;
    }

    private int remove(String[] args){
        int id = -1;
        return args.length < 3 || (id = CommandWrapper.Utility.tryParseUnsignedInt(args[2])) > -1 ?
                model.removeUser(id) : 1;
    }

    private int update(String[] args){
        int id;
        if(args.length < 4 || (id = CommandWrapper.Utility.tryParseUnsignedInt(args[2])) == -1 || args.length > 5){
            return 1;
        }
        HashMap<String, String> values = new HashMap<>();
        for(int i = 3; i < args.length; i++){
            String[] temp = args[i].split("=");
            values.put(temp[0], temp[1]);
        }
        if(values.containsKey("ownership")
                && CommandWrapper.Utility.tryParseUnsignedInt(values.get("ownership")) == -1){
            return 1;
        }
        return model.updateUser(id, values);
    }

    private int list(){
        ArrayList<User> users = model.getUsers();
        StringBuilder message = new StringBuilder();
        for(User user: users){
            message.append(user.toString());
            message.append("\n");
        }
        CommandWrapper.DisplayMessage(message);
        return 0;
    }

    private int sort(String[] args){
        if(args.length < 3)
            return 1;
        Comparator<User> comparator = Comparator.comparingInt(User::getId);
        switch (args[2]) {
            case "name":
                comparator = Comparator.comparing(User::getName);
                break;
            case "surname":
                comparator = Comparator.comparing(User::getSurname);
                break;
            case "ownership":
                comparator = Comparator.comparingInt(User::getOwnership);
                break;
        }
        model.sortUsers(comparator);
        return 0;
    }

    @Override
    public boolean hasKey(String key) {
        return keys.contains(key);
    }

    @Override
    public int execute(String[] args) {
        return args[1].equals("--add") ? add(args):
                args[1].equals("--remove") ? remove(args):
                args[1].equals("--update") ? update(args):
                args[1].equals("--list") ? list():
                sort(args);
    }
}
