package SOLID.OpenClosePrinciple.Good_Code;
public class WalletPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Processing Wallet Payment");
    }
}