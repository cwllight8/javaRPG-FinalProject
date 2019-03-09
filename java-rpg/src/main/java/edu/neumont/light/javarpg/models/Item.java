package edu.neumont.light.javarpg.models;

import java.io.Serializable;

/**
 * @author cole
 *
 */
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private String itemID;

	private int price;

	private String type;

	/**
	 * default constructor that does not initialize anything
	 */
	public Item() {
	}

	/**
	 * @param itemID
	 *            the item's id formated as a letter referring to the type, and then
	 *            3 numbers
	 * @param type
	 *            what type of item is it, for example a sword, mace, potion, knife,
	 *            etc.
	 */
	public Item(String itemID, String type) {
		this.itemID = itemID;
		this.type = type;
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
	 */
	public Item(String itemID, int price, String type) {
		this.itemID = itemID;
		this.price = price;
		this.type = type;
	}

	/**
	 * @return the item's id
	 */
	public String getItemID() {
		return itemID;
	}

	/**
	 * @param itemID
	 *            set the item's id
	 */
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	/**
	 * @return the price the item can be sold for
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            set the price the item can be sold for
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the type of item it is
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            set the type of item it is
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return a string representation of the fields formated as: itemID: (itemID)
	 *         price: (price)G type: (type)
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("itemID: ").append(this.itemID).append("\nprice : ").append(this.price).append("G \ntype: ")
				.append(this.type);

		return sb.toString();
	}

}
