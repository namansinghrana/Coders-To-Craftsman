package payment;

//  SRP
public class CardPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Processing payment of Rs." + amount + "...");
        System.out.println("Card payment approved");
        return true;
    }
}
