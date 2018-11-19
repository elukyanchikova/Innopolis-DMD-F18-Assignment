import java.sql.*;

public class DatabaseQueries {

    private DatabaseAPI sample;

    void MainTest(){
        createSample();
        sample.connect();

        Query01();
        Query02();
        Query03();
        Query04();
        Query05();
        Query06();
        Query07();
        Query08();
        Query09();
        Query10();

        sample.close();

    }

    private void createSample(){
        sample.createNewDatabase("sample.db");

        String carColumns[] = {"car_plate",   "brand_name", "model_name", "car_color", "current_order_id", "GPS_location", "car_rating", "crash_flag", "battery_percentage"};
        String carTypes[]   = {"text",        "text",       "text",       "text",      "integer",          "text",          "integer",   "integer",    "real"};
        String carF[]       = {"PRIMARY_KEY", "",           "",           "",          "",                 "",              "",          "",           ""};

        sample.createNewTable("car", carColumns, carTypes, carF);


        String carModelColumns[] = {"brand_name", "model_name", "socket", "passenger_capacity", "luggage_capacity", "battery_capacity"};
        String carModelTypes[]   = {"text",       "text",       "text",   "integer",            "real",             "real"};
        String carModelF[]       = {"", "", "", "", "", ""};

        sample.createNewTable("car_model", carModelColumns, carModelTypes, carModelF);


        String carPartColumns[] = {"part_id", "part_name", "part_price", "part_manufacturer", "provider_id"};
        String carPartTypes[] = {};
        String carPartF[] = {};

        sample.createNewTable("car_parts", carPartColumns, carPartTypes, carPartF);


        String chargingStationColumns[] = {};
        String chargingStationTypes[] = {};
        String chargingStationF[] = {};

        sample.createNewTable("charging_station", chargingStationColumns, chargingStationTypes, chargingStationF);


        String customerColumns[] = {};
        String customerTypes[] = {};
        String customerF[] = {};

        sample.createNewTable("customer", customerColumns, customerTypes, customerF);


        String orderColumns[] = {};
        String orderTypes[] = {};
        String orderF[] = {};

        sample.createNewTable("order", orderColumns, orderTypes, orderF);


        String providerColumns[] = {};
        String providerTypes[] = {};
        String providerF[] = {};

        sample.createNewTable("provider", providerColumns, providerTypes, providerF);


        String socketsColumns[] = {};
        String socketsTypes[] = {};
        String socketsF[] = {};

        sample.createNewTable("sockets", socketsColumns, socketsTypes, socketsF);


        String workshopColumns[] = {};
        String workshopTypes[] = {};
        String workshopF[] = {};

        sample.createNewTable("workshop", workshopColumns, workshopTypes, workshopF);


        String chargesAtColumns[] = {};
        String chargesAtTypes[] = {};
        String chargesAtF[] = {};

        sample.createNewTable("charges_at", chargesAtColumns, chargesAtTypes, chargesAtF);


        String repairsColumns[] = {};
        String repairsTypes[] = {};
        String repairsF[] = {};

        sample.createNewTable("repairs", repairsColumns, repairsTypes, repairsF);


        String requestsColumns[] = {};
        String requestsTypes[] = {};
        String requestsF[] = {};

        sample.createNewTable("requests", requestsColumns, requestsTypes, requestsF);


        String servesColumns[] = {};
        String servesTypes[] = {};
        String servesF[] = {};

        sample.createNewTable("serves", servesColumns, servesTypes, servesF);


        sample.close();

    }


    void Query01(){

    }

    void Query02(){

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
