package edu.neumont.light.javarpg.view;

import java.util.ArrayList;
import java.util.List;

import edu.neumont.light.javarpg.models.enums.TileType;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class RpgView {

	private Stage stage;

	@FXML
	private GridPane pane;

	@FXML
	private Label tileLabel;

	private List<List<TileType>> board = new ArrayList<List<TileType>>();

	public void setStage(Stage stage) {
		this.stage = stage;

	}

	private void drawTiles() {

		for(int i = 0; i < this.board.size(); i++) {
			for(int j = 0; j < this.board.get(i).size(); i++) {
				this.pane.add(this.tileLabel.setGraphic(Image()), arg1, arg2);
			}
		}
		
	}

}
