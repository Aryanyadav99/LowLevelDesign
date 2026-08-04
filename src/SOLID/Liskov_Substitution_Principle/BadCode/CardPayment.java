package SOLID.Liskov_Substitution_Principle.BadCode;

public class CardPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Card Payment");
    }
    @Override
    public void refund() {
        System.out.println("Refund Processed");
    }
}