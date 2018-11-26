package relations;

public class ChargesAt {
    private String CarPlate;
    private int UID;
    private long TimeStart;
    private long TimeFinish;

    public ChargesAt(String carPlate, int UID, long timeStart, long timeFinish) {
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

    public long getTimeStart() {
        return TimeStart;
    }

    public void setTimeStart(long timeStart) {
        TimeStart = timeStart;
    }

    public long getTimeFinish() {
        return TimeFinish;
    }

    public void setTimeFinish(long timeFinish) {
        TimeFinish = timeFinish;
    }
}
