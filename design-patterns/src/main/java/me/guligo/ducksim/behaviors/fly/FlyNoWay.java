package me.guligo.ducksim.behaviors.fly;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I don't know how to fly");
	}

}
