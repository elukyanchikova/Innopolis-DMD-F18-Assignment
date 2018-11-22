package database;


import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
		if (connection != null)
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
		if (!isConnected())
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

	//TODO: write clear for db
	public void clear(){

    }


    //TODO: write insertion for all the tables
	public void insertIntoCar(String carPlate, String carModel, String carBrand, String carColor, float carRating, float carLat, float carLon, float batteryPercentage, boolean crashFlag){
	    String SQLStatement = "INSERT INTO car (car_plate, brand_name, model_name, car_color, car_latitude, car_longitude, car_rating, crash_flag, battery_percentage)\n"
                              + "VALUES (" + carPlate + ", " + carBrand + ", " + carModel + ", " + carColor + ", " + carLat + ", " + carLon + ", " + carRating + ", " + (crashFlag ? 1 : 0) + ", " + batteryPercentage + ");";

	    execute(SQLStatement);
    }

    public void fillTheCar(){
	    File f = new File("/home/stale/Education/Databases/DB-project/src/sample_data/car.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] args = line.split(" ");
                insertIntoCar(args[0], args[1], args[2], args[3], Float.valueOf(args[4]), Float.valueOf(args[5]), Float.valueOf(args[6]), Float.valueOf(args[7]), Boolean.valueOf(args[8]));
            }
        } catch (IOException e){
	        e.printStackTrace();
        }
    }

    public void insertIntoCarModel(){

    }

    public void insertIntoCarParts(){

    }

    public void insertIntoChargesAt(){

    }

    public void insertIntoChargingStation(){

    }

    public void insertIntoCustomer(){

    }

    public void insertIntoFits(){}

    public void insertIntoOrders(){

    }

    public void insertIntoProvider(){

    }

    public void insertIntoRepairs(){

    }

    public void insertIntoRequests(){

    }

    public void insertIntoServes(){

    }

    public void insertIntoSockets(){

    }

    public void insertIntoWorkshop(){

    }
}
