package app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	Connection conn;

	public DBConnector() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Nie zarejestrowano sterownika!");
		}
	}

	public Connection connInit() {
		String url = "jdbc:mysql://localhost:3306/wiedzmak";
		String user = "root";
		String pass = "9xvxpa";

		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.out.println("Nie mog� po��czy� si� z baz� danych");
		}
		return conn;
	}

}
