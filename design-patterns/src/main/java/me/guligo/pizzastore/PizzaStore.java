package me.guligo.pizzastore;

import me.guligo.pizzastore.pizzas.Pizza;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public abstract class PizzaStore {

	public Pizza orderPizza(String pizzaType) {
		Pizza pizza = createPizza(pizzaType);
		pizza.prepare();
		pizza.bake();
		pizza.box();
		return pizza;
	}

	protected abstract Pizza createPizza(String pizzaType);

}
