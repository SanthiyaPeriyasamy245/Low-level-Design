package FlightTicketBookingSystem;

public class DynamicPricing implements PriceStrategy {
    private static final int priceVariation=200;
    @Override
    public int calculatePrice(int currentPrice, int seats, boolean isBooking) {

           int adjustments=seats*priceVariation;
           return isBooking? currentPrice+adjustments:currentPrice-adjustments;


    }
}
