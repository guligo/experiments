package me.guligo.pizzastore.ingredients;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
abstract class Ingredient {

	private String name;

	Ingredient(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{ name = " + this.name + " }";
	}

}
