package me.guligo.remote;

import me.guligo.remote.commands.Command;
import me.guligo.remote.commands.NoCommand;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class RemoteControl {

	private Command onSlots[];
	private Command offSlots[];
	private Command lastUsedSlot;

	public RemoteControl() {
		onSlots = new Command[4];
		offSlots = new Command[4];
		lastUsedSlot = new NoCommand();
	}

	public void setOnSlot(int index, Command slot) {
		onSlots[index] = slot;
	}

	public void setOffSlot(int index, Command slot) {
		offSlots[index] = slot;
	}

	public void onButtonPressed(int index) {
		onSlots[index].execute();
		lastUsedSlot = onSlots[index];
	}

	public void offButtonPressed(int index) {
		offSlots[index].execute();
		lastUsedSlot = offSlots[index];
	}

	public void undoButtonPressed() {
		lastUsedSlot.undo();
	}

}
