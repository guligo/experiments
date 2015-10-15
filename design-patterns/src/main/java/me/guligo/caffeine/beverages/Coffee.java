package me.guligo.caffeine.beverages;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public final class Coffee extends Beverage {

	@Override
	final void brew() {
		System.out.println("Brewing coffee");
	}

	@Override
	final void addCondiments() {
		System.out.println("Adding milk");
	}

}
