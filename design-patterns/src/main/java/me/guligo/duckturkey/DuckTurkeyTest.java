package me.guligo.duckturkey;

/**
 * Demonstrates adapter pattern in action. The "adapter pattern" converts the
 * interface of a class into another interface the client expects. Adapter lets
 * classes work together that couldn't otherwise because of incompatible
 * interfaces.
 * 
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class DuckTurkeyTest {

	public static void main(String[] args) {
		Duck wannabe = new TurkeyAdapter(new Turkey());
		wannabe.quack();
		wannabe.fly();
	}

}
