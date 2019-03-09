package edu.neumont.light.javarpg.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.neumont.light.javarpg.models.HPPotion;
import edu.neumont.light.javarpg.models.Item;
import edu.neumont.light.javarpg.models.Monster;
import edu.neumont.light.javarpg.models.Player;
import edu.neumont.light.javarpg.models.Weapon;
import edu.neumont.light.javarpg.view.RpgView;

public class RpgController {

	private RpgView view;

	private Player player;

	private final String directory = "saves";

	private List<Monster> monsters = new ArrayList<>();

	private Random rng = new Random();

	private int combatDamge;

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

	public void createPlayer(String name) {
		this.player = new Player(name);

	}

	public void chanceEncounter() {

		int chance = this.rng.nextInt(100);

		// TODO set back to 2
		if (chance < 100) {
			this.generateMonsters();
		}

	}

	private void generateMonsters() {
		int chance = this.rng.nextInt(10);
		int numOfMonsters;

		if (chance < 5) {
			numOfMonsters = 1;
		} else if (chance < 8) {
			numOfMonsters = 2;
		} else {
			numOfMonsters = 3;
		}

		this.monsters.clear();
		for (int i = 0; i < numOfMonsters; i++) {
			this.monsters.add(new Monster(this.player.getLevel()));
		}
		this.view.startCombat();
	}

	public Player getcharacter() {
		return this.player;
	}

	public void setCombatDamage(int damage) {
		this.combatDamge = damage;
	}

	public void attackMonster(int i) {
		this.monsters.get(i).takeDamage(this.combatDamge);
		this.view.updateMonsterLabel(i);
		if (this.monsters.get(i).checkDeath()) {
			this.view.monsterDied(i);
		}
		boolean endCombat = true;
		for (int j = 0; j < this.monsters.size() && endCombat; j++) {
			endCombat = this.monsters.get(j).checkDeath();
		}
		if (endCombat) {
			this.endCombat();
		}

		this.monstersTurn();
	}

	private void monstersTurn() {
		for (int i = 0; i < this.monsters.size(); i++) {
			if (!this.monsters.get(i).checkDeath()) {
				if (this.rng.nextInt(10) < 7) {
					this.player.takeDamage(this.monsters.get(i).getBasicAttack());
				} else {
					this.player.takeDamage(this.monsters.get(i).getSkillDamage(0));
				}
			}
			this.view.updatePlayerLabel();
		}

	}

	public List<Monster> getMonsters() {

		return this.monsters;
	}

	public void endCombat() {

		for (int i = 0; i < this.monsters.size(); i++) {
			this.player.addItems(this.monsters.get(i).generateLoot(this.player.getLevel()));
			this.player.xpGain(this.monsters.get(i).expGain());
		}
		this.view.exitCombat();

	}

	public void setEquipedWeapon(Item item) {
		if (item instanceof Weapon) {
			this.player.setEquippedWeapon((Weapon) item);
		}

	}

	public void usePotion(Item item) {
		if (item instanceof HPPotion) {
			this.player.usePotion((HPPotion)item);
		}
		
	}

}
