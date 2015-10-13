package me.guligo.duckturkey;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class TurkeyAdapter implements Duck {

	private Turkey adaptee;

	public TurkeyAdapter(Turkey turkey) {
		this.adaptee = turkey;
	}

	@Override
	public void fly() {
		for (int i = 0; i < 5; i++) {
			adaptee.makeMove();
		}
	}

	@Override
	public void quack() {
		adaptee.makeSound();
	}

}
