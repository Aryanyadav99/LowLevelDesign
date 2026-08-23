package DesignPatterns.Structural.Proxy;

public class ProxyPattern {

    // Subject
    interface BankAccount {
        void withdraw(int amount);
    }

    // Real Subject
    static class RealBankAccount implements BankAccount {
        private int balance = 10000;

        @Override
        public void withdraw(int amount) {
            if (amount > balance) {
                System.out.println("Insufficient balance");
                return;
            }
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
            System.out.println("Remaining Balance: ₹" + balance);
        }
    }

    // Proxy
    static class BankAccountProxy implements BankAccount {

        private RealBankAccount realBankAccount;
        private boolean authenticated;

        public BankAccountProxy(boolean authenticated) {
            this.authenticated = authenticated;
        }

        @Override
        public void withdraw(int amount) {

            if (!authenticated) {
                System.out.println("Access denied");
                return;
            }

            if (realBankAccount == null) {
                realBankAccount = new RealBankAccount();
            }

            System.out.println("Access granted");
            realBankAccount.withdraw(amount);
        }
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccountProxy(true);
        account.withdraw(2000);

        System.out.println("----------------");

        BankAccount unauthorizedAccount = new BankAccountProxy(false);
        unauthorizedAccount.withdraw(2000);
    }
}