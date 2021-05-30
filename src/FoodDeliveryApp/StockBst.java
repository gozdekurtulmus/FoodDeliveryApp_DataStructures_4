
/**
 *  This class creates and stores all Binary Search Trees and Food & Restaurant queues.
 */

public class StockBst {
    // Search trees with respect to different attributes
    private SearchTreeInterface<Food> priceTree ;
    private SearchTreeInterface<Food> stockTree ;
    private SearchTreeInterface<Restaurant> ratingTree ;
    private SearchTreeInterface<Restaurant> deliveryTree;

    // Queues to store Foods and Restaurants
    private QueueInterface<Food> foodArray ;
    private QueueInterface<Restaurant> restaurantArray;

    private String[][] propertyList ; // All properties
    private ArrayIterator<String[]> arrayIterator ; // Array iterator to iterate through propertyList


    public StockBst(String[][] givenList){
        this.propertyList = givenList;
        setEverything();
    }

    // Create Search trees and Queues and fill
    private void setEverything(){
        int listLength = propertyList.length -1;
        arrayIterator = new ArrayIterator<>(propertyList, listLength+1);

        this.priceTree = new SearchTree<>(new PriceComparator());
        this.stockTree = new SearchTree<>(new StockComparator());
        this.ratingTree = new SearchTree<>(new RatingComparator());
        this.deliveryTree= new SearchTree<>(new DeliveryTimeComparator());

        this.foodArray = new ArrayQueue<>();
        this.restaurantArray = new ArrayQueue<>();

        // Fill arrays from property list.
        createFoodArray();
        arrayIterator.setCurrent(0); //Since the restaurantArray will use the same iterator
        createRestaurantArray();

        // Fill Binary Search Trees
        createFoodTrees();
        createRestaurantTrees();
    }

    //Fills Trees of Foods
    private void createFoodTrees(){
        while(!foodArray.isEmpty()){
            Food element= foodArray.dequeue();
            priceTree.add(element);
            stockTree.add(element);
        }
    }

    //Fills Trees of Restaurants
    private void createRestaurantTrees() {
        while (!restaurantArray.isEmpty()) {
            Restaurant element = restaurantArray.dequeue();
            ratingTree.add(element);
            deliveryTree.add(element);
        }
    }

    //Fills Food queue
    private void createFoodArray(){
        arrayIterator.next();
        while (arrayIterator.hasNext()){
            this.foodArray.enqueue(new Food(arrayIterator.next()));
        }
    }

    // Fills Restaurant queue
    private void createRestaurantArray(){
        arrayIterator.next();
        while (arrayIterator.hasNext()){
            this.restaurantArray.enqueue(new Restaurant(arrayIterator.next()));
        }
    }

    //Getter and Setter methods
    public SearchTreeInterface<Food> getPriceTree() {
        return priceTree;
    }

    public void setPriceTree(SearchTree<Food> priceTree) {
        this.priceTree = priceTree;
    }

    public SearchTreeInterface<Food> getStockTree() {
        return stockTree;
    }

    public void setStockTree(SearchTree<Food> stockTree) {
        this.stockTree = stockTree;
    }

    public SearchTreeInterface<Restaurant> getRatingTree() {
        return ratingTree;
    }

    public void setRatingTree(SearchTree<Restaurant> ratingTree) {
        this.ratingTree = ratingTree;
    }

    public SearchTreeInterface<Restaurant> getDeliveryTree() {
        return deliveryTree;
    }

    public void setDeliveryTree(SearchTree<Restaurant> deliveryTree) {
        this.deliveryTree = deliveryTree;
    }

