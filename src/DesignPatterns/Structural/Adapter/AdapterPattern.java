package DesignPatterns.Structural.Adapter;

public class AdapterPattern {

    // Target
    interface PaymentProcessor {
        void pay(double amount);
    }

    // Adaptee
    static class ThirdPartyPayment {

        public void makePayment(double amount) {
            System.out.println("Payment of ₹" + amount + " processed by Third Party");
        }
    }

    // Adapter
    static class PaymentAdapter implements PaymentProcessor {
        private ThirdPartyPayment thirdPartyPayment;
        public PaymentAdapter(ThirdPartyPayment thirdPartyPayment) {
            this.thirdPartyPayment = thirdPartyPayment;
        }
        @Override
        public void pay(double amount) {
            thirdPartyPayment.makePayment(amount);
        }
    }

    public static void main(String[] args) {
        ThirdPartyPayment thirdPartyPayment = new ThirdPartyPayment();
        PaymentProcessor payment = new PaymentAdapter(thirdPartyPayment);
        payment.pay(2000);
    }
}