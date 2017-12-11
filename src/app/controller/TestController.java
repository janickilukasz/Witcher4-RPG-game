package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.database.DBConnector;
import app.model.Pole;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TestController {

	ImageView pajonk;
	int x = 1;
	int y = 1;
	int ile_pol = 10;
	int nr_planszyX = 0;
	int nr_planszyY = 0;
	int ile_plansz = 2;

	ArrayList<Pole> plansza = new ArrayList<Pole>();

	PreparedStatement ps;
	Connection conn;
	DBConnector db;
	ResultSet rs;

	@FXML
	private GridPane gp;

	private void polacz() {
		db = new DBConnector();
		conn = db.connInit();
	}

	private void dane_z_sql() {
		polacz();

		// Pobieranie danych z bazy danych
		try {
			ps = conn.prepareStatement("SELECT * FROM pola WHERE planszax = ? and planszay = ?");
			ps.setInt(1, nr_planszyX);
			ps.setInt(2, nr_planszyY);
			rs = ps.executeQuery();
			plansza.clear();
			while (rs.next()) {
				plansza.add(new Pole(rs.getInt("x"), rs.getInt("y"), rs.getInt("rodzaj"), rs.getInt("stwor")));
			}
		} catch (SQLException e) {
			System.out.println("B³¹d podczas preparowania zapytania!");
		}
	}
	
	public void nowa_plansza() {
		gp.getChildren().clear();
		dane_z_sql();
		// Wyœwietlanie danych na planszy
		for (Pole i : plansza) {
			Rectangle kwadrat = new Rectangle(60, 60, Color.GREEN);
			gp.add(kwadrat, i.getY(), i.getX());
			if (i.getRodzaj() == 1) {
				kwadrat.setFill(Color.BLACK);
			}
		}
		
		// Inicjalizacja paj¹czka
		Image test = new Image("/app/view/pajak.png", 60, 60, true, false);
		pajonk = new ImageView();
		pajonk.setImage(test);
		gp.add(pajonk, y, x);
		show();
	}

	public void initialize() {
		nowa_plansza();
	}

	private void show() {
		// Czemu poni¿sza metoda powinna byæ przypisana jako statyczna?
		GridPane.setRowIndex(pajonk, x);
		GridPane.setColumnIndex(pajonk, y);
	}

	private int jakiRodzaj(int x, int y) {
		for (Pole i : plansza) {
			if (x == i.getX() && y == i.getY()) {
				return i.getRodzaj();
			}
		}
		return 0;
	}

	@FXML
	void keyPressAction(KeyEvent event) {

		if (event.getCode() == KeyCode.UP && x > 0 && jakiRodzaj(x - 1, y) == 0) {
			pajonk.setRotate(0);
			x--;
		}
		if (event.getCode() == KeyCode.DOWN && x < ile_pol - 1 && jakiRodzaj(x + 1, y) == 0) {
			pajonk.setRotate(180);
			x++;
		}
		if (event.getCode() == KeyCode.LEFT && y > 0 && jakiRodzaj(x, y - 1) == 0) {
			pajonk.setRotate(270);
			y--;
		}
		
		
//Zrobione tylko dla RIGHT, trzeba jeszcze zrobiæ pozosta³e.
		
		if (event.getCode() == KeyCode.RIGHT) {
			if (y < ile_pol - 1 && jakiRodzaj(x, y + 1) == 0) {
				y++;
			} else if (y == ile_pol - 1 && nr_planszyY < ile_plansz - 1) {
				nr_planszyY++;
				nowa_plansza();
				y = 0;
			}
			pajonk.setRotate(90);
		}
		show();
	}
}