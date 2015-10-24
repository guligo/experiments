package me.guligo.restaurant;

/**
 * Following demonstrates composite pattern in action. The "composite pattern"
 * allows you to compose objects into tree structures to represent part-whole
 * hierarchies. Composite lets clients treat individual objects and compositions
 * of objects uniformly.
 * 
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class Main {

	public static void main(String[] args) {
		MenuItem coffee = new MenuItem("Coffee", 0.95);
		MenuItem tea = new MenuItem("Tea", 0.50);
		MenuItem juice = new MenuItem("Juice", 0.99);
		MenuItem beer = new MenuItem("Beer", 1.50);
		MenuItem wine = new MenuItem("Wine", 2.05);

		Menu alcohol = new Menu("Alcohol");
		alcohol.addChild(beer);
		alcohol.addChild(wine);

		Menu menu = new Menu("Beverages");
		menu.addChild(coffee);
		menu.addChild(tea);
		menu.addChild(juice);
		menu.addChild(alcohol);

		System.out.println(menu.toString());
	}

}
