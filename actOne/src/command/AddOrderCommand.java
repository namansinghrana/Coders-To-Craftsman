package command;

import order.OrderComponent;
import service.OrderService;

public class AddOrderCommand implements Command {
    private OrderService orderService;
    private OrderComponent order;

    public AddOrderCommand(OrderService orderService, OrderComponent order){
        this.order = order;
        this.orderService = orderService;
    }

    @Override
    public void execute(){
        orderService.addOrder(order);
    }

    @Override
    public void undo(){
        orderService.removeOrder(order);
    }
}
