package me.guligo.ducksim.ducks;

import me.guligo.ducksim.behaviors.fly.FlyWithWings;
import me.guligo.ducksim.behaviors.quack.SimpleQuack;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class MallardDuck extends Duck {

	public MallardDuck() {
		setFlyBehavior(new FlyWithWings());
		setQuackBehavior(new SimpleQuack());
	}

	@Override
	public void display() {
		System.out.println("What's up homies, I'm real Mallard duck!");
	}

}
