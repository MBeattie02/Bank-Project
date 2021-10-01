package part3;

public class Accounts {
	
	private short BankClientID;
	private byte BankAccountID;
	
	
	public void setBankClientID(short bankClientID) {BankClientID = bankClientID;}
	public void setBankAccountID(byte newBankAccountID) {BankAccountID = newBankAccountID;}
	
	public short getBankClientID() { return BankClientID;}
	public byte getBankAccountID() {return BankAccountID;}
}
