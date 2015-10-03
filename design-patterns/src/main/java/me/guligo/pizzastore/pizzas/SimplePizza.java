package me.guligo.pizzastore.pizzas;

import me.guligo.pizzastore.ingredients.IngredientFactory;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class SimplePizza extends Pizza {

	public SimplePizza(IngredientFactory ingredientFactory) {
		super(ingredientFactory, "Simple Pizza");
	}

	@Override
	public void prepare() {
		setDough(getIngredientFactory().createDough());
		setCheese(getIngredientFactory().createCheese());
	}

}
