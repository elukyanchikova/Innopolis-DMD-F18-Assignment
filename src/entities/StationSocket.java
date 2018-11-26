package entities;

public class StationSocket extends Socket {

	private int SocketNumber;
	private int StationUID;
	private int ChargingTime;

	public StationSocket(float socketSize, String socketShape, int socketNumber, int stationUID) {
		super(socketSize, socketShape);
		setSocketNumber(socketNumber);
		setStationUID(stationUID);
	}

	public int getSocketNumber() {
		return SocketNumber;
	}

	public void setSocketNumber(int socketNumber) {
		SocketNumber = socketNumber;
	}

	public int getStationUID() {
		return StationUID;
	}

	public void setStationUID(int stationUID) {
		StationUID = stationUID;
	}

	public int getChargingTime() {
		return -1; // TODO Compute charging time
	}
}
