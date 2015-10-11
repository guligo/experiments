package me.guligo.remote.api;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class Light {

	private String room;

	public Light(String room) {
		this.room = room;
	}

	public void on() {
		System.out.println("Light in " + room + " is on");
	}

	public void off() {
		System.out.println("Light in " + room + " is off");
	}

}
