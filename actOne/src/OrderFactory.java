//Factory pattern to handle centralized creation and validation of objects
//Benefits ->
//Reduces repeated checks across codebase for validation.
//Consistent way to create different types of object.
public class OrderFactory{
    
    //centralized creation logic
    public static Order createOrder(String item,double price,int quantity){
        
        //Validation rules
        if(item == null || item.trim().isEmpty()){ throw new IllegalArgumentException("Item name cannot be empty"); }
        if(price < 0){ throw new IllegalArgumentException("Price cannot be negative"); }
        if(quantity <= 0){ throw new IllegalArgumentException("Quantity must be greater than 0"); }

        //returned object
        return new Order(item, price, quantity);
    }
}