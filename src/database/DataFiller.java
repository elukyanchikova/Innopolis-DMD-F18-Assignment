package database;

import entities.*;
import relations.ChargesAt;
import relations.Repairs;
import relations.Requests;
import relations.Serves;

import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

@Deprecated
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
		for (String[] fields : strings) {
			GPSLocation location = new GPSLocation(Float.valueOf(fields[1]), Float.valueOf(fields[2]));
			ChargingStation obj = new ChargingStation(Integer.valueOf(fields[0]), Integer.valueOf(fields[4]), Float.valueOf(fields[3]), Float.valueOf(fields[5]), location);
			stations.add(obj);
		}

		return stations;
	}

	public Collection<Customer> parseCustomers() {
		LinkedList<Customer> customers = new LinkedList<>();

		Collection<String[]> strings = loadStrings("Customer");
		for (String[] fields : strings) {
			Residence residence = new Residence(fields[6], fields[7], Integer.valueOf(fields[5]));
			Customer obj = new Customer(fields[0], fields[1], fields[2], fields[3], fields[4], residence);
			customers.add(obj);
		}

		return customers;
	}

	public Collection<Order> parseOrders() {
		LinkedList<Order> orders = new LinkedList<>();

		Collection<String[]> strings = loadStrings("Order");
		for (String[] fields : strings) {
			GPSLocation departure = new GPSLocation(Float.valueOf(fields[7]), Float.valueOf(fields[8]));
			GPSLocation destination = new GPSLocation(Float.valueOf(fields[9]), Float.valueOf(fields[10]));
			Order obj = new Order(Integer.valueOf(fields[0]), fields[1], Integer.valueOf(fields[2]), Integer.valueOf(fields[3]), Float.valueOf(fields[4]), Boolean.valueOf(fields[5]), Float.valueOf(fields[6]), departure, destination, fields[11]);
			orders.add(obj);
		}

		return orders;
	}

	public Collection<Provider> parseProviders() {
		LinkedList<Provider> providers = new LinkedList<>();

		Collection<String[]> strings = loadStrings("Provider");
		for (String[] fields : strings) {

			Provider obj;
			//providers.add(obj);
		}

		return providers;
	}

	public Collection<Workshop> parseWorkshops() {
		LinkedList<Workshop> workshops = new LinkedList<>();

		Collection<String[]> strings = loadStrings("Workshops");
		for (String[] fields : strings) {

			Workshop obj;
			//workshops.add(obj);
		}

		return workshops;
	}

	public Collection<StationSocket> parseStationSockets() {
		LinkedList<StationSocket> stationSockets = new LinkedList<>();

		Collection<String[]> strings = loadStrings("Sockets");
		for (String[] fields : strings) {

			StationSocket obj;
			//stationSockets.add(obj);
		}

		return stationSockets;
	}

	public Collection<ChargesAt> parseChargesAt() {
		LinkedList<ChargesAt> chargesAt = new LinkedList<>();

		Collection<String[]> strings = loadStrings("ChargesAt");
		for (String[] fields : strings) {

			ChargesAt obj;
			//chargesAt.add(obj);
		}

		return chargesAt;
	}

	public Collection<Repairs> parseRepairs() {
		LinkedList<Repairs> repairs = new LinkedList<>();

		Collection<String[]> strings = loadStrings("Repair");
		for (String[] fields : strings) {

			Repairs obj;
			//repairs.add(obj);
		}

		return repairs;
	}

	public Collection<Requests> parseRequests() {
		LinkedList<Requests> requests = new LinkedList<>();

		Collection<String[]> strings = loadStrings("Request");
		for (String[] fields : strings) {

			Provider obj;
			//requests.add(obj);
		}

		return requests;
	}

	public Collection<Serves> parseServes() {
		LinkedList<Serves> serves = new LinkedList<>();

		Collection<String[]> strings = loadStrings("Serves");
		for (String[] fields : strings) {

			Serves obj;
			//serves.add(obj);
		}

		return serves;
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
