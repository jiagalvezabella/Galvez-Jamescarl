import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Retail {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your userID: ");
        String username = scan.nextLine();
        System.out.print("Enter your password: ");
        String password = scan.nextLine();

        
        Customer customer = new Customer(username, password, 1);

        
        System.out.print("Enter product name: ");
        String productName = scan.nextLine();
        System.out.print("Enter product price: ");
        double productPrice = scan.nextDouble();
        System.out.print("Enter product stock quantity: ");
        int stockQuantity = scan.nextInt();

        
        Product product1 = new Product(1, productName, productPrice, stockQuantity);

        
        List<Product> productsInOrder = new ArrayList<>();
        productsInOrder.add(product1);

        
        customer.placeOrder(productsInOrder);

        
        List<Order> orderHistory = customer.getOrderHistory();
        for (Order order : orderHistory) {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Customer ID: " + order.getCustomerId());
            System.out.println("Total Amount: $" + order.getTotalAmount());
            System.out.println("Order Date: " + order.getOrderDate());
            System.out.println("Products:");

            for (Product product : order.getProducts()) {
                System.out.println("- " + product.getName() + ", Price: $" + product.getPrice());
            }
        }
        
        
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String enteredPassword) {
        return password.equals(enteredPassword);
    }
}

class Customer extends User {
    private int customerId;
    private List<Order> orderHistory;

    public Customer(String username, String password, int customerId) {
        super(username, password);
        this.customerId = customerId;
        this.orderHistory = new ArrayList<>();
    }

    public void placeOrder(List<Product> products) {
        Order order = new Order(this.customerId, products);
        orderHistory.add(order);
        order.confirmOrder();
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }
}

class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    public void updateProductPrice(Product product, double newPrice) {
        product.setPrice(newPrice);
    }

    public void updateProductStock(Product product, int newStockQuantity) {
        product.setStockQuantity(newStockQuantity);
    }
}

class Product {
    private int productId;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(int productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}

class Order {
    private int orderId;
    private int customerId;
    private List<Product> products;
    private double totalAmount;
    private Date orderDate;

    public Order(int customerId, List<Product> products) {
        this.orderId = generateOrderId();
        this.customerId = customerId;
        this.products = products;
        this.totalAmount = calculateTotalAmount();
        this.orderDate = new Date();
    }

    private int generateOrderId() {
        return (int) (Math.random() * 1000);
    }

    private double calculateTotalAmount() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void confirmOrder() {
        
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}
