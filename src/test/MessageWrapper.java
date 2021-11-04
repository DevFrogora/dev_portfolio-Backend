package test;

import java.util.List;

public class MessageWrapper {
	
	private String can_contact;
	private List<Message> messages;
	
	public MessageWrapper() {
		super();
	}
	public String getCan_contact() {
		return can_contact;
	}
	public void setCan_contact(String can_contact) {
		this.can_contact = can_contact;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
