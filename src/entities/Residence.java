package entities;

public class Residence {
    private String City;
    private String Country;
    private int ZIPCode;

    public Residence(String city, String country, int zipCode){
        setCity(city);
        setCountry(country);
        setZIPCode(zipCode);
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setZIPCode(int ZIPCode) {
        this.ZIPCode = ZIPCode;
    }

    public int getZIPCode() {
        return ZIPCode;
    }
    public String toString(){
        return getCity() + ", " + getCountry() +", " + getZIPCode();
    }


}
