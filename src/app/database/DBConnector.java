package app.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

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
		String pass = "";
		File f = new File("password.txt");
		try {
			Scanner odczyt = new Scanner(f);
			pass = odczyt.nextLine();
			odczyt.close();
		} catch (FileNotFoundException e1) {
			System.out.println("B��dny odczyt z pliku password!");
		}
		
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.out.println("Nie mog� po��czy� si� z baz� danych");
		}
		return conn;
	}

}
