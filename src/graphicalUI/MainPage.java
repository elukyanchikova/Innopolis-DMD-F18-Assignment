package graphicalUI;

import database.DatabaseQueries;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MainPage extends Application {

	@FXML
	DatePicker datePicker;
	@FXML
	Button generateDataBtn;
	@FXML
	FlowPane controls;
	@FXML
	TableView outputTable;

	Button[] queryButtons;

	DatabaseQueries queries;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		AnchorPane layout = null;
		try {
			layout = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
		} catch (IOException e) {
			System.err.println("Cannot load layout.");
			System.exit(-1);
		}

		if (layout == null) {
			System.err.println("Failed to load layout.");
			System.exit(-1);
		}

		Scene scene = new Scene(layout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	void generateData() {
		queries = new DatabaseQueries();
		queries.createSample();
		queries.FillSample();
		addQueryButtons();
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
		ResultSet resultSet = null;
		switch (n) {
			case 1:
				resultSet = queries.Query01();
				break;
			case 2:
//				resultSet = queries.Query02(getRequestedDateSeconds());
				break;
			case 3:
//				resultSet=queries.Query03(getRequestedDateSeconds());
				break;
			case 4:
				resultSet = queries.Query04(getRequestedDateSeconds());
				break;
			case 5:
				resultSet = queries.Query05(getRequestedDateSeconds());
				break;
			case 6:
//				resultSet=queries.Query06(getRequestedDateSeconds());
				break;
			case 7:
//				resultSet=queries.Query07();
				break;
			case 8:
//				resultSet=queries.Query08();
				break;
			case 9:
				resultSet = queries.Query09();
				break;
			case 10:
//				resultSet=queries.Query10();
				break;
		}

		assert resultSet != null;

	}

	void updateTable(ResultSet resultSet) {
		outputTable.getColumns().clear();

		try {
			for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
				final int j = i;
				TableColumn<ObservableList, String> column =
						new TableColumn(resultSet.getMetaData().getColumnName(j + 1));
				column.setCellValueFactory(param ->
						new SimpleStringProperty(param.getValue().get(j).toString()));

				outputTable.getColumns().add(column);
			}
		} catch (SQLException | ClassCastException e) {
			e.printStackTrace();
		}
	}

	long getRequestedDateSeconds() {
		return Timestamp.valueOf(datePicker.getValue().atStartOfDay()).getTime() / 1000;
	}
}
