public class Passenger {
    String name;  // Passenger name
    int age;      // Passenger age
    String gender;  // Gender of the passenger
    String berthPreference; // Lower, Upper, or Middle
    String allottedBerth;  // The berth allotted to the passenger
    String ticketId;  // Unique ticket ID for each booking
    // Constructor to initialize passenger details
    public Passenger(String name, int age, String gender, String berthPreference, String allottedBerth, String ticketId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthPreference = berthPreference;
        this.allottedBerth = allottedBerth;
        this.ticketId = ticketId;
    }
    // Override toString to display ticket details when printed
    @Override
    public String toString() {
        return "Ticket ID: " + ticketId + ", Name: " + name + ", Age: " + age +
                ", Gender: " + gender + ", Berth: " + allottedBerth;
    }
}