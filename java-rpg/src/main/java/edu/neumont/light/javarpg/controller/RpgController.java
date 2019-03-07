package edu.neumont.light.javarpg.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

import edu.neumont.light.javarpg.models.Player;
import edu.neumont.light.javarpg.view.RpgView;

public class RpgController {

	private RpgView view;

	private Player player;

	private final String directory = "saves";

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

}
