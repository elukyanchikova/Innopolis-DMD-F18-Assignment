package entities;

public class Workshop {
    private int WID;
    private int NumberOfPlaces;
    private int NumberOfPlacesAvailable;
    private GPSLocation WorkshopLocation;

    public Workshop(int WID, int numberOfPlaces, int numberOfPlacesAvailable){
        setWID(WID);
        setNumberOfPlaces(numberOfPlaces);
        setNumberOfPlacesAvailable(numberOfPlacesAvailable);
    }

    public int getWID() {
        return WID;
    }

    public void setWID(int WID) {
        this.WID = WID;
    }

    public int getNumberOfPlaces() {
        return NumberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        NumberOfPlaces = numberOfPlaces;
    }

    public int getNumberOfPlacesAvailable() {
        return NumberOfPlacesAvailable;
    }

    public void setNumberOfPlacesAvailable(int numberOfPlacesAvailable) {
        NumberOfPlacesAvailable = numberOfPlacesAvailable;
    }

    public GPSLocation getWorkshopLocation() {
        return WorkshopLocation;
    }

    public void setWorkshopLocation(GPSLocation workshopLocation) {
        WorkshopLocation = workshopLocation;
    }
}
