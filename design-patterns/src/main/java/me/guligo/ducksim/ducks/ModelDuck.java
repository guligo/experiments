package me.guligo.ducksim.ducks;

import me.guligo.ducksim.behaviors.fly.FlyNoWay;
import me.guligo.ducksim.behaviors.quack.MuteQuack;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class ModelDuck extends Duck {

	public ModelDuck() {
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new MuteQuack());
	}

	@Override
	public void display() {
		System.out.println("I'm a model duck");
	}

}
