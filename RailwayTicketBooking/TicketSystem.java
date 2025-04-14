import java.util.*;  // Importing utilities for ArrayList, Queue, etc.

public class TicketSystem {
    private final List<String> availableBerths = new ArrayList<>(Arrays.asList("L", "U", "M")); // Available confirmed berths
    private final Queue<Passenger> racQueue = new LinkedList<>(); // Queue for RAC passengers
    private final Queue<Passenger> waitingListQueue = new LinkedList<>(); // Queue for waiting list passengers
    private final List<Passenger> confirmedPassengers = new ArrayList<>(); // List of confirmed passengers
    private int ticketCounter = 1; // Counter for generating unique ticket IDs
    // Booking tickets
    public void bookTicket(String name, int age, String gender, String berthPreference) {
        String ticketId = "T" + ticketCounter++;  // Generate unique ticket ID
        Passenger passenger;
        // Check for available confirmed tickets
        if (!availableBerths.isEmpty()) {
            String allocatedBerth = allocateBerth(age, gender, berthPreference);
            passenger = new Passenger(name, age, gender, berthPreference, allocatedBerth, ticketId);
            confirmedPassengers.add(passenger);  // Add to confirmed list
            availableBerths.remove(allocatedBerth); // Remove allocated berth
            System.out.println("Ticket confirmed: " + passenger);
        }
        // Check for RAC availability
        else if (racQueue.size() < 1) {
            passenger = new Passenger(name, age, gender, berthPreference, "RAC", ticketId);
            racQueue.offer(passenger); // Add to RAC queue
            System.out.println("Ticket in RAC: " + passenger);
        }
        // Check for Waiting List availability
        else if (waitingListQueue.size() < 1) {
            passenger = new Passenger(name, age, gender, berthPreference, "Waiting List", ticketId);
            waitingListQueue.offer(passenger); // Add to Waiting List
            System.out.println("Ticket in Waiting List: " + passenger);
        }
        // No tickets available
        else {
            System.out.println("No tickets available");
        }
    }
    // Allocating berth based on conditions
    private String allocateBerth(int age, String gender, String preference) {
        if (age > 60 || gender.equalsIgnoreCase("female") && availableBerths.contains("L")) {
            return "L";  // Prioritize lower berth
        }
        if (availableBerths.contains(preference)) {
            return preference;  // Allocate preferred berth
        }
        return availableBerths.get(0);  // Allocate first available berth
    }
    // Canceling tickets
    public void cancelTicket(String ticketId) {
        Optional<Passenger> passengerOpt = confirmedPassengers.stream()
                .filter(p -> p.ticketId.equals(ticketId))
                .findFirst();
        if (passengerOpt.isPresent()) {
            Passenger passenger = passengerOpt.get();
            confirmedPassengers.remove(passenger);
            availableBerths.add(passenger.allottedBerth);
            // Move RAC to confirmed
            if (!racQueue.isEmpty()) {
                Passenger racPassenger = racQueue.poll();
                String allocatedBerth = allocateBerth(racPassenger.age, racPassenger.gender, racPassenger.berthPreference);
                racPassenger.allottedBerth = allocatedBerth;
                confirmedPassengers.add(racPassenger);
                availableBerths.remove(allocatedBerth);
                System.out.println("RAC ticket moved to confirmed: " + racPassenger);
            }
            // Move Waiting List to RAC
            if (!waitingListQueue.isEmpty()) {
                Passenger waitingPassenger = waitingListQueue.poll();
                racQueue.offer(waitingPassenger);
                waitingPassenger.allottedBerth = "RAC";
                System.out.println("Waiting list ticket moved to RAC: " + waitingPassenger);
            }
            System.out.println("Ticket cancelled successfully for ID: " + ticketId);
        } else {
            System.out.println("No ticket found with ID: " + ticketId);
        }
    }
    // Printing confirmed tickets
    public void printBookedTickets() {
        if (confirmedPassengers.isEmpty()) {
            System.out.println("No confirmed tickets.");
        } else {
            System.out.println("Confirmed Tickets:");
            for (Passenger passenger : confirmedPassengers) {
                System.out.println(passenger);
            }
        }
    }
    // Printing available tickets
    public void printAvailableTickets() {
        System.out.println("Available Berths: " + availableBerths.size());
        System.out.println("Available RAC Tickets: " + (1 - racQueue.size()));
        System.out.println("Available Waiting List Tickets: " + (1 - waitingListQueue.size()));
    }
}