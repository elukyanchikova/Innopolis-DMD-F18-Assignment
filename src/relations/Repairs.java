package relations;

public class Repairs {
    private int CarPlate;
    private int WID;
    private int TimeStart;
    private int TimeFinish;

    public int getCarPlate() {
        return CarPlate;
    }

    public void setCarPlate(int carPlate) {
        CarPlate = carPlate;
    }

    public int getWID() {
        return WID;
    }

    public void setWID(int WID) {
        this.WID = WID;
    }

    public int getTimeStart() {
        return TimeStart;
    }

    public void setTimeStart(int timeStart) {
        TimeStart = timeStart;
    }

    public int getTimeFinish() {
        return TimeFinish;
    }

    public void setTimeFinish(int timeFinish) {
        TimeFinish = timeFinish;
    }
}
