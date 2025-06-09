package Customers;

import java.io.IOException;
import java.util.Scanner;

import Bank.AccountHandler;
import Transaction.TransactionHandler;
public class Main {

	public static void main(String[] args) throws IOException {
	
		
		// Task-1 Initialize customers.
		CustomerFileHandler handler=new CustomerFileHandler();
	
		try {
			handler.initialize();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
//		System.out.println(Bank.customers.get(0).name +"\n"
//		+Bank.customers.get(0).balance+"\n"+
//		Bank.customers.get(0).customerId+"\n"+
//		Bank.customers.get(0).password+"\n"+Bank.customers.get(0).accountNo
//		);
//		
//		System.out.println(Bank.customers);
		menu();
		

	}
	static void menu()
	{
		
		
		System.out.println("Select the option"+"\n1.create user"+"\n2.deposit"+"\n3.withdrawl"+"\n4.fund-transfer"+"\n5.transaction-history");
		try (Scanner input = new Scanner(System.in)) {
			int option=input.nextInt();
			switch(option)
			{
			case 1:
				CustomerHandler handling_Customer=new CustomerHandler();
				handling_Customer.addCustomer();
				break;
			case 2:
				deposit();
				break;
			case 3:
				withdraw();
				break;
			case 4:
				transfer();
				break;
			default:System.out.println("Invalid Option!");
				
			}
		}catch(Exception e)
		{
			System.out.print("Invalid input");
		}
	}
	private static void transfer() throws IOException {
		CustomerHandler handling_Customer=new CustomerHandler();
		AccountHandler account=new AccountHandler();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter customer Id :");
		int id=input.nextInt();
		System.out.println("Enter password :");
		String password=input.next();
		if(handling_Customer.authenticate(id,password))
		{
			System.out.println("Enter the recieverId");
			int reciverId=input.nextInt();
			System.out.println("Enter the amount");
			double amount=input.nextDouble();
			account.transfer(id, reciverId, amount);
		}
		input.close();
		
	}
	public static void deposit() throws IOException
	{
		CustomerHandler handling_Customer=new CustomerHandler();
		AccountHandler account=new AccountHandler();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter customer Id :");
		int id=input.nextInt();
		System.out.println("Enter password :");
		String password=input.next();
		if(handling_Customer.authenticate(id,password))
		{
			System.out.println("Enter the amount");
			double amount=input.nextDouble();
			account.deposit(id,amount);
		}
		input.close();
	}
	public static void withdraw() throws IOException
	{
		CustomerHandler handling_Customer=new CustomerHandler();
		AccountHandler account=new AccountHandler();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter customer Id :");
		int id=input.nextInt();
		System.out.println("Enter password :");
		String password=input.next();
		if(handling_Customer.authenticate(id,password))
		{
			System.out.println("Enter the amount");
			double amount=input.nextDouble();
			account.withdraw(id,amount);
		}
		input.close();
	}
	public static void transactionHistory(int custId,String password)
	{
		CustomerHandler handling_Customer=new CustomerHandler();
		System.out.println("Enter customer Id :");
		Scanner input = new Scanner(System.in);
		int id=input.nextInt();
		System.out.println("Enter password :");
		if(handling_Customer.authenticate(id,password))
		{
		System.out.println("******Transaction History*******");
		TransactionHandler handler=new TransactionHandler();
		handler.printTransactionHistory(custId);
	}
	input.close();
	}

}
