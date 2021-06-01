package FoodDeliveryApp;

public class Restaurant {
    private String name; //keeps the name of the restaurant
    private double rating; //keeps the rate of the restaurant
    private String cuisine; //keeps the cuisine of the restaurant
    private int deliveryTime; // in minutes

    //constructor
    public Restaurant(String[] properties) {
        this.name = properties[3];
        this.rating = Double.parseDouble(properties[4]);
        this.cuisine = properties[5];
        this.deliveryTime = Integer.parseInt(properties[6]);
    }

    //starts the getters and setters methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    //ends the setters and getters methods
}
/**
 * Places nodes in BST according to the rate of the restaurants
 */
class RatingComparator implements Comparator<Restaurant>{

    @Override
    //@return positive if first is bigger, 0 if equal and negative otherwise.
    public double compare(Restaurant first, Restaurant second) {
        return first.getRating() - second.getRating();
    }
}

/**
 * Places nodes in BST according to the delivery time of the restaurants
 */
class DeliveryTimeComparator implements Comparator<Restaurant>{

    @Override
    //@return positive if first is bigger, 0 if equal and negative otherwise.
    public double compare(Restaurant first, Restaurant second) {
        return first.getDeliveryTime()-second.getDeliveryTime();
    }
}
