package InvoiceManagementSystem;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
       InvoiceService invoiceService =InvoiceService.getInvoiceService();
       System.out.println("Welcome to the Invoice Management System");
       while(true)
       {

           System.out.println("1. Add Customer");
           System.out.println("2. Add Invoice");
           System.out.println("3. Add product ");
           System.out.println("4. Show invoices of Customers");
           System.out.println("5. Show invoices by invoiceId ");
           System.out.println("6. Exit");
           System.out.println("Please enter your choice");
           int choice=sc.nextInt();
           sc.nextLine();
           switch(choice) {
               case 1:
                   System.out.println("Enter your id");
                   String id=sc.nextLine();
                   System.out.println("Enter your  name");
                   String name=sc.nextLine();
                   invoiceService.addCustomer(id, name);
                   break;
               case 2:
                   System.out.println("Enter customer id");
                   String customerId=sc.nextLine();
                   System.out.println("Enter invoice id");
                   String invoiceId=sc.nextLine();
                   invoiceService.addInvoice( invoiceId, customerId);
                   break;
               case 3:
                   System.out.println("Enter invoice id:");
                   String invoiceId1=sc.nextLine();
                   System.out.println("Enter product name:");
                   String product=sc.nextLine();
                   System.out.println("Enter product price:");
                   double price=sc.nextDouble();
                   System.out.println("Enter product quantity:");
                   int quantity=sc.nextInt();
                   invoiceService.addProduct(invoiceId1,product,quantity,price);
                   break;
               case 4:
                   System.out.println("Enter customer id:");
                   String customerId1=sc.nextLine();
                   invoiceService.ListOfInvoicesOfCustomer(customerId1);
                   break;
               case 5:
                   System.out.println("Enter invoice id:");
                   String invoiceId2=sc.nextLine();
                   invoiceService.ListOfInvoicesByInvoiceId(invoiceId2);
                   break;
               case 6:
                   System.out.println("exiting....");
                   sc.close();
                   return;
               default:
                   System.out.println("invalid choice");
                   break;
           }
       }

    }
}