package dboperator;

import entities.Car;
import entities.User;

public class DBOperator {
    //private String connectionString;

    public boolean addUser(User user){ //update user id as side effect
        return true;
    }

    public boolean removeUser(User user){
        return true;
    }

    public boolean updateUser(User user){
        return true;
    }

    public boolean addCar(Car car){ //update car id as side effect
        return true;
    }

    public boolean removeCar(Car car){
        return true;
    }

    public boolean updateCar(Car car){
        return true;
    }

    public DBOperator() {}
}
