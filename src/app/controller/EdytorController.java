package app.controller;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import app.database.DBConnector;
import app.database.RetrivalFromSql;
import app.model.Creature;
import app.model.Element;
import app.model.Field;
import app.model.Land;
import app.model.Obstacle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

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

	PreparedStatement ps;
	Connection conn;
	DBConnector db;
	ResultSet rs;

	ArrayList<Element> lands;
	ArrayList<Element> obstacles;
	ArrayList<Element> creatures;
	ArrayList<Field> fieldsAll;

	public void initialize() {

		lands = RetrivalFromSql.landRetrieve();
		obstacles = RetrivalFromSql.obstacleRetrieve();
		creatures = RetrivalFromSql.creatureRetrieve();
		
		// TUTAJ TRZEBA POBRAÆ DANE Z BAZY DANYCH I WSTAWIÆ JE DO fieldsAll. A
		// potem napisaæ metodê, która wyœwietli zawartoœæ fieldsAll.

		// Image test = new Image("img/land_trawa.jpg", 60, 60, true, false);
		// ImageView iv;
		// for (int i = 1; i < 11; i++) {
		// for (int j = 1; j < 11; j++) {
		// iv = new ImageView(test);
		// gpMain.add(iv, i, j);
		// iv.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
		// System.out.println("Row:" + GridPane.getRowIndex((Node)
		// e.getSource()) + ", Column:"
		// + GridPane.getColumnIndex((Node) e.getSource()));
		// });
		// }
		// }

		bordersOfGp(gpElements, 4, 7);

	}

	// dobrze by³oby tutaj automatycznie sprawdzaæ rows i columns ale na razie
	// nie wiem jak
	private void bordersOfGp(GridPane gp, int rows, int columns) {

		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				Pane pane = new Pane();
				pane.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
					System.out.println("PANE Row:" + GridPane.getRowIndex((Node) pane) + ", Column:"
							+ GridPane.getColumnIndex((Node) pane));
					lightUpThePane(pane);
				});
				gp.add(pane, i, j);
			}
		}
	}

	// uproszczenie:
	private void fill2(ArrayList<Element> el) {
		gpElements.getChildren().clear();
		bordersOfGp(gpElements, 4, 7);
		Image img;
		int i=0;
		for (Node n : gpElements.getChildren()) {
			if (n instanceof Pane) {
				img = new Image("/img/" + el.get(i).getFileName(), 59, 59, true, false);
				ImageView iv = new ImageView(img);
				((Pane) n).getChildren().add(iv);
			}

		}
	}

	private void fill(String typeOfFill) {

		gpElements.getChildren().clear();
		bordersOfGp(gpElements, 4, 7);
		final File folder = new File("./src/img/");
		int columnGp = 0;
		int rowGp = 0;

		for (final File fileEntry : folder.listFiles()) {
			String fileName = fileEntry.getName();
			if (fileEntry.isFile() && fileName.matches(typeOfFill + ".*")) {
				Image img = new Image("/img/" + fileName, 59, 59, true, false);
				ImageView iv = new ImageView(img);
				gpElements.add(iv, columnGp, rowGp);

				iv.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
					System.out.println("IV Row:" + GridPane.getRowIndex((Node) e.getSource()) + ", Column:"
							+ GridPane.getColumnIndex((Node) e.getSource()));
					lightUpThePane(identifyPane(iv));
					deselectImg();
					iv.setOpacity(0.5);
				});

				if (columnGp < 6) {
					columnGp++;
				} else {
					rowGp++;
					columnGp = 0;
				}
			}
		}

	}

	private void deselectImg() {
		for (Node n : gpElements.getChildren()) {
			if (n instanceof ImageView) {
				n.setOpacity(1);
			}
		}
	}

	private void lightUpThePane(Pane p) {
		for (Node n : p.getParent().getChildrenUnmodifiable()) {
			if (n instanceof Pane) {
				n.setStyle("-fx-background-color: transparent");
			}
		}
		p.setStyle("-fx-background-color: orange");
	}

	private Pane identifyPane(ImageView img) {
		int r = GridPane.getRowIndex(img);
		int c = GridPane.getColumnIndex(img);
		for (Node n : img.getParent().getChildrenUnmodifiable()) {
			if (n instanceof Pane && GridPane.getColumnIndex(n) == c && GridPane.getRowIndex(n) == r) {
				return (Pane) n;
			}
		}
		return null;
	}

	@FXML
	void clickActionCreatures(MouseEvent event) {
		fill2(creatures);
	}

	@FXML
	void clickActionLands(MouseEvent event) {
		fill2(lands);
	}

	@FXML
	void clickActionObstacles(MouseEvent event) {
		fill2(obstacles);
	}

}