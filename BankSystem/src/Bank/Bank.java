package Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Customers.Customer;

public class Bank {
	//Task2 : Adding new Customer.
	 
	public  static int refcustomerid;
	public static long refaccountno;
	public static final double INITIAL_AMOUNT=10000;
	public static List<Customer>customers=new ArrayList<>();
	public static Map<Integer,Customer>customerMap=new HashMap<Integer,Customer>();
	
}
