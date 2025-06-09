package Transaction;

public class Transaction {
 
	@Override
	public String toString() {
		return  trancsactionId + " " + type + " " + amount + " "
				+ balance;
	}

	public int trancsactionId;
	public String type;
	public double amount;
	public double balance;
	
	public Transaction(int trancsactionId, String type, double amount, double balance) {
		
		this.trancsactionId = trancsactionId;
		this.type = type;
		this.amount = amount;
		this.balance = balance;
	}
	
}
