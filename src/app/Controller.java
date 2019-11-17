package app;

import entities.Car;
import entities.Order;
import entities.User;
import model.Model;
import services.DBOperator;
import services.XmlParser;

public class Controller {



    public static void main(String[] args) {
        XmlParser xmlParser = new XmlParser();
        Model model = null;//new Model();
//        model.users.add(new User("N", "B", 1));
//        model.cars.add(new Car("bmv", "x5", 1));
//        model.orders.add(new Order());
//        xmlParser.serialize(model);

        if(xmlParser.validate()) {
            model = xmlParser.loadModel();
            DBOperator dbOperator = new DBOperator();
            if(dbOperator.connect()){
                dbOperator.migrate(model);
            }
            System.out.println("Success");
        }else{
            System.out.println("Error");
        }
    }
}
