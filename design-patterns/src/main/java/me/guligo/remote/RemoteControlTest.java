package me.guligo.remote;

import me.guligo.remote.api.Light;
import me.guligo.remote.api.Stereo;
import me.guligo.remote.commands.LightOffCommand;
import me.guligo.remote.commands.LightOnCommand;
import me.guligo.remote.commands.MacroCommand;
import me.guligo.remote.commands.StereoOffCommand;
import me.guligo.remote.commands.StereoOnCommand;

/**
 * Following is an example of command pattern. The "command pattern"
 * encapsulates a request as an object, thereby letting you parametrize other
 * objects with different requests, queue or requests, and support undoable
 * operations.
 * 
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class RemoteControlTest {

	public static void main(String[] args) {
		Light livingRoomLight = new Light("living room");
		Light kitchenLight = new Light("kitchen");
		Stereo stereo = new Stereo();

		LightOnCommand livingRoomLightOnCommand = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOffCommand = new LightOffCommand(livingRoomLight);
		LightOnCommand kitchenLightOnCommand = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenLightOffCommand = new LightOffCommand(kitchenLight);
		StereoOnCommand stereoOnCommand = new StereoOnCommand(stereo);
		StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);
		MacroCommand partyOnCommand = new MacroCommand(livingRoomLightOnCommand, kitchenLightOnCommand, stereoOnCommand);
		MacroCommand partyOffCommand = new MacroCommand(livingRoomLightOffCommand, kitchenLightOffCommand, stereoOffCommand);

		RemoteControl control = new RemoteControl();
		control.setOnSlot(0, livingRoomLightOnCommand);
		control.setOffSlot(0, livingRoomLightOffCommand);
		control.setOnSlot(1, kitchenLightOnCommand);
		control.setOffSlot(1, kitchenLightOffCommand);
		control.setOnSlot(2, stereoOnCommand);
		control.setOffSlot(2, stereoOffCommand);
		control.setOnSlot(3, partyOnCommand);
		control.setOffSlot(3, partyOffCommand);

		control.onButtonPressed(3);
	}

}
