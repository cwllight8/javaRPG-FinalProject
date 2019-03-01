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
	
	public Chest() {}
	
}
