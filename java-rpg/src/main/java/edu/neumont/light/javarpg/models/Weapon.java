package edu.neumont.light.javarpg.models;

import java.util.Random;

/**
 * @author cole
 *
 */
public class Weapon extends Item implements Comparable<Weapon> {

	private int damage;

	private int level;

	/**
	 * default constructor that calls the super's default constructor
	 */
	public Weapon() {
		super();
	}

	/**
	 * @param itemID
	 *            the item's id formated as a letter referring to the type, and then
	 *            3 numbers
	 * @param type
	 *            what type of item is it, for example a sword, mace, potion, knife,
	 *            etc.
	 * @param level
	 *            what level weapon is it
	 * 
	 *            the damage an price will be generated based on level with this
	 *            constructor
	 */
	public Weapon(String itemID, String type, int level) {
		super(itemID, type);
		this.level = level;
		this.generateDamage();
		this.generatePrice();

	}

	/**
	 * @param itemID
	 *            the item's id formated as a letter referring to the type, and then
	 *            3 numbers
	 * @param price
	 *            how much the item can be sold for
	 * @param type
	 *            what type of item is it, for example a sword, mace, potion, knife,
	 *            etc.
	 * @param level
	 *            what level weapon is it
	 * 
	 *            damage will be generated based on the weapons level
	 */
	public Weapon(String itemID, int price, String type, int level) {
		super(itemID, price, type);
		this.level = level;
		this.generateDamage();

	}

	/**
	 * @return the damage the weapon does
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @param damage
	 *            set the damage the weapon does
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * @return the level of the weapon
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            set the level of the weapon
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * will generate the damage of the weapon based on level and set it to the local
	 * damage variable
	 */
	private void generateDamage() {
		//add 3 per level
		Random rng = new Random();
		int lowerBound = this.level * 3;
		this.damage = rng.nextInt(4) + lowerBound;
	}

	/**
	 * will generate the price of the weapon based on level and set it to the local
	 * price variable
	 */
	private void generatePrice() {
		//based on damage
		this.setPrice(this.damage*3 + this.level);
	}

	/**
	 * @return a string representation of the fields formated as:
	 * 		itemID: (itemID)
	 * 		price: (price)G
	 * 		type: (type)
	 * 		damage: (damage)
	 * 		level: (level)
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString()).append("\ndamage: ").append(this.damage);
		sb.append("\nlevel: ").append(this.level);

		return sb.toString();
	}

	/**
	 * @param W
	 *            another weapon that is to be compared to this
	 * @return a positive number if this has a higher damage, negative if w has a
	 *         greater damage, and 0 if they are equal
	 */
	public int compareTo(Weapon w) {
		return this.getDamage() - w.getDamage();
	}

	/**
	 * @param w
	 *            the weapon that is to be checked for equivalence
	 * @return true if the weapons have equal damage
	 */
	public boolean equals(Weapon w) {
		return this.compareTo(w) == 0 ? true : false;
	}

}
