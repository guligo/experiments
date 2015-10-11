package me.guligo.remote.commands;

import me.guligo.remote.api.Light;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class LightOffCommand implements Command {

	private Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.off();
	}

	@Override
	public void undo() {
		light.on();
	}

}
