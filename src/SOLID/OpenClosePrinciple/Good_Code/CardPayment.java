package SOLID.OpenClosePrinciple.Good_Code;

public class CardPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Processing Card Payment");
    }
}