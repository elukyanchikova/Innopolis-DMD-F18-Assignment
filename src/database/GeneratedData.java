package database;

import entities.*;
import relations.*;

import java.util.LinkedList;
import java.util.List;

public class GeneratedData {
	private List<Car> cars;
	private List<CarModel> models;
	private List<CarPart> parts;
	private List<ChargingStation> stations;
	private List<Customer> customers;
	private List<Order> orders;
	private List<Provider> providers;
	private List<StationSocket> sockets;
	private List<Workshop> workshops;

	private List<ChargesAt> chargesAt;
	private List<Fits> fits;
	private List<Repairs> repairs;
	private List<Serves> serves;
	private List<Requests> requests;

	public GeneratedData() {
		cars = new LinkedList<>();
		models = new LinkedList<>();
		parts = new LinkedList<>();
		stations = new LinkedList<>();
		customers = new LinkedList<>();
		orders = new LinkedList<>();
		providers = new LinkedList<>();
		sockets = new LinkedList<>();
		workshops = new LinkedList<>();

		chargesAt = new LinkedList<>();
		fits = new LinkedList<>();
		repairs = new LinkedList<>();
		serves = new LinkedList<>();
		requests = new LinkedList<>();
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<CarModel> getModels() {
		return models;
	}

	public List<CarPart> getParts() {
		return parts;
	}

	public List<ChargingStation> getStations() {
		return stations;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public List<StationSocket> getSockets() {
		return sockets;
	}

	public List<Workshop> getWorkshops() {
		return workshops;
	}

	public List<ChargesAt> getChargesAt() {
		return chargesAt;
	}

	public List<Fits> getFits() {
		return fits;
	}

	public List<Repairs> getRepairs() {
		return repairs;
	}

	public List<Serves> getServes() {
		return serves;
	}

	public List<Requests> getRequests() {
		return requests;
	}
}
