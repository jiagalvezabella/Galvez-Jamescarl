import java.util.*;
import java.util.Scanner;

public class InteractiveMenu 
{
    public static void main(String[] args) 
    {
        Map<String, MenuItem> menu = new HashMap<>();
        menu.put("C1", new MenuItem("C1", 100.00));
        menu.put("C2", new MenuItem("C2", 150.00));
        menu.put("C3", new MenuItem("C3", 200.00));
        menu.put("R1", new MenuItem("R1", 35.00));
        menu.put("R2", new MenuItem("R2", 50.00));

        Scanner scan = new Scanner(System.in);
        Order order = new Order();

        System.out.println("Menu:");
        for (MenuItem item : menu.values()) 
        {
            System.out.println(item.getName() + " - Php " + item.getPrice());
        }

        while (true) 
        {
            System.out.print("Enter your order (item code and quantity): ");
            String input = scan.nextLine().trim();

            if (input.equalsIgnoreCase("done")) 
            {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid input. ");
                continue;
            }

            String itemCode = parts[0].toUpperCase();
            int quantity = Integer.parseInt(parts[1]);

            if (!menu.containsKey(itemCode)) {
                System.out.println("Invalid item code. Please select from the menu.");
                continue;
            }

            MenuItem menuItem = menu.get(itemCode);
            OrderItem orderItem = new OrderItem(menuItem, quantity);
            order.addOrderItem(orderItem);
        }

        System.out.println("Order Summary:");
        
        for (OrderItem orderItem : order.getOrderItems()) {
            System.out.println(orderItem.getMenuItem().getName() + " x" + orderItem.getQuantity() + " - Php " + orderItem.calculateCost());
        }

        double totalCostInDollars = order.getTotalCost() / 50.0; 
        // Assume 1 PHP = 50 USD
        
        System.out.println("Total Price (in USD): $" + totalCostInDollars);
        System.out.println("Total Quantity: " + order.getTotalQuantity());

        scan.close();
    }
}

class MenuItem 
{
    private String name;
    private double price;

    public MenuItem(String name, double price) 
    {
        this.name = name;
        this.price = price;
    }

    public String getName() 
    {
        return name;
    }

    public double getPrice() 
    {
        return price;
    }
}

class OrderItem 
{
    private MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menuItem, int quantity) 
    {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() 
    {
        return menuItem;
    }

    public int getQuantity() 
    {
        return quantity;
    }

    public double calculateCost() 
    {
        return menuItem.getPrice() * quantity;
    }
}

class Order 
{
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItem orderItem) 
    {
        orderItems.add(orderItem);
    }

    public double getTotalCost() 
    {
        double totalCost = 0.0;
        for (OrderItem orderItem : orderItems) 
        {
            totalCost += orderItem.calculateCost();
        }
        return totalCost;
    }

    public int getTotalQuantity() 
    {
        int totalQuantity = 0;
        for (OrderItem orderItem : orderItems) 
        {
            totalQuantity += orderItem.getQuantity();
        }
        return totalQuantity;
    }

    public List<OrderItem> getOrderItems() 
    {
        return orderItems;
    }
}
