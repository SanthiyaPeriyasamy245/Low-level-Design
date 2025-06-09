package Customers;
import Bank.Bank;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CustomerFileHandler {
	
	private static final String fileName="Db_Bank.txt";
	
	 public static CustomerFileHandler instance;
	 
	 public static CustomerFileHandler getInstance()
	 {
		 if(instance==null)
		 {
			 instance=new CustomerFileHandler();
			 
		 }
		 return instance;
	 }
	
	public void initialize() throws IOException {
	    List<Customer> customers = new ArrayList<>();
	    File file = new File(fileName);
	    BufferedReader reader = new BufferedReader(new FileReader(file));

	    String customerInfo;
	    while ((customerInfo = reader.readLine()) != null) {
	        if (!customerInfo.trim().isEmpty()) {
	        	Customer customer=castStringToCustomer(customerInfo);
	            customers.add(customer);
	            Bank.customerMap.put(customer.customerId,customer);
	        }
	    }

	    reader.close();
	    Bank.customers = customers;
	    Bank.refcustomerid=customers.get((customers.size()-1)).customerId;
	    Bank.refaccountno=customers.get((customers.size()-1)).accountNo;
	}

	private static Customer castStringToCustomer(String customerInfo) {
	    String[] splitted_Data = customerInfo.split(" ");
	    
	    return new Customer(
	        Integer.parseInt(splitted_Data[0]),      
	        splitted_Data[2],                       
	        Double.parseDouble(splitted_Data[3]),    
	        splitted_Data[4],                        
	        Long.parseLong(splitted_Data[1])      
	    );
	}
	public void addCustomerToFile(Customer customer) throws IOException
	{
		File file = new File(fileName);
	    BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
	    writer.write(customer.toString());
	    writer.close();
	}
	
	public void fileWriter() throws IOException
	{
		File file = new File(fileName);
		Set<Integer>keyset=Bank.customerMap.keySet();
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		Iterator<Integer> iterator=keyset.iterator();
		while(iterator.hasNext())
		{
			int customerId=(int) iterator.next();
			Customer customer=Bank.customerMap.get(customerId);
			
		    writer.write(customer.toString());
		}
	    writer.close();
	    
	}


}
