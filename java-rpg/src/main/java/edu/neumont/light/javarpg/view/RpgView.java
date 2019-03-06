package edu.neumont.light.javarpg.view;

import java.util.ArrayList;
import java.util.List;

import edu.neumont.light.javarpg.controller.RpgController;
import edu.neumont.light.javarpg.models.enums.TileType;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RpgView {

	RpgController controller;
	
	private Stage stage;
	
	@FXML
	private Canvas Canvas;
	
	@FXML
	private BorderPane pane;
	
	private double playerx;
	
	private double playery;

	private List<List<TileType>> board = new ArrayList<List<TileType>>();

	public void setStage(Stage stage) {
		this.stage = stage;

	}
	
	public void init() {
		this.stage.setTitle("Tale Of Legend");
		this.pane.setBackground(Background.EMPTY);
		this.pane.setStyle("-fx-graphic: url(BaseMap.png)");
		this.stage.show();
		GraphicsContext g = Canvas.getGraphicsContext2D();
		g.strokeRect(this.Canvas.getWidth()/2, this.Canvas.getHeight()/2, 20, 20);
	}

	public void registerController(RpgController rpgController) {
		this.controller = rpgController;
		
	}

}
