package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import app.database.DBConnector;
import app.model.Pole;
import app.model.Przeszkoda;
import app.model.Stwor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PlanszaController {

	Image wiedzmin_img;
	ImageView wiedzmin;
	static String imie = "Jasio";
	static int spryt = 1;
	static int atak = 2;
	static int obrona = 2;
	static String bron = "rêce";
	static int bronSila = 0;
	static int zycie = 8;
	static int x = 3;
	static int y = 4;
	static int ile_pol = 10;
	static int nr_planszyX = 0;
	static int nr_planszyY = 0;
	static int ile_plansz = 3;

	static int potworek = 0;

	ArrayList<Pole> plansza;
	static HashMap<Integer, Przeszkoda> przeszkody = new HashMap<Integer, Przeszkoda>();
	static HashMap<Integer, Stwor> stworki = new HashMap<Integer, Stwor>();

	PreparedStatement ps;
	Connection conn;
	DBConnector db;
	ResultSet rs;

	@FXML
	private GridPane gp;

	@FXML
	private Label lbl_Test;

	public void initialize() {
		wiedzmin = new ImageView();
		plansza = new ArrayList<Pole>();
		przeszkody_sql();
		nowa_plansza();
	}

	public void nowa_plansza() {
		gp.getChildren().clear();
		dane_z_sql();
		// Wyœwietlanie danych na planszy
		for (Pole i : plansza) {
			Image trawa = new Image("/app/view/trawa.jpg", 60, 60, true, false);
			ImageView iv_trawa = new ImageView(trawa);
			gp.add(iv_trawa, i.getY(), i.getX());

			// Dodawanie przeszkód
			if (i.getRodzaj() >= 100) {
				Image img = new Image("/app/view/" + przeszkody.get(i.getRodzaj()).getPlik(), 60, 60, true, false);
				ImageView iv = new ImageView(img);
				gp.add(iv, i.getY(), i.getX());
			}

			// Dodawanie stworków
			if (i.getStwor() > 0) {
				if (stworki.get(i.getId()) == null) {
					try {
						ps = conn.prepareStatement("SELECT * FROM stwory WHERE id = ?");
						ps.setInt(1, i.getStwor());
						rs = ps.executeQuery();
						rs.next();
						Image temp1 = new Image("/app/view/" + rs.getString("img_maly"), 60, 60, true, false);
						Image temp2 = new Image("/app/view/" + rs.getString("img_duzy"), 500, 500, true, false);
						stworki.put(i.getId(),
								new Stwor(rs.getString("nazwa"), temp1, temp2, rs.getInt("spryt"), rs.getInt("atak"),
										rs.getInt("obrona"), rs.getString("bron"), rs.getInt("bronsila"),
										rs.getInt("zycie")));
					} catch (SQLException e) {
						System.out.println("B³¹d przy selectowaniu stwora!");
					}

				}

				Image stwor = stworki.get(i.getId()).getImg_maly();
				ImageView potwor = new ImageView();
				potwor.setImage(stwor);
				gp.add(potwor, i.getY(), i.getX());
			}

			// Inicjalizacja postaci

		}
		showPostac("dol");
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
				plansza.add(new Pole(rs.getInt("id"), rs.getInt("x"), rs.getInt("y"), rs.getInt("rodzaj"),
						rs.getInt("stwor")));
			}
		} catch (SQLException e) {
			System.out.println("B³¹d podczas preparowania zapytania!");
		}
	}

	private void przeszkody_sql() {
		try {
			polacz();
			ps = conn.prepareStatement("SELECT * FROM przeszkody");
			rs = ps.executeQuery();
			while(rs.next()){
				przeszkody.put(rs.getInt("id"), new Przeszkoda(rs.getInt("id"), rs.getString("nazwa"), rs.getString("img")));
			}
		} catch (SQLException e) {
			System.out.println("B³¹d przy pobieraniu przeszkód z SQL");
		}
	}

	private void polacz() {
		db = new DBConnector();
		conn = db.connInit();
	}

	private void showPostac(String kierunek) {
		if (!kierunek.equals("")) {
			// Grafiki zaci¹gniête ze strony:
			// http://www.reinerstilesets.de/2d-grafiken/
			wiedzmin_img = new Image("/app/view/" + kierunek + ".png", 60, 60, true, false);
			wiedzmin.setImage(wiedzmin_img);
			gp.getChildren().remove(wiedzmin);
			gp.add(wiedzmin, y, x);
			// Czemu poni¿sza metoda powinna byæ przypisana jako statyczna?
			// GridPane.setRowIndex(wiedzmin, x);
			// GridPane.setColumnIndex(wiedzmin, y);
		}
	}

	private int jakiRodzaj(int x, int y) {
		for (Pole i : plansza) {
			if (x == i.getX() && y == i.getY()) {
				return i.getRodzaj();
			}
		}
		return 0;
	}

	private int jakiPotwor(int x, int y) {
		for (Pole i : plansza) {
			if (x == i.getX() && y == i.getY()) {
				return i.getStwor();
			}
		}
		return 0;
	}

	private int jakieId(int x, int y) {
		for (Pole i : plansza) {
			if (x == i.getX() && y == i.getY()) {
				return i.getId();
			}
		}
		return 0;
	}

	private void show(String plik, String tytul) {
		Stage stejdz = new Stage();
		Parent rodzic = null;
		try {
			rodzic = (Parent) FXMLLoader.load(getClass().getResource("/app/view/" + plik + ".fxml"));
		} catch (IOException e) {
			System.out.println("B³¹d przy odpalaniu widoku!");
		}
		Scene scenka = new Scene(rodzic);
		stejdz.setScene(scenka);
		stejdz.setTitle(tytul);
		stejdz.show();
	}

	@FXML
	void keyPressAction(KeyEvent event) {
		String kierunek = "";
		boolean walka = false;
		if (event.getCode() == KeyCode.UP) {
			// TUTAJ PONI¯EJ ZAMIAST FALSE TRZEBA DAÆ ZYCIE STWORKA
			if (x > 0 && jakiRodzaj(x - 1, y) < 100
					&& (jakiPotwor(x - 1, y) == 0 || stworki.get(jakieId(x - 1, y)).getZycie() == 0)) {
				x--;
			} else if (x == 0 && nr_planszyX > 0) {
				nr_planszyX--;
				nowa_plansza();
				x = ile_pol - 1;
			} else if (jakiPotwor(x - 1, y) > 0) {
				potworek = jakieId(x - 1, y);
				walka = true;
			}
			kierunek = "gora";
		}

		if (event.getCode() == KeyCode.DOWN) {
			if (x < ile_pol - 1 && jakiRodzaj(x + 1, y) < 100
					&& (jakiPotwor(x + 1, y) == 0 || stworki.get(jakieId(x + 1, y)).getZycie() == 0)) {
				x++;
			} else if (x == ile_pol - 1 && nr_planszyX < ile_plansz - 1) {
				nr_planszyX++;
				nowa_plansza();
				x = 0;
			} else if (jakiPotwor(x + 1, y) > 0) {
				potworek = jakieId(x + 1, y);
				walka = true;
			}
			kierunek = "dol";
		}

		if (event.getCode() == KeyCode.LEFT) {
			if (y > 0 && jakiRodzaj(x, y - 1) < 100
					&& (jakiPotwor(x, y - 1) == 0 || stworki.get(jakieId(x, y - 1)).getZycie() == 0)) {
				y--;
			} else if (y == 0 && nr_planszyY > 0) {
				nr_planszyY--;
				nowa_plansza();
				y = ile_pol - 1;
			} else if (jakiPotwor(x, y - 1) > 0) {
				potworek = jakieId(x, y - 1);
				walka = true;
			}
			kierunek = "lewo";
		}

		if (event.getCode() == KeyCode.RIGHT) {
			if (y < ile_pol - 1 && jakiRodzaj(x, y + 1) < 100
					&& (jakiPotwor(x, y + 1) == 0 || stworki.get(jakieId(x, y + 1)).getZycie() == 0)) {
				y++;
			} else if (y == ile_pol - 1 && nr_planszyY < ile_plansz - 1) {
				nr_planszyY++;
				nowa_plansza();
				y = 0;
			} else if (jakiPotwor(x, y + 1) > 0) {
				potworek = jakieId(x, y + 1);
				walka = true;
			}
			kierunek = "prawo";
		}

		if (walka) {
			lbl_Test.setText("MONSTER WYKRYTY!");
			show("WalkaView", "Walka!");
			((Node) (event.getSource())).getScene().getWindow().hide();
		}
		showPostac(kierunek);
	}
}