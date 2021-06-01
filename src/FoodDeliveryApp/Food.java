package FoodDeliveryApp;

public class Food implements Orderable {
    private String name; // keeps the name of the food
    private double price;  // keeps the price of the food
    private int stock;  // keeps the stock of the food
    private Restaurant restaurant;  // keeps the restaurant of the food

    //constructor
    public Food(String[] properties) {
        this.name = properties[0];
        this.price = Double.parseDouble(properties[1]);
        this.stock = Integer.parseInt(properties[2]);
        this.restaurant = new Restaurant(properties);
    }

     //Updates the price of the foods
    public void updatePrice(double priceRate) {
        this.price = this.price + (this.price * (priceRate / 100));
    }
    //Updates the stock of the foods
    public void updateStock(int stockRate) {
        this.stock /= stockRate;
    }
    //starts the getter and setters methods
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
    //ends the getters and the setters methods
}

/**
 * Places nodes in BST according to the prices of the foods
 */
class PriceComparator implements Comparator<Food>{

        @Override
        //@return positive if first is bigger, 0 if equal and negative otherwise.
        public double compare(Food first, Food second) {
            return first.getPrice()-second.getPrice();
        }
    }

/**
 * Places nodes in BST according to the stocks of the foods
 */
    class StockComparator implements Comparator<Food>{

        @Override
        //@return positive if first is bigger, 0 if equal and negative otherwise.
        public double compare(Food first, Food second) {
            return first.getStock() - second.getStock();
        }
    }

