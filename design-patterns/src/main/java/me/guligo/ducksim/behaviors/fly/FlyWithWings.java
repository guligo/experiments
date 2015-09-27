package me.guligo.ducksim.behaviors.fly;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I'm flying!");
	}

}
