import java.util.*;

//New Imports for the Strategy Pattern
import discount.NoDiscount;
import discount.ThresholdDiscount;
import order.Order;
import payment.CardPayment;
import payment.CashPayment;
import payment.PaymentProcessor;
import payment.PaymentStrategy;
import payment.UpiPayment;
import discount.SeasonalDiscount;
import order.OrderComponent;
import order.ExpressDeliveryDecorator;
import order.GiftWrapDecorator;

//for this step we are going to apply
//Exception handling and continue the factory method implementation.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Now ordeService needs a default behavoiur for discount
        OrderService orderService = new OrderService(new NoDiscount());

        // Trail ConsoleObserver
        ConsoleNotifier consoleNotifier = new ConsoleNotifier();
        orderService.registerObservers(consoleNotifier);

        // Console User Interface to Run the Application
        while (true) {
            // New 5th option was added for changing the strategy
            System.out.println(
                    "1.Add order  2.View orders  3.Total price   4.Changing discount strategy  5.Pay for Orders   6.Exit");
            int ch = Integer.parseInt(scanner.nextLine());
            if (ch == 1) {
                System.out.print("Enter item name: ");
                String item = scanner.nextLine();
                System.out.print("Enter price: ");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter quantity: ");
                int qty = Integer.parseInt(scanner.nextLine());

                // New implement after orderfactory
                try {
                    //Old Order Logic
                    // Order order = OrderFactory.createOrder(item, price, qty);
                    // orderService.addOrder(order);
                    
                    //New Order Logic
                    OrderComponent order = OrderFactory.createOrder(item, price, qty);
                    //Gift Wrapper Implemented
                    System.out.println("Do you want Gift Wrap ? (y/n)");
                    String gift = scanner.nextLine();

                    if(gift.equalsIgnoreCase("y")){
                        order = new GiftWrapDecorator(order);
                    }

                    //Express Wrapper Implemented
                    System.out.println("Do you want Express Delivery? (y/n)");
                    String express = scanner.nextLine();1
                    
                    if(express.equalsIgnoreCase("y")){
                        order = new ExpressDeliveryDecorator(order);
                    }                    
                    //Now we first have to typecast means convert our orderComponent into Order.
                    orderService.addOrder(order);
                    System.out.println("Order Added Successfully");

                } catch (IllegalArgumentException e) {
                    System.out.println("Error" + e.getMessage());
                }

            } else if (ch == 2) {

                // New implement after orderfactory
                try {
                    orderService.showOrders();
                } catch (IllegalArgumentException e) {
                    System.out.println("Error" + e.getMessage());
                }
            } else if (ch == 3) {

                // New implement after orderfactory
                try {
                    System.out.println("Total: " + orderService.total());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error" + e.getMessage());
                }
            } else if (ch == 4) {
                // Code was changed and the concrete, encapsulated yet loosely coupled
                // algorithms are being used.
                System.out.println("Choose Strategy Type: 1.No Discount  2.Threshold Discount  3.Seasonal Discount");
                int discountCharacter = Integer.parseInt(scanner.nextLine());
                switch (discountCharacter) {
                    case 1:
                        // Calculated no discount
                        // No trace of how it is being done
                        // No direct service files access from viewing the code.
                        orderService.setDiscountStrategy(new NoDiscount());
                        System.out.println("No Discount applied.");
                        break;
                    case 2:
                        // Calculated threshold discount
                        // No trace of how it is being done
                        // No direct service files access from viewing the code.
                        System.out.println("Enter the threshold");
                        double threshold = Double.parseDouble(scanner.nextLine());
                        System.out.println("Enter the rate");
                        double rate = Double.parseDouble(scanner.nextLine());
                        orderService.setDiscountStrategy(new ThresholdDiscount(threshold, rate));
                        System.out.println("Threshold Discount applied.");
                        break;
                    case 3:
                        // Calculated seasonal discount
                        // No trace of how it is being done
                        // No direct service files access from viewing the code.
                        System.out.println("Enter the SeasolRate");
                        double seasonalRate = Double.parseDouble(scanner.nextLine());
                        orderService.setDiscountStrategy(new SeasonalDiscount(seasonalRate));
                        System.out.println("Seasonal Discount applied.");
                        break;
                    default:
                        break;
                }
                break;
            } else if (ch == 5) {
                System.out.println("Select Your Payment Method:  1.Cash  2.Card  3.UPI");
                int paymentChoice = Integer.parseInt(scanner.nextLine());
                PaymentStrategy paymentStrategy;
                switch (paymentChoice) {
                    case 1:
                        paymentStrategy = new CashPayment();
                        break;
                    case 2:
                        paymentStrategy = new CardPayment();
                        break;
                    case 3:
                        paymentStrategy = new UpiPayment();
                        break;
                    default:
                        System.out.println("Invalid choice. Payment cancelled.");
                        continue;
                }

                PaymentProcessor processor = new PaymentProcessor(paymentStrategy);
                boolean success = processor.processPayment(orderService.total());
                if (success)
                    System.out.println("Payment Successfull !");
                else
                    System.out.println("Payment Failed !");
            } else if (ch == 6) {
                System.out.println("Bye");
                break;
            } else {
                System.out.println("Invalid");
            }
            // pausing it for Now
            // scanner.close();
        }
    }
}
