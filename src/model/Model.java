package model;

import dboperator.DBOperator;
import entities.Car;
import entities.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Model {
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private DBOperator dbOperator = new DBOperator();

    public ArrayList<User> getUsers(){
        return users;
    }

    public ArrayList<Car> getCars(){
        return cars;
    }

    public int addUser(User user){
        return !users.contains(user) ?
                (dbOperator.addUser(user) == 0 ?
                        (users.add(user) ? 0 : 3)
                        : 1)
                : 2;
    }

    public int removeUser(Integer id){
        return dbOperator.removeUser(id) == 0 ?
                (users.remove(new User("","",id)) ? 0 : 3)
                : 2;
    }

    public int updateUser(int id, HashMap<String, String> values){
        int i = users.indexOf(new User("", "", id));
        User user = users.get(i);
        if(values.containsKey("name")){
            user.setName(values.get("name"));
        }
        if(values.containsKey("surname")){
            user.setSurname(values.get("surname"));
        }
        if(values.containsKey("ownership")){
            if(user.getOwnership() == 0) {
                user.setOwnership(Integer.parseUnsignedInt(values.get("ownership")));
            }else{
                return 3;
            }
        }
        return 0;
    }

    public void sortUsers(Comparator<User> comparator){
        users.sort(comparator);
    }

    public int addCar(Car car){
        return !cars.contains(car) ?
                (dbOperator.addCar(car) == 0 ?
                        (cars.add(car) ? 0 : 3)
                        : 1)
                : 2;
    }

    public int removeCar(Integer id){
        return dbOperator.removeCar(id) == 0 ?
                (cars.remove(new Car("","",id)) ? 0 : 3)
                : 2;
    }

    public int updateCar(int id, HashMap<String, String> values){
        int i = cars.indexOf(new Car("", "", id));
        Car car = cars.get(i);
        if(values.containsKey("model")){
            car.setModel(values.get("model"));
        }
        if(values.containsKey("make")){
            car.setMake(values.get("make"));
        }
        if(values.containsKey("ownerId")){
            if(car.getOwnerId() == 0) {
                car.setOwnerId(Integer.parseUnsignedInt(values.get("ownerId")));
            }else{
                return 3;
            }
        }
        return 0;
    }

    public void sortCars(Comparator<Car> comparator){
        cars.sort(comparator);
    }

    public int clearResources(){
        return 0;
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
