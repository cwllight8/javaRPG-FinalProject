package edu.neumont.light.javarpg.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.neumont.light.javarpg.controller.RpgController;
import edu.neumont.light.javarpg.models.enums.MonsterType;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class RpgView {

	RpgController controller;

	private Stage stage;

	private Scene combatScene;

	private Scene scene;

	private boolean inCombat = false;

	// private boolean collision;

	@FXML
	private Canvas canvas;

	@FXML
	private BorderPane pane;

	private double playerx;

	private double playery;
	
	private double playerW = 14;
	
	private double playerH = 19;
	
	// private List<List<TileType>> board = new ArrayList<List<TileType>>();

	private List<String> input = new ArrayList<>();



	public void setStage(Stage stage) {
		this.stage = stage;

	}

	public void init() {
		this.stage.setTitle("Tale Of Legend");
		this.stage.getIcons().add(new Image(this.getClass().getClassLoader().getResourceAsStream("icon.png")));
		this.stage.show();
		this.playerx = this.canvas.getWidth() / 2;
		this.playery = this.canvas.getHeight() / 2;
		this.drawTitle();
		this.setTitleKeys();

	}

	private void setTitleKeys() {
		this.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				drawGame();
				PlayerStartup();
				initkeys();

			}
		});

	}

	private void PlayerStartup() {
		String msg = "Would you like to load an existing character?";

		Alert a = new Alert(AlertType.CONFIRMATION, msg, ButtonType.YES, ButtonType.NO);
		a.setOnHidden(new EventHandler<DialogEvent>() {

			@Override
			public void handle(DialogEvent event) {
				Alert a = (Alert) event.getSource();

				if (a.getResult() == ButtonType.YES) {
					onLoad(new ActionEvent());

				} else {
					createPlayer();
				}
			}

		});
		a.show();

	}

	private void createPlayer() {
		Optional<String> name;

		do {
			TextInputDialog prompt = new TextInputDialog("newCharacter");
			prompt.setTitle("player creation prompt");
			prompt.setHeaderText("what would you like to name this charactor?");
			prompt.setContentText("name:");

			name = prompt.showAndWait();
			if (name.isPresent()) {

				this.controller.createPlayer(name);
			}
		} while (!name.isPresent());

	}

	private void drawTitle() {
		GraphicsContext g = canvas.getGraphicsContext2D();
		g.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
		Image screen = new Image("TitleScreen.png");
		g.drawImage(screen, 0, 0);

	}

	private void initkeys() {
		this.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				String code = e.getCode().toString();

				if (!input.contains(code)) {

					input.add(code);
					// System.out.println(code);
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
				if (code == "ENTER") {
					System.out.println("X: " + playerx + " Y: " + playery);
				}
			}
		});

		new AnimationTimer() {

			@Override
			public void handle(long currentNanoTime) {

				if (input.contains("W")) {
					moveUp();
					drawGame();
					controller.chanceEncounter();
				} else if (input.contains("S")) {
					moveDown();
					drawGame();
					controller.chanceEncounter();
				} else if (input.contains("A")) {
					moveLeft();
					drawGame();
					controller.chanceEncounter();
				} else if (input.contains("D")) {
					moveRight();
					drawGame();
					controller.chanceEncounter();
				}
				if (inCombat) {
					this.stop();
				}

			}

		}.start();

	}

	public void moveUp() {

		boolean canMove = false;
		
		boolean upperBound = (this.playery >= 0);
		boolean tree1 = !((this.playery <= 635 && this.playery >= 625) && (this.playerx <= 1165 && this.playerx >= 1080));
		boolean tree2 = !((this.playery <= 645 && this.playery >= 635) && (this.playerx <= 1700 && this.playerx >= 1620));
		boolean tree3 = !((this.playery <= 75 && this.playery >= 65) && (this.playerx <= 190 && this.playerx >= 135));
		boolean tree4 = !(this.playery <= 75 && this.playery >= 65 && this.playerx <= 310 && this.playerx >= 250);
		boolean rock1 = !(this.playery <= 375 && this.playery >= 365 && this.playerx <= 1310 && this.playerx >= 1235);
		boolean rock2 = !(this.playery <= 240 && this.playery >= 230 && this.playerx <= 1495 && this.playerx >= 1425);
		boolean rock3 = !(this.playery <= 250 && this.playery >= 240 && this.playerx <= 1115 && this.playerx >= 1045);
		boolean rock4 = !(this.playery <= 270 && this.playery >= 260 && this.playerx <= 225 && this.playerx >= 190);
		boolean bush = !(this.playery <= 240 && this.playery >= 230 && this.playerx <= 190 && this.playerx >= 130);
		boolean rock5 = !(this.playery <= 200 && this.playery >= 190 && this.playerx <= 130 && this.playerx >= 120);
		
		
		boolean house1 = !(this.playery <= 645 && this.playery >= 635 && this.playerx <= 1295 && this.playerx >= 1200);
		boolean house2 = !(this.playery <= 645 && this.playery >= 635 && this.playerx <= 1435 && this.playerx >= 1340);
		boolean house3 = !(this.playery <= 645 && this.playery >= 635 && this.playerx <= 1580 && this.playerx >= 1475);
		boolean house4 = !(this.playery <= 645 && this.playery >= 635 && this.playerx <= 1855 && this.playerx >= 1750);
		boolean house5 = !(this.playery <= 120 && this.playery >= 110 && this.playerx <= 135 && this.playerx >= 70);
		boolean house6 = !(this.playery <= 120 && this.playery >= 110 && this.playerx <= 250 && this.playerx >= 190);
		boolean house7 = !(this.playery <= 125 && this.playery >= 115 && this.playerx <= 370 && this.playerx >= 300);
		
		
				
		canMove = upperBound 
				&& tree1 && tree2 && tree3 && tree4 && rock1 && rock2 && rock3 && rock4
				&& bush && rock5
				&& house1 && house2 && house3 && house4 && house5 && house6 && house7;
		
		// 1080 1165
		if (canMove) {
			this.playery -= 5;
		}

	}

	public void moveDown() {
		
		boolean canMove = false;
		
		boolean lowerBound = (this.playery <= this.canvas.getHeight() - this.playerH/* player size */);
		boolean tree1 = !((this.playery <= 570 - this.playerH && this.playery >= 560 - this.playerH) && (this.playerx <= 1165 && this.playerx >= 1080));
		boolean tree2 = !((this.playery <= 580 - this.playerH && this.playery >= 570 - this.playerH) && (this.playerx <= 1700 && this.playerx >= 1620));
		boolean tree3 = !((this.playery <= 30 - this.playerH && this.playery >= 20 - this.playerH) && (this.playerx <= 190 && this.playerx >= 135));
		boolean tree4 = !(this.playery <= 35 - this.playerH && this.playery >= 25 - this.playerH && this.playerx <= 310 && this.playerx >= 250);
		boolean rock1 = !(this.playery <= 325 - this.playerH && this.playery >= 315 - this.playerH && this.playerx <= 1310 && this.playerx >= 1235);
		boolean rock2 = !(this.playery <= 185 - this.playerH && this.playery >= 175 - this.playerH && this.playerx <= 1495 && this.playerx >= 1425);
		boolean rock3 = !(this.playery <= 195 - this.playerH && this.playery >= 185 - this.playerH && this.playerx <= 1115 && this.playerx >= 1045);
		boolean rock4 = !(this.playery <= 250 - this.playerH && this.playery >= 240 - this.playerH && this.playerx <= 225 && this.playerx >= 190);
		boolean bush = !(this.playery <= 190 - this.playerH && this.playery >= 180 - this.playerH && this.playerx <= 190 && this.playerx >= 130);
		boolean rock5 = !(this.playery <= 175 - this.playerH && this.playery >= 165 - this.playerH && this.playerx <= 130 && this.playerx >= 120);
		
		
		boolean house1 = !(this.playery <= 585 - this.playerH && this.playery >= 575 - this.playerH && this.playerx <= 1295 && this.playerx >= 1200);
		boolean house2 = !(this.playery <= 585 - this.playerH && this.playery >= 575 - this.playerH && this.playerx <= 1435 && this.playerx >= 1340);
		boolean house3 = !(this.playery <= 585 - this.playerH && this.playery >= 575 - this.playerH && this.playerx <= 1580 && this.playerx >= 1475);
		boolean house4 = !(this.playery <= 585 - this.playerH && this.playery >= 575 - this.playerH && this.playerx <= 1855 && this.playerx >= 1750);
		boolean house5 = !(this.playery <= 85 - this.playerH && this.playery >= 75 - this.playerH && this.playerx <= 135 && this.playerx >= 70);
		boolean house6 = !(this.playery <= 85 - this.playerH && this.playery >= 75 - this.playerH && this.playerx <= 250 && this.playerx >= 190);
		boolean house7 = !(this.playery <= 85 - this.playerH && this.playery >= 75 - this.playerH && this.playerx <= 370 && this.playerx >= 300);
		
		
				
		canMove = lowerBound 
				&& tree1 && tree2 && tree3 && tree4 && rock1 && rock2 && rock3 && rock4
				&& bush && rock5
				&& house1 && house2 && house3 && house4 && house5 && house6 && house7;

		if (canMove) {
			this.playery += 5;
		}

	}

	public void moveRight() {
		
		boolean canMove = false;
		
		boolean rightBound = this.playerx <= this.canvas.getWidth() - this.playerW/* player size */;
		boolean tree1 = !((this.playery <= 635 && this.playery >= 560) && (this.playerx <= 1090 && this.playerx >= 1080 - this.playerW));
		boolean tree2 = !((this.playery <= 645 && this.playery >= 570) && (this.playerx <= 1630 && this.playerx >= 1620 - this.playerW));
		boolean tree3 = !((this.playery <= 75 && this.playery >= 20) && (this.playerx <= 145 && this.playerx >= 135 - this.playerW));
		boolean tree4 = !(this.playery <= 75 && this.playery >= 25 && this.playerx <= 260 && this.playerx >= 250 - this.playerW);
		boolean rock1 = !(this.playery <= 375 && this.playery >= 315 && this.playerx <= 1245 && this.playerx >= 1235 - this.playerW);
		boolean rock2 = !(this.playery <= 240 && this.playery >= 175 && this.playerx <= 1435 && this.playerx >= 1425 - this.playerW);
		boolean rock3 = !(this.playery <= 250 && this.playery >= 185 && this.playerx <= 1055 && this.playerx >= 1045 - this.playerW);
		boolean rock4 = !(this.playery <= 270 && this.playery >= 240 && this.playerx <= 200 && this.playerx >= 190 - this.playerW);
		boolean bush = !(this.playery <= 240 && this.playery >= 180 && this.playerx <= 140 && this.playerx >= 130 - this.playerW);
		boolean rock5 = !(this.playery <= 200 && this.playery >= 165 && this.playerx <= 130 && this.playerx >= 120 - this.playerW);
		
		
		boolean house1 = !(this.playery <= 645 && this.playery >= 575 && this.playerx <= 1210 && this.playerx >= 1200 - this.playerW);
		boolean house2 = !(this.playery <= 645 && this.playery >= 575 && this.playerx <= 1350 && this.playerx >= 1340 - this.playerW);
		boolean house3 = !(this.playery <= 645 && this.playery >= 575 && this.playerx <= 1485 && this.playerx >= 1475 - this.playerW);
		boolean house4 = !(this.playery <= 645 && this.playery >= 575 && this.playerx <= 1760 && this.playerx >= 1750 - this.playerW);
		boolean house5 = !(this.playery <= 120 && this.playery >= 75 && this.playerx <= 80 && this.playerx >= 70 - this.playerW);
		boolean house6 = !(this.playery <= 120 && this.playery >= 75 && this.playerx <= 200 && this.playerx >= 190 - this.playerW);
		boolean house7 = !(this.playery <= 125 && this.playery >= 75 && this.playerx <= 310 && this.playerx >= 300 - this.playerW);
		
		
				
		canMove = rightBound 
				&& tree1 && tree2 && tree3 && tree4 && rock1 && rock2 && rock3 && rock4
				&& bush && rock5
				&& house1 && house2 && house3 && house4 && house5 && house6 && house7;

		if (canMove) {
			this.playerx += 5;
		}

	}

	public void moveLeft() {
		
		boolean canMove = false;
		
		boolean leftBound = this.playerx >= 0;
		boolean tree1 = !((this.playery <= 635 && this.playery >= 560) && (this.playerx <= 1165 && this.playerx >= 1155));
		boolean tree2 = !((this.playery <= 645 && this.playery >= 570) && (this.playerx <= 1700 && this.playerx >= 1690));
		boolean tree3 = !((this.playery <= 75 && this.playery >= 20) && (this.playerx <= 190 && this.playerx >= 180));
		boolean tree4 = !(this.playery <= 75 && this.playery >= 25 && this.playerx <= 310 && this.playerx >= 300);
		boolean rock1 = !(this.playery <= 375 && this.playery >= 315 && this.playerx <= 1310 && this.playerx >= 1300);
		boolean rock2 = !(this.playery <= 240 && this.playery >= 175 && this.playerx <= 1495 && this.playerx >= 1485);
		boolean rock3 = !(this.playery <= 250 && this.playery >= 185 && this.playerx <= 1115 && this.playerx >= 1105);
		boolean rock4 = !(this.playery <= 270 && this.playery >= 240 && this.playerx <= 225 && this.playerx >= 215);
		boolean bush = !(this.playery <= 240 && this.playery >= 180 && this.playerx <= 190 && this.playerx >= 180);
		boolean rock5 = !(this.playery <= 200 && this.playery >= 165 && this.playerx <= 130 && this.playerx >= 120);
		
		
		boolean house1 = !(this.playery <= 645 && this.playery >= 575 && this.playerx <= 1295 && this.playerx >= 1285);
		boolean house2 = !(this.playery <= 645 && this.playery >= 575 && this.playerx <= 1435 && this.playerx >= 1425);
		boolean house3 = !(this.playery <= 645 && this.playery >= 575 && this.playerx <= 1580 && this.playerx >= 1570);
		boolean house4 = !(this.playery <= 645 && this.playery >= 575 && this.playerx <= 1855 && this.playerx >= 1845);
		boolean house5 = !(this.playery <= 120 && this.playery >= 75 && this.playerx <= 135 && this.playerx >= 125);
		boolean house6 = !(this.playery <= 120 && this.playery >= 75 && this.playerx <= 250 && this.playerx >= 240);
		boolean house7 = !(this.playery <= 125 && this.playery >= 75 && this.playerx <= 370 && this.playerx >= 360);
		
		
				
		canMove = leftBound 
				&& tree1 && tree2 && tree3 && tree4 && rock1 && rock2 && rock3 && rock4
				&& bush && rock5
				&& house1 && house2 && house3 && house4 && house5 && house6 && house7;

		if (canMove) {
			this.playerx -= 5;
		}

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
		Image player = new Image("Player.png");
		g.drawImage(player, this.playerx, this.playery);
//		g.strokeRect(this.playerx, this.playery, 20, 20);

	}

	public void registerController(RpgController rpgController) {
		this.controller = rpgController;
	}

	public void registerScene(Scene scene) {
		this.scene = scene;

	}

	public void onRestart(ActionEvent e) {
		// TODO
	}

	public void onSave(ActionEvent e) {
		try {
			this.controller.save();
		} catch (IOException e1) {
			new Alert(AlertType.ERROR, "An error occured trying to save the file.", ButtonType.OK).show();
		}
	}

	public void onSaveExit(ActionEvent e) {
		this.onSave(e);
		this.stage.close();
	}

	public void onLoad(ActionEvent e) {
		File file;
		do {
			FileChooser chooser = new FileChooser();
			chooser.setTitle("select a saved game file");
			file = chooser.showOpenDialog(this.stage);
			if (file == null) {
				return;
			}
			try {
				this.controller.load(file);
			} catch (IOException | ClassNotFoundException ex) {
				file = null;
				new Alert(AlertType.ERROR, "an error occured while trying to select the file. please select another.",
						ButtonType.OK).show();
			}
		} while (file == null);
	}

	public void onExit(ActionEvent e) {
		this.stage.close();
	}

	public void startCombat() {
		this.inCombat = true;
		this.input.clear();

		int damage;

		Button attack = new Button("Basic Attack");
		Button skill = new Button("skill");// TODO add for loop to get the damage skills
		Button run = new Button("RUN!!");
		run.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				exitCombat();
			}
		});

		attack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				controller.setCombatDamage(controller.getcharacter().getWeaponDamage());
			}

		});

		Region spcr1 = new Region();
		Region spcr2 = new Region();

		HBox lowerScreneButtons = new HBox(10, attack, spcr1, skill, spcr2, run);

		HBox upperScreen = new HBox();

		for (int i = 0; i < controller.getMonsters().size(); i++) {
			Button[] monsters = new Button[controller.getMonsters().size()];

			Button temp = new Button(controller.getMonsters().get(i).getHP() + "/", this.getImageView(i));// TODO add
																											// for loop
																											// to get
																											// the
																											// different
																											// monsters

			final int monsterNum = i;

			temp.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO need to add a way to determin the monster(likely has to do with creating
					// the multiple monster buttons)
					controller.attackMonster(monsterNum);
				}

			});

			upperScreen.getChildren().add(temp);
		}

		lowerScreneButtons.setHgrow(spcr1, Priority.ALWAYS);

		VBox lowerScreen = new VBox(10, lowerScreneButtons);
		lowerScreen.setAlignment(Pos.CENTER);

		VBox screen = new VBox(10, upperScreen, lowerScreen);

		this.combatScene = new Scene(screen);

		this.stage.setScene(this.combatScene);
		this.stage.setWidth(1900);
		this.stage.setHeight(900);

	}

	private ImageView getImageView(int i) {
		Image image;
		ImageView imageView = null;
		if (this.controller.getMonsters().get(i).getType() == MonsterType.SillySlime) {
			image = new Image("SlimeMonsterTransparent.png");
			imageView = new ImageView(image);
		} else if (this.controller.getMonsters().get(i).getType() == MonsterType.BadBird) {
			image = new Image("BirdMonsterTransparent.png");
			imageView = new ImageView(image);
		} else if (this.controller.getMonsters().get(i).getType() == MonsterType.StabbingSkull) {
			image = new Image("FloatingSkullMonsterTransparent.png");
			imageView = new ImageView(image);
		}
		return imageView;
	}

	public void exitCombat() {
		this.inCombat = false;
		this.stage.setScene(this.scene);
		this.initkeys();
	}

	public void monsterDied(int i) {

	}

}
