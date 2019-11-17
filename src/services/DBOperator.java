package services;

import entities.Car;
import entities.Order;
import entities.User;
import model.Model;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import com.mysql.jdbc.Driver;

import static java.util.logging.Level.ALL;
import static java.util.logging.Level.SEVERE;


public class DBOperator {
    private static final String PATH = "jdbc:mysql://localhost:3306/rent?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "123321";
    private final String LOG_SOURCE = "/home/beetoss/Projects/Lab2/xml_source/log" + LocalDateTime.now() + ".txt";

    private static final String INSERT_USER_QUERY = "INSERT INTO users (id, name, surname) VALUES (?, ?, ?)";
    private static final String INSERT_CAR_QUERY = "INSERT INTO cars (id, model, make) VALUES (?, ?, ?)";
    private static final String INSERT_ORDER_QUERY =
            "INSERT INTO orders (id, userId, carId, startDate, endDate, status) VALUES (?, ?, ?, ?, ?, ?)";

    private final Logger logger = Logger.getLogger(DBOperator.class.getName());

    private Connection connection = null;

    public boolean connect(){
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(PATH, USER, PASSWORD);
            logger.info("Connection to " + PATH + " successful");
            return true;
        } catch (SQLException e) {
            logger.log(SEVERE, "Connection to " + PATH + " failed " + e);
            return false;
        }
    }

    public void migrate(Model model){
        migrateCars(model.getCars());
        migrateUsers(model.getUsers());
        migrateOrders(model.getOrders());
    }

    private void migrateUsers(ArrayList<User> users){
        int count = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_QUERY)) {
            for (User user : users) {
                preparedStatement.setInt(1, user.getId());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getSurname());
                preparedStatement.executeUpdate();
                count++;
            }
        } catch (SQLException ex) {
            logger.log(SEVERE, "SQL exception occured" + ex.getMessage());
        }
        logger.info("Migrated " + count + " users of " + users.size());
    }

    private void migrateCars(ArrayList<Car> cars){
        int count = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CAR_QUERY)) {
            for (Car car : cars) {
                preparedStatement.setInt(1, car.getId());
                preparedStatement.setString(2, car.getModel());
                preparedStatement.setString(3, car.getMake());
                preparedStatement.executeUpdate();
                count++;
            }
        } catch (SQLException ex) {
            logger.log(SEVERE, "SQL exception occured" + ex.getMessage());
        }
        logger.info("Migrated " + count + " cars of " + cars.size());
    }

    private void migrateOrders(ArrayList<Order> orders){
        int count = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_QUERY)) {
            for (Order order : orders) {
                preparedStatement.setInt(1, order.getId());
                preparedStatement.setInt(2, order.getUserId());
                preparedStatement.setInt(3, order.getCarId());
                preparedStatement.setDate(4, Date.valueOf(order.getStartDate().toLocalDate()));
                preparedStatement.setDate(5, Date.valueOf(order.getEndDate().toLocalDate()));
                preparedStatement.setString(6, order.getStatus().toString());
                preparedStatement.executeUpdate();
                count++;
            }
        } catch (SQLException ex) {
            logger.log(SEVERE, "SQL exception occured" + ex.getMessage());
        }
        logger.info("Migrated " + count + " orders of " + orders.size());
    }

    public DBOperator(){
        try {
            FileHandler fileHandler = new FileHandler(LOG_SOURCE);
            fileHandler.setLevel(ALL);
            logger.addHandler(fileHandler);
        }catch(IOException e){
            logger.addHandler(new ConsoleHandler());
        }
        logger.setLevel(ALL);
    }
}
