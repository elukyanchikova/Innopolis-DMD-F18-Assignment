import entities.*;
import relations.ChargesAt;
import relations.Repairs;
import relations.Requests;
import relations.Serves;

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

	}

	public Collection<ChargingStation> parseChargingStations() {

	}

	public Collection<Customer> parseCustomers() {

	}

	public Collection<Order> parseOrders() {

	}

	public Collection<Provider> parseProviders() {

	}

	public Collection<Workshop> parseWorkshops() {

	}

	public Collection<StationSocket> parseStationSockets() {

	}

	public Collection<ChargesAt> parseChargesAt() {

	}

	public Collection<Repairs> parseRepairs() {

	}

	public Collection<Requests> parseRequests(){

	}

	public Collection<Serves> parseServes(){
		
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
