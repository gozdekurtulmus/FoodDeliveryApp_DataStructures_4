package FoodDeliveryApp;

import java.sql.Array;

public class StockBst {
    private BinaryTree<Food> priceTree = new BinaryTree(); ;
    private BinaryTree<Food> stockTree ;
    private BinaryTree<Restaurant> ratingTree ;
    private BinaryTree<Restaurant> deliveryTree;

    public Food[] foodArray ;
    public Restaurant[] restaurantArray;


    private String[][] propertyList ;
    private ArrayIterator<String[]> arrayIterator ;


    public StockBst(String[][] givenList){
        this.propertyList = givenList;
        setEverything();
    }

    private void setEverything(){
        int listLength = propertyList.length;
        arrayIterator = new ArrayIterator<>(propertyList, listLength);

        this.foodArray = new Food[listLength];
        this.restaurantArray = new Restaurant[listLength];

        createFoodArray();
        arrayIterator.setCurrent(0);
        createRestaurantArray();

        createFoodTrees();

        this.stockTree = new BinaryTree();
        this.ratingTree = new BinaryTree();
        this.deliveryTree= new BinaryTree();

    }

    private void createFoodTrees(){
        ArrayIterator<Food> iterator = new ArrayIterator<>(foodArray, propertyList.length);

        while(iterator.hasNext()){
            Food element= iterator.next();
            priceTree.add(element, element.getPrice());
        }
        arrayIterator.setCurrent(0);
        while(iterator.hasNext()){
            Food element= iterator.next();
            priceTree.add(element, element.getStock());
        }
    }

    private void createRestaurantTrees(){
        ArrayIterator<Restaurant> iterator = new ArrayIterator<>(restaurantArray, propertyList.length);

        while(iterator.hasNext()){
            Restaurant element= iterator.next();
            ratingTree.add(element, element.getRating());
        }
        arrayIterator.setCurrent(0);
        while(iterator.hasNext()){
            Restaurant element= iterator.next();
            deliveryTree.add(element, element.getDeliveryTime());
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



}
