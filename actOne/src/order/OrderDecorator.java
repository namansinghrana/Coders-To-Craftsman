package order;

public abstract class OrderDecorator implements OrderComponent{
    protected OrderComponent decoratedOrder;

    public OrderDecorator(OrderComponent decoratedOrder){ this.decoratedOrder = decoratedOrder; }

    @Override
    public double calculateTotal(){ return decoratedOrder.calculateTotal(); }
    public String getDescription(){ return decoratedOrder.getDescription(); }
}
