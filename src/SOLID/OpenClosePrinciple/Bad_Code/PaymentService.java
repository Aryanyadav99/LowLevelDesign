package SOLID.OpenClosePrinciple.Bad_Code;

public class PaymentService {
    public void processPayment(String paymentType) {
        if (paymentType.equalsIgnoreCase("CARD")) {
            System.out.println("Processing Card Payment");
        } else if (paymentType.equalsIgnoreCase("UPI")) {
            System.out.println("Processing UPI Payment");
        } else if (paymentType.equalsIgnoreCase("WALLET")) {
            System.out.println("Processing Wallet Payment");
        } else {
            throw new IllegalArgumentException("Invalid Payment Method");
        }
    }
}
