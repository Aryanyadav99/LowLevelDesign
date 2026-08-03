package SOLID.OpenClosePrinciple.Good_Code;

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        service.processPayment(new CardPayment());
        service.processPayment(new UpiPayment());
        service.processPayment(new WalletPayment());
    }

}