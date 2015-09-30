package me.guligo.starbuzz.beverages;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class HouseBlend extends Beverage {

	public HouseBlend() {
		super("House Blend Coffee");
	}

	@Override
	public double getCost() {
		return 0.89;
	}

}
