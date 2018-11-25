package relations;

import entities.CarPart;

public class Repairs {
    private String CarPlate;
    private int WID;
    private int TimeStart;
    private int TimeFinish;
    private CarPart carPart;

    public Repairs(String carPlate, int WID, int timeStart, int timeFinish, CarPart carPart) {
        CarPlate = carPlate;
        this.WID = WID;
        TimeStart = timeStart;
        TimeFinish = timeFinish;
        this.carPart = carPart;
    }

    public String getCarPlate() {
        return CarPlate;
    }

    public void setCarPlate(String carPlate) {
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

    public CarPart getCarPart() {
        return carPart;
    }

    public void setCarPart(CarPart carPart) {
        this.carPart = carPart;
    }
}
