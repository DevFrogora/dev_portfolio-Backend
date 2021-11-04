package test;

public class ContactPending {

	  private int totalCount;
	  private int pendingCount;
	  private int trueCount;
	  
	  private String canContact;
	  
	  public ContactPending() {
		  super();
	  }

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPendingCount() {
		return pendingCount;
	}

	public void setPendingCount(int pendingCount) {
		this.pendingCount = pendingCount;
	}

	public int getFalseCount() {
		return trueCount;
	}

	public void setFalseCount(int trueCount) {
		this.trueCount = trueCount;
	}

	public String getCanContact() {
		return canContact;
	}

	public void setCanContact(String canContact) {
		this.canContact = canContact;
	}
	
	

	  
}
