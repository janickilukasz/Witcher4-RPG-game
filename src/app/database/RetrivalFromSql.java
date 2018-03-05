package app.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import app.model.Land;
import app.model.Podloze;
import app.model.Pole;
import app.model.Przeszkoda;

public class RetrivalFromSql {

	static Connection conn;
	static DBConnector db;

	private static void connect() {
		db = new DBConnector();
		conn = db.connInit();
	}

	private static HashMap<Integer, Land> landRetrieve() {
		connect();
		PreparedStatement ps;
		ResultSet rs;
		HashMap<Integer, Land> hm = new HashMap<Integer, Land>();
		try {
			ps = conn.prepareStatement("SELECT * FROM lands");
			rs = ps.executeQuery();
			while (rs.next()) {
				hm.put(rs.getInt("id"), new Land(rs.getInt("id"), rs.getString("justname"), rs.getString("filename")));
			}
			return hm;
		} catch (SQLException e) {
			System.out.println("Error while retrieving lands!");
			return null;
		}

	}
}
