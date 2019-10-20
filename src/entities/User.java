package entities;

import java.text.MessageFormat;
import java.util.Objects;

public class User {
    private String name;
    private String surname;
    private int id;
    private int ownership;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnership() {
        return ownership;
    }

    public void setOwnership(int ownership) {
        this.ownership = ownership;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User it = (User)obj;
        return it.id == id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id + this.toString());
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "Name: {0}  Surname: {1}  Id: {2, number, integer}  OwnedId: {3, number, integer}",
                name, surname, id, ownership);
    }

    public User(){
        this.name = "None";
        this.surname = "None";
        this.id = -1;
        this.ownership = -1;
    }

    public User(String model, String make, int id) {
        this.name = model;
        this.surname = make;
        this.id = id;
        this.ownership = 0;
    }
}
