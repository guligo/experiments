package me.guligo.remote.commands;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class NoCommand implements Command {

	@Override
	public void execute() {
		// do nothing
	}

	@Override
	public void undo() {
		// do nothing
	}

}
