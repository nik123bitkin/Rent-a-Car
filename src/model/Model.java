package model;

import com.fasterxml.jackson.dataformat.xml.annotation.*;
import services.XmlParser;
import entities.Car;
import entities.Order;
import entities.User;

import java.io.Serializable;
import java.util.ArrayList;

@JacksonXmlRootElement(localName = "model")
public class Model implements Serializable {
    @JacksonXmlElementWrapper(localName = "cars")
    @JacksonXmlProperty(localName = "car")
    public ArrayList<Car> cars = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "users")
    @JacksonXmlProperty(localName = "user")
    public ArrayList<User> users = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "orders")
    @JacksonXmlProperty(localName = "order")
    public ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<User> getUsers(){
        return users;
    }

    public ArrayList<Car> getCars(){
        return cars;
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }

    public Model(){
    }
}
