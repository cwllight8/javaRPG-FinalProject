package edu.neumont.light.javarpg.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.neumont.light.javarpg.models.enums.MonsterType;

public class Monster {
	
	private int level;
	
	private int HP;
	
	private MonsterType type;
	
	private List<Item> loot = new ArrayList<>();
	
	private List<Skill> skills = new ArrayList<>();
	
	private int basicAttack;
	
	private Random rand = new Random();

	public Monster() {}

	public Monster(int pLevel, MonsterType type) {
		this.level = this.generateLevel(pLevel);
		this.type = type;
	}

	public Monster(int pLevel) {
		this.level = this.generateLevel(pLevel);
	}
	
	private int generateLevel(int pLevel) {
		if (pLevel <= 2) {
			return rand.nextInt(2) + pLevel;
		} else {
			int lowerBound = pLevel - 2;
			return rand.nextInt(5) + lowerBound;
		}
	}
	
	private void generateType() {
		
	}
	
	
	
}
