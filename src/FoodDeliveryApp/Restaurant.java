package FoodDeliveryApp;

public class Restaurant {
    private String name;
    private double rating;
    private String cuisine;
    private int deliveryTime; // in minutes

    
     public Restaurant(String[] properties){
        this.name = properties[3];
        this.rating = Double.parseDouble(properties[4]);
        this.cuisine = properties[5];
        this.deliveryTime = Integer.parseInt(properties[6]);
    }


    public void updateCuisine(String category){
        this.cuisine = category;
    }
    public void updateRating(double score){
        this.rating = score;
    }
    public void updateDeliveryTime(int deliveryTime){
        this.deliveryTime = deliveryTime;
    }

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
