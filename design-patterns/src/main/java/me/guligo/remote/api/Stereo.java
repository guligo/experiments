package me.guligo.remote.api;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class Stereo {

	public void turnItOn() {
		System.out.println("Stereo is ready to rock!");
	}

	public void turnCdModeOn() {
		System.out.println("Turning CD mode on");
	}

	public void play() {
		System.out.println("Playing...");
	}

	public void turnItOff() {
		System.out.println("Stereo off");
	}

}
