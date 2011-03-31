// Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

package projectubernahme;

public class LogMessage {
	
	private String msg;
	private Enum<MessageTypes> type;

	public LogMessage(String s, Enum<MessageTypes> type) {
		setMsg(s);
		this.setType(type);
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setType(Enum<MessageTypes> type) {
		this.type = type;
	}

	public Enum<MessageTypes> getType() {
		return type;
	}

}
