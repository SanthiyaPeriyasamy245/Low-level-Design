package Customers;

import Bank.Bank;
import Transaction.Transaction;
import Transaction.TransactionHandler;

import java.io.IOException;
import java.util.Scanner;

public class CustomerHandler {
	public void addCustomer() throws IOException
	{
		Scanner input=new Scanner(System.in);
		System.out.print("Enter Your Name:");
		String name=input.nextLine();
		System.out.print("Enter Password :");
		String password=input.nextLine();
		System.out.print("Enter Password again :");
		String retyped_password=input.nextLine();
		if(!password.equals(retyped_password))
		{
			System.out.println("Adding new Customer action failed : Password Mismatch!");
			input.close();
			return;
		}
		// task 3: password encryption.
		if(!isValid(password))
		{
			System.out.println("Adding new Customer action failed : Password Incorrect Avoid using special characters!");
			input.close();
			return;
		}
		password=getEncryptedPassword(password);
		Bank.refcustomerid++;
		Bank.refaccountno++;
	   Customer customer=new Customer(Bank.refcustomerid,name,Bank.INITIAL_AMOUNT,password,Bank.refaccountno);
	   Bank.customers.add(customer);
	   CustomerFileHandler.getInstance().addCustomerToFile(customer);
	   System.out.println("Customer added successfully!");
	   addToTransactionHistory(Bank.refcustomerid);
	 
	  input.close();
	}
	
	private void addToTransactionHistory(int custId) throws IOException {
		
		Transaction transaction=new Transaction(1,"opening",10000,10000);
		TransactionHandler handler=new TransactionHandler();
		handler.writeTransaction(custId, transaction);
	}

	private boolean isValid(String password)
	{
		// ascii value of '0'- 48 and '9'-57.
		char[]char_password=password.toCharArray();
		for(char c:char_password)
		{
		 if((c>=97 && c<=122) ||(c>=65 && c<=120)||(c>=48 &&c<=57))
		 {
			 continue;
		 }
		 else {
			 return false;		 }
		}
		return true;
	}
	public static String getEncryptedPassword(String password)
	{
		char[]char_password=password.toCharArray();
		for(int i=0;i<char_password.length;i++)
		{
			if(char_password[i]=='z' || char_password[i]=='Z'||char_password[i]=='9')
			{
			switch(char_password[i])
			{
			case 122:
				char_password[i]='a';
				break;
			case 'Z':
				char_password[i]='A';
				break;
			case 9:
				char_password[i]=0;
				break;
			}
			}
			else {
				char_password[i]=(char)(char_password[i]+1);
			}
		}
		return new String(char_password);
		
	}
	// Task4 :Authentication 
	public boolean authenticate(int custId,String password)
	{
		String password_check=getEncryptedPassword(password);
		Customer c=Bank.customerMap.get(custId);
		if(c==null)
		{
			System.out.println("There is no account with this id number!");
			return false;
		}
		 if(c.password.equals(password_check)){
			System.out.println("Authentication Successfull");
			return true;
			
		}
		 else {
			 System.out.println("Invalid Password!");
			
		 }
		 return false;
		
	}
}
