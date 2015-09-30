package me.guligo.starbuzz.beverages;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public abstract class Beverage {

	private String description;

	public Beverage(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public abstract double getCost();

}
