import java.util.*;

public class Taxi implements ITaxi {
    private final int id;
    private char currentLocation = 'A';
    private int earnings = 0;
    private final List<Booking> bookings = new ArrayList<>();

    public Taxi(int id) {
        this.id = id;
    }

    @Override
    public boolean isAvailable(int time) {
        if (bookings.isEmpty()) return true;
        return bookings.get(bookings.size() - 1).dropTime <= time;
    }

    @Override
    public void addBooking(Booking booking) {
        bookings.add(booking);
        currentLocation = booking.to;
        earnings += booking.earnings;
    }

    @Override
    public void displayBookings() {
        for (Booking booking : bookings) {
            System.out.printf("%d %d %c %c %d %d\n",
                    booking.custId, booking.bookingId, booking.from, booking.to,
                    booking.dropTime, booking.earnings);
        }
    }

    public int calculateEarnings(char from, char to) {
        int distance = Math.abs(to - from) * 15;
        return 100 + Math.max(0, distance - 5) * 10;
    }

    public int getId() {
        return id;
    }

    public char getCurrentLocation() {
        return currentLocation;
    }

    public int getEarnings() {
        return earnings;
    }

    public int getLastDropTime() {
        return bookings.isEmpty() ? 0 : bookings.get(bookings.size() - 1).dropTime;
    }

    public int getDistanceFrom(char point) {
        return Math.abs(currentLocation - point);
    }
}
