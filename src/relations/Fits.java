package relations;

public class Fits {
	private String BrandName;
	private String ModelName;
	private int CarPartID;

	public Fits(String brandName, String modelName, int carPartID) {
		BrandName = brandName;
		ModelName = modelName;
		CarPartID = carPartID;
	}


	public String getBrandName() {
		return BrandName;
	}

	public void setBrandName(String brandName) {
		BrandName = brandName;
	}

	public String getModelName() {
		return ModelName;
	}

	public void setModelName(String modelName) {
		ModelName = modelName;
	}

	public int getCarPartID() {
		return CarPartID;
	}

	public void setCarPartID(int carPartID) {
		CarPartID = carPartID;
	}
}
