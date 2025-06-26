package FlightTicketBookingSystem;

public interface PriceStrategy {
    int calculatePrice(int currentPrice,int seats,boolean isBooking);

}
