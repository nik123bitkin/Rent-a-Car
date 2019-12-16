package main.core.entities;

import main.core.enums.OrderStatus;

import java.io.Serializable;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Order it = (Order) obj;
        return it.id == id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id + this.toString());
    }

    @Override
    public String toString() {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        var startDateTime = startDate.format(formatter);
        var endDateTime = endDate.format(formatter);
        return MessageFormat.format(
                "UserId: {0, number, integer}  CarId: {1, number, integer} startTime: {2} " +
                        "endTime: {3} status: {4}  Id: {5, number, integer}",
                userId, carId, startDateTime, endDateTime, status.toString(), id);
    }

    public Order() {
        userId = 0;
        carId = 0;
        try {
            startDate = LocalDateTime.of(2000, 1, 1, 0, 0);
            endDate = LocalDateTime.of(2000, 1, 2, 0, 0);
        } catch (Exception ignored) {
        }
        status = OrderStatus.PLACED;
    }

    public Order(int userId, int carId, LocalDateTime startDate, LocalDateTime endDate, OrderStatus status) {
        this.userId = userId;
        this.carId = carId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
}
