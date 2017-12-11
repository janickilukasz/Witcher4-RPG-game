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
	final int nr_planszy = 1;

	ArrayList<Pole> plansza = new ArrayList<Pole>();

	PreparedStatement ps;
	Connection conn;
	DBConnector db;
	ResultSet rs;
	
	@FXML
	private GridPane gp;

	public void initialize() {
		// Inicjalizacja planszy
		
		// Pobieranie danych z bazy danych
		polacz();
		try {
			ps = conn.prepareStatement("SELECT * FROM pola WHERE plansza = ?");
			ps.setInt(1, nr_planszy);
			rs = ps.executeQuery();
			while(rs.next()){
				plansza.add(new Pole(rs.getInt("x"), rs.getInt("y"), rs.getInt("rodzaj"), rs.getInt("stwor")));
			}
		} catch (SQLException e) {
			System.out.println("B³¹d podczas preparowania zapytania!");
		}
		
		//Wyœwietlanie danych na planszy
		for(Pole i: plansza){
			Rectangle kwadrat = new Rectangle(60, 60, Color.GREEN);
			gp.add(kwadrat, i.getY(), i.getX());
			if(i.getRodzaj()==1){
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

	private void polacz() {
		db = new DBConnector();
		conn = db.connInit();
	}

	private void show() {
		// Czemu poni¿sza metoda powinna byæ przypisana jako statyczna?
		GridPane.setRowIndex(pajonk, x);
		GridPane.setColumnIndex(pajonk, y);
	}
	
	private int jakiRodzaj(int x, int y){
		for(Pole i:plansza){
			if(x==i.getX()&&y==i.getY()){
				return i.getRodzaj();
			}
		}
		return 0;
	}
	
	@FXML
	void keyPressAction(KeyEvent event) {
		
		
		
		if (event.getCode() == KeyCode.UP && x > 0 && jakiRodzaj(x-1,y)==0) {
			pajonk.setRotate(0);
			x--;
		}
		if (event.getCode() == KeyCode.DOWN && x < ile_pol-1 && jakiRodzaj(x+1,y)==0) {
			pajonk.setRotate(180);
			x++;
		}
		if (event.getCode() == KeyCode.LEFT && y > 0 && jakiRodzaj(x,y-1)==0) {
			pajonk.setRotate(270);
			y--;
		}
		if (event.getCode() == KeyCode.RIGHT && y < ile_pol-1 && jakiRodzaj(x,y+1)==0) {
			pajonk.setRotate(90);
			y++;
		}
		show();
	}
}