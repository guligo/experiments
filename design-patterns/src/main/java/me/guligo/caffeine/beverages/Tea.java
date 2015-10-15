package me.guligo.caffeine.beverages;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public final class Tea extends Beverage {

	@Override
	final void brew() {
		System.out.println("Brewing tea");
	}

	@Override
	final void addCondiments() {
		System.out.println("Adding lemon");
	}

}
