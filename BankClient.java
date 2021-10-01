package part3;

public class BankClient {

	private short bankClientID;
	public Profile profile = new Profile();
	public Details details = new Details();
	
	
	
	
	
	
	public void setBankClientID ( short newBankClientID ) { bankClientID = newBankClientID; }
	public void setProfile ( Profile newProfile ) { profile = newProfile; }
	public void setDetails(Details newDetails) {details = newDetails;}
	

	public short getBankClientID () { return bankClientID; }
	public Profile getProfile () { return profile; }
	public Details getDetails() {return details;}
	
	
	
}

		
		

