import java.util.*;

public class TaxiService {
    private final List<Taxi> taxis;
    private int customerId = 1;

    public TaxiService(int numTaxis) {
        taxis = new ArrayList<>();
        for (int i = 1; i <= numTaxis; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public void bookTaxi(char pickup, char drop, int pickupTime) {
        Taxi bookedTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi taxi : taxis) {
            if (taxi.isAvailable(pickupTime)) {
                int distance = taxi.getDistanceFrom(pickup);
                if (distance < minDistance ||
                    (distance == minDistance && taxi.getEarnings() < (bookedTaxi != null ? bookedTaxi.getEarnings() : Integer.MAX_VALUE))) {
                    bookedTaxi = taxi;
                    minDistance = distance;
                }
            }
        }

        if (bookedTaxi == null) {
            System.out.println("No taxi available at this time.");
            return;
        }

        int bookingId = bookedTaxi.getId() + bookedTaxi.getLastDropTime(); // or any logic for ID
        int fare = bookedTaxi.calculateEarnings(pickup, drop);
        int dropTime = pickupTime + Math.abs(drop - pickup);

        Booking booking = new Booking(bookingId, customerId++, pickup, drop, dropTime, fare);
        bookedTaxi.addBooking(booking);
        System.out.printf("Taxi-%d is allotted\n", bookedTaxi.getId());
    }

    public void displayAllTaxiBookings() {
        System.out.println("Taxi-Id Total-Earnings");
        for (Taxi taxi : taxis) {
            System.out.println(taxi.getId() + " " + taxi.getEarnings());
            taxi.displayBookings();
        }
    }
}
