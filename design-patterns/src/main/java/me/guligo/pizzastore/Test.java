package me.guligo.pizzastore;

/**
 * Following is an example of abstract factory and factory method patterns. The
 * "abstract factory" provides and interface for creating families of related or
 * dependent objects without specifying their concrete classes. Whereas
 * "factory method" defines an interface for creating an object, but lets
 * subclasses decide which class to instantiate.
 * 
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class Test {

	public static void main(String[] args) {
		PizzaStore store = new NewYorkPizzaStore();
		System.out.println(store.orderPizza("cheese"));

		store = new ChicagoPizzaStore();
		System.out.println(store.orderPizza("cheese"));
	}

}
