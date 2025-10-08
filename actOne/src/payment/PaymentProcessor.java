package payment;

// Dependency Inversion Principle
//It was all along implement even in the discountStrategy
//It only means to put a layer between
//Low level and High level modules at the code.

//A sign of a clean architecture is the principle disappears.

//In this part I got to know about it because it was made explicitly visible
//But it was invisible in the  discount part
//Where OrderService was a higher module.
//& NoDiscount,SeasonalDiscount were lower modules.
//And the DIP was implemented when we provided
//An abstract layer between them. --> (DiscountStrategy)
//Which in this module is similar to --> (PaymentStrategy)
public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean processPayment(double amount) {
        if (paymentStrategy == null) {
            // This exception means the system is in a valid state structurally
            // but not ready to perform an operation.
            throw new IllegalStateException("No payment strategy set!");
        }
        return paymentStrategy.pay(amount);
    }
}
