package edu.neumont.light.javarpg.models;

/**
 * @author cole
 *
 */
public class DamageSkill extends Skill {

	private int damage;

	/**
	 * default constructor that calls the super's default constructor
	 */
	public DamageSkill() {
		super();
	}
	
	/**
	 * @param description
	 *            a description of the skill
	 * @param unlocked
	 *            a boolean for whether the skill is unlocked or not
	 * @param name
	 *            the name of the skill
	 * @param damage
	 *            how much damage the skill does
	 */
	public DamageSkill(String description, boolean unlocked, String name, int damage, int cost) {
		super(description, unlocked, name, cost);
		this.damage = damage;
	}

	/**
	 * @param description
	 *            a description of the skill
	 * @param name
	 *            the name of the skill
	 * @param damage
	 *            how much damage the skill does
	 * 
	 *            sets unlocked to false by default
	 */
	public DamageSkill(String description, String name, int damage, int cost) {
		super(description, name, cost);
		this.damage = damage;
	}

	/**
	 * @return how much damage the skill does
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @param damage
	 *            sets how much damage the skill does
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

}
