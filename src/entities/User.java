package entities;

import java.text.MessageFormat;
import java.util.Objects;

public class User {
    public String name;
    public String surname;
    public int id;
    public int ownedId = 0; //TODO: default parameter?

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "Name: {0}  Surname: {1}  Id: {2, number, integer}  OwnedId: {3, number, integer}",
                name, surname, id, ownedId);
    }

    public User(String model, String make, int id) {
        this.name = model;
        this.surname = make;
        this.id = id;
    }
}
