package edu.neumont.light.javarpg.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lemuel Bonite
 *
 */
public class Player {
	
	private String name;

	private int level;
	
	private int xp;
	
	private int xpToNextLevel;
	

	private int skillPoints;
	
	private int hp;
	
	private List<Item> inventory = new ArrayList<>();
	
	private List<Skill> skills = new ArrayList<>();
	
	private Weapon equippedWeapon;

	
	/**
	 * 
	 */
	public Player() {
		
		name = "Player1";
		level = 1;
		xp = 0;
		skillPoints = 0;
		hp = 100;
		
		
	}
	
	public Player(String name) {
		this.name = name;
	}

	public Player(String name, int level, int xp, int xpToNextLevel, int skillPoints, int hp, ArrayList<Item> inventory,
			ArrayList<Skill> skills, Weapon equippedWeapon) {
		this.name = name;
		this.level = level;
		this.xp = xp;
		this.xpToNextLevel = xpToNextLevel;
		this.skillPoints = skillPoints;
		this.hp = hp;
		this.inventory = inventory;
		this.skills = skills;
		this.equippedWeapon = equippedWeapon;
	}


	public int getXpToNextLevel() {
		return xpToNextLevel;
	}
	
	public void setXpToNextLevel(int xpToNextLevel) {
		this.xpToNextLevel = xpToNextLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getSkillPoints() {
		return skillPoints;
	}

	public void setSkillPoints(int skillPoints) {
		this.skillPoints = skillPoints;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public List<Item> getInventory() {
		return inventory;
	}

	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}

	public void setEquippedWeapon(Weapon equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}
	
	
	
	
	
}
