package me.guligo.ducksim.behaviors.quack;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("I have absolutely nothing to say");
	}

}
