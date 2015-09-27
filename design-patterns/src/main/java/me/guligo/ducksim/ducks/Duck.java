package me.guligo.ducksim.ducks;

import me.guligo.ducksim.behaviors.fly.FlyBehavior;
import me.guligo.ducksim.behaviors.quack.QuackBehavior;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public abstract class Duck {

	private FlyBehavior flyBehavior;
	private QuackBehavior quackBehavior;

	public Duck() {
		// do nothing
	}

	public abstract void display();

	public void fly() {
		flyBehavior.fly();
	}

	public void quack() {
		quackBehavior.quack();
	}

	public void swim() {
		System.out.println("All ducks float");
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

}
