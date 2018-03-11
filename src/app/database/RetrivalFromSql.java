package app.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.model.Creature;
import app.model.Element;
import app.model.Land;
import app.model.Obstacle;

public class RetrivalFromSql {

	static Connection conn;
	static DBConnector db;

	private static void connect() {
		db = new DBConnector();
		conn = db.connInit();
	}

	public static ArrayList<Element> landRetrieve() {
		connect();
		PreparedStatement ps;
		ResultSet rs;
		List<Element> li = new ArrayList<Element>();
		try {
			ps = conn.prepareStatement("SELECT * FROM lands");
			rs = ps.executeQuery();
			while (rs.next()) {
				li.add(new Land(rs.getInt("id"), rs.getString("justname"), rs.getString("filename")));
			}
			return (ArrayList<Element>) li;
		} catch (SQLException e) {
			System.out.println("Error while retrieving lands!");
			return null;
		}

	}
	
	public static ArrayList<Element> obstacleRetrieve() {
		connect();
		PreparedStatement ps;
		ResultSet rs;
		List<Element> li = new ArrayList<Element>();
		try {
			ps = conn.prepareStatement("SELECT * FROM obstacles");
			rs = ps.executeQuery();
			while (rs.next()) {
				li.add(new Obstacle(rs.getInt("id"), rs.getString("justname"), rs.getString("filename")));
			}
			return (ArrayList<Element>) li;
		} catch (SQLException e) {
			System.out.println("Error while retrieving obstacles!");
			return null;
		}

	}
	
	public static ArrayList<Element> creatureRetrieve() {
		connect();
		PreparedStatement ps;
		ResultSet rs;
		List<Element> li = new ArrayList<Element>();
		try {
			ps = conn.prepareStatement("SELECT * FROM creatures");
			rs = ps.executeQuery();
			while (rs.next()) {
				li.add(new Creature(rs.getInt("id"), rs.getString("justname"), rs.getString("filename"), rs.getString("fileNameBig"), rs.getInt("smart"), rs.getInt("offence"), rs.getInt("defence"),
						rs.getString("weapon"), rs.getInt("weaponPower"), rs.getInt("life")));
			}
			return (ArrayList<Element>) li;
		} catch (SQLException e) {
			System.out.println("Error while retrieving creatures!");
			return null;
		}

	}
}
