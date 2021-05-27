package FoodDeliveryApp;

public class StockBst {
    private SearchTreeInterface<Food> priceTree ;
    private SearchTreeInterface<Food> stockTree ;
    private SearchTreeInterface<Restaurant> ratingTree ;
    private SearchTreeInterface<Restaurant> deliveryTree;

    private Food[] foodArray ;
    private Restaurant[] restaurantArray;

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

        this.foodArray = new Food[listLength];
        this.restaurantArray = new Restaurant[listLength];

        createFoodArray();
        arrayIterator.setCurrent(0);
        createRestaurantArray();

        createFoodTrees();
        createRestaurantTrees();
    }

    private void createFoodTrees(){
        ArrayIterator<Food> iterator = new ArrayIterator<>(foodArray, foodArray.length);

        while(iterator.hasNext()){
            Food element= iterator.next();
            priceTree.add(element);
            stockTree.add(element);

        }
    }


    private void createRestaurantTrees() {
        ArrayIterator<Restaurant> iterator = new ArrayIterator<>(restaurantArray, restaurantArray.length);

        while (iterator.hasNext()) {
            Restaurant element = iterator.next();
            if (element != null) {
                ratingTree.add(element);
                deliveryTree.add(element);
            }
        }
    }

    private void createFoodArray(){
        arrayIterator.next();
        while (arrayIterator.hasNext()){
            this.foodArray[arrayIterator.getCurrent()-1] = new Food(arrayIterator.next());
        }
    }

    private void createRestaurantArray(){
        arrayIterator.next();
        while (arrayIterator.hasNext()){
            Restaurant nextElement = new Restaurant(arrayIterator.next());
            boolean check = true;
            for (Restaurant element: restaurantArray) {
                if (element != null) {
                    if (element.getName().equals(nextElement.getName())) {
                        check = false;
                        break;
                    }
                }
            }
            if(check){
                this.restaurantArray[arrayIterator.getCurrent()-1] = nextElement;
            }
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
