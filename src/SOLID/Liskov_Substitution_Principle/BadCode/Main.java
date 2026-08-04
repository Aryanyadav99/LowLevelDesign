package SOLID.Liskov_Substitution_Principle.BadCode;

public class Main {
    public static void main(String[] args) {
        Payment payment = new CashPayment();
        payment.pay();
        payment.refund();
    }
}