package me.guligo.pizzastore.pizzas;

import me.guligo.pizzastore.ingredients.Cheese;
import me.guligo.pizzastore.ingredients.Dough;
import me.guligo.pizzastore.ingredients.IngredientFactory;
import me.guligo.pizzastore.ingredients.Sauce;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public abstract class Pizza {

	private IngredientFactory ingredientFactory;
	private String name;
	private Dough dough;
	private Cheese cheese;
	private Sauce sauce;

	Pizza(IngredientFactory ingredientFactory, String name) {
		this.ingredientFactory = ingredientFactory;
		this.name = name;
	}

	public abstract void prepare();

	public void bake() {
		System.out.println("Bake for 25 minutes at 350 degrees");
	}

	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	public void box() {
		System.out.println("Place pizza in pretty box");
	}

	IngredientFactory getIngredientFactory() {
		return ingredientFactory;
	}

	void setDough(Dough dough) {
		this.dough = dough;
	}

	void setCheese(Cheese cheese) {
		this.cheese = cheese;
	}

	void setSauce(Sauce sauce) {
		this.sauce = sauce;
	}

	@Override
	public String toString() {
		return "{ name = " + name + ", daugh = " + dough + ", cheese = "
				+ cheese + ", sauce = " + sauce + " }";
	}

}
