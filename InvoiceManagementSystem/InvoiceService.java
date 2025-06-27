package InvoiceManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class InvoiceService {

   private static  InvoiceService invoiceService;

    private Map<String, Customer> customers=new HashMap<>();
    private  Map<String, Invoice> invoices=new HashMap<>();

    private InvoiceService() {
    }
    public static synchronized InvoiceService getInvoiceService()
   {
       if(invoiceService==null) {
           invoiceService=new InvoiceService();
       }
       return invoiceService;
   }

    void addCustomer(String id, String name) {
        if(customers.containsKey(id)) {
            System.out.println("The customer already exist with this id give another id");
            return;
        }
        Customer customer = new Customer(id, name);
        customers.put(id, customer);
        System.out.println("customer added Successfully");
    }

    void addInvoice(String id, String customerId) {
        if (!customers.containsKey(customerId)) {
            System.out.println("The customer does not exist");
            return;
        }
        Invoice invoice = new Invoice(id, customerId);
        invoices.put(id, invoice);
        System.out.println("invoice added Successfully");
    }

    void addProduct(String invoiceId, String name, int count, double price) {
        if (!invoices.containsKey(invoiceId)) {
            System.out.println("The invoice does not exist");
            return;
        }
        Invoice invoice = invoices.get(invoiceId);
        Product product = new Product(name, count, price);
        invoice.products.add(product);

        System.out.println("invoice added Successfully");

    }

    void ListInvoices() {
        if (invoices.isEmpty()) {
            System.out.println("There are no invoices");
            return;
        }
        for (Invoice invoice : invoices.values()) {
            System.out.println(invoice);
        }
    }

    void ListCustomers() {
        if(customers.isEmpty()) {
            System.out.println("There is no customer");
            return;
        }
        for (Customer customer : customers.values()) {
            System.out.println(customer);

        }
    }

    void ListOfInvoicesOfCustomer(String customerId) {
        if(!customers.containsKey(customerId)) {
            System.out.println("The customer does not exist");
            return;
        }
        for(Invoice invoice : invoices.values()) {
            if(invoice.customerId.equals(customerId)) {
                System.out.println(invoice);
                System.out.println("total-amount:"+invoice.calculatePrice());
            }
        }
        return;
    }

    void ListOfInvoicesByInvoiceId(String invoiceId) {
        if (!invoices.containsKey(invoiceId)) {
            System.out.println("The invoice does not exist");
            return;
        }
        for (Invoice invoice : invoices.values()) {
            if (invoice.id.equals(invoiceId)) {
                System.out.println(invoice);
                System.out.println("total-amount:"+invoice.calculatePrice());
            }
        }
    }
}
