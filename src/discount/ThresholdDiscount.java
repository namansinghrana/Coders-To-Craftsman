//implementing thresholdDiscount behaviour for interface
public class ThresholdDiscount implements DiscountStrategy{
    private final double threshold;
    private final double rate;

    public ThresholdDiscount(int threshold, int rate){
        this.threshold = threshold;
        this.rate = rate; 
    }

    @Override
    public double applyDiscount(double total){
        if(total > threshold){
            return total * (1-rate);
        }
        return total;
    }
}