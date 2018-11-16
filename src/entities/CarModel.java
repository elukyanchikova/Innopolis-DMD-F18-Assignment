package entities;

public class CarModel {

    private String BrandName;
    private String ModelName;
    private int PassengerCapacity;
    private float LuggageCapacity;
    private float BatteryCapacity;
    private CarSocket ModelSocket;

    public CarModel(String brandName, String modelName, int passengerCapacity, float luggageCapacity, float batteryCapacity, CarSocket modelSocket){
        setBrandName(brandName);
        setModelName(modelName);
        setPassengerCapacity(passengerCapacity);
        setLuggageCapacity(luggageCapacity);
        setBatteryCapacity(batteryCapacity);
        setModelSocket(modelSocket);
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

    public int getPassengerCapacity() {
        return PassengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        PassengerCapacity = passengerCapacity;
    }

    public float getLuggageCapacity() {
        return LuggageCapacity;
    }

    public void setLuggageCapacity(float luggageCapacity) {
        LuggageCapacity = luggageCapacity;
    }

    public float getBatteryCapacity() {
        return BatteryCapacity;
    }

    public void setBatteryCapacity(float batteryCapacity) {
        BatteryCapacity = batteryCapacity;
    }

    public CarSocket getModelSocket() {
        return ModelSocket;
    }

    public void setModelSocket(CarSocket modelSocket) {
        ModelSocket = modelSocket;
    }
}
