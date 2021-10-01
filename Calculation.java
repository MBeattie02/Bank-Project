package part3;

public class Calculation {
	private double Balance;
	
	protected void setBalance(double newBalance) {Balance = newBalance;}
	public double getBalance() {return Balance;}
	
	public boolean deposit(double amt) {
		if (amt>0.0) {
			Balance += amt;
			
			return true;
		}
		return false;
	}
	
	
	
	
	public boolean withdraw(double amt) {
		if (amt>0.0 && (Balance-amt>=0.0)) {
			Balance -= amt;
			
			return true;
		}
		return false;
	}
}
