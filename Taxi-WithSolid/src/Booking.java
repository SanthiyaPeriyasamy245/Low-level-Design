public class Booking {
    int bookingId;
    int custId;
    char from;
    char to;
    int dropTime;
    int earnings;

    public Booking(int bookingId, int custId, char from, char to, int dropTime, int earnings) {
        this.bookingId = bookingId;
        this.custId = custId;
        this.from = from;
        this.to = to;
        this.dropTime = dropTime;
        this.earnings = earnings;
    }
}
