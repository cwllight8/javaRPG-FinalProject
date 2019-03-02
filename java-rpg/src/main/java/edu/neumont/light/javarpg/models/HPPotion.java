package edu.neumont.light.javarpg.models;

/**
 * @author cole
 *
 */
public class HPPotion extends Item implements Comparable<HPPotion>{

	private int hpRegen;

	/**
	 * default constructor that calls the super's default constructor and sets hpRegen to 40;
	 */
	public HPPotion() {
		super();
		this.hpRegen = 40;
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
	 *            
	 *            sets hpRegen to 40 by default
	 */
	public HPPotion(String itemID, int price, String type) {
		super(itemID, price, type);
		this.hpRegen = 40;
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
	 * @param hpRegen the amount of HP restored when the potion is used
	 */
	public HPPotion(String itemID, int price, String type, int hpRegen) {
		super(itemID, price, type);
		this.hpRegen = hpRegen;
	}

	/**
	 * @return the HP that the potion restores
	 */
	public int getHpRegen() {
		return hpRegen;
	}
	

	/**
	 * @return the amount of HP that will be restored from this potion
	 * 
	 * also sets the hpRegen to 0 so the same potion cannot be used again
	 */
	public int usePotion() {
		int temp = this.hpRegen;
		this.hpRegen = 0;
		return temp;
	}

	/**
	 * @param h the hpPotion that is to be compared to this
	 * @return positive if this potion will restore a greater amount of HP, 0 if they are equal, and negative if h will restore a greater amount of HP
	 */
	public int compareTo(HPPotion h) {
		return this.getHpRegen() - h.getHpRegen();
	}
	
	/**
	 * @param h the hpPotion that is to be compared for equivalence
	 * @return true if they are equal and false if they are not
	 */
	public boolean equals(HPPotion h) {
		return this.compareTo(h) == 0;
	}
	
	/**
	 * @return a string representation of the fields formated as:
	 * 		itemID: (itemID)
	 * 		price: (price)G
	 * 		type: (type)
	 * 		HP restored: (hpRegen)
	 */
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString()).append("\nHP restored: ").append(this.hpRegen);
		
		return sb.toString();
	}
}
