package app.controller;

import java.io.File;

import app.model.Podloze;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class EdytorController {

	@FXML
	private GridPane gpMain;

	@FXML
	private Button btnLands;

	@FXML
	private Button btnObstacles;

	@FXML
	private Button btnCreatures;

	@FXML
	private GridPane gpElements;

	public void initialize() {

		Image test = new Image("img/land_trawa.jpg", 60, 60, true, false);
		ImageView iv;
		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				iv = new ImageView(test);
				gpMain.add(iv, i, j);
				iv.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
					System.out.println("Row:" + GridPane.getRowIndex((Node) e.getSource()) + ", Column:"
							+ GridPane.getColumnIndex((Node) e.getSource()));
				});
			}
		}
		
	}

	private void fillLand(){
		final File folder = new File("./src/img/");
		int columnGp = 0;
		int rowGp = 0;
		for (final File fileEntry : folder.listFiles()) {
			String fileName = fileEntry.getName();
			if (fileEntry.isFile() && fileName.matches("land.*")) {
				String justName = fileName.substring(fileName.indexOf('_')+1, fileName.indexOf('.'));
				Podloze land = new Podloze(justName,fileName);
				
				Image land_img = new Image("/img/" + fileName, 59, 59, true, false);
				ImageView land_iv = new ImageView(land_img);
				gpElements.add(land_iv, columnGp, rowGp);
				if(columnGp<6){
					columnGp++;
				} else {
					rowGp++;
					columnGp=0;
				}
				
				
			}
		}
	}
	
	@FXML
	void clickActionCreatures(MouseEvent event) {
		System.out.println("clickActionCreatures");
	}

	@FXML
	void clickActionLands(MouseEvent event) {
		fillLand();
	}

	@FXML
	void clickActionObstacles(MouseEvent event) {
		System.out.println("clickActionObstacles");
	}

}