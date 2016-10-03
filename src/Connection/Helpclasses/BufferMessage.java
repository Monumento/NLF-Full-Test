package Connection.Helpclasses;

public class BufferMessage {

	// priorität von 1(eher unwichtig)-5(sehr wichtig)

	public String message;
	public int priority;

	public BufferMessage(int priority, String message) {
		this.message = message;
		this.priority = priority;
	}

}
