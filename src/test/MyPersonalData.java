package test;

public class MyPersonalData {
	
	private String name;
	private String email;
	private String currentWorking;
	
	public MyPersonalData() {
		// TODO Auto-generated constructor stub
		super();
	}

	public MyPersonalData(String name, String email, String currentWorking) {
		super();
		this.name = name;
		this.email = email;
		this.currentWorking = currentWorking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurrentWorking() {
		return currentWorking;
	}

	public void setCurrentWorking(String currentWorking) {
		this.currentWorking = currentWorking;
	}
	
	

}
