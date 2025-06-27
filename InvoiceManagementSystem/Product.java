package InvoiceManagementSystem;

public class Product {
     String name;
     int count;
     double price;

    public Product(String name, int count, double price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
