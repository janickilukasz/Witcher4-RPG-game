package app.controller;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class WalkaController {

	@FXML
	private ImageView imgZawodnik1;

	@FXML
	private ImageView imgZawodnik2;

	@FXML
	private Label lblNazwa1;

	@FXML
	private Label lblPoziom1;

	@FXML
	private Label lblNazwa2;

	@FXML
	private Label lblPoziom2;

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

	String imie;
	int poziom1;
	int atak1;
	int obrona1;
	String bron1;
	int bronSila1;
	int zycie1;

	String nazwa;
	int poziom2;
	int atak2;
	int obrona2;
	String bron2;
	int bronSila2;
	int zycie2;
	Image img_potwor;

	public void initialize() {
		imie = PlanszaController.imie;
		poziom1 = PlanszaController.poziom;
		atak1 = PlanszaController.atak;
		obrona1 = PlanszaController.obrona;
		bron1 = PlanszaController.bron;
		bronSila1 = PlanszaController.bronSila;
		zycie1 = PlanszaController.zycie;

		nazwa = PlanszaController.stworki.get(PlanszaController.potworek).getNazwa();
		poziom2 = PlanszaController.stworki.get(PlanszaController.potworek).getPoziom();
		atak2 = PlanszaController.stworki.get(PlanszaController.potworek).getAtak();
		obrona2 = PlanszaController.stworki.get(PlanszaController.potworek).getObrona();
		bron2 = PlanszaController.stworki.get(PlanszaController.potworek).getBron();
		bronSila2 = PlanszaController.stworki.get(PlanszaController.potworek).getBronSila();
		zycie2 = PlanszaController.stworki.get(PlanszaController.potworek).getZycie();
		img_potwor = PlanszaController.stworki.get(PlanszaController.potworek).getImg_duzy();
		imgZawodnik2.setImage(img_potwor);

		statystyki();
	}

	private void statystyki() {
		lblNazwa1.setText("WiedŸmin " + imie);
		lblPoziom1.setText("poziom " + poziom1);
		lblAtak1.setText("" + atak1);
		lblObrona1.setText("" + obrona1);
		lblBron1.setText(bron1 + " (" + bronSila1 + ")");

		lblNazwa2.setText(nazwa);
		lblPoziom2.setText("poziom " + poziom2);
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

	@FXML
	void atakAction(MouseEvent event) {
		Random los = new Random();
		double mnoznik = 0.5 + los.nextDouble() / 2;
		int atakPkt = (int) Math.ceil((poziom1 * atak1 + bronSila1) * mnoznik);
		mnoznik = los.nextDouble();
		int obronaPkt = (int) Math.ceil(poziom2 * obrona2 * mnoznik);
		int roznicaPkt = Math.max(atakPkt-obronaPkt, 0);
		roznicaPkt = Math.min(roznicaPkt, zycie2);
		zycie2-=roznicaPkt;
		paskiZycia();
		String temp = txtRelacja.getText();
		txtRelacja.setText(imie + " atakuje i zadaje " + atakPkt + " obra¿eñ!!\n" + nazwa + " siê broni z obron¹ "
				+ obronaPkt + "\n" + nazwa + " traci "+roznicaPkt+" pkt. ¿ycia!\n"+ temp);
	}

	@FXML
	void atakMniejszyAction(MouseEvent event) {
		Random los = new Random();
		double mnoznik = los.nextDouble() / 2;
		int atakPkt = (int) Math.ceil((poziom1 * atak1 + bronSila1) * mnoznik);
		mnoznik = los.nextDouble();
		int obronaPkt = (int) Math.ceil(poziom2 * obrona2 * mnoznik);
		int roznicaPkt = Math.max(atakPkt-obronaPkt, 0);
		roznicaPkt = Math.min(roznicaPkt, zycie2);
		zycie2-=roznicaPkt;
		paskiZycia();
		String temp = txtRelacja.getText();
		txtRelacja.setText(imie + " atakuje i zadaje " + atakPkt + " obra¿eñ!!\n" + nazwa + " siê broni z obron¹ "
				+ obronaPkt + "\n" + nazwa + " traci "+roznicaPkt+" pkt. ¿ycia!\n"+ temp);
	}

	@FXML
	void ciosSpecjalnyAction(MouseEvent event) {

	}

	@FXML
	void obronaAction(MouseEvent event) {
		String temp = txtRelacja.getText();
		txtRelacja.setText(imie + " przechodzi do obrony.\n"+ temp);
	}

}
