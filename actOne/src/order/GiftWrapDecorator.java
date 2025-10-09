package order;

public class GiftWrapDecorator extends OrderDecorator{
    private double wrapCost = 50.0;

    public GiftWrapDecorator(OrderComponent decoratedOrder){
        super(decoratedOrder);
    }

    @Override
    public double calculateTotal(){
        return super.calculateTotal() + wrapCost;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " +Gift Wrap";
    }
}
