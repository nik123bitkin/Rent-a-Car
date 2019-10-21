package entities;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * Entity of car that can be rented
 */
public class Car implements java.io.Serializable {
    private String model;
    private String make;
    private int id;
    private int ownerId;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car it = (Car)obj;
        return it.id == id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id + this.toString());
    }

    /**
     * @return string representation of object
     */
    @Override
    public String toString() {
        return MessageFormat.format(
                "Model: {0}  Make: {1}  Id: {2, number, integer}  OwnerId: {3, number, integer}",
                model, make, id, ownerId);
    }

    /**
     * Java bean default constructor
     * @deprecated
     */
    public Car(){
        this.model = "None";
        this.make = "None";
        this.id = -1;
        this.ownerId = -1;
    }

    /**
     * Constructs car object based on model and make.
     * @param model car model
     * @param make car make
     * @param id car id
     */
    public Car(String model, String make, int id) {
        this.model = model;
        this.make = make;
        this.id = id;
        this.ownerId = 0;
    }
}
