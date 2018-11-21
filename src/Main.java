public class Main {
	public static void main(String[] args) {
		DatabaseAPI dbAPI = new DatabaseAPI();
		dbAPI.createNewDatabase("NewDB");
		dbAPI.connect();
		dbAPI.close();
	}
}
