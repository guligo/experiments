package me.guligo.starbuzz.beverages.condiments;

import me.guligo.starbuzz.beverages.Beverage;

/**
 * Also known as an abstract decorator.
 * 
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public abstract class Condiment extends Beverage {

	public Condiment(String description) {
		super(description);
	}

}
