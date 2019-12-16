package main.core.servlet;

import main.core.model.Model;

import javax.servlet.http.HttpServletRequest;

public class Command {
    static private final String mainUrl = "index.jsp";
    static private final String usersUrl = "/pages/users.jsp";
    static private final String carsUrl = "/pages/cars.jsp";
    static private final String ordersUrl = "/pages/orders.jsp";

    static private Model model = new Model();
    static private int page;
    static private int capacity;
    static private int internalCount;
    static private String url;
    static private String currentPage;

    static public String execute(HttpServletRequest request, String target){
        page = Integer.valueOf(request.getParameter("page"));
        capacity = Integer.valueOf(request.getParameter("capacity"));
        switch(target){
            case "users":
                executeUser(request);
                break;
            case "cars":
                executeCars(request);
                break;
            case "orders":
                executeOrders(request);
                break;
            case "index":
                url = mainUrl;
                break;
        }
        currentPage = target;
        int count = internalCount / capacity + (internalCount % capacity);

        request.setAttribute("count", count);
        request.setAttribute("page", page);
        request.setAttribute("capacity", capacity);
        request.setAttribute("currentPage", currentPage);

        return url;
    }

    static private void executeUser(HttpServletRequest request){
        var users = model.getUsers();
        internalCount = users.size();
        request.setAttribute("users",
                users.subList((page - 1) * capacity,
                        page * capacity >= internalCount ? internalCount : page * capacity));
        url = usersUrl;
    }

    static private void executeCars(HttpServletRequest request){
        var cars = model.getCars();
        internalCount = cars.size();
        request.setAttribute("cars",
                cars.subList((page - 1) * capacity,
                        page * capacity >= internalCount ? internalCount : page * capacity));
        url = carsUrl;
    }

    static private void executeOrders(HttpServletRequest request){
        var orders = model.getOrders();
        internalCount = orders.size();
        request.setAttribute("orders",
                orders.subList((page - 1) * capacity,
                        page * capacity >= internalCount ? internalCount : page * capacity));
        url = ordersUrl;
    }
}
