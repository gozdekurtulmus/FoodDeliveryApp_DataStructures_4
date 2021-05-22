package FoodDeliveryApp;

public class StockBst {
    private BinaryTree<Food> priceTree ;
    private BinaryTree<Food> stockTree ;
    private BinaryTree<Restaurant> ratingTree ;
    private BinaryTree<Restaurant> deliveryTree;

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
        arrayIterator = new ArrayIterator<>(propertyList, listLength);

        this.priceTree = new BinaryTree<>();
        this.stockTree = new BinaryTree<>();
        this.ratingTree = new BinaryTree<>();
        this.deliveryTree= new BinaryTree<>();

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

        for(int i=0; i<2; i++){
            while(iterator.hasNext()){
                Food element= iterator.next();
                if(i == 0){
                    priceTree.add(element, element.getPrice());
                }
                else{
                    stockTree.add(element, element.getStock());
                }
            }
            iterator.setCurrent(0);
        }
    }

    private void createRestaurantTrees() {
        ArrayIterator<Restaurant> iterator = new ArrayIterator<>(restaurantArray, restaurantArray.length);

        for (int i = 0; i < 2; i++) {
            while (iterator.hasNext()) {
                Restaurant element = iterator.next();
                if (element != null) {
                    if (i == 0) {
                        ratingTree.add(element, element.getRating());
                    } else {
                        deliveryTree.add(element, element.getDeliveryTime());
                    }
                }
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

    public BinaryTree<Food> getPriceTree() {
        return priceTree;
    }

    public void setPriceTree(BinaryTree<Food> priceTree) {
        this.priceTree = priceTree;
    }

    public BinaryTree<Food> getStockTree() {
        return stockTree;
    }

    public void setStockTree(BinaryTree<Food> stockTree) {
        this.stockTree = stockTree;
    }

    public BinaryTree<Restaurant> getRatingTree() {
        return ratingTree;
    }

    public void setRatingTree(BinaryTree<Restaurant> ratingTree) {
        this.ratingTree = ratingTree;
    }

    public BinaryTree<Restaurant> getDeliveryTree() {
        return deliveryTree;
    }

    public void setDeliveryTree(BinaryTree<Restaurant> deliveryTree) {
        this.deliveryTree = deliveryTree;
    }



}
