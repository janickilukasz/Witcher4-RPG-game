package app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

	public void initialize() {
		lblNazwa1.setText("Wiedümin " + PlanszaController.imie);
		lblPoziom1.setText("poziom " + PlanszaController.poziom);
		lblAtak1.setText("" + PlanszaController.atak);
		lblObrona1.setText("" + PlanszaController.obrona);
		lblBron1.setText(PlanszaController.bron + " (" + PlanszaController.bronSila + ")");
		lblPkt1.setText("" + PlanszaController.zycie);

		lblNazwa2.setText(PlanszaController.stworki.get(PlanszaController.potworek).getNazwa());
		lblPoziom2.setText("poziom " + PlanszaController.stworki.get(PlanszaController.potworek).getPoziom());
		lblAtak2.setText("" + PlanszaController.stworki.get(PlanszaController.potworek).getAtak());
		lblObrona2.setText("" + PlanszaController.stworki.get(PlanszaController.potworek).getObrona());
		lblBron2.setText(PlanszaController.stworki.get(PlanszaController.potworek).getBron() + " (" + PlanszaController.stworki.get(PlanszaController.potworek).getBronSila() + ")");
		lblPkt2.setText("" + PlanszaController.stworki.get(PlanszaController.potworek).getZycie());
	}

	@FXML
	void atakAction(MouseEvent event) {

	}

	@FXML
	void atakMniejszyAction(MouseEvent event) {

	}

	@FXML
	void ciosSpecjalnyAction(MouseEvent event) {

	}

	@FXML
	void obronaAction(MouseEvent event) {

	}

}
