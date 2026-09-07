package DesignPatterns.Structural.Fascade;

class InventoryService {
    public boolean checkStock() {
        System.out.println("Checking inventory...");
        return true;
    }
}

class PaymentService {
    public boolean processPayment() {
        System.out.println("Processing payment...");
        return true;
    }
}

class OrderService {
    public void createOrder() {
        System.out.println("Creating order...");
    }
}

class NotificationService {
    public void sendConfirmation() {
        System.out.println("Sending confirmation...");
    }
}


// Facade
class OrderFacade {
    private InventoryService inventory;
    private PaymentService payment;
    private OrderService order;
    private NotificationService notification;

    public OrderFacade() {
        inventory = new InventoryService();
        payment = new PaymentService();
        order = new OrderService();
        notification = new NotificationService();
    }

    public void placeOrder() {

        if (!inventory.checkStock()) {
            System.out.println("Product out of stock.");
            return;
        }

        if (!payment.processPayment()) {
            System.out.println("Payment failed.");
            return;
        }

        order.createOrder();
        notification.sendConfirmation();

        System.out.println("Order placed successfully!");
    }
}


// Client
public class Main {
    public static void main(String[] args) {

        OrderFacade facade = new OrderFacade();
        facade.placeOrder();
    }
}