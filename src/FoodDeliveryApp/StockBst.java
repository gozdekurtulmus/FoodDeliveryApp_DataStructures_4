package FoodDeliveryApp;

public class StockBst {
    private SearchTreeInterface<Food> priceTree ;
    private SearchTreeInterface<Food> stockTree ;
    private SearchTreeInterface<Restaurant> ratingTree ;
    private SearchTreeInterface<Restaurant> deliveryTree;

    private QueueInterface<Food> foodArray ;
    private QueueInterface<Restaurant> restaurantArray;

    private String[][] propertyList ;
    private ArrayIterator<String[]> arrayIterator ;


    public StockBst(String[][] givenList){
        this.propertyList = givenList;
        setEverything();
    }

    private void setEverything(){
        int listLength = propertyList.length -1;
        arrayIterator = new ArrayIterator<>(propertyList, listLength+1);

        this.priceTree = new SearchTree<>(new PriceComparator());
        this.stockTree = new SearchTree<>(new StockComparator());
        this.ratingTree = new SearchTree<>(new RatingComparator());
        this.deliveryTree= new SearchTree<>(new DeliveryTimeComparator());

        this.foodArray = new ArrayQueue<>();
        this.restaurantArray = new ArrayQueue<>();

        createFoodArray();
        arrayIterator.setCurrent(0);
        createRestaurantArray();

        createFoodTrees();
        createRestaurantTrees();
    }

    private void createFoodTrees(){
        while(!foodArray.isEmpty()){
            Food element= foodArray.dequeue();
            priceTree.add(element);
            stockTree.add(element);
        }
    }


    private void createRestaurantTrees() {
        while (!restaurantArray.isEmpty()) {
            Restaurant element = restaurantArray.dequeue();
            ratingTree.add(element);
            deliveryTree.add(element);
        }
    }

    private void createFoodArray(){
        arrayIterator.next();
        while (arrayIterator.hasNext()){
            this.foodArray.enqueue(new Food(arrayIterator.next()));
        }
    }

    private void createRestaurantArray(){
        arrayIterator.next();
        while (arrayIterator.hasNext()){
            this.restaurantArray.enqueue(new Restaurant(arrayIterator.next()));
        }
    }

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



}
