package DesignPatterns.Behavioral.Template;

public class TemplateMethodPattern {

    static abstract class PaymentProcessor {
        // Template Method
        public final void processPayment(double amount) {
            validatePayment(amount);
            authenticate();
            double fee = calculateFee(amount);
            executePayment(amount, fee);
            sendNotification(amount, fee);
        }

        // Common step
        private void validatePayment(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be greater than 0");
            }
            System.out.println("Payment validated");
        }

        // Common step
        private void authenticate() {
            System.out.println("User authenticated");
        }

        // Variable step
        abstract double calculateFee(double amount);

        // Variable step
        abstract void executePayment(double amount, double fee);

        // Common step
        private void sendNotification(double amount, double fee) {
            System.out.println("Payment successful | Amount: ₹" + amount + " | Fee: ₹" + fee);
        }
    }

    // Concrete Class 1
    static class FriendPayment extends PaymentProcessor {
        @Override
        double calculateFee(double amount) {
            return 0;
        }

        @Override
        void executePayment(double amount, double fee) {
            System.out.println("Transferring ₹" + amount + " to friend using UPI");
        }
    }

    // Concrete Class 2
    static class MerchantPayment extends PaymentProcessor {
        @Override
        double calculateFee(double amount) {
            return amount * 0.02;
        }
        @Override
        void executePayment(double amount, double fee) {
            System.out.println("Processing merchant payment of ₹" + amount + " through Payment Gateway");
        }
    }

    public static void main(String[] args) {
        PaymentProcessor friendPayment = new FriendPayment();
        friendPayment.processPayment(1000);
        System.out.println("-----------------------------");
        PaymentProcessor merchantPayment = new MerchantPayment();
        merchantPayment.processPayment(1000);
    }
}