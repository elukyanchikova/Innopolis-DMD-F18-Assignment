package entities;

public class Workshop {
	private int WID;
	private int NumberOfPlacesAvailable;
	private Residence WorkshopLocation;

	public Workshop(int WID, int numberOfPlacesAvailable, Residence workshopLocation) {
		this.WID = WID;
		NumberOfPlacesAvailable = numberOfPlacesAvailable;
		WorkshopLocation = workshopLocation;
	}


	public int getWID() {
		return WID;
	}

	public void setWID(int WID) {
		this.WID = WID;
	}

	public int getNumberOfPlacesAvailable() {
		return NumberOfPlacesAvailable;
	}

	public void setNumberOfPlacesAvailable(int numberOfPlacesAvailable) {
		NumberOfPlacesAvailable = numberOfPlacesAvailable;
	}

	public Residence getWorkshopLocation() {
		return WorkshopLocation;
	}

	public void setWorkshopLocation(Residence workshopLocation) {
		WorkshopLocation = workshopLocation;
	}
}
