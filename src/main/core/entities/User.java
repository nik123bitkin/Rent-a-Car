package main.core.entities;

import java.text.MessageFormat;
import java.util.Objects;

public class User extends Entity implements java.io.Serializable {
    private String name;
    private String surname;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User it = (User) obj;
        return it.id == id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id + this.toString());
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "Name: {0}  Surname: {1}  Id: {2, number, integer}",
                name, surname, id);
    }

    public User() {
        this.name = "None";
        this.surname = "None";
        this.id = -1;
    }

    public User(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }
}
