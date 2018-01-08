package app.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class WygranaController {

    @FXML
    private Label lbl_Nazwa;
	
    @FXML
    private Label lbl_zaZycie;

    @FXML
    private Label lbl_zaSpryt;

    @FXML
    private Label lbl_zaAtak;

    @FXML
    private Label lbl_zaObrone;

    @FXML
    private Label lbl_zaBron;

    @FXML
    private Label lbl_suma;
	
    public void initialize(){
    	lbl_Nazwa.setText("Pokona³eœ stwora o nazwie " + PlanszaController.stworki.get(PlanszaController.potworek).getNazwa().toUpperCase() + "!");
    	int zycie = WalkaController.zycie2nastarcie;
    	int spryt = WalkaController.spryt2;
    	int atak = WalkaController.atak2;
    	int obrona = WalkaController.obrona2;
    	int bron = WalkaController.bronSila2;
    	lbl_zaZycie.setText((zycie*WalkaController.zycieMulti)+"");
    	lbl_zaSpryt.setText((spryt*WalkaController.sprytMulti)+"");
    	lbl_zaAtak.setText((atak*WalkaController.atakMulti)+"");
    	lbl_zaObrone.setText((obrona*WalkaController.obronaMulti)+"");
    	lbl_zaBron.setText((bron*WalkaController.bronMulti)+"");
    	lbl_suma.setText((WalkaController.ileDosw(zycie,spryt,atak,obrona,bron))+"");
    }
    
	@FXML
	void okAction(MouseEvent event) {
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
