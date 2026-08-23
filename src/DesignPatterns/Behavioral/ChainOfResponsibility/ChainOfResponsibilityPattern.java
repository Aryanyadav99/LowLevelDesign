package DesignPatterns.Behavioral.ChainOfResponsibility;
public class ChainOfResponsibilityPattern {
    static abstract class CashHandler {
        protected CashHandler next;
        public void setNext(CashHandler next) {
            this.next = next;
        }
        public abstract void dispense(int amount);
    }

    // Handler 1
    static class TwoThousandHandler extends CashHandler {

        @Override
        public void dispense(int amount) {
            if (amount >= 2000) {
                int notes = amount / 2000;
                amount = amount % 2000;
                System.out.println("2000 notes: " + notes);
            }
            if (amount > 0 && next != null) {
                next.dispense(amount);
            }
        }
    }
    // Handler 2
    static class FiveHundredHandler extends CashHandler {
        @Override
        public void dispense(int amount) {
            if (amount >= 500) {
                int notes = amount / 500;
                amount = amount % 500;
                System.out.println("500 notes: " + notes);
            }
            if (amount > 0 && next != null) {
                next.dispense(amount);
            }
        }
    }

    // Handler 3
    static class HundredHandler extends CashHandler {
        @Override
        public void dispense(int amount) {
            if (amount >= 100) {
                int notes = amount / 100;
                amount = amount % 100;
                System.out.println("100 notes: " + notes);
            }

            if (amount > 0) {
                System.out.println("Amount cannot be dispensed: " + amount);
            }
        }
    }

    public static void main(String[] args) {

        CashHandler twoThousand = new TwoThousandHandler();
        CashHandler fiveHundred = new FiveHundredHandler();
        CashHandler hundred = new HundredHandler();

        twoThousand.setNext(fiveHundred);
        fiveHundred.setNext(hundred);

        twoThousand.dispense(4600);
    }
}