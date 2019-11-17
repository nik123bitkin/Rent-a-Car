package entities;

import java.text.MessageFormat;
import java.util.Objects;

public class Car extends Entity implements java.io.Serializable {
    private String model;
    private String make;

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

    @Override
    public String toString() {
        return MessageFormat.format(
                "Model: {0}  Make: {1}  Id: {2, number, integer}",
                model, make, id);
    }

    public Car(){
        this.model = "None";
        this.make = "None";
        this.id = -1;
    }

    public Car(String model, String make, int id) {
        this.model = model;
        this.make = make;
        this.id = id;
    }
}
