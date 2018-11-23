import database.DataFiller;
import database.DatabaseQueries;
import entities.Car;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

public class Main {
	public static void main(String[] args) throws IOException {
		/*FileInputStream input = new FileInputStream("SampleData/Cars-Fill.txt");
		DataFiller filler = new DataFiller(input);
		Collection<Car> cars = filler.parseCars();
		input.close();*/
		DatabaseQueries example = new DatabaseQueries();
		example.MainTest();
	}
}
