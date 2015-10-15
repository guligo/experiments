package me.guligo.caffeine;

import me.guligo.caffeine.beverages.Coffee;
import me.guligo.caffeine.beverages.Tea;

/**
 * Following demonstrates template method pattern in action. The
 * "template method" defines steps of an algorithm and allows subclasses to
 * provide the implementation for one or more steps.
 * 
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class CaffeineTest {

	public static void main(String[] args) {
		Coffee coffee = new Coffee();
		coffee.prepare();

		Tea tea = new Tea();
		tea.prepare();
	}

}
