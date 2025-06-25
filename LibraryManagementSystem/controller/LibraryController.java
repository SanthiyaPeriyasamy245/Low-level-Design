package LibraryManagementSystem.controller;

import LibraryManagementSystem.model.Book;
import LibraryManagementSystem.model.Member;
import LibraryManagementSystem.service.BookService;
import LibraryManagementSystem.service.MemberService;

import java.util.Scanner;

public class LibraryController {

    private final String userName = "admin";
    private final String password = "password";
    private BookService bookService;
    private MemberService memberService;
    private Scanner scanner = new Scanner(System.in);
    Member loggedInMember = null;

    public LibraryController(BookService bookService, MemberService memberService) {
        this.bookService = bookService;
        this.memberService = memberService;
    }


    public void run()
    {
        while(true)
        {
            System.out.println("Enter a role (user/admin)");
            String role = scanner.nextLine().trim().toLowerCase();
            if(role.equalsIgnoreCase("admin")) {
                adminMenu();
            } else if (role.equalsIgnoreCase("user")) {
                userMenu();
            } else {
                System.out.println("Invalid role. Please try again.");

            }
        }
    }

    private void userMenu() {

        System.out.println("Welcome to the Library Management System!");
        System.out.println("Please enter your username to login:");
        String userName = scanner.nextLine().trim();
        loggedInMember= memberService.login(userName);
        System.out.println("Hello " + loggedInMember.getUserName() + "!");
        while (true) {
            System.out.println("User Menu:");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. View All Books");
            System.out.println("4. Exit");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.println("Enter the title of the book to borrow:");
                    String bookTitle = scanner.nextLine().trim();
                    Book book = bookService.getBookByTitle(bookTitle);
                    if (book != null && memberService.borrowBook(loggedInMember, book)) {
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Book not available or you have reached your borrowing limit.");
                    }
                    break;
                case "2":
                    System.out.println("Enter the title of the book to return:");
                    String returnTitle = scanner.nextLine().trim();
                    Book returnBook = bookService.getBookByTitle(returnTitle);
                    if (returnBook != null) {
                        memberService.returnBook(loggedInMember, returnBook);
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("You do not have this book borrowed.");
                    }
                    break;
                case "3":
                    System.out.println("All Available Books:");
                    bookService.getAllBooks().forEach(System.out::println);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    private void adminMenu() {

        System.out.println("Welcome to the Library Management System!");
        System.out.println("Please enter your admin username to login:");
        String adminUserName = scanner.nextLine().trim();
        System.out.println("Please enter your admin password:");
        String adminPassword = scanner.nextLine().trim();
        if (!adminUserName.equals(userName) || !adminPassword.equals(password)) {
            System.out.println("Invalid admin credentials. Exiting.");
            return;
        }
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Remove Book");
            System.out.println("4. View All Books");
            System.out.println("5. View All Members");
            System.out.println("6. Exit");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.println("Enter title:");
                    String title = scanner.nextLine().trim();
                    System.out.println("Enter author:");
                    String author = scanner.nextLine().trim();
                    System.out.println("Enter genre:");
                    String genre = scanner.nextLine().trim();
                    if (bookService.addBook(title, author, genre)) {
                        System.out.println("Book added successfully.");
                    } else {
                        System.out.println("Book with this title already exists.");
                    }
                    break;
                case "2":
                    System.out.println("Enter the title of the book to update:");
                    String oldTitle = scanner.nextLine().trim();
                    System.out.println("Enter new title:");
                    String newTitle = scanner.nextLine().trim();
                    System.out.println("Enter new author:");
                    String newAuthor = scanner.nextLine().trim();
                    System.out.println("Enter new genre:");
                    String newGenre = scanner.nextLine().trim();
                     if(bookService.updateBook(oldTitle, newTitle, newAuthor, newGenre)) {
                         System.out.println("Book updated successfully.");
                     }
                        else {
                            System.out.println("Book with this title does not exist.");
                        }
                    break;
                case "3":
                    System.out.println("Enter the title of the book to remove:");
                    String bookTitle = scanner.nextLine().trim();
                   if(bookService.removeBook(bookTitle)) {
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Book with this title does not exist.");
                   }
                    break;
                case "4":
                    System.out.println("All Books:");
                    bookService.getAllBooks().forEach(System.out::println);
                    break;
                case "5":
                    System.out.println("All Members:");
                    memberService.getAllMembers().forEach(System.out::println);
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }
}
