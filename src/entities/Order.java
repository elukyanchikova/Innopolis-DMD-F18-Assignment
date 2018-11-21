package entities;

public class Order {
    private int OrderID;
    private String OrderStatus;
    private int OrderTime;
    private int NumberOfAdultPassengers;
    private float LuggageVolume;
    private boolean NeedBabySeat;
    private float OrderCost;
    private GPSLocation DeparturePoint;
    private GPSLocation Destination;
    private String CustomerUsername;

    public Order(int orderID, String orderStatus, int orderTime, int numberOfAdultPassengers, float luggageVolume, boolean needBabySeat, float orderCost, GPSLocation departurePoint, GPSLocation destination, String customerUsername) {
        OrderID = orderID;
        OrderStatus = orderStatus;
        OrderTime = orderTime;
        NumberOfAdultPassengers = numberOfAdultPassengers;
        LuggageVolume = luggageVolume;
        NeedBabySeat = needBabySeat;
        OrderCost = orderCost;
        DeparturePoint = departurePoint;
        Destination = destination;
        CustomerUsername = customerUsername;
    }


    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }

    public int getOrderTime() {
        return OrderTime;
    }

    public void setOrderTime(int orderTime) {
        OrderTime = orderTime;
    }

    public int getNumberOfAdultPassengers() {
        return NumberOfAdultPassengers;
    }

    public void setNumberOfAdultPassengers(int numberOfAdultPassengers) {
        NumberOfAdultPassengers = numberOfAdultPassengers;
    }

    public float getLuggageVolume() {
        return LuggageVolume;
    }

    public void setLuggageVolume(float luggageVolume) {
        LuggageVolume = luggageVolume;
    }

    public boolean isNeedBabySeat() {
        return NeedBabySeat;
    }

    public void setNeedBabySeat(boolean needBabySeat) {
        NeedBabySeat = needBabySeat;
    }

    public float getOrderCost() {
        return OrderCost;
    }

    public void setOrderCost(float orderCost) {
        OrderCost = orderCost;
    }

    public GPSLocation getDeparturePoint() {
        return DeparturePoint;
    }

    public void setDeparturePoint(GPSLocation departurePoint) {
        DeparturePoint = departurePoint;
    }

    public GPSLocation getDestination() {
        return Destination;
    }

    public void setDestination(GPSLocation destination) {
        Destination = destination;
    }

    public String getCustomerUsername() {
        return CustomerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        CustomerUsername = customerUsername;
    }
}
