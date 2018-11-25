package entities;

public class Order {
	private int OrderID;
	private String OrderStatus;
	private long OrderTime;
	private int NumberOfAdultPassengers;
	private float LuggageVolume;
	private boolean NeedBabySeat;
	private float OrderCost;
	private GPSLocation DeparturePoint;
	private GPSLocation Destination;
	private String CustomerUsername;

	public Order(int orderID, String orderStatus, long orderTime, int numberOfAdultPassengers, float luggageVolume, boolean needBabySeat, float orderCost, GPSLocation departure, GPSLocation destination, String customerUsername) {
		OrderID = orderID;
		OrderStatus = orderStatus;
		OrderTime = orderTime;
		NumberOfAdultPassengers = numberOfAdultPassengers;
		LuggageVolume = luggageVolume;
		NeedBabySeat = needBabySeat;
		OrderCost = orderCost;
		DeparturePoint = departure; // TODO Rename to Departure
		Destination = destination; // TODO Or rename to DestinationPoint
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

	public long getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(long orderTime) {
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
