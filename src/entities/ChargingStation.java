package entities;

import java.util.List;

public class ChargingStation {
    private int UID;
    private int NumberOfSockets;
    private int NumberOfSocketsAvailable;
    private float ElectricalPower;
    private float ChargingAmountPrice;

    public ChargingStation(int UID, int numberOfSockets, int numberOfSocketsAvailable, float electricalPower, float chargingAmountPrice){
        setUID(UID);
        setNumberOfSockets(numberOfSockets);
        setNumberOfSockets(numberOfSocketsAvailable);
        setElectricalPower(electricalPower);
        setChargingAmountPrice(chargingAmountPrice);
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public int getNumberOfSockets() {
        return NumberOfSockets;
    }

    public void setNumberOfSockets(int numberOfSockets) {
        NumberOfSockets = numberOfSockets;
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
}
