package me.guligo.theone;

/**
 * @author guligo
 */
public class TheOne {

	private static TheOne instance;

	public static synchronized TheOne getInstance() {
		if (instance == null) {
			instance = new TheOne();
		}
		return instance;
	}

	private TheOne() {
		// do nothing
	}

	public String saySomething() {
		return this.toString();
	}

}
