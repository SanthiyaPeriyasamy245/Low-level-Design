
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of taxis:");
        int numTaxis = scanner.nextInt();
        TaxiService taxiService = new TaxiService(numTaxis);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1.Book Taxi\n2.Display Taxi\n3.Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Pickup Point (A-F): ");
                    char pickup = scanner.next().toUpperCase().charAt(0);
                    System.out.println("Enter Drop Point (A-F): ");
                    char drop = scanner.next().toUpperCase().charAt(0);
                    System.out.println("Enter Pickup Time: ");
                    int time = scanner.nextInt();
                    taxiService.bookTaxi(pickup, drop, time);
                    break;
                case 2:
                    taxiService.displayAllTaxiBookings();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}

