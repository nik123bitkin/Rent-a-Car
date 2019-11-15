package model;

import com.fasterxml.jackson.dataformat.xml.annotation.*;
import dboperator.DBOperator;
import entities.Car;
import entities.User;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

@JacksonXmlRootElement(localName = "model")
public class Model implements Serializable {
    @JacksonXmlElementWrapper(localName = "cars")
    @JacksonXmlProperty(localName = "car")
    private ArrayList<Car> cars;

    @JacksonXmlElementWrapper(localName = "users")
    @JacksonXmlProperty(localName = "user")
    private ArrayList<User> users;
    private DBOperator dbOperator = new DBOperator();

    /**
     * @return array list with users
     */
    public ArrayList<User> getUsers(){
        return users;
    }

    /**
     * @return array list with cars
     */
    public ArrayList<Car> getCars(){
        return cars;
    }

    /**
     * Adding new user to collection
     * @param user user to be added
     * @return 0 if successfully, 1 if database error occurred, 2 if such user exists, 3 if collection caused an error
     */
    public int addUser(User user){
        return !users.contains(user) ?
                (dbOperator.addUser(user) == 0 ?
                        (users.add(user) ? 0 : 3)
                        : 1)
                : 2;
    }

    /**
     * This method removes user
     * @param id id of user to be deleted
     * @return 0 if successfully, 1 if database error occurred, 3 if such user doesn't exist
     */
    public int removeUser(Integer id){
        return dbOperator.removeUser(id) == 0 ?
                (users.remove(new User("","",id)) ? 0 : 3)
                : 1;
    }

    /**
     * @param id id of user to be updated
     * @param values list of pairs field-value to be updated
     * @return 0 if successfully, 1 if database error occurred, 3 if collection caused an error
     */
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

    /**
     * This method sorts users by given comparator
     * @param comparator comparator to use for sorting
     */
    public void sortUsers(Comparator<User> comparator){
        users.sort(comparator);
    }

    /**
     * Adding new car to the collection
     * @param car car to be added
     * @return 0 if successfully, 1 if database error occurred, 2 if such user exists, 3 if collection caused an error
     */
    public int addCar(Car car){
        return !cars.contains(car) ?
                (dbOperator.addCar(car) == 0 ?
                        (cars.add(car) ? 0 : 3)
                        : 1)
                : 2;
    }

    /**
     * This method removes a car
     * @param id id of car to be removed
     * @return 0 if successfully, 1 if database error occurred, 3 if such car doesn't exist
     */
    public int removeCar(Integer id){
        return dbOperator.removeCar(id) == 0 ?
                (cars.remove(new Car("","",id)) ? 0 : 3)
                : 2;
    }

    /**
     * @param id id of car to be updated
     * @param values list of pairs field-value to be updated
     * @return 0 if successfully, 1 if database error occurred, 3 if collection caused an error
     */
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

    /**
     * This method sorts cars by given comparator
     * @param comparator comparator to use for sorting
     */
    public void sortCars(Comparator<Car> comparator){
        cars.sort(comparator);
    }

    /**
     * @return -1 if exit allowed, 4 if error occurred during data storing
     */
    public int clearResources(){
        try {
            dbOperator.serialize(this);
        }catch(Exception e){
            return 4;
        }
        return -1;
    }

    /**
     * @return object hash code
     */
    @Override
    public int hashCode() {
        return cars.hashCode() | users.hashCode()| dbOperator.hashCode();
    }

    /**
     * @param obj Object to compare
     * @return equality
     */
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

    /**
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "RentACar model" + this.hashCode();
    }

    /**
     * Constructor that creates an object and retrieves lists of users and cars from storage
     */
    public Model(){
    }

    public void Init(){
        try {
            Model m = dbOperator.deserializeModel();
            users = m.getUsers();
            cars = m.getCars();
        }catch(Exception ex){
            users = new ArrayList<>();
            cars = new ArrayList<>();
        };
    }
}
