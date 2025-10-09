package order;

public class ExpressDeliveryDecorator extends OrderDecorator{
    private double deliveryCharge = 100.0;
    
    public ExpressDeliveryDecorator(OrderComponent decoratedOrder){
        super(decoratedOrder);
    }

    @Override
        public double calculateTotal(){
            return super.calculateTotal() + deliveryCharge;
        }


    @Override
        public String getDescription(){
            return super.getDescription() + deliveryCharge;
        } 
}
