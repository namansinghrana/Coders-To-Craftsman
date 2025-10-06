//interface contract works as a trusted employee for me
//where I can just tell him to create the discount type
//then I do not need to handle, He will do it for me.


public interface DiscountStrategy{
    public double applyDiscount(double total);
}


//This is single button to handle multiple soda options in a machine.