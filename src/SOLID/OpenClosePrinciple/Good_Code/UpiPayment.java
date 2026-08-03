package SOLID.OpenClosePrinciple.Good_Code;

public class UpiPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Processing UPI Payment");
    }
}