package entities;

import enums.OrderStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order extends Entity implements Serializable {
    private int userId;
    private int carId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private OrderStatus status;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Order(){
        userId = 0;
        carId = 0;
        try {
            startDate = LocalDateTime.of(2000, 1, 1, 0, 0);
            endDate = LocalDateTime.of(2000, 1, 2, 0, 0);
        }catch (Exception ignored){}
        status = OrderStatus.PLACED;
    }

    public Order(int userId, int carId, LocalDateTime startDate, LocalDateTime endDate, OrderStatus status){
        this.userId = userId;
        this.carId = carId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
}
