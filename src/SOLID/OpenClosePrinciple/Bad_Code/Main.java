package SOLID.OpenClosePrinciple.Bad_Code;

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        service.processPayment("CARD");
        service.processPayment("UPI");
    }
}
