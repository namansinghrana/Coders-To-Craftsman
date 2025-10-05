import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderService os = new OrderService();
        while(true){
            System.out.println("1.Add order  2.View orders  3.Total price  4.Exit");
            int ch = Integer.parseInt(sc.nextLine());
            if(ch==1){
                System.out.print("Enter item name: ");
                String item = sc.nextLine();
                System.out.print("Enter price: ");
                double price = Double.parseDouble(sc.nextLine());
                System.out.print("Enter quantity: ");
                int qty = Integer.parseInt(sc.nextLine());
                os.addOrder(item, price, qty);
            } else if(ch==2){
                os.showOrders();
            } else if(ch==3){
                System.out.println("Total: "+os.total());
            } else if(ch==4){
                System.out.println("Bye");
                break;
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
