package database;

import entities.*;
import relations.ChargesAt;
import relations.Fits;
import relations.Repairs;
import relations.Serves;

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

	public GeneratedData() {

	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<CarModel> getModels() {
		return models;
	}

	public void setModels(List<CarModel> models) {
		this.models = models;
	}

	public List<CarPart> getParts() {
		return parts;
	}

	public void setParts(List<CarPart> parts) {
		this.parts = parts;
	}

	public List<ChargingStation> getStations() {
		return stations;
	}

	public void setStations(List<ChargingStation> stations) {
		this.stations = stations;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public List<StationSocket> getSockets() {
		return sockets;
	}

	public void setSockets(List<StationSocket> sockets) {
		this.sockets = sockets;
	}

	public List<Workshop> getWorkshops() {
		return workshops;
	}

	public void setWorkshops(List<Workshop> workshops) {
		this.workshops = workshops;
	}

	public List<ChargesAt> getChargesAt() {
		return chargesAt;
	}

	public void setChargesAt(List<ChargesAt> chargesAt) {
		this.chargesAt = chargesAt;
	}

	public List<Fits> getFits() {
		return fits;
	}

	public void setFits(List<Fits> fits) {
		this.fits = fits;
	}

	public List<Repairs> getRepairs() {
		return repairs;
	}

	public void setRepairs(List<Repairs> repairs) {
		this.repairs = repairs;
	}

	public List<Serves> getServes() {
		return serves;
	}

	public void setServes(List<Serves> serves) {
		this.serves = serves;
	}
}
