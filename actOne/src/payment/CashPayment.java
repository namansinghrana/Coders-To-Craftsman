package payment;

//  SRP
public class CashPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Payment of Rs." + amount + "received in Cash.");
        return true;
    }
}
