package me.guligo.starbuzz;

import me.guligo.starbuzz.beverages.Beverage;
import me.guligo.starbuzz.beverages.Espresso;
import me.guligo.starbuzz.beverages.condiments.Mocha;
import me.guligo.starbuzz.beverages.condiments.Whip;

/**
 * Following is an example of decorator pattern. The "decorator pattern"
 * attaches additional responsibilities to an object dynamically. Decorators
 * provide a flexible alternative to sub-classing for extending functionality.
 * 
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class StarbuzzCoffee {

	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " = "
				+ beverage.getCost());

		beverage = new Whip(new Mocha(new Espresso()));
		System.out.println(beverage.getDescription() + " = "
				+ beverage.getCost());
	}

}
