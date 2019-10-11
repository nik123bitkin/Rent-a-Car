package app;

import entities.Car;
import model.Model;

public class Controller {

    private Model model = new Model();

    public static void main(String[] args) {
        Car c = new Car("bmw", "x5", 1);
        System.out.println(c);
        try {
            System.out.println("Hello world!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
