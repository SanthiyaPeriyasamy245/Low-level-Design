package Bank;

import java.io.IOException;

import Customers.Customer;
import Customers.CustomerFileHandler;
import Transaction.Transaction;
import Transaction.TransactionHandler;

// Task5:deposit,withdraw,money transfer.

public class AccountHandler {
	
	public void deposit(int custId,double amount) throws IOException
	{
	   Customer user=Bank.customerMap.get(custId);
	   if(amount<0)
	   {
		   return;
	   }
	   user.balance+=amount;
	   Bank.customerMap.put(custId,user);
	   CustomerFileHandler.getInstance().fileWriter();
	   System.out.println("Amount Deposited Successfully!");
	   TransactionHandler history=new TransactionHandler();
	   int transId=history.getLastTransactionId(custId);
	   Transaction transferHistory=new Transaction(transId+1,"Depoist",amount,user.balance);
	   history.writeTransaction(custId, transferHistory);
	}
	public boolean withdraw(int custId,double amount) throws IOException
	{
		Customer user=Bank.customerMap.get(custId);
		double balance=user.balance-amount;
		if(balance>=1000)
		{
			user.balance-=amount;
			Bank.customerMap.put(custId,user);
			CustomerFileHandler.getInstance().fileWriter();
			 TransactionHandler history=new TransactionHandler();
			  int transId=history.getLastTransactionId(custId);
			  Transaction transferHistory=new Transaction(transId+1,"Withdrawn",amount,user.balance);
			  history.writeTransaction(custId, transferHistory);
			  System.out.println("Amount withdrawn Successfully!");
			
			return true;
		}
		System.out.println("withdrawn failed : Insufficient Balance! check your Account balance!");
		return false;
		
	}
	public void transfer(int fromCustId,int toCustId,double amount ) throws IOException {
		
		Customer toCustomer=Bank.customerMap.get(toCustId);
		if(toCustomer==null)
		{
			System.out.println("customer id to send amount is not found!");
			return;
		}
		Customer fromCustomer=Bank.customerMap.get(fromCustId);
		boolean check_balance=withdraw(fromCustomer.customerId,amount);
		if(!check_balance)
		{
			System.out.println("Insufficent bank balance check your balance!");
		}
		System.out.printf("Amount of rupees"+"%.2f"+" transfered from"+"%d"+" customer id"+" to"+"%d"+" customerid\n",amount,fromCustId,toCustId);
	    deposit(toCustId,amount);
	    
		System.out.println("Transaction done successfully!");
	}
	
	

}
