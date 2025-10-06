import java.util.*;

//Self Observation Now the code feels ligther
//Because the objects are no more hard coded.
//And no one can directly access the objects too.
public class OrderService {
    List<Order> orders = new ArrayList<>();

    //Previously We were just creating raw objects here in OrderService
    //But now we moved the object creation to the OrderFactory
    //Now we dont have to create objects at multiple layers
    //And we can just use an objectfactory to create new objects. 
    public void addOrder(Order order){
        orders.add(order);
    }

    //Made the same changes across showOrders
    public void showOrders(){
        for(Order order : orders){
            System.out.println(order.getItem()+" x"+order.getQuantity()+" @ "+order.getPrice());
        }
    }

    //Made the same changes across total as well
    public double total(){
        double total =0;
        for(Order order: orders){
            total +=order.getPrice() * order.getQuantity();
        }
        if(total>100) total = total * 0.9; // random discount
        return total;
    }
}
