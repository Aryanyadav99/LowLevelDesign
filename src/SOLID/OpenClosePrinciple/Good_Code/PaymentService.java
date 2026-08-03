package SOLID.OpenClosePrinciple.Good_Code;

public class PaymentService {
    public void processPayment(Payment payment) {
        payment.pay();
    }
}