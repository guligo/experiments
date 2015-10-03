package me.guligo.pizzastore.pizzas;

import me.guligo.pizzastore.ingredients.IngredientFactory;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class CheesePizza extends Pizza {

	public CheesePizza(IngredientFactory ingredientFactory) {
		super(ingredientFactory, "Cheese Pizza");
	}

	@Override
	public void prepare() {
		setDough(getIngredientFactory().createDough());
		setCheese(getIngredientFactory().createCheese());
		setSauce(getIngredientFactory().createSauce());
	}

}
