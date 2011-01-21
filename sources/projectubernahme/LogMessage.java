package projectubernahme;

public class LogMessage {
	
	public String msg;
	public Enum<MessageTypes> type;

	public LogMessage(String s, Enum<MessageTypes> type) {
		msg = s;
		this.type = type;
	}

}
