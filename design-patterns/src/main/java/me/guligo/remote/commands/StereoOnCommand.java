package me.guligo.remote.commands;

import me.guligo.remote.api.Stereo;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class StereoOnCommand implements Command {

	private Stereo stereo;

	public StereoOnCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.turnItOn();
		stereo.turnCdModeOn();
		stereo.play();
	}

	@Override
	public void undo() {
		stereo.turnItOff();
	}

}
