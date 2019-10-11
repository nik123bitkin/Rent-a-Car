package entities; //TODO: maybe base entity? reasons...

import java.text.MessageFormat;
import java.util.Objects;

public class Car {
    public String model; // No properties, get/set not necessary bcz of direct access
    public String make;
    public int id;
    public int ownerId = 0; //TODO: default parameter??

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "Model: {0}  Make: {1}  Id: {2, number, integer}  OwnerId: {3, number, integer}",
                model, make, id, ownerId);
    }

    public Car(String model, String make, int id) {
        this.model = model;
        this.make = make;
        this.id = id;
    }
}
