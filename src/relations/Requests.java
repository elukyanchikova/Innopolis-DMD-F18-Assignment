package relations;

public class Requests {
	private int ProviderID;
	private int WID;
	private String PartName;
	private int NumberOfParts;
	private int RequestID;

	public Requests(int providerID, int WID, String partName, int numberOfParts, int requestID) {
		ProviderID = providerID;
		this.WID = WID;
		PartName = partName;
		NumberOfParts = numberOfParts;
		RequestID = requestID;
	}

	public int getProviderID() {
		return ProviderID;
	}

	public void setProviderID(int providerID) {
		ProviderID = providerID;
	}

	public int getWID() {
		return WID;
	}

	public void setWID(int WID) {
		this.WID = WID;
	}

	public String getPartName() {
		return PartName;
	}

	public void setPartName(String partName) {
		PartName = partName;
	}

	public int getNumberOfParts() {
		return NumberOfParts;
	}

	public void setNumberOfParts(int numberOfParts) {
		NumberOfParts = numberOfParts;
	}

	public int getRequestID() {
		return RequestID;
	}

	public void setRequestID(int requestID) {
		RequestID = requestID;
	}
}
