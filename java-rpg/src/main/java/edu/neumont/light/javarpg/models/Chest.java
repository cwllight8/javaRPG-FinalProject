package edu.neumont.light.javarpg.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author cole
 *
 */
public class Chest {

	private Random rand = new Random();

	private List<Item> loot = new ArrayList<>();

	/**
	 * default constructor
	 */
	public Chest() {
	}

	/**
	 * @param pLevel
	 *            the players level
	 * @return a list of items that were generated randomly
	 */
	public List<Item> generateLoot(int pLevel) {

		this.loot.clear();

		int numOfItems = this.generateAmountOfLoot();
		for (int i = 0; i < numOfItems; i++) {
			generateTypeOfLoot(pLevel);
		}

		return this.loot;
	}

	/**
	 * @return a random number between 2 and 5 for how much loot will be dropped
	 */
	private int generateAmountOfLoot() {

		return rand.nextInt(4) + 2;

	}

	/**
	 * @param pLevel
	 *            the players level
	 * 
	 *            will generate either a weapon(60%) or a potion(40%) and adds it to
	 *            the loot array
	 */
	private void generateTypeOfLoot(int pLevel) {
		// 60 weapon 40 potion
		int chance = rand.nextInt(100) + 1;
		if (chance < 61) {
			// weapon
			Item weapon = new Weapon("S001", "Sword", this.generateItemLevel(pLevel));
			this.loot.add(weapon);
		} else {
			// potion
			Item potion = new HPPotion("H001", 15, "Health Potion");
			this.loot.add(potion);
		}
	}

	/**
	 * @param pLevel
	 *            the players level
	 * @return the level the item generated will be
	 */
	private int generateItemLevel(int pLevel) {
		if (pLevel <= 2) {
			return rand.nextInt(2) + pLevel;
		} else {
			int lowerBound = pLevel - 2;
			return rand.nextInt(5) + lowerBound;
		}
	}

	/**
	 * @return a list of loot that was generated
	 */
	public List<Item> getLoot() {
		return loot;
	}

	/**
	 * @param loot
	 *            takes in a list of items and sets loot to it
	 */
	public void setLoot(List<Item> loot) {
		this.loot = loot;
	}

}
