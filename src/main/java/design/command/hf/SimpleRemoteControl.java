package design.command.hf;

public class SimpleRemoteControl {

	private Command slot;

	public SimpleRemoteControl() {
		super();
	}

	// set when command changed
	public void setSlot(Command slot) {
		this.slot = slot;
	}

	public void buttonWasPressed() {
		slot.execute();
	}
}
