package me.guligo.starbuzz.beverages;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class Espresso extends Beverage {

	public Espresso() {
		super("Espresso");
	}

	@Override
	public double getCost() {
		return 1.99;
	}

}
