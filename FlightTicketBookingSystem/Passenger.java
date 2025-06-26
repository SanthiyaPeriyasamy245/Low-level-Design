package FlightTicketBookingSystem;

public class Passenger {
    private final String bookingId;
    private final  String name;
    private final  int age;
    private final int seats;

    public Passenger(String bookingId, String name, int age, int seats) {
        this.bookingId = bookingId;
        this.name = name;
        this.age = age;
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "bookingId=" + bookingId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", seats=" + seats +
                '}';
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
