package database;


import entities.*;
import relations.*;
import java.io.*;
import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;

public class DatabaseAPI {

	private String Name;
	private String URL;
	private Connection connection;
	private boolean isConnected;

	public void createNewDatabase(String name) {
		String url = "jdbc:sqlite:" + name + ".db";
		Name = name;
		URL = url;
		connect();

	}

	public void connect() {
		if (isConnected)
			System.out.println("Database already connected!");
		else
			try {
			Connection con = DriverManager.getConnection(URL);
			if (con != null) {
					connection = con;
					isConnected = true;
					System.out.println("Database connected!");
				}
			} catch (SQLException e) {
				isConnected = false;
				e.printStackTrace();
			}
	}

	public void close() {
		if (isConnected()) {
			try {
				connection.close();
				System.out.println("Connection closed!");
				isConnected = false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("Database either closed or was not created yet!");
		}
	}

	public boolean isConnected() {
		return isConnected;
	}

	public void execute(String SQLStatement) {
		if (!isConnected)
			connect();
		try {
			Statement statement = connection.createStatement();
			statement.execute(SQLStatement);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void createNewTable(String name, String[] column_name, String[] column_type, String[] f, String others) {
		String SQLStatement = "CREATE TABLE IF NOT EXISTS " + name + " (\n";
		for (int i = 0; i < column_name.length; i++) {
			if (i == column_name.length - 1 && others.length() == 0) SQLStatement += column_name[i] + " " + column_type[i] + " " + f[i] + "\n";
			else SQLStatement += column_name[i] + " " + column_type[i] + " " + f[i] + ",\n";
		}
		SQLStatement += others + ");";
		execute(SQLStatement);
	}

	public ResultSet executeQuery(String SQLStatement){
		if(!isConnected())
			connect();
		try{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQLStatement);
			statement.close();
			return  resultSet;
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}


	public void clear(){
		execute("DELETE FROM car;");
		execute("DELETE FROM car_model;");
		execute("DELETE FROM car_parts;");
		execute("DELETE FROM charges_at;");
		execute("DELETE FROM charging_station;");
		execute("DELETE FROM customer;");
		execute("DELETE FROM fits;");
		execute("DELETE FROM orders;");
		execute("DELETE FROM provider;");
		execute("DELETE FROM repairs;");
		execute("DELETE FROM requests;");
		execute("DELETE FROM serves;");
		execute("DELETE FROM sockets;");
		execute("DELETE FROM workshop;");
		System.out.println("Records cleared.");

		execute("UPDATE sqlite_sequence SET seq=0;");
		System.out.println("Indices reset.");
    }


    public void insertIntoCar(Car car){
		String SQLStatement = "INSERT INTO car (car_plate, brand_name, model_name, car_color, car_latitude, car_longitude, car_rating, crash_flag, battery_percentage)\n"
				+ "VALUES ('" + car.getCarPlate() + "', '" + car.getBrandName() + "', '" + car.getModelName() + "', '" + car.getColor() + "', " + car.getCarLocation().getLatitude() + ", " + car.getCarLocation().getLongitude() + ", " + car.getCarRating() + ", " + (car.isCrashFlag() ? 1 : 0) + ", " + car.getBatteryPercentage() + ");";

		execute(SQLStatement);
	}

    public void fillTheCar(){
		try{
			FileInputStream input = new FileInputStream("SampleData/Cars-Fill.txt");
			DataFiller filler = new DataFiller(input);
			Collection <Car> cars = filler.parseCars();
			for(Car car: cars){
				insertIntoCar(car);
			}
		} catch (IOException e){
			e.printStackTrace();
		}

    }

    public void insertIntoCarModel(CarModel carModel){
		String SQLStatement = "INSERT INTO car_model (\nbrand_name, model_name, socket_shape, socket_size, passenger_capacity, luggage_capacity, battery_capacity )\n"
				+ "VALUES \n (\n'" + carModel.getBrandName() + "', '" + carModel.getModelName() + "', '" + carModel.getModelSocket().getSocketShape() + "', " + carModel.getModelSocket().getSocketSize() + ", " + carModel.getPassengerCapacity() + ", " + carModel.getLuggageCapacity() + ", " + carModel.getBatteryCapacity() + ");";

		execute(SQLStatement);
    }

    public void fillTheCarModel(){
		try{
			FileInputStream input = new FileInputStream("SampleData/CarModel-Fill.txt");
			DataFiller filler = new DataFiller(input);
			Collection<CarModel> models = filler.parseCarModels();
			for (CarModel model : models){
				insertIntoCarModel(model);
			}

		} catch (IOException e){
			e.printStackTrace();
		}

	}

    public void insertIntoCarParts(CarPart carPart){
		String SQLStatement = "INSERT INTO car_parts (part_name, part_price, part_manufacturer, provider_id, WID)\n"
				+ "VALUES ('" + carPart.getPartName() + "', "+ carPart.getPartPrice() + ", '"+ carPart.getPartManufacturer()+ "', " + carPart.getProviderID()+ ", " + carPart.getWID() +");";

		execute(SQLStatement);
    }

    public void fillTheCarParts(){

	}

    public void insertIntoChargesAt(ChargesAt chargesAt){
		String SQLStatement = "INSERT INTO charges_at (UID, car_plate, time_start, time_finish)\n"
				+ "VALUES (" + chargesAt.getUID() + ", '" + chargesAt.getCarPlate() + "', " + chargesAt.getTimeStart() + ", " + chargesAt.getTimeFinish() + ");";

		execute(SQLStatement);
    }

    public void fillTheChargesAt(){

	}

    public void insertIntoChargingStation(ChargingStation chargingStation){
		String SQLStatement = "INSERT INTO charging_station (station_latitude, station_longitude, electrical_power, number_of_available_sockets, charging_amount_price)\n"
				+ "VALUES (" + chargingStation.getStationLocation().getLatitude() + ", " + chargingStation.getStationLocation().getLongitude() + ", " + chargingStation.getElectricalPower() + ", " + chargingStation.getNumberOfSocketsAvailable() + ", " + chargingStation.getChargingAmountPrice() + ");";

		execute(SQLStatement);
    }

    public void fillTheChargingStation(){
        try{
            FileInputStream input = new FileInputStream("SampleData/ChargingStation-Fill.txt");
            DataFiller filler = new DataFiller(input);
            Collection<ChargingStation> stations = filler.parseChargingStations();
            for (ChargingStation station: stations){
                insertIntoChargingStation(station);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
	}

    public void insertIntoCustomer(Customer customer){
		String SQLStatement = "INSERT INTO customer (username, customer_name, customer_phone, customer_email, payment_info, zip_code, city, country)\n"
				+ "VALUES ('" +customer.getUsername() + "', '" + customer.getCustomerName() + "', '" + customer.getCustomerPhone() + "', '" + customer.getCustomerEmail() + "', '" + customer.getPaymentInfo() + "', " + customer.getCustomerResidence().getZIPCode() + ", '" + customer.getCustomerResidence().getCity() + "', '" + customer.getCustomerResidence().getCountry() + "');";

		execute(SQLStatement);
    }

    public void fillTheCustomer(){
        try{
            FileInputStream input = new FileInputStream("SampleData/Customer-Fill.txt");
            DataFiller filler = new DataFiller(input);
            Collection<Customer> customers = filler.parseCustomers();
            for (Customer customer: customers){
                insertIntoCustomer(customer);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
	}

    public void insertIntoFits(Fits fits){
		String SQLStatement = "INSERT INTO fits (part_id, model_name, brand_name)\n"
				+ "VALUES (" + fits.getCarPartID() + ", '" + fits.getModelName() + "', '" + fits.getBrandName() + "');";

		execute(SQLStatement);
	}

	public void fillTheFits(){

	}

    public void insertIntoOrders(Order order){
		String SQLStatement = "INSERT INTO orders (order_status, order_time, A_latitude, A_longitude, B_latitude, B_longitude, number_of_adult_passengers, need_babyseat, luggage_volume, customer_username)\n"
				+ "VALUES ('" + order.getOrderStatus() + "', " + order.getOrderTime() + ", " + order.getDeparturePoint().getLatitude() + ", " + order.getDeparturePoint().getLongitude() + ", " + order.getDestination().getLatitude() + ", " + order.getDestination().getLongitude() + ", " + order.getNumberOfAdultPassengers() + ", " + ((order.isNeedBabySeat())? 1 : 0) + ", " + order.getLuggageVolume() + ", '" + order.getCustomerUsername() + "');";

		execute(SQLStatement);
    }

    public void fillTheOrders(){
		try{
			FileInputStream input = new FileInputStream("SampleData/Order-Fill.txt");
			DataFiller filler = new DataFiller(input);
			Collection<Order> orders = filler.parseOrders();
			for (Order order: orders){
				insertIntoOrders(order);
			}

		} catch (IOException e){
			e.printStackTrace();
		}
	}

    public void insertIntoProvider(Provider provider){
		String SQLStatement = "INSERT INTO provider (provider_name, provider_phone, payment_info, zip_code, city, country)\n"
				+ "VALUES ('" + provider.getProviderName() +"', '"+provider.getProviderPhone()+"', '"+provider.getProviderPaymentInfo()+"', "+provider.getProviderAddress().getZIPCode()+", '"+provider.getProviderAddress().getCity()+"', '"+provider.getProviderAddress().getCountry()+"');";

		execute(SQLStatement);
    }

    public void fillTheProvider(){

	}

    public void insertIntoRepairs(Repairs repairs){
		String SQLStatement = "INSERT INTO repairs (WID, car_plate, time_start, time_finish)\n"
				+ "VALUES (" + repairs.getWID() + ", '" + repairs.getCarPlate() + "', " + repairs.getTimeStart() + ", " + repairs.getTimeFinish() + ");";

		execute(SQLStatement);
    }

    public void fillTheRepairs(){

	}

    public void insertIntoRequests(Requests requests){
		String SQLStatement = "INSERT INTO requests (part_name, number_of_parts, WID, provider_id)\n"
				+ "VALUES ('" + requests.getPartName() + "', " + requests.getNumberOfParts() + ", " + requests.getWID() + ", " + requests.getProviderID() + ");";

		execute(SQLStatement);
    }

    public void fillTheRequests(){

	}

    public void insertIntoServes(Serves serves){
		String SQLStatement = "INSERT INTO serves (order_id, car_plate, time_start, time_finish)\n"
				+ "VALUES (" +serves.getOrderID() + ", '"+ serves.getCarPlate() + "', " + serves.getTimeStart() + ", " + serves.getTimeFinish() + ");";

		execute(SQLStatement);
    }

    public void fillTheServes(){

	}

    public void insertIntoSockets(StationSocket stationSocket){
		String SQLStatement = "INSERT INTO sockets (UID, socket_shape, socket_size)\n"
				+ "VALUES (" + stationSocket.getStationUID()  + ", '" + stationSocket.getSocketShape() + "', '" + stationSocket.getSocketSize()+ "');";

		execute(SQLStatement);
    }

    public void fillTheSockets(){

	}

    public void insertIntoWorkshop(Workshop workshop){
		String SQLStatement = "INSERT INTO workshop (number_of_available_places, zip_code, city, country)\n"
				+ "VALUES (" + workshop.getNumberOfPlacesAvailable() + ", " + workshop.getWorkshopLocation().getZIPCode() + ", '" + workshop.getWorkshopLocation().getCity() + "', '" + workshop.getWorkshopLocation().getCountry() + "');";

		execute(SQLStatement);
    }

    public void fillTheWorkshop(){

	}

}
