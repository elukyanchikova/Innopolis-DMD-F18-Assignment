package entities;

public class Car {
	private String BrandName;
	private String ModelName;
	private String CarPlate;
	private String Color;
	private float CarRating;
	private boolean CrashFlag;
	private float BatteryPercentage;
	private GPSLocation CarLocation;

	public Car(String brandName, String modelName, String carPlate, String color, float carRating, boolean crashFlag, float batteryPercentage, GPSLocation location) {
		setBrandName(brandName);
		setModelName(modelName);
		setCarPlate(carPlate);
		setColor(color);
		setCarRating(carRating);
		setCrashFlag(crashFlag);
		setBatteryPercentage(batteryPercentage);
		setCarLocation(location);
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

	public String getCarPlate() {
		return CarPlate;
	}

	public void setCarPlate(String carPlate) {
		CarPlate = carPlate;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public float getCarRating() {
		return CarRating;
	}

	public void setCarRating(float carRating) {
		CarRating = carRating;
	}

	public boolean isCrashFlag() {
		return CrashFlag;
	}

	public void setCrashFlag(boolean crashFlag) {
		CrashFlag = crashFlag;
	}

	public float getBatteryPercentage() {
		return BatteryPercentage;
	}

	public void setBatteryPercentage(float batteryPercentage) {
		BatteryPercentage = batteryPercentage;
	}

	public GPSLocation getCarLocation() {
		return CarLocation;
	}

	public void setCarLocation(GPSLocation carLocation) {
		CarLocation = carLocation;
	}
}
