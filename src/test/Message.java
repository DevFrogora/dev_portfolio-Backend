package test;

import java.util.Date;

public class Message {

	private String username;
	private String message;
	private String email;
	private String message_type;
	
	private boolean pending;
	private Date date =null;
	
	public Message() {

		super();
	}
	
	public Message(String username, String message, String email, String message_type) {
		super();
		this.username = username;
		this.message = message;
		this.email = email;
		this.message_type = message_type;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage_type() {
		return message_type;
	}
	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}

	public boolean isPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}
	
	
}
