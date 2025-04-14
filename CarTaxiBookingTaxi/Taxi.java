
import java.util.*;
public class Taxi {
	
	int id;
	char currentPoint='A';
	int totalEarnings=0;
	 List<Booking>bookings=new ArrayList<>();
	public Taxi(int id)
	{
		this.id=id;
		
	}
	public boolean isAvailable(int pickupTime) {
		if(bookings.isEmpty())
		{
			return true;
		}
		Booking last_Booking=bookings.get(bookings.size()-1);
		return last_Booking.dropTime<=pickupTime;
		
	}
	public int calculateEarnings(char pickupPoint, char dropPoint) {
		
		int total_Distance=Math.abs(dropPoint-pickupPoint)*15;
		return 100+((total_Distance-5)*10);
	}
	public void addBooking(Booking booking) {
		
		this.bookings.add(booking);
		totalEarnings+=booking.amount;
		currentPoint=booking.to;
		
	}
	
	

}
