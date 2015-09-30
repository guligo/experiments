package me.guligo.starbuzz.beverages.condiments;

import me.guligo.starbuzz.beverages.Beverage;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class Mocha extends Condiment {

	private Beverage beverage;

	public Mocha(Beverage beverage) {
		super(beverage.getDescription() + ", Mocha");
		this.beverage = beverage;
	}

	@Override
	public double getCost() {
		return 0.20 + beverage.getCost();
	}

}
