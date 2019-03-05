package edu.neumont.light.javarpg.view;

import java.util.ArrayList;
import java.util.List;

import edu.neumont.light.javarpg.models.enums.TileType;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class RpgView {

	private Stage stage;

	@FXML
	private TilePane tilePane;

	@FXML
	private Label tileLabel;

	private List<List<TileType>> listOfLists = new ArrayList<List<TileType>>();

	public void setStage(Stage stage) {
		this.stage = stage;

	}

	private void drawTiles() {

	}

}
