package edu.neumont.light.javarpg.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import edu.neumont.light.javarpg.models.Monster;
import edu.neumont.light.javarpg.models.Player;
import edu.neumont.light.javarpg.view.RpgView;

public class RpgController {

	private RpgView view;

	private Player player;

	private final String directory = "saves";
	
	private List<Monster> monsters = new ArrayList<>();

	private Random rng = new Random();

	public RpgController(RpgView view) {
		this.view = view;
		this.view.registerController(this);
	}

	public void run() {
		view.init();

	}

	public void save() throws IOException {

		File file = new File(directory + "\\players-save-" + player.getName() + ".db");

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
			out.writeObject(this.player);
			out.close();
		}

	}

	public void load(File file) throws ClassNotFoundException, IOException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
			this.player = (Player) in.readObject();
		}
	}

	public void createPlayer(Optional<String> name) {
		this.player = new Player(name.toString());

	}

	public void chanceEncounter() {
		
		int chance = this.rng.nextInt(100);
		
		//TODO set back to 2
		if(chance < 0) {
			this.generateMonsters();
		}
		
	}

	private void generateMonsters() {
		int chance = this.rng.nextInt(10);
		int numOfMonsters;
		
		if(chance < 5) {
			numOfMonsters = 1;
		}else if(chance < 8) {
			numOfMonsters = 2;
		}else {
			numOfMonsters = 3;
		}
		
		this.monsters.clear();
		for(int i = 0; i < numOfMonsters; i++) {
			this.monsters.add(new Monster(this.player.getLevel()));
		}
		this.view.startCombat();
	}

}
