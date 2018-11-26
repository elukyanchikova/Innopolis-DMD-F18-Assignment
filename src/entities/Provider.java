package entities;

public class Provider {
    private int ProviderID;
    private String ProviderName;
    private String ProviderPhone;
    private String ProviderPaymentInfo;
    private Residence ProviderAddress;

    public Provider(int providerID, String providerName, String providerPhone, String providerPaymentInfo, Residence providerAddress) {
        setProviderID(providerID);
        setProviderName(providerName);
        setProviderPhone(providerPhone);
        setProviderPaymentInfo(providerPaymentInfo);
        setProviderAddress(providerAddress);
    }

    public int getProviderID() {
        return ProviderID;
    }

    public void setProviderID(int providerID) {
        ProviderID = providerID;
    }

    public String getProviderName() {
        return ProviderName;
    }

    public void setProviderName(String providerName) {
        ProviderName = providerName;
    }

    public String getProviderPhone() {
        return ProviderPhone;
    }

    public void setProviderPhone(String providerPhone) {
        ProviderPhone = providerPhone;
    }

    public String getProviderPaymentInfo() {
        return ProviderPaymentInfo;
    }

    public void setProviderPaymentInfo(String providerPaymentInfo) {
        ProviderPaymentInfo = providerPaymentInfo;
    }

    public Residence getProviderAddress() {
        return ProviderAddress;
    }

    public void setProviderAddress(Residence providerAddress) {
        ProviderAddress = providerAddress;
    }
}
