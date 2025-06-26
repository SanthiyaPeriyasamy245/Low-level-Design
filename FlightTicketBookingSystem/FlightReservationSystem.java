package FlightTicketBookingSystem;

import java.util.HashMap;
import java.util.Map;

public class FlightReservationSystem {

    Map<FlightType,Flight> flights=new HashMap<FlightType,Flight>();

    public FlightReservationSystem() {
        DynamicPricing pricing=new DynamicPricing();
        flights.put(FlightType.AIRINDIA,new Flight(FlightType.AIRINDIA,pricing));
        flights.put(FlightType.INDIGO,new Flight(FlightType.INDIGO,pricing));
        flights.put(FlightType.SPACEJET,new Flight(FlightType.SPACEJET,pricing));
    }
    public String bookTicket(FlightType flightType, String name, int age, int seats) {
        return flights.get(flightType).bookTicket(name, age, seats);
    }
    public String cancelTicket(FlightType flightType, String id) {
        return flights.get(flightType).cancelBooking(id);
    }
    public void showBookingDetails(FlightType flightType, String id) {
       flights.get(flightType).showDetails();
    }
}


