
import java.util.*;
public class TaxiBookingSystem {

	static List<Taxi>taxis=new ArrayList<>();
	static Scanner sc=new Scanner(System.in);
	static int customerCounter=1;
	public static void main(String[]args)
	{
		System.out.println("Enter the number of taxis :");
		int numTaxis=sc.nextInt();
		initializeTaxi(numTaxis);
		while(true)
		{
			System.out.println("1.BookTaxi\n2.Display Taxi Details\n3.exit");
			System.out.println("Enter your choice ");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				bookTaxi();
				break;
			case 2:
				DisplayTaxiDetails();
				break;
			case 3:
				System.out.println("Thank you for your visit");
				break;
			default:
				System.out.println("Enter a valid choice (between (A-F)");
			}
		}
	}
	
	

	public static void initializeTaxi(int n)
	{
		for(int i=1;i<=n;i++)
		{
			taxis.add(new Taxi(i));
		}
	}
	public static void bookTaxi() {
		int customerId=customerCounter++;
		System.out.println("Enter your Pickup Point (Enter between (A-F))");
		char pickupPoint=sc.next().toUpperCase().charAt(0);
		System.out.println("Enter your droping Point (Enter between (A-F))");
		char dropPoint=sc.next().toUpperCase().charAt(0);
		System.out.println("Enter your Pickup Time preference");
		int pickupTime=sc.nextInt();
		Taxi selected_Taxi=null;
		int min_Distance=Integer.MAX_VALUE;
		for(Taxi taxi: taxis)
		{
			if(taxi.isAvailable(pickupTime))
			{
				int distance=Math.abs(taxi.currentPoint-pickupPoint);
if(distance<min_Distance || (distance==min_Distance && taxi.totalEarnings <selected_Taxi.totalEarnings))
				{
					selected_Taxi=taxi;
					min_Distance=distance;
				}
			}
		}
			if(selected_Taxi==null)
			{
				
				System.out.println("No taxi is available right now all are booked");
				return;
			}
			int dropTime=pickupTime+Math.abs(dropPoint-pickupPoint);
			int amount=selected_Taxi.calculateEarnings(pickupPoint,dropPoint);
			int bookingId=selected_Taxi.bookings.size()+1;
			Booking booking =new Booking(bookingId,customerCounter,pickupPoint,dropPoint,pickupTime,dropTime,amount);
			selected_Taxi.addBooking(booking);
			System.out.println("Taxi -"+ selected_Taxi.id + " is allocated ");
		
	}
		
		public static void DisplayTaxiDetails() {
			for(Taxi taxi :taxis)
			{
				System.out.println("Taxi-id : " + taxi.id +" taxi-totalEarnings : Rs."+taxi.totalEarnings);
	
			    System.out.printf("%-10s %-10s %-5s %-5s %-12s %-9s %-6s%n ","BookingId ","customerId","From","To","pickupTime","dropTime","Amount");
				for(Booking booked:taxi.bookings)
			    {
				System.out.printf("%-10d %-10d %-5c %-5c %-12d %-9d %-6d%n",booked.bookingId,booked.customerId,booked.from,booked.to,booked.pickupTime,booked.dropTime,booked.amount);
			    	
			    }
			}
		}
		
		
	
}
