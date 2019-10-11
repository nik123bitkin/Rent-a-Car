package app;

import model.Model;

public class Controller {

    private Model model = new Model();

    public static void main(String[] args) {
        try {
            System.out.println("Hello world!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
