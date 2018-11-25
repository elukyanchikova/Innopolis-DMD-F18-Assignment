package relations;

public class Repairs {
	private String CarPlate;
	private int WID;
	private long TimeStart;
	private long TimeFinish;
	private int carPartID;

	public Repairs(String carPlate, int WID, long timeStart, long timeFinish, int carPartID) {
		CarPlate = carPlate;
		this.WID = WID;
		TimeStart = timeStart;
		TimeFinish = timeFinish;
		this.carPartID = carPartID;
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

	public int getCarPartID() {
		return carPartID;
	}

	public void setCarPartID(int carPartID) {
		this.carPartID = carPartID;
	}
}
