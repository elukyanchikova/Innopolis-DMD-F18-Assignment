package database;

import entities.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DataGenerator {
	private final String[] firstNames = {"Albert", "Andrei", "Nikola", "Alan", "Richard", "Alonzo"};
	private final String[] lastNames = {"Sakharov", "Feynman", "Einstein", "Tesla", "Turing", "Church"};
	private final String[] colors = {"red", "green", "blue", "yellow", "silver", "black"};
	private final String[] shapes = {"round", "square", "Klenee star"};
	private final String[] carModels = {"Niva", "Corolla", "Desyatka"};
	private final String[] carBrands = {"Mitsubishi", "Nissan", "Lada", "Toyota"};
	private final String[] cities = {"Kazan", "Moscow", "Novosibirsk", "Tbilisi", "Omsk", "Erevan"};
	private final String[] countries = {"Russia", "Armenia", "Georgia"};
	private final String[] usernames = {"stalem1", "stalem2", "stalem3", "stalem4", "stalem5", "shakirovrrr1", "shakirovrrr2", "elukyanchikova"};
	private final String[] providers = {"National Car Rental", "Alamo", "Sixt", "Hertz"};
	private final String[] parts = {"windshield washer motor", "sparking cable", "wheel disk"};
	private final String[] manufacturers = {"Audi", "Bentley", "Skoda", "Citroen", "Opel", "BMW"};

	private final Random random;
	private long fromDate;

	public DataGenerator() {
		random = new Random();
	}

	public GeneratedData generateData(int nModels, int nCars, int nCustomers,
	                                  int nStations, int nWorkshops, int nProviders,
	                                  int nParts, int nOrders, long fromDate) {
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

		data.setStations(new LinkedList<>());
		for (int i = 0; i < nStations; i++) {
			data.getStations().add(generateStation(i));
		}

		data.setProviders(new LinkedList<>());
		for (int i = 0; i < nProviders; i++) {
			data.getProviders().add(generateProvider(i));
		}

		data.setWorkshops(new LinkedList<>());
		for (int i = 0; i < nWorkshops; i++) {
			data.getWorkshops().add(generateWorkshop(i));
		}

		data.setParts(new LinkedList<>());
		for (int i = 0; i < nParts; i++) {
			data.getParts().add(generateCarPart(i, ((CarPart) pickRandomFrom(data.getProviders())).getWID()));
		}

		this.fromDate = fromDate;
		data.setOrders(new LinkedList<>());
		for (int i = 0; i < nOrders; i++) {
			data.getOrders().add(generateOrder(i, ((Customer) pickRandomFrom(data.getCustomers())).getUsername()));
		}

		return data;
	}

	public CarModel generateCarModel() {
		CarSocket socket = new CarSocket(random.nextInt(10) + 1, pickRandomFrom(shapes));

		return new CarModel(pickRandomFrom(carBrands), pickRandomFrom(carModels),
				random.nextInt(6) + 2, random.nextInt(100) + 20,
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

	public Order generateOrder(int orderID, String customerUsername) {
		String status = random.nextInt(15) < 2 ? "cancelled" : "done";
		GPSLocation departure = generateLocation();
		GPSLocation destination = generateLocation();
		float cost = (float) Math.sqrt((destination.getLatitude() - departure.getLatitude()) *
				(destination.getLatitude() - departure.getLatitude()) +
				(destination.getLongitude() - departure.getLongitude()) *
						(destination.getLongitude() - departure.getLongitude())) * 5 * 120;
		return new Order(orderID, status, randomTime(fromDate),
				random.nextInt(6) + 2, random.nextInt(100) + 20,
				random.nextInt(10) < 2, cost, departure, destination, customerUsername);
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

	private long randomTime(long startsFrom) {
		long adds = random.nextLong() % startsFrom;
		return startsFrom + adds;
	}
}
