package dboperator;

import entities.Car;
import entities.User;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DBOperator {
    private final String usersPath = "C:\\Files\\Projects\\users.xml";
    private final String carsPath = "C:\\Files\\Projects\\cars.xml";
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

    public void serialize(ArrayList<User> users, ArrayList<Car> cars) throws IOException {//TODO: remove exception
        try(FileOutputStream fos = new FileOutputStream(usersPath);
            XMLEncoder encoder = new XMLEncoder(fos)) {
            encoder.setExceptionListener(e -> System.out.println("Exception! :" + e.toString()));
            encoder.writeObject(users);
            encoder.writeObject(cars);
        }
    }

    public Object[] deserializeUsers() throws IOException {
        try(FileInputStream fis = new FileInputStream(usersPath);
            XMLDecoder decoder = new XMLDecoder(fis)){
            decoder.setExceptionListener(e -> System.out.println("Exception! :" + e.toString()));
            Object us = decoder.readObject();
            Object cr = decoder.readObject();
            ArrayList<User> users = us instanceof ArrayList ? (ArrayList<User>)us : null;
            ArrayList<Car> cars = cr instanceof ArrayList ? (ArrayList<Car>)cr : null;
            return new Object[]{users, cars};
        }
    }

    public DBOperator() {}
}
