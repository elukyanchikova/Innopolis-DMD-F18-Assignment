package graphicalUI;

import database.DatabaseQueries;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.sql.ResultSet;

public class MainPage extends Application {

	@FXML
	DatePicker datePicker;
	@FXML
	Button generateDataBtn;
	@FXML
	FlowPane controls;

	Button[] queryButtons;

	DatabaseQueries queries;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		queries = new DatabaseQueries();

	}

	@FXML
	void generateData() {
		queries.createSample();
		queries.FillSample();
	}

	void addQueryButtons() {
		queryButtons = new Button[10];
		for (int i = 0; i < queryButtons.length; i++) {
			queryButtons[i] = new Button("Query " + (i + 1));
			final int j = i;
			queryButtons[i].setOnAction((event) -> showQuery(j + 1));
			controls.getChildren().add(queryButtons[i]);
		}
	}

	void showQuery(int n) {
		ResultSet resultSet;
		switch (n) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				break;
		}
	}

}
