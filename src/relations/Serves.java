package relations;

public class Serves {
	private String CarPlate;
	private int OrderID;
	private long TimeStart;
	private long TimeFinish;

	public Serves(String carPlate, int orderID, long timeStart, long timeFinish) {
		CarPlate = carPlate;
		OrderID = orderID;
		TimeStart = timeStart;
		TimeFinish = timeFinish;
	}

	public long getTimeFinish() {
		return TimeFinish;
	}

	public void setTimeFinish(long timeFinish) {
		TimeFinish = timeFinish;
	}

	public long getTimeStart() {
		return TimeStart;
	}

	public void setTimeStart(long timeStart) {
		TimeStart = timeStart;
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public String getCarPlate() {
		return CarPlate;
	}

	public void setCarPlate(String carPlate) {
		CarPlate = carPlate;
	}
}
