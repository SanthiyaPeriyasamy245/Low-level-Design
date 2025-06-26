package FlightTicketBookingSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        FlightReservationSystem flightReservationSystem = new FlightReservationSystem();
        System.out.println("Welcome to FlightReservationSystem");
        while(true)
        {
            System.out.println("select an option from below");
            System.out.println("1.Book Ticket");
            System.out.println("2.Cancel Ticket");
            System.out.println("3.Show flight details");
            System.out.println("4.Exit");
            System.out.println("Enter your choice");
            int choice =sc.nextInt();

            if(choice ==4)
            {
                sc.close();
                return;
            }
            System.out.println("Select the flight (INDIGO/SPACEJET/AIRINDIA)");
            String flight=sc.next().trim().toUpperCase();
            sc.nextLine();
            FlightType flightType= FlightType.valueOf(flight);
            switch(choice) {
                case 1:
                    System.out.println("Enter your name:");
                    String name = sc.nextLine();
                    System.out.println("Enter your age:");
                    int age = sc.nextInt();
                    System.out.println("Enter your seats:");
                    int seats = sc.nextInt();
                    String booking_id=flightReservationSystem.bookTicket(flightType, name, age, seats);
                    System.out.println("Flight booked successfully"+" "+"ticket :" +booking_id);
                    break;
               case 2:
                   System.out.println("Enter your booking id");
                   String bookingId=sc.nextLine();
                   String id=flightReservationSystem.cancelTicket(flightType, bookingId);
                   System.out.println("Flight cancelled successfully"+" "+"ticket :" +id);
                   break;
                case 3:
                    System.out.println("Enter your booking id");
                    String checkId=sc.nextLine();
                    flightReservationSystem.showBookingDetails(flightType,checkId);
                    break;
                case 4:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }
}
