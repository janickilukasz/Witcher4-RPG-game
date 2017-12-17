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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class WalkaController {

    @FXML
    private AnchorPane ap;
	
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
	private Rectangle recSpec1;

	@FXML
	private Rectangle recSpec2;

	@FXML
	private ImageView ivAnimacja;
	
    @FXML
    private Button btnAtak;

    @FXML
    private Button btnAtakMaly;

    @FXML
    private Button btnObrona;

    @FXML
    private Button btnSpecial;


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
		System.out.println("initialize");
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
		paskiZycia();
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
		System.out.println("statystyki");
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
		
	}

	private void paskiZycia() {
		System.out.println("paski ¿ycia");
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

		recSpec1.setHeight(specjalny1 * 10);
		recSpec2.setHeight(specjalny2 * 10);

		recSpec1.setLayoutY(379 - recSpec1.getHeight());
		recSpec2.setLayoutY(379 - recSpec2.getHeight());
	}

	int atakPunkty(boolean mocno, int spryt, int atak, int bronSila) {
		System.out.println("atakPunkty");
		Random los = new Random();
		double mnoznik = (mocno ? 1 : 0) * 0.5 + los.nextDouble() / 2;
		int atakPkt = (int) Math.round((spryt * atak + bronSila) * mnoznik);
		System.out.println("Mno¿nik=" + mnoznik + ", spryt=" + spryt + ", atak=" + atak + ", bronSila=" + bronSila);
		return atakPkt;
	}

	int obronaPunkty(boolean wobronie, int spryt, int obrona) {
		System.out.println("obronaPunkty");
		Random los = new Random();
		double mnoznik = (wobronie ? 1 : 0) * 0.5 + los.nextDouble();
		int obronaPkt = (int) Math.round(spryt * obrona * mnoznik);
		System.out.println("Mno¿nik=" + mnoznik + ", spryt=" + spryt + ", obrona=" + obrona);
		return obronaPkt;
	}

	int atakSpecjalnyPunkty(int spryt, int atak, int bronSila, int specjalny) {
		System.out.println("atakSpecjalnyPunkty");
		Random los = new Random();
		double mnoznik = 0.5 * Math.pow(1.2, (double) specjalny) - 0.3 + (los.nextDouble() / 7) * specjalny;
		int atakPkt = (int) Math.round((spryt * atak + bronSila) * mnoznik);
		System.out.println("Mno¿nik=" + mnoznik + ", spryt=" + spryt + ", atak=" + atak + ", bronSila=" + bronSila);
		return atakPkt;
	}

	void atak(boolean mocno) {
		System.out.println("atak");
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
	}

	void atakSpecjalny() {
		System.out.println("atakSpecjalny");
		wobronie1 = false;
		int atakPkt = atakSpecjalnyPunkty(spryt1, atak1, bronSila1, specjalny1);
		int obronaPkt = obronaPunkty(wobronie2, spryt2, obrona2);
		int roznicaPkt = Math.max(atakPkt - obronaPkt, 0);
		roznicaPkt = Math.min(roznicaPkt, zycie2);
		zycie2 -= roznicaPkt;
		paskiZycia();
		String temp = txtRelacja.getText();
		txtRelacja.setText(imie + " atakuje i zadaje " + atakPkt + " obra¿eñ!!\n" + nazwa + " siê broni z obron¹ "
				+ obronaPkt + "\n" + nazwa + " traci " + roznicaPkt
				+ " pkt. ¿ycia!\n-----------------------------------------------------------\n" + temp);

	}

	void obrona() {
		System.out.println("obrona");
		// Nazwa tej metody jest myl¹ca, bo to jest po prostu ruch stwora
		Random los = new Random();
		double rzut = los.nextDouble();
		int atakPkt;
		boolean flaga = false;
		String dzialanie;
		if (rzut < 0.25) {
			dzialanie = "atak";
			atakPkt = atakPunkty(true, spryt2, atak2, bronSila2);
		} else if (rzut < 0.5) {
			dzialanie = "atak_maly";
			atakPkt = atakPunkty(false, spryt2, atak2, bronSila2);
			if (specjalny2 < 11) {
				specjalny2++;
			}
		} else if (rzut < 0.75) {
			dzialanie = "obrona";
			atakPkt = 0;
			flaga = true;
			wobronie2 = true;
			if (specjalny2 < 9) {
				specjalny2 += 3;
				;
			} else {
				specjalny2 = 11;
			}
		} else {
			dzialanie = "atak_special";
			atakPkt = atakSpecjalnyPunkty(spryt2, atak2, bronSila2, specjalny2);
			specjalny2 = 0;
		}
		System.out.println("Stwór zrobi³ " + dzialanie);
		int obronaPkt = obronaPunkty(wobronie1, spryt1, obrona1);
		int roznicaPkt = Math.max(atakPkt - obronaPkt, 0);
		roznicaPkt = Math.min(roznicaPkt, zycie1);
		zycie1 -= roznicaPkt;
		paskiZycia();
		String temp = txtRelacja.getText();
		if (flaga) {
			txtRelacja.setText(nazwa
					+ " przechodzi do obrony.\n-----------------------------------------------------------\n" + temp);

		} else {
			txtRelacja.setText(nazwa + " atakuje i zadaje " + atakPkt + " obra¿eñ!!\n" + imie + " siê broni z obron¹ "
					+ obronaPkt + ".\n" + imie + " traci " + roznicaPkt
					+ " pkt. ¿ycia!\n-----------------------------------------------------------\n" + temp);
		}
		anim(dzialanie, false);

	}

	@FXML
	void atakAction(MouseEvent event) {
		System.out.println("atakAction");
		atak(true);
		anim("atak", true);
	}

	@FXML
	void atakMniejszyAction(MouseEvent event) {
		System.out.println("atakMniejszyAction");
		atak(false);
		if (specjalny1 < 11) {
			specjalny1++;
		}
		anim("atak_maly", true);
	}

	@FXML
	void ciosSpecjalnyAction(MouseEvent event) {
		System.out.println("ciosSpecjalnyAction");
		atakSpecjalny();
		specjalny1 = 0;
		anim("atak_special", true);
	}

	@FXML
	void obronaAction(MouseEvent event) {
		System.out.println("obronaAction");
		wobronie1 = true;
		if (specjalny1 < 9) {
			specjalny1 += 3;
			;
		} else {
			specjalny1 = 11;
		}
		String temp = txtRelacja.getText();
		txtRelacja.setText(
				imie + " przechodzi do obrony.\n-----------------------------------------------------------\n" + temp);
		anim("obrona", true);

	}

	void anim(String co, boolean czyJa) {
		System.out.println("anim");
		btnAtak.setDisable(true);
		btnAtakMaly.setDisable(true);
		btnObrona.setDisable(true);
		btnSpecial.setDisable(true);
		String temp = "";
		double rotacja = 180.0;
		if (co.equals("obrona")) {
			temp = "obrona.png";
			rotacja = 0.0;
		} else if (co.equals("atak")) {
			temp = "atak.png";
		} else if (co.equals("atak_maly")) {
			temp = "atak_maly.png";
		} else if (co.equals("atak_special")) {
			temp = "atak_special.png";
		}
		double x_start = 50.0;
		double x_stop = 350.0;

		if (!czyJa) {
			x_start = 350.0;
			x_stop = 50.0;
		}

		Image img = new Image("/app/view/" + temp, 100, 100, true, false);
		ivAnimacja.setImage(img);

		FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), ivAnimacja);
		fadeTransition.setFromValue(1.0);
		fadeTransition.setToValue(0.0);
		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), ivAnimacja);
		translateTransition.setFromX(x_start);
		translateTransition.setToX(x_stop);

		RotateTransition rotateTransition = new RotateTransition(Duration.millis(500), ivAnimacja);
		rotateTransition.setFromAngle(0.0);
		rotateTransition.setToAngle(rotacja);

		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(500), ivAnimacja);
		scaleTransition.setFromX(0.8);
		scaleTransition.setFromY(0.8);
		scaleTransition.setToX(1.5);
		scaleTransition.setToY(1.5);

		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(fadeTransition, translateTransition, rotateTransition, scaleTransition);
		// Linijka ni¿ej pozwala na wykonanie kolejnej metody dopiero po
		// ukoñczeniu animacji
		parallelTransition.setOnFinished(e -> sprawdzenie(czyJa));
		parallelTransition.play();
	}

	void sprawdzenie(boolean czyAtak) {
		System.out.println("sprawdzenie"+zycie1+","+zycie2);
		if (zycie1 == 0) {
			koniecWalki(false);
		} else if (zycie2 == 0) {
			koniecWalki(true);
		} else if (czyAtak){
			obrona();
			
		} else {
		btnAtak.setDisable(false);
		btnAtakMaly.setDisable(false);
		btnObrona.setDisable(false);
		btnSpecial.setDisable(false);}
	}

	void koniecWalki(boolean czyZyje) {
		System.out.println("koniecWalki");
		if (czyZyje) {
			PlanszaController.stworki.get(PlanszaController.potworek).setZycie(0);
			Image kill = new Image("/app/view/kill.png", 60, 60, true, false);
			PlanszaController.stworki.get(PlanszaController.potworek).setImg_maly(kill);
			PlanszaController.zycie = zycie1;
			show("Wygrana", "Zwyciêstwo!");
		} else {
			show("GameOver", "GAME OVER");
		}

		ap.getScene().getWindow().hide();
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
