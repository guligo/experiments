package me.guligo.caffeine.beverages;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public abstract class Beverage {

	public final void prepare() {
		boilWater();
		brew();
		pourIntoCup();
		addCondiments();
	}

	void boilWater() {
		System.out.println("Boiling water");
	}

	abstract void brew();

	void pourIntoCup() {
		System.out.println("Filling the cup");
	}

	abstract void addCondiments();

}
