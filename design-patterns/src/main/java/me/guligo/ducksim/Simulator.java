package me.guligo.ducksim;

import me.guligo.ducksim.behaviors.fly.FlyRocketPowered;
import me.guligo.ducksim.ducks.Duck;
import me.guligo.ducksim.ducks.MallardDuck;
import me.guligo.ducksim.ducks.ModelDuck;

/**
 * Following is an example of strategy pattern. The "strategy pattern defines" a
 * family of algorithms, encapsulates each one, and makes them interchangeable.
 * Strategy lets the algorithm vary independently from clients that use it.
 * 
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class Simulator {

	public static void main(String[] args) {
		Duck mallardDuck = new MallardDuck();
		mallardDuck.fly();
		mallardDuck.quack();

		Duck modelDuck = new ModelDuck();
		modelDuck.fly();
		modelDuck.setFlyBehavior(new FlyRocketPowered());
		modelDuck.fly();
	}

}
