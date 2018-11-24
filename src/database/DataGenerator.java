package database;

import entities.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DataGenerator {
	private final String[] firstNames = {};
	private final String[] lastNames = {};
	private final String[] colors = {};
	private final String[] shapes = {};
	private final String[] carModels = {};
	private final String[] carBrands = {};
	private final String[] cities = {};
	private final String[] countries = {};
	private final String[] usernames = {};
	private final String[] providers = {};
	private final String[] parts = {};
	private final String[] manufacturers = {};

	private final Random random;

	public DataGenerator() {
		random = new Random();
	}

	public GeneratedData generateData(int nModels, int nCars, int nCustomers) {
		GeneratedData data = new GeneratedData();
		data.setModels(new LinkedList<>());
		for (int i = 0; i < nModels; i++) {
			data.getModels().add(generateCarModel());
		}

		data.setCars(new LinkedList<>());
		for (int i = 0; i < nCars; i++) {
			data.getCars().add(generateCar((CarModel) pickRandomFrom(data.getModels())));
		}

		data.setCustomers(new LinkedList<>());
		for (int i = 0; i < nCustomers; i++) {
			data.getCustomers().add(generateCustomer());
		}

		return data;
	}

	public CarModel generateCarModel() {
		CarSocket socket = new CarSocket(random.nextInt(10) + 1, pickRandomFrom(shapes));

		return new CarModel(pickRandomFrom(carBrands), pickRandomFrom(carModels),
				random.nextInt(5) + 2, random.nextInt(100) + 20,
				random.nextInt(40) + 10, socket);
	}

	public Car generateCar(CarModel model) {
		float rating = (float) (random.nextInt(5)) + random.nextFloat() % 1; // TODO Correct rating
		float battery = random.nextFloat() % 1;
		GPSLocation location = generateLocation();

		return new Car(model.getBrandName(), model.getModelName(),
				generatePlate(), pickRandomFrom(colors),
				rating, random.nextBoolean(), battery, location);
	}

	public Customer generateCustomer() {
		String username = pickRandomFrom(usernames) + random.nextInt(1000);

		return new Customer(username,
				pickRandomFrom(firstNames) + " " + pickRandomFrom(lastNames),
				generatePhone(), username + "@example.com",
				randomString(20), generateResidence());
	}

	public ChargingStation generateStation(int UID) {
		return new ChargingStation(UID, random.nextInt(20) + 1,
				random.nextInt(500) + 1,
				random.nextInt(10) + 20, generateLocation());
	}

	public Provider generateProvider(int providerID) {
		return new Provider(providerID, pickRandomFrom(providers), generatePhone(),
				randomString(20), generateResidence());
	}

	public Workshop generateWorkshop(int WID) {
		return new Workshop(WID, random.nextInt(20) + 1, generateResidence());
	}

	public CarPart generateCarPart(int partID, int providerID) {
		return new CarPart(partID, pickRandomFrom(parts), random.nextInt(20000) + 500,
				pickRandomFrom(manufacturers), providerID);
	}

	public GPSLocation generateLocation() {
		return new GPSLocation(random.nextFloat() % 180 - 90,
				random.nextFloat() % 360 - 180);
	}

	public String generatePhone() {
		return "+" + random.nextLong() % 10000000000L;
	}

	public Residence generateResidence() {
		return new Residence(pickRandomFrom(cities), pickRandomFrom(countries),
				random.nextInt(1000000) + 100000);
	}

	private Object pickRandomFrom(List collection) {
		int ix = random.nextInt(collection.size());
		return collection.get(ix);
	}

	private String pickRandomFrom(String[] collection) {
		int ix = random.nextInt(collection.length);
		return collection[ix];
	}

	private String generatePlate() {
		return String.valueOf(randomLetter()) +
				(random.nextInt(900) + 100) +
				randomLetter() +
				randomLetter();
	}

	private char randomLetter() {
		return (char) (random.nextInt(26) + 65);
	}

	private String randomString(int length) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if (random.nextBoolean()) {
				builder.append(random.nextInt(10));
			} else {
				builder.append(randomLetter());
			}
		}

		return builder.toString();
	}
}
