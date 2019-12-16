package main.core.parsers;

import main.core.entities.Car;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class CarSaxHandler extends DefaultHandler {
    private static final String CARS    = "cars";
    private static final String CAR     = "car";
    private static final String MODEL   = "model";
    private static final String MAKE    = "make";

    private String elementValue;
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue = new String(ch, start, length);
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case CARS:
                cars = new ArrayList<>();
                break;
            case CAR:
                var car = new Car();
                car.setId(Integer.parseInt(attr.getValue(0)));
                cars.add(car);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case MODEL:
                cars.get(cars.size() - 1).setModel(elementValue);
                break;
            case MAKE:
                cars.get(cars.size() - 1).setMake(elementValue);
                break;
        }
    }
}
