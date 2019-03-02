package edu.neumont.light.javarpg.models;

import edu.neumont.light.javarpg.models.enums.SkillEffect;

/**
 * @author cole
 *
 */
public class PassiveSkill extends Skill {

	private SkillEffect effect;

	private double potency;

	/**
	 * default constructor that calls the super's default constructor
	 */
	public PassiveSkill() {
		super();
	}

	/**
	 * @param description
	 *            a description of the skill
	 * @param unlocked
	 *            a boolean for whether the skill is unlocked or not
	 * @param name
	 *            the name of the skill
	 * @param effect
	 *            the type of effect the skill has. i.e. a damage multiplier or
	 *            damage resistance
	 * @param potency
	 *            how strong the effect is as a number(how many times is the damage
	 *            multiplied or damage decreased)
	 */
	public PassiveSkill(String description, boolean unlocked, String name, SkillEffect effect, double potency, int cost) {
		super(description, unlocked, name, cost);
		this.effect = effect;
		this.potency = potency;
	}

	/**
	 * @param description
	 *            a description of the skill
	 * @param name
	 *            the name of the skill
	 * @param effectthe
	 *            type of effect the skill has. i.e. a damage multiplier or damage
	 *            resistance
	 * @param potency
	 *            how strong the effect is as a number(how many times is the damage
	 *            multiplied or damage decreased)
	 * 
	 *            unlocked is set to false by default
	 */
	public PassiveSkill(String description, String name, SkillEffect effect, double potency, int cost) {
		super(description, name, cost);
		this.effect = effect;
		this.potency = potency;
	}

	/**
	 * @return the type of effect the skill has
	 */
	public SkillEffect getEffect() {
		return effect;
	}

	/**
	 * @param effect
	 *            set the type of effect the skill has
	 */
	public void setEffect(SkillEffect effect) {
		this.effect = effect;
	}

	/**
	 * @return how strong the effect is
	 */
	public double getPotency() {
		return potency;
	}

	/**
	 * @param potency
	 *            set how strong the effect is
	 */
	public void setPotency(double potency) {
		this.potency = potency;
	}

}
