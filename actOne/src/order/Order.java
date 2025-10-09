package order;

public class Order implements OrderComponent{
    //Blocked Public Access
    private String item;
    private double price;
    private int quantity;


    //Constructor to assign value once
    public Order(String item, double price, int quantity){
        this.item = item;
        this.price = price;
        this.quantity = quantity;          
    }


    //Getters to get details
    public String getItem(){ return item; }
    public double getPrice(){ return price; } 
    public int getQuantity(){ return quantity; }

    //Extra function for calculating total in an object
    @Override
    public double calculateTotal(){
        return price * quantity;
    }
    
    @Override
    public String getDescription(){
        return item + " x" + quantity + " @ " + price;
    }
}
