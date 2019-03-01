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

}
