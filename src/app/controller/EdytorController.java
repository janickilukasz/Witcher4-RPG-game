package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

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
	static final int gpMainRows = 12;
	static final int gpMainCols = 12;
	static int boardRow;
	static int boardCol;
	static PreparedStatement ps;
	static Connection conn;
	static DBConnector db;
	static ResultSet rs;

	static ArrayList<Element> lands;
	static ArrayList<Element> obstacles;
	static ArrayList<Element> creatures;
	static ArrayList<Field> fieldsAll;

	static HashMap<Pane, Element> GpElemHM;
	static HashMap<Pane, Field> GpMainHM;

	static Pane gpElemPaneClicked;

	public void initialize() {

		lands = RetrivalFromSql.landRetrieve();
		obstacles = RetrivalFromSql.obstacleRetrieve();
		creatures = RetrivalFromSql.creatureRetrieve();
		GpElemHM = new HashMap<Pane, Element>();
		GpMainHM = new HashMap<Pane, Field>();

		boardRow = 0;
		boardCol = 0;

		bordersOfGp(gpElements, gpElemRows, gpElemCols);
		bordersOfGp(gpMain, gpMainRows, gpMainCols);

	}

	// dobrze by³oby tutaj automatycznie sprawdzaæ rows i columns ale na razie
	// nie wiem jak
	private void bordersOfGp(GridPane gp, int rows, int columns) {

		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				Pane pane = new Pane();

				if (gp == gpElements) {
					pane.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
						clickGpElemPane(pane);
					});
				} else if (gp == gpMain) {
					pane.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
						clickGpMainPane(pane);
					});
				}
				gp.add(pane, i, j);
			}

		}
	}

	private void fill(ArrayList<Element> el, String fold) {
		gpElements.getChildren().clear();
		clickGpElemPane(null);
		GpElemHM.clear();
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
					GpElemHM.put((Pane) n, el.get(i));
				}
				gpRow++;
				if (gpRow >= gpElemRows) {
					gpRow = 0;
					gpCol++;
				}
			}
		}
	}

	private void clickGpElemPane(Pane newPane) {

		if (gpElemPaneClicked != null) {
			gpElemPaneClicked.setStyle("-fx-background-color: transparent");
			gpElemPaneClicked.setOpacity(1);
		}
		if (newPane != null && !newPane.getChildren().isEmpty()) {
			gpElemPaneClicked = newPane;
			newPane.setStyle("-fx-background-color: orange");
			newPane.setOpacity(0.5);
		} else {
			gpElemPaneClicked = null;
		}
	}

	private void clickGpMainPane(Pane p) {
		int row = GridPane.getRowIndex(p);
		int col = GridPane.getColumnIndex(p);
		if (row >= 1 && row < gpMainRows && col >= 1 && col < gpMainCols) {
			Element e = GpElemHM.get(gpElemPaneClicked);
//TUTAJ!!!! CZY TU NIE LEPIEJ ZMIENIÆ FIELD ZEBY ZAWIERA£O LAND, OBSTACLE itp zamiast LandFileName?
			if (gpElemPaneClicked != null) {
				if (GpMainHM.containsKey(p)) {
					// podmianka
				} else {
					String filename = e.getFileName();
					String landFilename = null;
					String obstacleFilename = null;
					String creatureFilename = null;
					if (e instanceof Land) {
						landFilename = filename;
					} else if (e instanceof Obstacle) {
						obstacleFilename = filename;
					} else if (e instanceof Creature) {
						creatureFilename = filename;
					}
					Field f = new Field(boardRow, boardCol, row, col, landFilename, 0, obstacleFilename,
							creatureFilename);
					GpMainHM.put(p, f);
					Image img = new Image("/img/" + e.getClass().getSimpleName() + "s/" + e.getFileName(), 59, 59, true,
							false);
					ImageView iv = new ImageView(img);
					p.getChildren().add(iv);
				}
			}
		}
	}

	@FXML
	void clickActionCreatures(MouseEvent event) {
		fill(creatures, "creatures");
	}

	@FXML
	void clickActionLands(MouseEvent event) {
		fill(lands, "lands");
	}

	@FXML
	void clickActionObstacles(MouseEvent event) {
		fill(obstacles, "obstacles");
		// int i = 1;
		// for (Entry<Pane, Element> entry : GpElemHM.entrySet()) {
		// String nazwa = entry.getValue().getName();
		// System.out.println(i + ": " + nazwa);
		// i++;
		// }
	}

}