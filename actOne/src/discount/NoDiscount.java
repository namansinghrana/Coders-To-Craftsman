//implementing the noDiscount for interface
public class NoDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double total){
        return total;
    }
}