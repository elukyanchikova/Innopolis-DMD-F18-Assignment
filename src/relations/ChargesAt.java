package relations;

public class ChargesAt {
    private int CarPlate;
    private int UID;
    private int TimeStart;
    private int TimeFinish;

    public int getCarPlate() {
        return CarPlate;
    }

    public void setCarPlate(int carPlate) {
        CarPlate = carPlate;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
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
