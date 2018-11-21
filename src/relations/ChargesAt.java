package relations;

public class ChargesAt {
    private String CarPlate;
    private int UID;
    private int TimeStart;
    private int TimeFinish;

    public ChargesAt(String carPlate, int UID, int timeStart, int timeFinish) {
        CarPlate = carPlate;
        this.UID = UID;
        TimeStart = timeStart;
        TimeFinish = timeFinish;
    }

    public String getCarPlate() {
        return CarPlate;
    }

    public void setCarPlate(String carPlate) {
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
