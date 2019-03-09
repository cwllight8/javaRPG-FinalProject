package edu.neumont.light.javarpg.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lemuel Bonite
 *
 */
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;

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
		this.xp = 0;
		this.xpToNextLevel = 100;
		this.skillPoints = 0;
		this.hp = 100;
		this.equippedWeapon = new Weapon("S101", "sword", 1);
		this.skills.add(new DamageSkill("lung at the enemy ", true, "stabing lung", 7, 1));

	}

	/**
	 * @param name
	 *            the name of the player
	 */
	public Player(String name) {
		this.name = name;
		this.level = 1;
		this.xp = 0;
		this.xpToNextLevel = 100;
		this.skillPoints = 0;
		this.hp = 100;
		this.equippedWeapon = new Weapon("S101", "sword", 1);
		this.skills.add(new DamageSkill("lung at the enemy ", true, "stabing lung", 7, 1));


	}

	/**
	 * @param name
	 *            the name of the player
	 * @param level
	 *            the level of the player
	 * @param xp
	 *            how much xp the player will have
	 * @param xpToNextLevel
	 *            how much xp the player will have to next level to level up
	 * @param skillPoints
	 *            how much skill points the player will have
	 * @param hp
	 *            how much hp the player will have
	 * @param inventory
	 *            this is where the player will store their items
	 * @param skills
	 *            this is what skills the player will have
	 * @param equippedWeapon
	 *            this is what weapon the player will be equipped to them
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
	 *            sets how much xp is required to next level
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
	 *            sets the name of the player
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
	 *            sets the level of the player
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the xp for the player
	 */
	public int getExp() {
		return xp;
	}

	/**
	 * @param xp
	 *            sets the xp for the player
	 */
	public void setExp(int xp) {
		this.xp = xp;
	}

	/**
	 * @return the skill points to the player
	 */
	public int getSkillPoints() {
		return skillPoints;
	}

	/**
	 * @param skillPoints
	 *            sets the skill points for the player
	 */
	public void setSkillPoints(int skillPoints) {
		this.skillPoints = skillPoints;
	}

	/**
	 * @return the hp to the player
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * @param hp
	 *            set the hp to the player
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * @return the inventory to the player
	 */
	public List<Item> getInventory() {
		return inventory;
	}

	/**
	 * @param inventory
	 *            set the inventory for the player
	 */
	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

	/**
	 * @return the skills the player has
	 */
	public List<Skill> getSkills() {
		return skills;
	}

	/**
	 * @param skills
	 *            sets the skills for the player
	 */
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	/**
	 * @return the equipped weapon for the player
	 */
	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}

	/**
	 * @param equippedWeapon
	 *            sets the weapon equipped for the player
	 */
	public void setEquippedWeapon(Weapon equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}

	/**
	 * @param items
	 *            adds all items the player gets to the player's inventory
	 */
	public void addItems(List<Item> items) {
		this.inventory.addAll(items);
	}

	/**
	 * @param index
	 *            removes an item from the player's inventory
	 */
	public void removeItem(int index) {
		this.inventory.remove(index);
	}

	/**
	 * levels up the player as he exceeds the xp level and gains 1 skill point
	 */
	public void levelUp() {
		this.xp -= this.xpToNextLevel;
		this.level++;
		this.skillPoints++;
		this.xpToNextLevel *= 1.3;

	}

	/**
	 * @param xp
	 *            the xp the player will gain
	 */
	public void xpGain(int xp) {
		this.xp += xp;
	}

	/**
	 * @param hp
	 *            the hp lost when the player takes damage
	 */
	public void takeDamage(int hp) {
		this.hp -= hp;
	}

	/**
	 * @return the damage the weapon will do
	 */
	public int getWeaponDamage() {
		return this.equippedWeapon.getDamage();
	}

	/**
	 * @return all skills for damage skills
	 */
	public List<DamageSkill> getDamageSkill() {

		List<DamageSkill> skillDamage = new ArrayList<>();

		for (int i = 0; i < this.skills.size(); i++) {
			if (this.skills.get(i) instanceof DamageSkill) {
				skillDamage.add((DamageSkill) this.skills.get(i));
			}
		}
		return skillDamage;

	}

	/**
	 * @param index
	 *            the index the skill in the array is at
	 * @return the skill damage
	 */
	public int getSkillDamage(int index) {
		DamageSkill ds = (DamageSkill) this.skills.get(index);
		return ds.getDamage();
	}

	/**
	 * @param cost
	 *            the cost of how much the skill is to purchase
	 */
	public void purchasedSkill(int cost) {
		if (skillPoints >= cost) {
			this.skillPoints -= cost;
		}
	}

	/**
	 * @return true if the player is ready to level up
	 */
	public boolean checkLevelUp() {
		return this.xp >= this.xpToNextLevel;
	}

	/**
	 * @return true if the player is dead
	 */
	public boolean checkDeath() {
		return this.hp <= 0;
	}

}
