package entities;

public class GPSLocation {
    private float Latitude;
    private float Longitude;

    public GPSLocation(float latitude, float longitude) {
        Latitude = latitude;
        Longitude = longitude;
    }


    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float latitude) {
        Latitude = latitude;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float longitude) {
        Longitude = longitude;
    }
}
