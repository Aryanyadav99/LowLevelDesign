package SOLID.Liskov_Substitution_Principle.BadCode;

public class CashPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Cash Payment");
    }
    @Override
    public void refund() {
        throw new UnsupportedOperationException(
                "Cash payment cannot be refunded online."
        );
    }
}