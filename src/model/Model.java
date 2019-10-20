package model;

import dboperator.DBOperator;
import entities.Car;
import entities.User;

import java.util.ArrayList;

public class Model {
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private DBOperator dbOperator = new DBOperator();

    //TODO: maybe int instead of bool to handle position of error? or throwing exceptions(ugly)
    public boolean addUser(User user){
        return !users.contains(user) && (dbOperator.addUser(user) && users.add(user));
    }

    public boolean removeUser(User user){
        return dbOperator.removeUser(user) && users.remove(user);
    }

    public boolean updateUser(User user){
        return true;
    }

    public boolean addCar(Car car){
        return !cars.contains(car) && (dbOperator.addCar(car) && cars.add(car));
    }

    public boolean removeCar(Car car){
        return dbOperator.removeCar(car) && cars.remove(car);
    }

    public boolean updateCar(Car car){
        return true;
    }

    @Override
    public int hashCode() {
        return cars.hashCode() | users.hashCode()| dbOperator.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "RentACar model" + this.hashCode();
    }

    public Model(){}
}
