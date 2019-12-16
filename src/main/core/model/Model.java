package main.core.model;

import main.core.entities.Car;
import main.core.entities.Order;
import main.core.entities.User;
import main.core.parsers.CarSaxHandler;
import main.core.parsers.OrderDomParser;
import main.core.parsers.StaxParser;
import main.core.parsers.domroutines.OrderDomRoutine;
import main.core.parsers.staxroutines.UserRoutine;

import javax.xml.parsers.SAXParserFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Model implements Serializable {
    private static final String source = "C:\\Files\\Projects\\Java\\Lab3_Final\\src\\main\\core\\xml\\model.xml";

    public List<Car> cars = new ArrayList<>();

    public List<User> users = new ArrayList<>();

    public List<Order> orders = new ArrayList<>();

    public List<User> getUsers(){
        return users;
    }

    public List<Car> getCars(){
        return cars;
    }

    public List<Order> getOrders(){
        return orders;
    }

    private void initialize(){
        var staxParser = new StaxParser<User>();
        users = staxParser.parseFile(source, new UserRoutine());
        try {
            var factory = SAXParserFactory.newInstance();
            var saxParser = factory.newSAXParser();
            var carSaxHandler = new CarSaxHandler();
            saxParser.parse(source, carSaxHandler);
            cars = carSaxHandler.getCars();
        } catch (Exception ignored) {
        }

        var domParser = new OrderDomParser<Order>();
        orders = domParser.getDataFromFile(source, new OrderDomRoutine("order"));
    }

    public Model(){
        initialize();
    }
}
