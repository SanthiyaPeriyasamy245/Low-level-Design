package Customers;

public class Customer {

	

	public int customerId;
	public String name;
	public double balance;
	public String password;
	public long accountNo;
	
	public Customer(int customerId, String name, double balance, String password, long accountNo) {
		
		this.customerId = customerId;
		this.name = name;
		this.balance = balance;
		this.password = password;
		this.accountNo = accountNo;
	}
	
	@Override
	public String toString() {
		return "\n"+customerId +" "+ accountNo + " "+name +" "+
				 balance +" "+password ;
	}
	
}
