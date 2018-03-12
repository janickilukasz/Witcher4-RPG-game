package app.controller;

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

	static final int gpElemRows = 4;
	static final int gpElemCols = 7;
	static PreparedStatement ps;
	static Connection conn;
	static DBConnector db;
	static ResultSet rs;

	static ArrayList<Element> lands;
	static ArrayList<Element> obstacles;
	static ArrayList<Element> creatures;
	static ArrayList<Field> fieldsAll;

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

		bordersOfGp(gpElements, gpElemRows, gpElemCols);

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
	private void fill2(ArrayList<Element> el, String fold) {
		gpElements.getChildren().clear();
		bordersOfGp(gpElements, gpElemRows, gpElemCols);
		Image img;
		int i = 0;
		int gpRow = 0;
		int gpCol = 0;
		int l = el.size();
		for (Node n : gpElements.getChildren()) {
			if (n instanceof Pane) {
				i = gpRow * gpElemCols + gpCol;
				if (i < l) {
					img = new Image("/img/" + fold + "/" + el.get(i).getFileName(), 59, 59, true, false);
					ImageView iv = new ImageView(img);
					((Pane) n).getChildren().add(iv);
				}
				gpRow++;
				if (gpRow >= gpElemRows) {
					gpRow = 0;
					gpCol++;
				}
			}
		}
	}

	private void lightUpThePane(Pane p) {
		for (Node n : p.getParent().getChildrenUnmodifiable()) {
			if (n instanceof Pane) {
				n.setStyle("-fx-background-color: transparent");
				n.setOpacity(1);
			}
		}
		p.setStyle("-fx-background-color: orange");
		p.setOpacity(0.5);
	}

	@FXML
	void clickActionCreatures(MouseEvent event) {
		fill2(creatures, "creatures");
	}

	@FXML
	void clickActionLands(MouseEvent event) {
		fill2(lands, "lands");
	}

	@FXML
	void clickActionObstacles(MouseEvent event) {
		fill2(obstacles, "obstacles");
	}

}