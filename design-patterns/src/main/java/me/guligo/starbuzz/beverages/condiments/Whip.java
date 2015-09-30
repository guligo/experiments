package me.guligo.starbuzz.beverages.condiments;

import me.guligo.starbuzz.beverages.Beverage;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class Whip extends Condiment {

	private Beverage beverage;

	public Whip(Beverage beverage) {
		super(beverage.getDescription() + ", Whip");
		this.beverage = beverage;
	}

	@Override
	public double getCost() {
		return 0.30 + beverage.getCost();
	}

}
