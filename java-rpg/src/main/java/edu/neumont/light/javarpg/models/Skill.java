package edu.neumont.light.javarpg.models;

/**
 * @author cole
 *
 */
public class Skill {

	private String description;

	private boolean unlocked;

	private String name;
	
	private int cost;

	/**
	 * default constructor with no initializations
	 */
	public Skill() {
	}

	/**
	 * @param description
	 *            a brief description of what the skill does
	 * @param name
	 *            the name of the skill
	 * 
	 *            will set unlocked to false
	 * @param cost how many skill points the skill costs
	 */
	public Skill(String description, String name, int cost) {
		this.description = description;
		this.name = name;
		this.unlocked = false;
		this.cost = cost;
	}

	/**
	 * @param description
	 *            a brief description of what the skill does
	 * @param unlocked
	 *            a boolean so that it can be checked whether the skill has been
	 *            unlocked or not
	 * @param name
	 *            the name of the skill
	 *             @param cost how many skill points the skill costs
	 */
	public Skill(String description, boolean unlocked, String name, int cost) {
		this.description = description;
		this.unlocked = unlocked;
		this.name = name;
		this.cost = cost;
	}

	/**
	 * @return a description of what the skill does
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            set the description for what a skill does
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return returns true if the skill is unlocked and false if it is not
	 */
	public boolean isUnlocked() {
		return unlocked;
	}

	/**
	 * @param unlocked
	 *            sets whether the skill is unlocked or not
	 */
	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}

	/**
	 * @return the name of the skill
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            sets the name of the skill
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the number of skillpoints this skill costs to unlock
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @param cost set the number of skillpoints this skill costs to unlock
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * @return will return false if the skill has already been unlocked and true if
	 *         it has not. in the case that the skill is not already unlocked it
	 *         will also set it to be unlocked.
	 *         
	 * @param pSP the players total skill points 
	 */
	public boolean unlockStill(int pSP) {
		if (this.isUnlocked()) {
			return false;
		}
		if(pSP >= this.cost) {
			
			this.unlocked = true;
			return true;
		}
		return false;
	}

	/**
	 * @return a string formated as:
	 * 			name:
	 * 			cost: (cost) SP
	 * 			description
	 */
	@Override
	public String toString() {
		return name + ":\ncost: " + this.cost + " SP\n" + description;
	}

}
