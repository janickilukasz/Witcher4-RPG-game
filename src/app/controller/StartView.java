package app.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class StartView {
	
	public static String imie;

	@FXML
	private Button btn_start;

	@FXML
	private TextField tf_imie;

	@FXML
	void aktywacjaAction(KeyEvent event) {
		if (tf_imie.getText().length() > 0) {
			btn_start.setDisable(false);
		} else {
			btn_start.setDisable(true);
		}
	}

	@FXML
	void startAction(MouseEvent event) {
		imie = tf_imie.getText();
		show("PlanszaView", "WITCHER 4 : Dzika Zgon");
		((Node) (event.getSource())).getScene().getWindow().hide();
	}
	
	private void show(String plik, String tytul) {
		System.out.println("show");
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
}
