package entities;

public class CarPart {

    private int PartID;
    private String PartName;
    private float PartPrice;
    private String PartManufacturer;
    private int ProviderID;
    private int WID;

    public CarPart(int partID, String partName, float partPrice, String partManufacturer, int providerID){
        setPartID(partID);
        setPartName(partName);
        setPartPrice(partPrice);
        setPartManufacturer(partManufacturer);
        setProviderID(providerID);
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

    public int getProviderID() {
        return ProviderID;
    }

    public void setProviderID(int providerID) {
        ProviderID = providerID;
    }

    public void setWID(int WID) {
        this.WID = WID;
    }

    public int getWID() {
        return WID;
    }
}
