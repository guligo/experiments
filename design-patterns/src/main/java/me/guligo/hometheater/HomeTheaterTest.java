package me.guligo.hometheater;

/**
 * Following is an example of facade design pattern. The "facade pattern"
 * provides a unified interface to a set of interfaces in a subsystem. Facade
 * defines a higher-level interface that makes the subsystem easier to use.
 * 
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class HomeTheaterTest {

	public static void main(String[] args) {
		Player player = new Player();
		Screen screen = new Screen();
		Stereo stereo = new Stereo();

		HomeTheaterFacade homeTheater = new HomeTheaterFacade(player, screen, stereo);
		homeTheater.playMovie();
	}

}
