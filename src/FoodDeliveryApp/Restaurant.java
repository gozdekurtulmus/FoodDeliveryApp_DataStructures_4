package FoodDeliveryApp;

public class Restaurant {
    private String name;
    private double rating;
    private String cuisine;
    private int deliveryTime; // in minutes



    public void updateCuisine(String category){ }
    public void updateRating(double score){}
    public void updateDeliveryTime(int deliveryTime){}

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
}
