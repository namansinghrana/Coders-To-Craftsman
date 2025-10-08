package payment;

//  SRP
public class UpiPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Initiating UPI payment of Rs. " + amount + "...");
        System.out.println("UPI payment successful.");
        return true;
    }
}
