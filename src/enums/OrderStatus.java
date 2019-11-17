package enums;

public enum OrderStatus {
    PLACED(0),
    IN_PROGRESS(1),
    CANCELLED(2);

    private int status;

    public int getStatus() {
        return status;
    }

    OrderStatus(int status) {
        this.status = status;
    }
}
