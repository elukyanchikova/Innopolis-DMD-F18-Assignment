package database;

import entities.*;
import relations.ChargesAt;
import relations.Repairs;
import relations.Requests;
import relations.Serves;
import sun.awt.image.ImageWatched;

import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

public class DataFiller {
	private InputStream input;

	public DataFiller(InputStream input) {
		this.input = input;
	}

	public Collection<Car> parseCars() {
		LinkedList<Car> cars = new LinkedList<>();

		Collection<String[]> strings = loadStrings("Car");
		for (String[] fields : strings) {
			GPSLocation location = new GPSLocation(Float.valueOf(fields[5]), Float.valueOf(fields[6]));
			Car obj = new Car(fields[2], fields[1],
					fields[0], fields[3], Float.valueOf(fields[4]),
					Boolean.valueOf(fields[8]), Float.valueOf(fields[7]), location);

			cars.add(obj);
		}

		return cars;
	}

	public Collection<CarModel> parseCarModels() {
		LinkedList<CarModel> models = new LinkedList<>();

		Collection<String[]> strings = loadStrings("CarModel");
		for (String[] fields : strings) {
			CarSocket socket = new CarSocket(Float.valueOf(fields[5]), fields[6]);
			CarModel obj = new CarModel(fields[1], fields[0], Integer.valueOf(fields[2]),
					Float.valueOf(fields[3]), Float.valueOf(fields[4]), socket);
			models.add(obj);
		}

		return models;
	}

	public Collection<ChargingStation> parseChargingStations() {
		LinkedList<ChargingStation> stations = new LinkedList<>();

		Collection<String[]> strings = loadStrings("ChargingStation");
		for (String[]fields : strings){
			GPSLocation location = new GPSLocation(Float.valueOf(fields[1]), Float.valueOf(fields[2]));
			ChargingStation obj = new ChargingStation(Integer.valueOf(fields[0]), Integer.valueOf(fields[4]), Float.valueOf(fields[3]), Float.valueOf(fields[5]), location);
			stations.add(obj);
		}

		return stations;
	}

	public Collection<Customer> parseCustomers() {
		LinkedList<Customer> customers = new LinkedList<>();

		Collection<String[]> strings = loadStrings("Customer");
		for (String[]fields: strings){
			Residence residence = new Residence(fields[6], fields[7], Integer.valueOf(fields[5]));
			Customer obj = new Customer(fields[0], fields[1], fields[2], fields[3], fields[4], residence);
			customers.add(obj);
		}

		return customers;
	}

	public Collection<Order> parseOrders() {
		return null;
	}

	public Collection<Provider> parseProviders() {
		return null;
	}

	public Collection<Workshop> parseWorkshops() {
		return null;
	}

	public Collection<StationSocket> parseStationSockets() {
		return null;
	}

	public Collection<ChargesAt> parseChargesAt() {
		return null;
	}

	public Collection<Repairs> parseRepairs() {
		return null;
	}

	public Collection<Requests> parseRequests() {
		return null;
	}

	public Collection<Serves> parseServes() {
		return null;
	}

	private Collection<String[]> loadStrings(String verify) {
		Scanner scanner = new Scanner(input);
		LinkedList<String[]> strings = new LinkedList<>();

		if (scanner.hasNextLine()) {
			if (!scanner.nextLine().equals(verify)) {
				return strings;
			}
		} else {
			return strings;
		}

		while (scanner.hasNextLine()) {
			String entry = scanner.nextLine();
			String[] fields = entry.split(";");
			strings.add(fields);
		}

		return strings;
	}
}
