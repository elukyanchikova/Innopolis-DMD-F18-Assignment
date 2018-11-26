package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import entities.*;

public class DatabaseQueries {

    private DatabaseAPI sample;

    public void MainTest() {
        createSample();
        FillSample();
        sample.connect();

        Query01();
        //Query02(12425346);
        //Query03(12432655);
        Query04();
        Query05(132445234);
        //Query06(15432443);
        //Query07();
        //Query08();
        //Query09();
        //Query10();


        sample.close();

    }

    public void createSample() {
        sample = new DatabaseAPI();
        sample.createNewDatabase("sample");

        String carModelColumns[] = {"brand_name", "model_name", "socket_shape", "socket_size", "passenger_capacity", "luggage_capacity", "battery_capacity"};
        String carModelTypes[] = {"text", "text", "text", "text", "integer", "real", "real"};
        String carModelF[] = {"NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL"};
        String carModelOthers = "PRIMARY KEY (brand_name, model_name)\n";
        sample.createNewTable("car_model", carModelColumns, carModelTypes, carModelF, carModelOthers);

        String customerColumns[] = {"username", "customer_name", "customer_phone", "customer_email", "payment_info", "zip_code", "city", "country"};
        String customerTypes[] = {"text", "text", "text", "text", "text", "integer", "text", "text"};
        String customerF[] = {"PRIMARY KEY", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL"};
        sample.createNewTable("customer", customerColumns, customerTypes, customerF, "");

        String carColumns[] = {"car_plate", "brand_name", "model_name", "car_color", "car_latitude", "car_longitude", "car_rating", "crash_flag", "battery_percentage"};
        String carTypes[] = {"text", "text", "text", "text", "real", "real", "real", "integer", "real"};
        String carF[] = {"PRIMARY KEY", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL"};
        String carOthers = "FOREIGN KEY (brand_name) REFERENCES car_model (brand_name) \n FOREIGN KEY (model_name) REFERENCES car_model (model_name)\n";
        sample.createNewTable("car", carColumns, carTypes, carF, carOthers);

        String chargingStationColumns[] = {"UID", "station_latitude", "station_longitude", "electrical_power", "number_of_available_sockets", "charging_amount_price"};
        String chargingStationTypes[] = {"integer", "real", "real", "real", "integer", "real"};
        String chargingStationF[] = {"PRIMARY KEY", "NOT NULL", "NOT NULL", "", "NOT NULL", ""};
        sample.createNewTable("charging_station", chargingStationColumns, chargingStationTypes, chargingStationF, "");

        String workshopColumns[] = {"WID", "number_of_available_places", "zip_code", "city", "country"};
        String workshopTypes[] = {"integer", "integer", "integer", "text", "text"};
        String workshopF[] = {"PRIMARY KEY", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL"};
        sample.createNewTable("workshop", workshopColumns, workshopTypes, workshopF, "");

        String providerColumns[] = {"provider_id", "provider_name", "provider_phone", "payment_info", "zip_code", "city", "country"};
        String providerTypes[] = {"integer", "text", "text", "text", "integer", "text", "text"};
        String providerF[] = {"PRIMARY KEY", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL"};
        sample.createNewTable("provider", providerColumns, providerTypes, providerF, "");

        String carPartColumns[] = {"part_id", "part_name", "part_price", "part_manufacturer", "provider_id", "WID"};
        String carPartTypes[] = {"integer", "text", "real", "text", "integer", "integer"};
        String carPartF[] = {"PRIMARY KEY", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", ""};
        String carPartOthers = "FOREIGN KEY (provider_id) REFERENCES provider (provider_id) \n FOREIGN KEY (WID) REFERENCES workshop(WID)\n";
        sample.createNewTable("car_parts", carPartColumns, carPartTypes, carPartF, carPartOthers);

        String orderColumns[] = {"order_id", "order_status", "order_time", "A_latitude", "A_longitude", "B_latitude", "B_longitude", "number_of_adult_passengers", "need_babyseat", "luggage_volume", "customer_username"};
        String orderTypes[] = {"integer", "text", "integer", "real", "real", "real", "real", "integer", "integer", "real", "text"};
        String orderF[] = {"PRIMARY KEY", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL"};
        String orderOthers = "FOREIGN KEY (customer_username) REFERENCES customer (username)\n";
        sample.createNewTable("orders", orderColumns, orderTypes, orderF, orderOthers);

        String socketsColumns[] = {"UID", "socket_number", "socket_shape", "socket_size"};
        String socketsTypes[] = {"integer", "integer", "text", "text"};
        String socketsF[] = {"NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL"};
        String socketsOthers = "FOREIGN KEY (UID) REFERENCES charging_station(UID) \n PRIMARY KEY (UID, socket_number)\n";
        sample.createNewTable("sockets", socketsColumns, socketsTypes, socketsF, socketsOthers);

        String chargesAtColumns[] = {"UID", "car_plate", "time_start", "time_finish"};
        String chargesAtTypes[] = {"integer", "text", "integer", "integer"};
        String chargesAtF[] = {"NOT NULL", "NOT NULL", "NOT NULL", ""};
        String chargesAtOthers = "FOREIGN KEY (UID) REFERENCES charging_station(UID) \n FOREIGN KEY (car_plate) references car(car_plate) \n PRIMARY KEY (UID, car_plate, time_start)\n";
        sample.createNewTable("charges_at", chargesAtColumns, chargesAtTypes, chargesAtF, chargesAtOthers);

        String repairsColumns[] = {"WID", "car_plate", "time_start", "time_finish", "part_id"};
        String repairsTypes[] = {"integer", "text", "integer", "integer", "integer"};
        String repairsF[] = {"NOT NULL", "NOT NULL", "NOT NULL", "", "NOT NULL"};
        String repairsOthers = "FOREIGN KEY (WID) REFERENCES workshop(WID) \n FOREIGN KEY (car_plate) references car(car_plate) \n FOREIGN KEY (part_id) references car_parts(part_id) \n PRIMARY KEY (WID, car_plate, time_start)\n";
        sample.createNewTable("repairs", repairsColumns, repairsTypes, repairsF, repairsOthers);

        String requestsColumns[] = {"request_id", "part_name", "number_of_parts", "WID", "provider_id"};
        String requestsTypes[] = {"integer", "text", "integer", "integer", "integer"};
        String requestsF[] = {"PRIMARY KEY", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL"};
        String requestOthers = "FOREIGN KEY (provider_id) REFERENCES provider (provider_id) \n FOREIGN KEY (WID) REFERENCES workshop(WID)\n";
        sample.createNewTable("requests", requestsColumns, requestsTypes, requestsF, requestOthers);

        String servesColumns[] = {"order_id", "car_plate", "time_start", "time_finish"};
        String servesTypes[] = {"integer", "text", "integer", "integer"};
        String servesF[] = {"PRIMARY KEY", "NOT NULL", "NOT NULL", "NOT NULL"};
        String servesOthers = "FOREIGN KEY (order_id) references orders(order_id) \n FOREIGN KEY (car_plate) references car(car_plate)\n";
        sample.createNewTable("serves", servesColumns, servesTypes, servesF, servesOthers);

        String fitsColumns[] = {"part_id", "model_name", "brand_name"};
        String fitsTypes[] = {"integer", "text", "text"};
        String fitsF[] = {"NOT NULL", "NOT NULL", "NOT NULL"};
        String fitsOthers = "FOREIGN KEY (part_id) REFERENCES car_parts(part_id)\n FOREIGN KEY (brand_name) REFERENCES car_model (brand_name) \n FOREIGN KEY (model_name) REFERENCES car_model (model_name)\n";
        sample.createNewTable("fits", fitsColumns, fitsTypes, fitsF, fitsOthers);

        sample.close();

    }

    public void FillSample() {
        sample.connect();
        sample.clear();

        DataGenerator dataGenerator = new DataGenerator();
        GeneratedData metaData = dataGenerator.generateData(5, 10, 20, 2, 2, 2, 10, 24, 3, 12, 8, 21, new Date().getTime() - 4 * 1000 * 30 * 24 * 3600l);

        sample.fillTheCarModel(metaData.getModels());
        sample.fillTheCustomer(metaData.getCustomers());
        sample.fillTheCar(metaData.getCars());
        sample.fillTheChargingStation(metaData.getStations());
        sample.fillTheWorkshop(metaData.getWorkshops());
        sample.fillTheProvider(metaData.getProviders());
        sample.fillTheCarParts(metaData.getParts());
        sample.fillTheOrders(metaData.getOrders());
        sample.fillTheSockets(metaData.getSockets());
        sample.fillTheChargesAt(metaData.getChargesAt());
        sample.fillTheRepairs(metaData.getRepairs());
        sample.fillTheRequests(metaData.getRequests());
        sample.fillTheServes(metaData.getServes());
        sample.fillTheFits(metaData.getFits());
        sample.close();

        //use this method only ONCE ....
        //TODO:  wid in car_parts and repairs differs ...
    }


    void Query01() {
        try {
            //execute your query
            String SQLStatement = "SELECT * FROM car WHERE car_color = 'red' AND car_plate LIKE '%AN%'";
            ResultSet result = sample.executeQuery(SQLStatement);

            //look at the fields of result of your query and according to them create new table
            String Query1Columns[] = {"car_plate", "brand_name", "model_name", "car_color", "car_latitude", "car_longitude", "car_rating", "crash_flag", "battery_percentage"};
            String Query1Types[] = {"text", "text", "text", "text", "real", "real", "real", "integer", "real"};
            String Query1F[] = {"PRIMARY KEY", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL"};
            sample.createNewTable("Query1", Query1Columns, Query1Types, Query1F, "");

            //insert results to new table
            while (result.next()){
                String SQLStatementInsert = "INSERT INTO query1 (car_plate, brand_name, model_name, car_color, car_latitude, car_longitude, car_rating, crash_flag, battery_percentage)\n"
                        + "VALUES ('" + result.getString(1) + "', '" + result.getString(2)+ "', '" + result.getString(3)+ "', '" + result.getString(4) + "', "+ result.getFloat(5) + ", " + result.getFloat(6) +", "+ result.getFloat(7) + ", " + result.getInt(8) + ", "+ result.getFloat(9) + ")";
            sample.execute(SQLStatementInsert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void Query02(long requestedDate) {
        //try {
        Collection<ResultSet> result = new LinkedList<>();
        //Collection<ResultSet> result = new LinkedList<>();
        ResultSet resultSet;

        String QueryColumns[] = {"time_start", "time_finish", "sockets_occupied"};
        //TODO is the type of time "TEXT"?
        String QueryTypes[] = {"text", "text", "integer"};
        String QueryF[] = {"PRIMARY KEY", "PRIMARY KEY"};
        sample.createNewTable("Query1", QueryColumns, QueryTypes, QueryF, "");
        String timeFrom = "";
        String timeTo = "";
        for (int hour = 0; hour <= 23; hour++) {
            timeFrom = "strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+" + hour + " hour')";
            timeTo = "strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+" + hour + " hour')";
            String SQLStatement = "SELECT" + timeFrom + " AS time_start, " + timeTo + " AS time_finish, count(*) FROM charges_at WHERE " +
                    "strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+" + hour + " hour') <= time_start < strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+" + hour + "+1 hour') OR " +
                    "strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+" + hour + " hour') <= time_finish < strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+" + hour + "+1 hour')";
            result.add(sample.executeQuery(SQLStatement));
            //resultSet.
        }
//TODO вывести в таблицу
//        for (int i = 0; i <=23 ; i++) {
//            ResultSet res = result.
//        }
            /*//Object[] resultSet = result.toArray();
            for (int i = 0; i <result.size() ; i++) {
                while (res)
                    System.out.println(result.getString(1));
            }*/

        //} /*catch (SQLException e)        {
        // e.printStackTrace();
        //}*/

    }


    void Query03(long requestedDate) {
        //TODO FIX HREN' with time format
        long timeConst = 7 * 24 * 60 * 60 * 1000L;
        //колво машин в определенныйй момент времени/кол-во машин вообще *100
        //long requestedDate = date.getTime();
        String SQLStatement0 = "SELECT count(*) FROM car";

        String timeCond0 = "strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+" + 7 + " )" +
                "<= time_start" +
                " < strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+" + 10 + ")";
        String timeCondition = requestedDate + "<= time_start<" + (requestedDate + timeConst) +
                "AND " + timeCond0;

        //String timeCondition = "date("+ requestedDate +", 'unixepoch') <= date(time_start, 'unixepoch') < (date(requestedDate, 'unixepoch')+7)";
        String SQLStatement1 = "SELECT car_plates, count(*) AS order_num FROM serves WHERE" + timeCondition + " AND  order_num > 0";

        timeCond0 = "strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+" + 12 + " )" +
                "<= time_start" +
                " < strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+" + 14 + ")";
        timeCondition = requestedDate + "<= time_start<" + (requestedDate + timeConst) +
                "AND " + timeCond0;
        String SQLStatement2 = "SELECT car_plates, count(*) AS order_num FROM serves WHERE" + timeCondition + " AND  order_num > 0";

        timeCond0 = "strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+" + 17 + " )" +
                "<= time_start" +
                " < strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+" + 19 + ")";
        timeCondition = requestedDate + "<= time_start<" + (requestedDate + timeConst) +
                "AND " + timeCond0;
        String SQLStatement3 = "SELECT car_plates, count(*) AS order_num FROM serves WHERE" + timeCondition + " AND  order_num > 0";
        //TODO THIS IS PSEUDOCDE: we need to get the corresponding data from the sql query result and do som computations, after create a new table
//        int result_0 = Integer.parseInt((sample.executeQuery(SQLStatement0)).toString());
        //      int result_1 = Integer.parseInt((sample.executeQuery(SQLStatement1)).toString());
        //    int result_2 = Integer.parseInt((sample.executeQuery(SQLStatement2)).toString());
        //  int result_3 = Integer.parseInt((sample.executeQuery(SQLStatement3)).toString());
//
        //      int res_1 = 100 * result_1 / result_0;//morning
        //    int res_2 = 100 * result_2 / result_0;//afternoon
        //  int res_3 = 100 * result_3 / result_0;//evening
    }

    void Query04() {
        //find users with high activity (more than 16 orders within last month)
        try {
            long constant = 1000 * 60 * 60 * 24 * 30L;
            String SQLStatement = "SELECT customer_username, COUNT(*) number_of_orders FROM orders WHERE order_time >= " + Long.toString(new Date().getTime() - constant) + " GROUP BY customer_username ORDER BY number_of_orders";
            ResultSet result = sample.executeQuery(SQLStatement);

            //look at the fields of result of your query and according to them create new table
            String QueryColumns[] = {"customer_username", "number_of_orders"};
            String QueryTypes[] = {"text", "integer"};
            String QueryF[] = {"PRIMARY KEY", "NOT NULL"};
            sample.createNewTable("Query4", QueryColumns, QueryTypes, QueryF, "");

            while (result.next()) {
                String SQLStatementInsert = "INSERT INTO query4 (costumer_username, number_of_orders)"
                        + "VALUES ('" + result.getString(1) + "', " + result.getInt(2) + ")";
                sample.execute(SQLStatementInsert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void Query05(long requestedDate) {
        try {
            String SQLStatement1 = "SELECT avg((A_latitude-B_latitude)*(A_longitude-B_longitude)) AS avg_distance FROM orders WHERE date(order_time,'unixepoch') >= date(" + requestedDate + ",'unixepoch')";
            String SQLStatement2 = "SELECT avg(time_finish-time_start) AS avg_trip_time FROM serves WHERE date(time_start,'unixepoch') = date(" + requestedDate + ",'unixepoch')";
            ResultSet result1 = sample.executeQuery(SQLStatement1);
            ResultSet result2 = sample.executeQuery(SQLStatement2);

            String QueryColumns[] = {"avg_distance", "avg_trip_time"};
            String QueryTypes[] = {"real", "real"};
            String QueryF[] = {"PRIMARY KEY", "NOT NULL"};
            sample.createNewTable("Query5", QueryColumns, QueryTypes, QueryF, "");

            while (result1.next()) {
                String SQLStatementInsert1 = "INSERT INTO query5 (avg_distance, avg_trip_time)"
                        + "VALUES (" + result1.getFloat(1) + ", " + result2.getFloat(1) + ")";
                sample.execute(SQLStatementInsert1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //TODO DONE
    void Query06(long requestedDate) {
        //выбрать 3 самые популярнык локации фром и ту на три времени 8-10, 12-2, 5-7
        try {
            String QueryColumns[] = {"morning_loc_from", "morning_loc_to", "afternoon_loc_from", "afternoon_loc_to", "evening_loc_from", "evening_loc_to"};
            String QueryTypes[] = {"real", "real", "real", "real", "real", "real"};
            String QueryF[] = {"PRIMARY KEY", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL", "NOT NULL"};
            sample.createNewTable("Query6", QueryColumns, QueryTypes, QueryF, "");

            String timeConditions = "strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+7')" +
                    " <= order_time <" +
                    " strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+10')";
            String SQLStatement1_1 = "SELECT A_latitude*A_longitude AS hashed, count(*) AS timesOrdered , A_latitude, A_longitude FROM orders" +
                    "WHERE " + timeConditions +
                    "GROUP BY hashed ORDER BY timesOrdered DESC LIMIT 3";
            String SQLStatement1_2 = "SELECT B_latitude*B_longitude AS hashed, count(*) AS timesOrdered FROM orders, B_latitude, B_longitude " +
                    "WHERE " + timeConditions +
                    "GROUP BY hashed ORDER BY timesOrdered DESC LIMIT 3";

            ResultSet result1_1 = sample.executeQuery(SQLStatement1_1);
            ResultSet result1_2 = sample.executeQuery(SQLStatement1_2);
            while (result1_1.next()){
                String SQLStatementInsert = "INSERT INTO query4 ()"
                        + "VALUES ('" + result1_1.getString(1) + "')";
                sample.execute(SQLStatementInsert);
            }
                System.out.println(result1_1.getString(1));
            while (result1_2.next())
                System.out.println(result1_2.getString(2));

            timeConditions = "strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+12')" +
                    " <= order_start <" +
                    " strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+14')";
            String SQLStatement2_1 = "SELECT A_latitude*A_longitude AS hashed, count(*) AS timesOrdered , A_latitude, A_longitude FROM orders" +
                    "WHERE " + timeConditions +
                    "GROUP BY hashed ORDER BY timesOrdered DESC LIMIT 3";
            String SQLStatement2_2 = "SELECT B_latitude*B_longitude AS hashed, count(*) AS timesOrdered FROM orders, B_latitude, B_longitude " +
                    "WHERE " + timeConditions +
                    "GROUP BY hashed ORDER BY timesOrdered DESC LIMIT 3";

            ResultSet result2_1 = sample.executeQuery(SQLStatement2_1);
            ResultSet result2_2 = sample.executeQuery(SQLStatement2_2);
            while (result2_1.next())
                System.out.println(result2_1.getString(3));
            while (result2_2.next())
                System.out.println(result2_2.getString(4));


            timeConditions = "strftime('%s', date(" + requestedDate + ", 'unixepoch'), 'start of day', '+12')" +
                    " <= order_start <" +
                    " strftime('%s', date(" + requestedDate + " , 'unixepoch'), 'start of day', '+14')";
            String SQLStatement3_1 = "SELECT A_latitude*A_longitude AS hashed, count(*) AS timesOrdered , A_latitude, A_longitude FROM orders" +
                    "WHERE " + timeConditions +
                    "GROUP BY hashed ORDER BY timesOrdered DESC LIMIT 3";
            String SQLStatement3_2 = "SELECT B_latitude*B_longitude AS hashed, count(*) AS timesOrdered FROM orders, B_latitude, B_longitude " +
                    "WHERE " + timeConditions +
                    "GROUP BY hashed ORDER BY timesOrdered DESC LIMIT 3";

            ResultSet result3_1 = sample.executeQuery(SQLStatement3_1);
            ResultSet result3_2 = sample.executeQuery(SQLStatement3_2);
            while (result3_1.next())
                System.out.println(result3_1.getString(5));
            while (result3_2.next())
                System.out.println(result3_2.getString(6));

        /* If doesn't work, use this string as timeConditions "WHERE " + " \"strftime('%s', date(\" + requestedDate + \", 'unixepoch'), 'start of day', '+\" + 8')" +
                " <= order_start <" +
                " strftime('%s', date(\" + requestedDate + \", 'unixepoch'), 'start of day', '+\" +10')"*/

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO CHECK
    void Query07() {
        //выбрать 10% худших машиноу
        try {
            String SQLStatement0 = "SELECT count(*) FROM car";
            ResultSet result0 = sample.executeQuery(SQLStatement0);
            //TODO ОНО ТАК РАБОТАЕТ?
            int carNumber = result0.getInt(1) / 10;
            String SQLStatement1 = "SELECT car_plate, count(*) AS orderedTimes FROM serves GROUP BY car_plate ORDER BY orderedTimes ASC LIMIT" + carNumber;
            ResultSet result1 = sample.executeQuery(SQLStatement1);


            String QueryColumns[] = {"car_plate", "times_ordered"};
            String QueryTypes[] = {"string", "integer"};
            String QueryF[] = {"PRIMARY KEY", "PRIMARY KEY"};
            sample.createNewTable("Query7", QueryColumns, QueryTypes, QueryF, "");

            while (result1.next())
                System.out.println(result1.getString(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO DONE
    void Query08() {
        // для каждого юзера посчитать количество зарядок, которые за месяц прошли машины, обслужившие его в этом месяце
        try {
            String QueryColumns[] = {"username", "trips_amount"};
            String QueryTypes[] = {"string", "integer"};
            String QueryF[] = {"PRIMARY KEY", "NOT NULL"};
            sample.createNewTable("Query8", QueryColumns, QueryTypes, QueryF, "");
            Date date = new Date();
            long constant = 30 * 24 * 60 * 60 * 1000L;
            long timeCondition = date.getTime() - constant;
            String SQLStatement = "SELECT orders.customer_username, count(*) FROM (orders INNER JOIN serves ON orders.order_id = serves.order_id) " +
                    "INNER JOIN charges_at ON serves.car_plate = charges_at.car_plate WHERE order_time >= " + timeCondition;

            ResultSet result = sample.executeQuery(SQLStatement);
            while (result.next())
                System.out.println(result.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO inner todo
    void Query09() {
        try {
            String SQLStatement0 = "SELECT count(*) FROM car";
            int carNumber = sample.executeQuery(SQLStatement0).getInt(1);
            System.out.println(carNumber);

            //количество деталек для каждого провайдера, необходимое в течение недели

            Collection<String> res = new LinkedList<>();
            for (int wid = 0; wid < carNumber; wid++) {
                String SQLStatement = "SELECT WID, sum(number_of_parts) AS partsNumber FROM requests WHERE WID =" + wid + "GROUP BY WID ORDER BY partsNumber";
                res.add(SQLStatement);
            }
            //TODO посчитать количество недель и вывести необходимое количество запчастей в неделю

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    void Query10() {
        try {
            // cartype(1) с самой высокой стоимостью содержани в день(все дни с начала) зарядка+ремонт
            String SQLStatementRepairs = "SELECT (car.brand_name + ' ' + car.model_name) AS type, sum(price) as total_cost FROM  car INNER JOIN ( SELECT repairs.car_plate, SUM (car_parts.part_price) AS price FROM (repairs INNER JOIN car_parts ON repairs.part_id = car_parts.part_id)  ) ON repairs.car_plate = car.car_plate GROUP BY type ORDER BY total_cost";
            String SQLStatementCharges = "SELECT (car.brand_name + ' ' + car.model_name) AS type, sum(price) as total_cost FROM car INNER JOIN ( SELECT charges_at.car_plate, SUM (charging_station.charging_amount_price*(charges_at.time_finish - charges_at.time_start)/" + 3600000l + " ) as price FROM ( charges_at INNER JOIN charging_station ON charges_at.UID = charging_station.UID) ) ON car.car_plate = charges_at.car_plate GROUP BY type ORDER BY total_cost";
            ResultSet resultRepairs = sample.executeQuery(SQLStatementRepairs);
            ResultSet resultCharges = sample.executeQuery(SQLStatementCharges);

            //create table


            //fill table
            while (resultRepairs.next()) {

            }


            while (resultCharges.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
