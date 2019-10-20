package app;

import entities.Car;
import model.Model;

public class Controller {

    private static Model model = new Model();

    public static void main(String[] args) {
        Car car = new Car("bmw", "x5", 1);
        System.out.println(car);
        boolean isadded = model.addCar(car);
        System.out.println(car);
        try {
            System.out.println("Hello world!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
