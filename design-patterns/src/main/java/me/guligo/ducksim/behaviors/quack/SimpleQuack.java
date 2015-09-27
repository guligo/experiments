package me.guligo.ducksim.behaviors.quack;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class SimpleQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Quack!");
	}

}
