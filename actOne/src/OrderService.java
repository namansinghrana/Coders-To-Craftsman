import java.util.*;

import discount.DiscountStrategy;
import notification.Subject;
import order.Order;
import order.OrderComponent;
import notification.Observer;

//Self Observation Now the code feels ligther
//Because the objects are no more hard coded.
//And no one can directly access the objects too.
public class OrderService implements Subject {
    List<OrderComponent> orders = new ArrayList<>();

    // Creating the discountStrategy button on my app.
    private DiscountStrategy discountStrategy;

    // This list represents all the observers
    // which are yet to be defined for my program.
    // I mean out service
    // ---------------------------------------------------------------
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObservers(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObservers(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    // ---------------------------------------------------------------
    // Updates Constructor
    public OrderService(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
        this.orders = new ArrayList<>();
    }

    // Previously We were just creating raw objects here in OrderService
    // But now we moved the object creation to the OrderFactory
    // Now we dont have to create objects at multiple layers
    // And we can just use an objectfactory to create new objects.
    public void addOrder(OrderComponent order) {
        orders.add(order);
        // 2nd chance made during the observer pattern implementation
        notifyObservers("New Order added: " + order.getDescription());
    }

    // Made the same changes across showOrders
    public void showOrders() {
        for (OrderComponent order : orders) {
            System.out.println(order.getDescription());
        }
    }

    // Made the same changes across total as well
    public double total() {
        double total = 0;
        // did forgot to update the newly created core
        // logic for calculating individual total for order.
        for (OrderComponent order : orders) {
            total += order.calculateTotal();
        }
        // Deleted the random discounting
        // & aaplied the new discount strategy.
        notifyObservers("Total Calculated: " + total);
        return discountStrategy.applyDiscount(total);
    }

    // Changing strategy in real-Time
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
        notifyObservers("Dsicount Strategy changed to: " + discountStrategy.getClass().getSimpleName());
    }

}