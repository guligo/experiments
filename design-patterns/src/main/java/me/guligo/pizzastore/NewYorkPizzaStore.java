package me.guligo.pizzastore;

import me.guligo.pizzastore.ingredients.NewYorkIngredientFactory;
import me.guligo.pizzastore.pizzas.CheesePizza;
import me.guligo.pizzastore.pizzas.Pizza;
import me.guligo.pizzastore.pizzas.SimplePizza;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class NewYorkPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String pizzaType) {
		if ("cheese".equals(pizzaType)) {
			return new CheesePizza(new NewYorkIngredientFactory());
		} else {
			return new SimplePizza(new NewYorkIngredientFactory());
		}
	}

}
