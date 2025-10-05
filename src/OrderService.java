import java.util.*;

public class OrderService {
    List<Order> orders = new ArrayList<>();

    public void addOrder(String item, double price, int qty){
        Order o = new Order();
        o.item=item;
        o.price=price;
        o.qty=qty;
        orders.add(o);
    }

    public void showOrders(){
        for(Order o: orders){
            System.out.println(o.item+" x"+o.qty+" @ "+o.price);
        }
    }

    public double total(){
        double t=0;
        for(Order o: orders){
            t+=o.price*o.qty;
        }
        if(t>100) t=t*0.9; // random discount
        return t;
    }
}
