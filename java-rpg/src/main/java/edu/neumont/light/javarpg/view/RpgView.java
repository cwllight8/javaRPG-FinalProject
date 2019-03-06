package edu.neumont.light.javarpg.view;

import java.util.ArrayList;
import java.util.List;

import edu.neumont.light.javarpg.controller.RpgController;
import edu.neumont.light.javarpg.models.enums.TileType;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class RpgView {

	RpgController controller;

	private Stage stage;

	@FXML
	private Canvas canvas;

	// @FXML
	// private BorderPane pane;

	private double playerx;

	private double playery;

	// private List<List<TileType>> board = new ArrayList<List<TileType>>();

	private List<String> input = new ArrayList<>();

	private Scene scene;

	public void setStage(Stage stage) {
		this.stage = stage;

	}

	public void init() {
		this.stage.setTitle("Tale Of Legend");
		this.stage.show();
		this.playerx = this.canvas.getWidth() / 2;
		this.playery = this.canvas.getHeight() / 2;
		this.drawGame();
		this.initkeys();

	}

	private void initkeys() {
		this.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				String code = e.getCode().toString();

				// && code != "TAB" && code != "M" && code != "I" && code != "K"
				if (!input.contains(code)) {

					input.add(code);
					System.out.println(code);
				}
				
			}
		});

		this.scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				String code = e.getCode().toString();
				input.remove(code);
				if (code == "TAB") {
					openMenu();
				}
				if (code == "M") {
					openMap();
				}
				if (code == "I") {
					openInventory();
				}
				if (code == "K") {
					openSkillsMenu();

				}
			}
		});

		new AnimationTimer() {

			@Override
			public void handle(long currentNanoTime) {
				if (input.contains("W")) {
					playery -= 5;
					drawGame();
				} else if (input.contains("S")) {
					playery += 5;
					drawGame();
				} else if (input.contains("A")) {
					playerx -= 5;
					drawGame();
				} else if (input.contains("D")) {
					playerx += 5;
					drawGame();
				}

			}

		}.start();

	}

	private void openSkillsMenu() {
		// TODO Auto-generated method stub
		System.out.println("skills");

	}

	private void openInventory() {
		// TODO Auto-generated method stub
		System.out.println("inventory");

	}

	private void openMap() {
		// TODO Auto-generated method stub
		System.out.println("map");

	}

	private void openMenu() {
		// TODO Auto-generated method stub
		System.out.println("menu");
	}

	public void drawGame() {
		GraphicsContext g = canvas.getGraphicsContext2D();
		g.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
		Image map = new Image("BaseMap.png");
		g.drawImage(map, 0, 0);
		g.strokeRect(this.playerx, this.playery, 20, 20);

	}

	public void registerController(RpgController rpgController) {
		this.controller = rpgController;
	}

	public void registerScene(Scene scene) {
		this.scene = scene;

	}

}
