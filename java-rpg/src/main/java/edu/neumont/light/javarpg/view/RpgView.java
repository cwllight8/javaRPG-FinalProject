package edu.neumont.light.javarpg.view;

import java.util.ArrayList;
import java.util.List;

import edu.neumont.light.javarpg.controller.RpgController;
import edu.neumont.light.javarpg.models.enums.TileType;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RpgView {

	RpgController controller;
	
	private Stage stage;
	
	@FXML
	private Canvas drawingCanvas;

	@FXML
	private GridPane pane;

	@FXML
	private Label tileLabel;
	
	private double playerx;
	
	private double playery;

	private List<List<TileType>> board = new ArrayList<List<TileType>>();

	public void setStage(Stage stage) {
		this.stage = stage;

	}
	
	public void init() {
		this.stage.setTitle("Tale Of Legend");
		this.stage.show();
		GraphicsContext g = drawingCanvas.getGraphicsContext2D();
		
		g.strokeRect(this.drawingCanvas.getWidth()/2, this.drawingCanvas.getHeight()/2, 20, 20);
	}

	public void registerController(RpgController rpgController) {
		this.controller = rpgController;
		
	}

}
