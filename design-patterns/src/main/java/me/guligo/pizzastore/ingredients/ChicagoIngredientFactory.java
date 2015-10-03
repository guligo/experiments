package me.guligo.pizzastore.ingredients;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class ChicagoIngredientFactory implements IngredientFactory {

	@Override
	public Dough createDough() {
		return new VeryThinCrustDough();
	}

	@Override
	public Cheese createCheese() {
		return new GoatCheese();
	}

	@Override
	public Sauce createSauce() {
		return new BruschettaSauce();
	}

}
