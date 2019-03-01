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
	 * The default constructor will make a basic player with these default settings
	 */
	public Player() {
		
		name = "Player1";
		level = 1;
		xp = 0;
		xpToNextLevel = 0;
		skillPoints = 0;
		hp = 100;
			
	}
	
	/**
	 * @param name
	 * 		the name of the player
	 */
	public Player(String name) {
		this.name = name;
	}

	
	/**
	 * @param name
	 * 		the name of the player
	 * @param level
	 * 		the level of the player
	 * @param xp
	 * 		how much xp the player will have
	 * @param xpToNextLevel
	 * 		how much xp the player will have to next level to level up
	 * @param skillPoints
	 * 		how much skill points the player will have
	 * @param hp
	 * 		how much hp the player will have
	 * @param inventory
	 * 		this is where the player will store their items
	 * @param skills
	 * 		this is what skills the player will have
	 * @param equippedWeapon
	 * 		this is what weapon the player will be equipped to them
	 */
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

	/**
	 * @return how much xp is required for next level
	 */
	public int getXpToNextLevel() {
		return xpToNextLevel;
	}
	
	/**
	 * @param xpToNextLevel
	 * 		sets how much xp is required to next level
	 */
	public void setXpToNextLevel(int xpToNextLevel) {
		this.xpToNextLevel = xpToNextLevel;
	}

	/**
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 * 		sets the name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the level of the player
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * @param level
	 * 		sets the level of the player
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the xp for the player
	 */
	public int getXp() {
		return xp;
	}

	/**
	 * @param xp
	 * 		sets the xp for the player
	 */
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
