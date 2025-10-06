import java.util.*;

//for this step we are going to apply 
//Exception handling and continue the factory method implementation.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderService orderService = new OrderService();
        while(true){
            System.out.println("1.Add order  2.View orders  3.Total price  4.Exit");
            int ch = Integer.parseInt(scanner.nextLine());
            if(ch==1){
                System.out.print("Enter item name: ");
                String item = scanner.nextLine();
                System.out.print("Enter price: ");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter quantity: ");
                int qty = Integer.parseInt(scanner.nextLine());
                
                //New implement after orderfactory
                try {
                    Order order = OrderFactory.createOrder(item, price, qty);
                    orderService.addOrder(order);
                    System.out.println("Order Added Successfully"); 
            
                } catch (IllegalArgumentException e) {
                    System.out.println("Error" + e.getMessage());
                }
                
            } else if(ch==2){

                //New implement after orderfactory
                try { 
                    orderService.showOrders();
                } catch (IllegalArgumentException e) {
                    System.out.println("Error" + e.getMessage());
                }
            } else if(ch==3){
                
                //New implement after orderfactory
                try{
                    System.out.println("Total: "+orderService.total());
                }catch(IllegalArgumentException e){
                    System.out.println("Error" + e.getMessage());
                }
            } else if(ch==4){
                System.out.println("Bye");
                break;
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
