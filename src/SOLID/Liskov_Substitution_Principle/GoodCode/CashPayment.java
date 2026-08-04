package SOLID.Liskov_Substitution_Principle.GoodCode;

public class CashPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Cash Payment");
    }
}