package relations;

public class Serves {
    private int CarPlate;
    private int OrderID;
    private int TimeStart;
    private int TimeFinish;

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

    public int getCarPlate() {
        return CarPlate;
    }

    public void setCarPlate(int carPlate) {
        CarPlate = carPlate;
    }
}
