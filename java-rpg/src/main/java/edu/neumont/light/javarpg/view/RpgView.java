package edu.neumont.light.javarpg.view;

import java.util.ArrayList;
import java.util.List;

import edu.neumont.light.javarpg.controller.RpgController;
import edu.neumont.light.javarpg.models.enums.TileType;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RpgView {

	RpgController controller;
	
	private Stage stage;

	@FXML
	private GridPane pane;

	@FXML
	private Label tileLabel;

	private List<List<TileType>> board = new ArrayList<List<TileType>>();

	public void setStage(Stage stage) {
		this.stage = stage;

	}
	
	public void init() {
		drawTiles();
		this.stage.setTitle("Tale Of Legend");
		this.stage.show();
	}

	private void drawTiles() {

		for(int i = 0; i < this.board.size(); i++) {
			for(int j = 0; j < this.board.get(i).size(); i++) {
				 Image image = new Image(getClass().getResourceAsStream("grassTile.png"));
				 this.tileLabel.setGraphic(new ImageView(image));
				 this.pane.add(tileLabel,i,j);
			}
		}
		
	}

	public void registerController(RpgController rpgController) {
		this.controller = rpgController;
		
	}

}
