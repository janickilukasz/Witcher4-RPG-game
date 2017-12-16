package app.controller;

import java.io.IOException;
import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class WalkaController {

	@FXML
	private ImageView imgZawodnik1;

	@FXML
	private ImageView imgZawodnik2;

	@FXML
	private Label lblNazwa1;

	@FXML
	private Label lblSpryt1;

	@FXML
	private Label lblNazwa2;

	@FXML
	private Label lblSpryt2;

	@FXML
	private Label lblAtak1;

	@FXML
	private Label lblObrona1;

	@FXML
	private Label lblBron1;

	@FXML
	private Label lblAtak2;

	@FXML
	private Label lblObrona2;

	@FXML
	private Label lblBron2;

	@FXML
	private Rectangle recZycie1;

	@FXML
	private Rectangle recZycie2;

	@FXML
	private Label lblPkt1;

	@FXML
	private Label lblPkt2;

	@FXML
	private TextArea txtRelacja;

	@FXML
	private ImageView ivAnimacja;

	MouseEvent myszkoruch;

	String imie;
	int spryt1;
	int atak1;
	int obrona1;
	String bron1;
	int bronSila1;
	int zycie1;

	String nazwa;
	int spryt2;
	int atak2;
	int obrona2;
	String bron2;
	int bronSila2;
	int zycie2;
	Image img_potwor;

	int specjalny1 = 0;
	int specjalny2 = 0;

	boolean wobronie1 = false;
	boolean wobronie2 = false;

	public void initialize() {
		imie = PlanszaController.imie;
		spryt1 = PlanszaController.spryt;
		atak1 = PlanszaController.atak;
		obrona1 = PlanszaController.obrona;
		bron1 = PlanszaController.bron;
		bronSila1 = PlanszaController.bronSila;
		zycie1 = PlanszaController.zycie;

		nazwa = PlanszaController.stworki.get(PlanszaController.potworek).getNazwa();
		spryt2 = PlanszaController.stworki.get(PlanszaController.potworek).getSpryt();
		atak2 = PlanszaController.stworki.get(PlanszaController.potworek).getAtak();
		obrona2 = PlanszaController.stworki.get(PlanszaController.potworek).getObrona();
		bron2 = PlanszaController.stworki.get(PlanszaController.potworek).getBron();
		bronSila2 = PlanszaController.stworki.get(PlanszaController.potworek).getBronSila();
		zycie2 = PlanszaController.stworki.get(PlanszaController.potworek).getZycie();
		img_potwor = PlanszaController.stworki.get(PlanszaController.potworek).getImg_duzy();
		imgZawodnik2.setImage(img_potwor);

		statystyki();
		if (spryt2 > spryt1) {
			txtRelacja.setText(
					"Stwór o nazwie " + nazwa.toUpperCase() + " jest sprytniejszy od Ciebie i to on zaczyna walkê!");
			obrona();
		} else if (spryt2 == spryt1) {
			Random rnd = new Random();
			double los = rnd.nextDouble();
			if (los > 0.5) {
				txtRelacja.setText("Stwór o nazwie " + nazwa.toUpperCase()
						+ " jest sprytniejszy od Ciebie i to on zaczyna walkê!");
				obrona();
			} else {
				txtRelacja.setText("Jesteœ sprytniejszy od stwora o nazwie " + nazwa.toUpperCase()
						+ ", wiêc to Ty zaczynasz walkê!");
			}
		} else {
			txtRelacja.setText(
					"Jesteœ sprytniejszy od stwora o nazwie " + nazwa.toUpperCase() + ", wiêc to Ty zaczynasz walkê!");
		}
	}

	private void statystyki() {
		lblNazwa1.setText("WiedŸmin " + imie);
		lblSpryt1.setText("" + spryt1);
		lblAtak1.setText("" + atak1);
		lblObrona1.setText("" + obrona1);
		lblBron1.setText(bron1 + " (" + bronSila1 + ")");

		lblNazwa2.setText(nazwa);
		lblSpryt2.setText("" + spryt2);
		lblAtak2.setText("" + atak2);
		lblObrona2.setText("" + obrona2);
		lblBron2.setText(bron2 + " (" + bronSila2 + ")");
		paskiZycia();
	}

	private void paskiZycia() {
		lblPkt1.setText("" + zycie1);
		lblPkt2.setText("" + zycie2);
		lblPkt1.setLayoutX(zycie1 + 20);
		lblPkt2.setLayoutX(586 - zycie2 - 20);
		recZycie1.setWidth(zycie1);
		recZycie2.setWidth(zycie2);
		recZycie2.setLayoutX(586 - zycie2);
		int g1 = (int) Math.round(255 * (zycie1 / 210.0));
		int g2 = (int) Math.round(255 * (zycie2 / 210.0));
		recZycie1.setFill(Color.rgb(255, g1, 0));
		recZycie2.setFill(Color.rgb(255, g2, 0));
	}

	int atakPunkty(boolean mocno, int poziom, int atak, int bronSila) {
		Random los = new Random();
		double mnoznik = (mocno ? 1 : 0) * 0.5 + los.nextDouble() / 2;
		int atakPkt = (int) Math.round((poziom * atak + bronSila) * mnoznik);
		System.out.println("Mno¿nik=" + mnoznik + ", poziom=" + poziom + ", atak=" + atak + ", bronSila=" + bronSila);
		return atakPkt;
	}

	int obronaPunkty(boolean wobronie, int poziom, int obrona) {
		Random los = new Random();
		double mnoznik = (wobronie ? 1 : 0) * 0.5 + los.nextDouble();
		int obronaPkt = (int) Math.round(poziom * obrona * mnoznik);
		System.out.println("Mno¿nik=" + mnoznik + ", poziom=" + poziom + ", obrona=" + obrona);
		return obronaPkt;
	}

	void atak(boolean mocno) {
		wobronie1 = false;
		int atakPkt = atakPunkty(mocno, spryt1, atak1, bronSila1);
		int obronaPkt = obronaPunkty(wobronie2, spryt2, obrona2);
		int roznicaPkt = Math.max(atakPkt - obronaPkt, 0);
		roznicaPkt = Math.min(roznicaPkt, zycie2);
		zycie2 -= roznicaPkt;
		paskiZycia();
		String temp = txtRelacja.getText();
		txtRelacja.setText(imie + " atakuje i zadaje " + atakPkt + " obra¿eñ!!\n" + nazwa + " siê broni z obron¹ "
				+ obronaPkt + "\n" + nazwa + " traci " + roznicaPkt
				+ " pkt. ¿ycia!\n-----------------------------------------------------------\n" + temp);
		if (zycie2 == 0) {
			koniecWalki(true);
		}
	}

	void obrona() {
		// Na razie potwory zawsze atakuj¹ mocno (poni¿ej wartoœæ true) i nigdy
		// nie przechodz¹ do obrony
		int atakPkt = atakPunkty(true, spryt2, atak2, bronSila2);
		int obronaPkt = obronaPunkty(wobronie1, spryt1, obrona1);
		int roznicaPkt = Math.max(atakPkt - obronaPkt, 0);
		roznicaPkt = Math.min(roznicaPkt, zycie1);
		zycie1 -= roznicaPkt;
		paskiZycia();
		String temp = txtRelacja.getText();
		txtRelacja.setText(nazwa + " atakuje i zadaje " + atakPkt + " obra¿eñ!!\n" + imie + " siê broni z obron¹ "
				+ obronaPkt + ".\n" + imie + " traci " + roznicaPkt
				+ " pkt. ¿ycia!\n-----------------------------------------------------------\n" + temp);

		if (zycie1 == 0) {
			koniecWalki(false);
		}
	}

	@FXML
	void atakAction(MouseEvent event) {
		myszkoruch = event;
		atak(true);
		anim("atak", true);
	}

	@FXML
	void atakMniejszyAction(MouseEvent event) {
		myszkoruch = event;
		atak(false);
		specjalny1++;
		anim("atak_maly", true);
	}

	@FXML
	void ciosSpecjalnyAction(MouseEvent event) {
		myszkoruch = event;
		specjalny1 = 0;
		obrona();
	}

	@FXML
	void obronaAction(MouseEvent event) {
		myszkoruch = event;
		wobronie1 = true;
		String temp = txtRelacja.getText();
		txtRelacja.setText(
				imie + " przechodzi do obrony.\n-----------------------------------------------------------\n" + temp);
		anim("obrona", true);

	}

	void anim(String co, boolean czyJa) {

		String temp = "";
		double rotacja = 180.0;
		if (co.equals("obrona")) {
			temp = "obrona.png";
			rotacja = 0.0;
		} else if (co.equals("atak")) {
			temp = "atak.png";
		} else if (co.equals("atak_maly")) {
			temp = "atak_maly.png";
		}

		Image img = new Image("/app/view/" + temp, 100, 100, true, false);
		ivAnimacja.setImage(img);

		FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), ivAnimacja);
		fadeTransition.setFromValue(1.0);
		fadeTransition.setToValue(0.0);
		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), ivAnimacja);
		translateTransition.setFromX(50);
		translateTransition.setToX(350);
		
		RotateTransition rotateTransition = new
		RotateTransition(Duration.millis(500), ivAnimacja);
		rotateTransition.setByAngle(rotacja);
		
		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(500), ivAnimacja);
		scaleTransition.setFromX(0.8);
		scaleTransition.setFromY(0.8);
		scaleTransition.setToX(1.5);
		scaleTransition.setToY(1.5);

		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(fadeTransition, translateTransition, rotateTransition, scaleTransition);
		parallelTransition.setOnFinished(e -> obrona());
		parallelTransition.play();
	}

	void koniecWalki(boolean czyZyje) {
		if (czyZyje) {
			Alert loginError = new Alert(AlertType.ERROR);
			loginError.setTitle("WYGRANA!");
			loginError.setHeaderText("Pokona³eœ stwora!");
			loginError.setContentText("Pokona³eœ stwora o nazwie " + nazwa.toUpperCase() + "!");
			PlanszaController.stworki.get(PlanszaController.potworek).setZycie(0);
			Image kill = new Image("/app/view/kill.png", 60, 60, true, false);
			PlanszaController.stworki.get(PlanszaController.potworek).setImg_maly(kill);
			show("PlanszaView", "WITCHER 4 : Dzika Zgon");
			((Node) (myszkoruch.getSource())).getScene().getWindow().hide();
		} else {
			Alert loginError = new Alert(AlertType.WARNING);
			loginError.setTitle("GAME OVER");
			loginError.setHeaderText("Zosta³eœ ubity!");
			loginError.setContentText("Pokona³ Ciê stwór o nazwie " + nazwa.toUpperCase());
			((Node) (myszkoruch.getSource())).getScene().getWindow().hide();
			loginError.showAndWait();
		}
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

}
