package SOLID.Liskov_Substitution_Principle.GoodCode;

public class CardPayment implements Payment, Refundable {
    @Override
    public void pay() {
        System.out.println("Card Payment");
    }
    @Override
    public void refund() {
        System.out.println("Refund Processed");
    }
}