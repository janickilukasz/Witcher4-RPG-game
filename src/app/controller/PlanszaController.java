package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import app.database.DBConnector;
import app.model.Podloze;
import app.model.Pole;
import app.model.Przeszkoda;
import app.model.Stwor;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PlanszaController {

	Image wiedzmin_img;
	ImageView wiedzmin;
	static String imie = StartView.imie;
	static int spryt = 1;
	static int atak = 2;
	static int obrona = 2;
	static String bron = "rêce";
	static int bronSila = 0;
	// Maksymalne ¿ycie to 210 pkt!
	static int zycie = 8;
	// wspolrzedna x na której jest wiedzmin
	static int x = 3;
	// wspolrzedna y na której jest wiedzmin
	static int y = 4;
	// rozmiar planszy
	static int ile_pol = 10;
	// wspolrzedna x pokazywanej planszy
	static int nr_planszyX = 0;
	// wspolrzedna y pokazywanej planszy
	static int nr_planszyY = 0;
	// rozmiar ca³ego œwiata
	static int ile_plansz = 3;

	// zmienna, która przekazuje numer potworka do widoku "Walka"
	static int potworek = 0;

	ArrayList<Pole> plansza;
	static HashMap<Integer, Podloze> podloza = new HashMap<Integer, Podloze>();
	static HashMap<Integer, Przeszkoda> przeszkody = new HashMap<Integer, Przeszkoda>();
	static HashMap<Integer, Stwor> stworki = new HashMap<Integer, Stwor>();

	PreparedStatement ps;
	Connection conn;
	DBConnector db;
	ResultSet rs;

	@FXML
	private ImageView iv_postac;

	@FXML
	private Label lbl_imie;

	@FXML
	private Rectangle recZycie;

	@FXML
	private Label lblZycie;

	@FXML
	private GridPane gp;

	@FXML
	private Label lbl_Atak;

	@FXML
	private Label lbl_Obrona;

	@FXML
	private Label lbl_Spryt;

	@FXML
	private Label lbl_Bron;

	@FXML
	private TextArea ta_info;

	@FXML
	private TextArea ta_stwor;

	public void initialize() {
		wiedzmin = new ImageView();
		plansza = new ArrayList<Pole>();
		iv_postac.setImage(new Image("/app/view/wiedzmak.png", 160, 180, true, false));
		lbl_imie.setText("WiedŸmak " + imie.toUpperCase());
		pokaz_statystyki();
		podloza_sql();
		przeszkody_sql();
		nowa_plansza();
	}

	public void pokaz_statystyki() {
		lbl_Atak.setText("ATAK: " + atak);
		lbl_Obrona.setText("OBRONA: " + obrona);
		lbl_Spryt.setText("SPRYT: " + spryt);
		lbl_Bron.setText("BROÑ: " + bron + "(" + bronSila + ")");
		recZycie.setWidth((int) 140 * zycie / 210);
		int g = (int) Math.round(255 * (zycie / 210.0));
		recZycie.setFill(Color.rgb(255, g, 0));
		lblZycie.setText("" + zycie);
		lblZycie.setLayoutX((int) 140 * zycie / 210 + 20);
	}

	public void nowa_plansza() {
		gp.getChildren().clear();
		dane_z_sql();
		// Wyœwietlanie danych na planszy
		for (Pole i : plansza) {
			Image pod = new Image("/app/view/" + podloza.get(i.getPodloze()).getPlik(), 60, 60, true, false);
			ImageView iv_pod = new ImageView(pod);
			iv_pod.setRotate(podloza.get(i.getPodloze()).getRotacja());
			gp.add(iv_pod, i.getY(), i.getX());

			// Dodawanie przeszkód
			if (i.getRodzaj() > 0) {
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
				// Dodawanie handlerów do pokazywania info na temat stworków
				EventHandler<MouseEvent> in = new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						Stwor st = stworki.get(i.getId());

						String n = st.getNazwa();
						String temp = n.toUpperCase() + "\nstwór ubit";
						if (st.getZycie() > 0) {
							String a = "?";
							String o = "?";
							String s = "?";
							String bs = "?";
							String z = "?";
							if (spryt >= stworki.get(i.getId()).getSpryt()) {
								a = "" + st.getAtak();
								o = "" + st.getObrona();
								s = "" + st.getSpryt();
								bs = "" + st.getBronSila();
								z = "" + st.getZycie();
							}
							temp = n.toUpperCase() + "\nA: " + a + "\tO: " + o + "\nS: " + s + "\tB: " + bs + "\n¯: "
									+ z;
						}
						ta_stwor.setText(temp);
						ta_stwor.setLayoutX(potwor.getLayoutX() + 250);
						ta_stwor.setLayoutY(potwor.getLayoutY() + 50);
						ta_stwor.setVisible(true);
					}
				};
				EventHandler<MouseEvent> out = new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						ta_stwor.setVisible(false);
					}
				};
				potwor.addEventHandler(MouseEvent.MOUSE_ENTERED, in);
				potwor.addEventHandler(MouseEvent.MOUSE_EXITED, out);

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
				plansza.add(new Pole(rs.getInt("id"), rs.getInt("x"), rs.getInt("y"), rs.getInt("podloze"),
						rs.getInt("rodzaj"), rs.getInt("stwor")));
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
			while (rs.next()) {
				przeszkody.put(rs.getInt("id"),
						new Przeszkoda(rs.getInt("id"), rs.getString("nazwa"), rs.getString("img")));
			}
		} catch (SQLException e) {
			System.out.println("B³¹d przy pobieraniu przeszkód z SQL");
		}
	}

	private void podloza_sql() {
		try {
			polacz();
			ps = conn.prepareStatement("SELECT * FROM podloza");
			rs = ps.executeQuery();
			while (rs.next()) {
				podloza.put(rs.getInt("id"),
						new Podloze(rs.getInt("id"), rs.getString("nazwa"), rs.getString("img"), rs.getInt("rotacja")));
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

	// Metoda zwraca numer przeszkody
	private int jakiRodzaj(int x, int y) {
		for (Pole i : plansza) {
			if (x == i.getX() && y == i.getY()) {
				return i.getRodzaj();
			}
		}
		return 0;
	}

	// Metoda zwraca numer potworka
	private int jakiPotwor(int x, int y) {
		for (Pole i : plansza) {
			if (x == i.getX() && y == i.getY()) {
				return i.getStwor();
			}
		}
		return 0;
	}

	// Metoda zwraca id danego pola (co jest jednoczeœnie kluczem potwora na
	// liœcie potworów)
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
		ta_info.setVisible(false);
		ta_stwor.setVisible(false);
		String kierunek = "";
		boolean walka = false;
		if (event.getCode() == KeyCode.UP) {
			if (x > 0 && jakiRodzaj(x - 1, y) == 0
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
			if (x < ile_pol - 1 && jakiRodzaj(x + 1, y) == 0
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
			if (y > 0 && jakiRodzaj(x, y - 1) == 0
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
			if (y < ile_pol - 1 && jakiRodzaj(x, y + 1) == 0
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
			show("WalkaView", "Walka!");
			((Node) (event.getSource())).getScene().getWindow().hide();
		}
		showPostac(kierunek);
	}

	@FXML
	void atakOnAction(MouseEvent event) {
		instrukcje(lbl_Atak, "ATAK odpowiedzialny jest za liczbê zadanych pkt obra¿eñ podczas walki");
	}

	@FXML
	void atakOffAction(MouseEvent event) {
		ta_info.setVisible(false);
	}

	@FXML
	void obronaOnAction(MouseEvent event) {
		instrukcje(lbl_Obrona, "OBRONA odpowiedzialna jest za liczbê pkt obrony podczas walki");
	}

	@FXML
	void obronaOffAction(MouseEvent event) {
		ta_info.setVisible(false);
	}

	@FXML
	void sprytOnAction(MouseEvent event) {
		instrukcje(lbl_Spryt, "SPRYT ma znaczenie podczas ataku oraz pozwala na rozpoznanie przeciwnika");
	}

	@FXML
	void sprytOffAction(MouseEvent event) {
		ta_info.setVisible(false);
	}

	@FXML
	void bronOnAction(MouseEvent event) {
		instrukcje(lbl_Bron, "Si³a noszonej broni pozwala zadaæ dodatkowe obra¿enia podczas walki");
	}

	@FXML
	void bronOffAction(MouseEvent event) {
		ta_info.setVisible(false);
	}

	void instrukcje(Label lbl, String tekst) {
		ta_info.setLayoutX(lbl.getLayoutX() + 30);
		ta_info.setLayoutY(lbl.getLayoutY() + 30);
		ta_info.setText(tekst);
		ta_info.setVisible(true);
	}

}