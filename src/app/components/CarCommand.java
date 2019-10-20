package app.components;

import entities.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class CarCommand extends Command {
    private ArrayList<String> keys = new ArrayList<>(){
        {
            add("--add");
            add("--remove");
            add("--update");
            add("--list");
            add("--sort");
        }
    };

    private int add(String[] args){
        return args.length > 3 ? model.addCar(new Car(args[2], args[3], -1)) : 1;
    }

    private int remove(String[] args){
        int id = -1;
        return args.length < 3 || (id = CommandWrapper.Utility.tryParseUnsignedInt(args[2])) > -1 ?
                model.removeCar(id) : 1;
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
        if(values.containsKey("ownerId")
                && CommandWrapper.Utility.tryParseUnsignedInt(values.get("ownerId")) == -1){
            return 1;
        }
        return model.updateCar(id, values);
    }

    private int list(){
        ArrayList<Car> cars = model.getCars();
        StringBuilder message = new StringBuilder();
        for(var car: cars){
            message.append(car.toString());
            message.append("\n");
        }
        CommandWrapper.DisplayMessage(message);
        return 0;
    }

    private int sort(String[] args){
        if(args.length < 3)
            return 1;
        Comparator<Car> comparator = Comparator.comparingInt(Car::getId);
        switch (args[2]) {
            case "model":
                comparator = Comparator.comparing(Car::getModel);
                break;
            case "make":
                comparator = Comparator.comparing(Car::getMake);
                break;
            case "ownerId":
                comparator = Comparator.comparingInt(Car::getOwnerId);
                break;
        }
        model.sortCars(comparator);
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
