package relations;

public class Serves {
    private String CarPlate;
    private int OrderID;
    private int TimeStart;
    private int TimeFinish;

    public Serves(String carPlate, int orderID, int timeStart, int timeFinish) {
        CarPlate = carPlate;
        OrderID = orderID;
        TimeStart = timeStart;
        TimeFinish = timeFinish;
    }

    public int getTimeFinish() {
        return TimeFinish;
    }

    public void setTimeFinish(int timeFinish) {
        TimeFinish = timeFinish;
    }

    public int getTimeStart() {
        return TimeStart;
    }

    public void setTimeStart(int timeStart) {
        TimeStart = timeStart;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public String getCarPlate() {
        return CarPlate;
    }

    public void setCarPlate(String carPlate) {
        CarPlate = carPlate;
    }
}
