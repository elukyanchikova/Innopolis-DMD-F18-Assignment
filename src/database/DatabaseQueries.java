package database;
import java.io.*;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.LinkedList;

public class DatabaseQueries {

	private DatabaseAPI sample;

	public void MainTest() {
		createSample();
		FillSample();
		sample.connect();

		/*Query01();
		Query02(12425346);
		Query03();
		Query04();
		Query05();
		Query06();
		Query07();
		Query08();
		Query09();
		Query10();*/


        sample.close();

    }

    public void createSample(){
        sample = new DatabaseAPI();
        sample.createNewDatabase("sample");

        String carModelColumns[] = {"brand_name", "model_name", "socket_shape", "socket_size", "passenger_capacity", "luggage_capacity", "battery_capacity"};
        String carModelTypes[]   = {"text",       "text",       "text",         "text",        "integer",            "real",             "real"};
        String carModelF[]       = {"NOT NULL",   "NOT NULL",   "NOT NULL",     "NOT NULL",    "NOT NULL",           "NOT NULL",         "NOT NULL"};
        String carModelOthers = "PRIMARY KEY (brand_name, model_name)\n";
        sample.createNewTable("car_model", carModelColumns, carModelTypes, carModelF, carModelOthers);

        String customerColumns[] = {"username",    "customer_name", "customer_phone", "customer_email", "payment_info", "zip_code", "city",     "country"};
        String customerTypes[]   = {"text",        "text",          "text",           "text",           "text",         "integer",  "text",     "text"};
        String customerF[]       = {"PRIMARY KEY", "NOT NULL",      "NOT NULL",       "NOT NULL",       "NOT NULL",     "NOT NULL", "NOT NULL", "NOT NULL"};
        sample.createNewTable("customer", customerColumns, customerTypes, customerF, "");

        String carColumns[] = {"car_plate",   "brand_name", "model_name", "car_color", "car_latitude", "car_longitude", "car_rating", "crash_flag", "battery_percentage"};
        String carTypes[]   = {"text",        "text",       "text",       "text",      "real",         "real",          "real",       "integer",    "real"};
        String carF[]       = {"PRIMARY KEY", "NOT NULL",   "NOT NULL",   "NOT NULL",  "NOT NULL",     "NOT NULL",      "NOT NULL",  "NOT NULL",   "NOT NULL"};
        String carOthers    = "FOREIGN KEY (brand_name) REFERENCES car_model (brand_name) \n FOREIGN KEY (model_name) REFERENCES car_model (model_name)\n";
        sample.createNewTable("car", carColumns, carTypes, carF, carOthers);

        String chargingStationColumns[] = {"UID",                       "station_latitude", "station_longitude", "electrical_power", "number_of_available_sockets", "charging_amount_price"};
        String chargingStationTypes[]   = {"integer",                   "real",             "real",              "real",             "integer",                     "real"};
        String chargingStationF[]       = {"PRIMARY KEY AUTOINCREMENT", "NOT NULL",         "NOT NULL",          "",                 "NOT NULL",                    ""};
        sample.createNewTable("charging_station", chargingStationColumns, chargingStationTypes, chargingStationF, "");

        String workshopColumns[] = {"WID",                       "number_of_available_places", "zip_code", "city",     "country"};
        String workshopTypes[]   = {"integer",                   "integer",                    "integer",  "text",     "text"};
        String workshopF[]       = {"PRIMARY KEY AUTOINCREMENT", "NOT NULL",                   "NOT NULL", "NOT NULL", "NOT NULL"};
        sample.createNewTable("workshop", workshopColumns, workshopTypes, workshopF, "");

        String providerColumns[] = {"provider_id",               "provider_name", "provider_phone", "payment_info", "zip_code", "city",     "country"};
        String providerTypes[]   = {"integer",                   "text",          "text",           "text",         "integer",  "text",     "text"};
        String providerF[]       = {"PRIMARY KEY AUTOINCREMENT", "NOT NULL",      "NOT NULL",       "NOT NULL",     "NOT NULL", "NOT NULL", "NOT NULL"};
        sample.createNewTable("provider", providerColumns, providerTypes, providerF, "");

        String carPartColumns[] = {"part_id",                   "part_name", "part_price", "part_manufacturer", "provider_id", "WID"};
        String carPartTypes[]   = {"integer",                   "text",      "real",       "text",              "integer",     "integer"};
        String carPartF[]       = {"PRIMARY KEY AUTOINCREMENT", "NOT NULL",  "NOT NULL",   "NOT NULL",          "NOT NULL",    ""};
        String carPartOthers = "FOREIGN KEY (provider_id) REFERENCES provider (provider_id) \n FOREIGN KEY (WID) REFERENCES workshop(WID)\n";
        sample.createNewTable("car_parts", carPartColumns, carPartTypes, carPartF, carPartOthers);

        String orderColumns[] = {"order_id",                  "order_status", "order_time", "A_latitude", "A_longitude", "B_latitude", "B_longitude", "number_of_adult_passengers", "need_babyseat", "luggage_volume", "customer_username"};
        String orderTypes[]   = {"integer",                   "text",         "integer",    "real",       "real",        "real",       "real",        "integer",                    "integer",       "real",           "text"};
        String orderF[]       = {"PRIMARY KEY AUTOINCREMENT", "NOT NULL",     "NOT NULL",   "NOT NULL",   "NOT NULL",    "NOT NULL",   "NOT NULL",    "NOT NULL",                   "NOT NULL",      "NOT NULL",       "NOT NULL"};
        String orderOthers = "FOREIGN KEY (customer_username) REFERENCES customer (username)\n";
        sample.createNewTable("orders", orderColumns, orderTypes, orderF, orderOthers);

        String socketsColumns[] = {"UID",      "socket_number",               "socket_shape", "socket_size"};
        String socketsTypes[]   = {"integer",  "integer",                     "text",         "text"};
        String socketsF[]       = {"NOT NULL", "NOT NULL",      "NOT NULL",     "NOT NULL"};
        String socketsOthers = "FOREIGN KEY (UID) REFERENCES charging_station(UID) \n PRIMARY KEY (UID, socket_number)\n";
        sample.createNewTable("sockets", socketsColumns, socketsTypes, socketsF, socketsOthers);

        String chargesAtColumns[] = {"UID",      "car_plate", "time_start", "time_finish"};
        String chargesAtTypes[]   = {"integer",  "text",      "integer",    "integer"};
        String chargesAtF[]       = {"NOT NULL", "NOT NULL",  "NOT NULL",   ""};
        String chargesAtOthers = "FOREIGN KEY (UID) REFERENCES charging_station(UID) \n FOREIGN KEY (car_plate) references car(car_plate) \n PRIMARY KEY (UID, car_plate, time_start)\n";
        sample.createNewTable("charges_at", chargesAtColumns, chargesAtTypes, chargesAtF, chargesAtOthers);

        String repairsColumns[] = {"WID",      "car_plate", "time_start", "time_finish"};
        String repairsTypes[]   = {"integer",  "text",      "integer",    "integer"};
        String repairsF[]       = {"NOT NULL", "NOT NULL",  "NOT NULL",   ""};
        String repairsOthers = "FOREIGN KEY (WID) REFERENCES workshop(WID) \n FOREIGN KEY (car_plate) references car(car_plate) \n PRIMARY KEY (WID, car_plate, time_start)\n";
        sample.createNewTable("repairs", repairsColumns, repairsTypes, repairsF, repairsOthers);

        String requestsColumns[] = {"request_id",                "part_name", "number_of_parts", "WID",      "provider_id"};
        String requestsTypes[]   = {"integer",                   "text",      "integer",         "integer",  "integer"};
        String requestsF[]       = {"PRIMARY KEY AUTOINCREMENT", "NOT NULL",  "NOT NULL",        "NOT NULL", "NOT NULL"};
        String requestOthers = "FOREIGN KEY (provider_id) REFERENCES provider (provider_id) \n FOREIGN KEY (WID) REFERENCES workshop(WID)\n";
        sample.createNewTable("requests", requestsColumns, requestsTypes, requestsF, requestOthers);

        String servesColumns[] = {"order_id",    "car_plate", "time_start", "time_finish"};
        String servesTypes[]   = {"integer",     "text",      "integer",    "integer"};
        String servesF[]       = {"PRIMARY KEY", "NOT NULL",  "NOT NULL",   "NOT NULL"};
        String servesOthers = "FOREIGN KEY (order_id) references orders(order_id) \n FOREIGN KEY (car_plate) references car(car_plate)\n";
        sample.createNewTable("serves", servesColumns, servesTypes, servesF, servesOthers);

        String fitsColumns[] = {"part_id",  "model_name", "brand_name"};
        String fitsTypes[]   = {"integer",  "text",       "text"};
        String fitsF[]       = {"NOT NULL", "NOT NULL",   "NOT NULL"};
        String fitsOthers = "FOREIGN KEY (part_id) REFERENCES car_parts(part_id)\n FOREIGN KEY (brand_name) REFERENCES car_model (brand_name) \n FOREIGN KEY (model_name) REFERENCES car_model (model_name)\n";
        sample.createNewTable("fits", fitsColumns, fitsTypes, fitsF, fitsOthers);

        sample.close();

    }

    public void FillSample(){
	    sample.connect();
	    sample.clear();
        sample.fillTheCarModel();
        sample.fillTheCustomer();
        sample.fillTheCar();
        sample.fillTheChargingStation();
        sample.fillTheWorkshop();
        sample.fillTheProvider();
        sample.fillTheCarParts();
        sample.fillTheOrders();
        sample.fillTheSockets();
        sample.fillTheChargesAt();
        sample.fillTheRepairs();
        sample.fillTheRequests();
        sample.fillTheServes();
        sample.fillTheFits();
        sample.close();
    }


	void Query01() {
		String SQLStatement = "SELECT * FROM car\n" +
				"\tWHERE car_color='red' AND car_plate LIKE 'AN%'";
		ResultSet result =  sample.executeQuery(SQLStatement);
		//TODO: create new table and insert result there (for all queries!)
	}

	void Query02(long requestedDate) {
		Collection<Integer> usage = new LinkedList<>();
		for (int hour = 0; hour <= 23; hour++) {
			String SQLStatement = "SELECT count(*) FROM charges_at WHERE " +
					"strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+" + hour + " hour') <= time_start < strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+" + hour + "+1 hour') OR " +
					"strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+" + hour + " hour') <= time_finish < strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+" + hour + "+1 hour')";
            ResultSet result = sample.executeQuery(SQLStatement);
		}
	}

    void Query03(){

    }

    void Query04(){

    }

    void Query05(){

    }

    void Query06(){

    }

    void Query07(){

    }

    void Query08(){

    }

    void Query09(){

    }

    void Query10(){

    }



}
