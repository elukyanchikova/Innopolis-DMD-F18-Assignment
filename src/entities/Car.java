package entities;

public class Car {

    private String BrandName;
    private String ModelName;
    private int CarPlate;
    private String Color;
    private int CurrentOrderID;
    private int CarRating;
    private boolean CrashFlag;
    private float BatteryPercentage;
    private GPSLocation CarLocation;

    public Car(String brandName, String modelName, int carPlate, String color, int currentOrderID, int carRating, boolean crashFlag, float batteryPercentage){
        setBrandName(brandName);
        setModelName(modelName);
        setCarPlate(carPlate);
        setColor(color);
        setCurrentOrderID(currentOrderID);
        setCarRating(carRating);
        setCrashFlag(crashFlag);
        setBatteryPercentage(batteryPercentage);
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String modelName) {
        ModelName = modelName;
    }

    public int getCarPlate() {
        return CarPlate;
    }

    public void setCarPlate(int carPlate) {
        CarPlate = carPlate;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getCurrentOrderID() {
        return CurrentOrderID;
    }

    public void setCurrentOrderID(int currentOrderID) {
        CurrentOrderID = currentOrderID;
    }

    public int getCarRating() {
        return CarRating;
    }

    public void setCarRating(int carRating) {
        CarRating = carRating;
    }

    public boolean isCrashFlag() {
        return CrashFlag;
    }

    public void setCrashFlag(boolean crashFlag) {
        CrashFlag = crashFlag;
    }

    public float getBatteryPercentage() {
        return BatteryPercentage;
    }

    public void setBatteryPercentage(float batteryPercentage) {
        BatteryPercentage = batteryPercentage;
    }

    public GPSLocation getCarLocation() {
        return CarLocation;
    }

    public void setCarLocation(GPSLocation carLocation) {
        CarLocation = carLocation;
    }
}
