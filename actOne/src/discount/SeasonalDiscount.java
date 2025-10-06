//implementing the seasonalDiscount behavior for interface
public class SeasonalDiscount implements DiscountStrategy{
    private final double rate;

    public SeasonalDiscount(double rate){
        this.rate = rate;
    }

    @Override
    public double applyDiscount(double total){
        return total * (1-rate);
    }
}