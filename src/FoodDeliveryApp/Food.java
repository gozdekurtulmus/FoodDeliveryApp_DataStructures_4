package FoodDeliveryApp;

public class Food implements Orderable {
    private String name;
    private double price;
    private int stock;
    private Restaurant restaurant;
    
     public Food(String[] properties){
        this.name = properties[0];
        this.price = Double.parseDouble(properties[1]);
        this.stock = Integer.parseInt(properties[2]);
        this.restaurant = new Restaurant(properties);
    }

    public void updatePrice(double priceRate){
        this.price = this.price + (this.price * (priceRate/100));
    }
    public void updateStock(int stockRate){
        this.stock /= stockRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
