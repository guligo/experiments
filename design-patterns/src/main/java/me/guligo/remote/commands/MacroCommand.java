package me.guligo.remote.commands;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class MacroCommand implements Command {

	private Command[] commands;

	public MacroCommand(Command... commands) {
		this.commands = commands;
	}

	@Override
	public void execute() {
		for (Command command : commands) {
			command.execute();
		}
	}

	@Override
	public void undo() {
		for (Command command : commands) {
			command.undo();
		}
	}

}
