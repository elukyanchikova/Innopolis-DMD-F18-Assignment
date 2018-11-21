package entities;


public class ChargingStation {
    private int UID;
    private int NumberOfSocketsAvailable;
    private float ElectricalPower;
    private float ChargingAmountPrice;
    private GPSLocation StationLocation;

    public ChargingStation(int UID, int numberOfSocketsAvailable, float electricalPower, float chargingAmountPrice){
        setUID(UID);
        setNumberOfSocketsAvailable(numberOfSocketsAvailable);
        setElectricalPower(electricalPower);
        setChargingAmountPrice(chargingAmountPrice);
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public int getNumberOfSocketsAvailable() {
        return NumberOfSocketsAvailable;
    }

    public void setNumberOfSocketsAvailable(int numberOfSocketsAvailable) {
        NumberOfSocketsAvailable = numberOfSocketsAvailable;
    }

    public float getElectricalPower() {
        return ElectricalPower;
    }

    public void setElectricalPower(float electricalPower) {
        ElectricalPower = electricalPower;
    }

    public float getChargingAmountPrice() {
        return ChargingAmountPrice;
    }

    public void setChargingAmountPrice(float chargingAmountPrice) {
        ChargingAmountPrice = chargingAmountPrice;
    }

    public GPSLocation getStationLocation() {
        return StationLocation;
    }

    public void setStationLocation(GPSLocation stationLocation) {
        StationLocation = stationLocation;
    }
}
