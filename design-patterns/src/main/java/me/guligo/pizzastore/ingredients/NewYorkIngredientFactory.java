package me.guligo.pizzastore.ingredients;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class NewYorkIngredientFactory implements IngredientFactory {

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

}
