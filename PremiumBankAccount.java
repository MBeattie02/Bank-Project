package part3;

public class PremiumBankAccount extends BankAccount{
	
	private float fee;
	private double totalCashBackAmount;
	
	public void setFee(float newFee ) {fee=newFee;}
	public void setTotalCashBackAmount(double newTotalCashBackAmount){totalCashBackAmount = newTotalCashBackAmount;}
	
	public float getFee() {return fee;}
	public double getTotalCashBackAmount() {return totalCashBackAmount;}
	
	

}	
	

