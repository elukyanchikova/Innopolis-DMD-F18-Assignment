package entities;

public class CarPart {

    private int PartID;
    private String PartName;
    private float PartPrice;
    private String PartManufacturer;

    public CarPart(int partID, String partName, float partPrice, String partManufacturer){
        setPartID(partID);
        setPartName(partName);
        setPartPrice(partPrice);
        setPartManufacturer(partManufacturer);
    }

    public int getPartID() {
        return PartID;
    }

    public void setPartID(int partID) {
        PartID = partID;
    }

    public String getPartName() {
        return PartName;
    }

    public void setPartName(String partName) {
        PartName = partName;
    }

    public float getPartPrice() {
        return PartPrice;
    }

    public void setPartPrice(float partPrice) {
        PartPrice = partPrice;
    }

    public String getPartManufacturer() {
        return PartManufacturer;
    }

    public void setPartManufacturer(String partManufacturer) {
        PartManufacturer = partManufacturer;
    }
}
