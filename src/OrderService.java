import java.util.*;

import discount.DiscountStrategy;

//Self Observation Now the code feels ligther
//Because the objects are no more hard coded.
//And no one can directly access the objects too.
public class OrderService {
    List<Order> orders = new ArrayList<>();

    //Creating the discountStrategy button on my app.
    private DiscountStrategy discountStrategy = new DiscountStrategy();

    //Updates Constructor
    public OrderService(DiscountStrategy discountStrategy){
        this.discountStrategy = discountStrategy;
        this.orders = new ArrayList<>();
    }

    //Changing strategy in real-Time
    public void setDiscountStrategy(DiscountStrategy discountStrategy){
        this.discountStrategy = discountStrategy;
    }

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
        //did forgot to update the newly created core
        //logic for calculating individual total for order.
        for(Order order: orders){ total += order.calculateTotal(); }
        //Deleted the random discounting 
        //& aaplied the new discount strategy.
        return discountStrategy.applyDiscount(total);
    }
}
