package dboperator;

import entities.Car;
import entities.User;

public class DBOperator {
    //private String connectionString;
    private int currentUserID = 1;
    private int currentCarID = 1;

    public int addUser(User user){ //update user id as side effect
        user.setId(currentUserID);
        currentUserID++;
        return 0;
    }

    public int removeUser(Integer id){
        return 0;
    }

    public int updateUser(User user){
        return 0;
    }

    public int addCar(Car car){ //update car id as side effect
        car.setId(currentCarID);
        currentCarID++;
        return 0;
    }

    public int removeCar(Integer id){
        return 0;
    }

    public int updateCar(Car car){
        return 0;
    }

    public DBOperator() {}
}
