package FlightTicketBookingSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flight {
    private final FlightType flightType;
    private final List<Passenger> passengers=new ArrayList<>();
    private int available_seats=50;
    private final int total_seats=50;
    private int current_price=5000;
    int count=0;
    private DynamicPricing pricing;


    public Flight(FlightType flightType, DynamicPricing pricing) {
        this.flightType = flightType;
        this.pricing = pricing;
    }
    public String bookTicket(String name,int age,int seats) {
       if(seats>available_seats) {
           return null;
       }
       count++;
       String id="T"+count;
       Passenger passenger=new Passenger(id,name,age,seats);
       passengers.add(passenger);
       current_price=pricing.calculatePrice(current_price,seats,true);
       available_seats=available_seats-seats;
       return  id;
    }
    public String cancelBooking(String id) {
//          for(Passenger passenger : passengers) {
//              if(passenger.getBookingId().equals(id)) {
//                  passengers.remove(passenger);
//                  current_price=pricing.calculatePrice(current_price,passenger.getSeats(),false);
//                  available_seats=available_seats+passenger.getSeats();
//                  return id;
//              }
//          } ---- it'll throw concurrent modification exception.
        Iterator<Passenger> iterator = passengers.iterator();
        while(iterator.hasNext()) {
            Passenger passenger = iterator.next();
            if(passenger.getBookingId().equals(id)) {
                iterator.remove();
                current_price=pricing.calculatePrice(current_price,passenger.getSeats(),false);
                 available_seats=available_seats+passenger.getSeats();
                 return  id;
            }
        }
          return null;
    }
    public void showDetails() {

        System.out.println("Flight Details");
        System.out.println("flight :"+flightType.toString());
        System.out.println("total seats :"+total_seats);
        System.out.println("available_seats :"+available_seats);
        System.out.println("current price :"+current_price);
        System.out.println("passenger details");
        for(Passenger passenger : passengers) {
            System.out.println(passenger.toString());
        }
    }
}
