package me.guligo.pizzastore.ingredients;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public interface IngredientFactory {

	public Dough createDough();

	public Cheese createCheese();

	public Sauce createSauce();

}
