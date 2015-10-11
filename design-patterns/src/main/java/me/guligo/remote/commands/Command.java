package me.guligo.remote.commands;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public interface Command {

	public void execute();

	public void undo();

}
