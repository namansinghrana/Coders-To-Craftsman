package order;

public class TestDecorator {
    public static void main(String[] args) {
        OrderComponent order = new Order("Coffee", 200, 2);
        System.out.println(order.getDescription() + " | Total: " + order.calculateTotal());

        order = new GiftWrapDecorator(order);
        System.out.println(order.getDescription() + " | Total: " + order.calculateTotal());

        order = new ExpressDeliveryDecorator(order);
        System.out.println(order.getDescription() + " | Total: " + order.calculateTotal());
    }
}
