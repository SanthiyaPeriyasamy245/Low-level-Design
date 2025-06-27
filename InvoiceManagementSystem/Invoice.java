package InvoiceManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Invoice {

    String id;
    String customerId;
    List<Product> products=new ArrayList<>();


    public Invoice(String id,String customerId) {
        this.id = id;
        this.customerId = customerId;
        this.products = products;

    }

    double calculatePrice()
    {
        double totalPrice=0;
        for(Product p:products) {
            totalPrice+=p.price*p.count;
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", products=" + products +
                '}';
    }
}
