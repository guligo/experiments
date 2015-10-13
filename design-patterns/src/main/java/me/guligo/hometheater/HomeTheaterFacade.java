package me.guligo.hometheater;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class HomeTheaterFacade {

	private Player player;
	private Screen screen;
	private Stereo stereo;

	public HomeTheaterFacade(Player player, Screen screen, Stereo stereo) {
		this.player = player;
		this.screen = screen;
		this.stereo = stereo;
	}

	public void playMovie() {
		player.play();
		screen.show();
		stereo.loud();
	}

}
