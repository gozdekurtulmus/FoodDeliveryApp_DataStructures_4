package FoodDeliveryApp;

public interface Orderable {
    
    /** 
     Updates the price of the foods
    @param: the price of the food 
     */ 
    void updatePrice(double price);

    /**
     Updates the stock of the foods
     @param: the stock of the food
     */
    void updateStock(int stock);  

}
