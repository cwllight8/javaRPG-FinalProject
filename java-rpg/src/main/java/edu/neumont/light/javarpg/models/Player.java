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
		
		this.name = "Player1";
		this.level = 1;
		this.xp= 0;
		this.xpToNextLevel = 100;
		this.skillPoints = 0;
		this.hp = 100;
			
	}
	
	/**
	 * @param name
	 * 		the name of the player
	 */
	public Player(String name) {
		this.name = name;
		this.level = 1;
		this.xp= 0;
		this.xpToNextLevel = 100;
		this.skillPoints = 0;
		this.hp = 100;
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
		this.xp= xp;
		this.xpToNextLevel = xpToNextLevel;
		this.skillPoints = skillPoints;
		this.hp = hp;
		this.inventory = inventory;
		this.skills = skills;
		this.equippedWeapon = equippedWeapon;
	}

	/**
	 * @return how much xpis required for next level
	 */
	public int getExpToNextLevel() {
		return xpToNextLevel;
	}
	
	/**
	 * @param xpToNextLevel
	 * 		sets how much xpis required to next level
	 */
	public void setExpToNextLevel(int xpToNextLevel) {
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
	 * @return the xpfor the player
	 */
	public int getExp() {
		return xp;
	}

	/**
	 * @param xp
	 * 		sets the xpfor the player
	 */
	public void setExp(int xp) {
		this.xp= xp;
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
	
	public void addItems(List<Item> items) {
		
	}
	
	public void removeItem(int index) {
		
	}
	
	public void levelUp() {
		this.xp -= this.xpToNextLevel;
		this.level++;
		this.skillPoints++;
		this.xpToNextLevel *= 1.3;
		
	}
	
	public void xpGain(int xp) {
		this.xp += xp;
	}
	
	public void takeDamage(int hp) {
		this.hp -= hp;
	}
	
	public int getWeaponDamage() {
		return this.equippedWeapon.getDamage();
	}
	
	public List<DamageSkill> getDamageSkill(int index) {
		
		List<DamageSkill> skdmg = new ArrayList<>();
		
		for(int i = 0; i < this.skills.size(); i++) {
			if(this.skills.get(i) instanceof  DamageSkill) {
				skdmg.add((DamageSkill) this.skills.get(i));
			}
		}
		return skdmg;
		
	}
	
	public void purchasedSkill(int cost) {
		
	}
	
	public boolean checkLevelUp() {
		return this.xp >= this.xpToNextLevel; 
	}
	
}
