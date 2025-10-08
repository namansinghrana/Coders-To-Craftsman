package payment;

//Again A contract was created to implement the strategy pattern
//to implement payment methods
//This ensures application of
//Open Closed Principle
//Single Responsibility Principle
//Loosely Coupled
//Meaning - Its pluggable (Strategy Pattern)
public interface PaymentStrategy {
    boolean pay(double amount);
}