package design.command.hf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoteControlTest {

	private static final Logger logger = LoggerFactory.getLogger(RemoteControlTest.class);

	public static void main(String[] args) {

		SimpleRemoteControl remoteControl = new SimpleRemoteControl();
		Light light = new Light();
		LightOnCommand lightOnCommand = new LightOnCommand(light);
		remoteControl.setSlot(lightOnCommand);
		remoteControl.buttonWasPressed();
	}

}
