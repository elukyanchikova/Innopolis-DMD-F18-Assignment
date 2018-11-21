package database;

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

}
