package me.guligo.remote.commands;

import me.guligo.remote.api.Stereo;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class StereoOffCommand implements Command {

	private Stereo stereo;

	public StereoOffCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.turnItOff();
	}

	@Override
	public void undo() {
		stereo.turnItOn();
	}

}
