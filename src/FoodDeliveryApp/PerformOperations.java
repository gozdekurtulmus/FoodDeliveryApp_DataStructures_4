package FoodDeliveryApp;

public class PerformOperations {
    // Search trees with respect to different attributes
    private SearchTreeInterface<Restaurant> ratingTree;
    private SearchTreeInterface<Restaurant> deliveryTree;
    private SearchTreeInterface<Food> priceTree;
    private SearchTreeInterface<Food> stockTree;

    public PerformOperations(){
        FileIO fileIO = new FileIO();
        //Create and get the trees from StockBst class.
        StockBst stock = new StockBst(fileIO.readToArray("CENG112_HW4.csv")); //Read datas from csv file.
        this.ratingTree = stock.getRatingTree();
        this.deliveryTree = stock.getDeliveryTree();
        this.priceTree = stock.getPriceTree();
        this.stockTree = stock.getStockTree();
    }

    //Executes all operations step-by-step
    public void start(){
        System.out.println("----------------- 1 -----------------");
        operation1();
        System.out.println("----------------- 2 -----------------");
        operation2();
        System.out.println("----------------- 3 -----------------");
        operation3();
        System.out.println("----------------- 4 -----------------");
        operation4();
        System.out.println("----------------- 5 -----------------");
        operation5();
        System.out.println("----------------- 6 -----------------");
        operation6();
        System.out.println("----------------- 7 -----------------");
        operation7();
        System.out.println("----------------- 8 -----------------");
        operation8();
        System.out.println("----------------- 9 -----------------");
        operation1();
        System.out.println("----------------- 10 -----------------");
        operation2();

    }

    //  List the names and ratings of the restaurants in descending order of rating.
    public void operation1(){
        SearchTreeInterface<Restaurant> temp = ratingTree;
        //Creates a stack since the getInOrderIterator gives the elements in ascending order.
        StackInterface<Restaurant> stack = turnIntoDescending(temp.getInOrderIterator());
        Restaurant element;
        while(!stack.isEmpty()){ //Untill the stack is empty, prints all the items.
            element = stack.pop();
            System.out.format("%-30s %5.1f\n",  element.getName(), element.getRating());
        }
        System.out.println();
    }

    //  List the names, prices, and stocks of the food in ascending order of price.
    public void operation2(){
        SearchTreeInterface<Food> temp = priceTree;
        // Gets an iterator of the Search Tree.
        Iterator<Food> iterator = temp.getInOrderIterator();
        Food element;
        while(iterator.hasNext()){ // Untill iterator doesn't have a next, prints all the elements.
            element = iterator.next();
            System.out.format("%-22s %-10.2f %-5d\n",  element.getName(), element.getPrice(), element.getStock());
        }
        System.out.println();
    }

    // Print the name of the Pizza restaurant that has the shortest delivery time.
    public void operation3(){
        SearchTreeInterface<Restaurant> temp = deliveryTree;
        // Gets an iterator of the Search Tree.
        Iterator<Restaurant> iterator = temp.getInOrderIterator();
        Restaurant element;
        while(iterator.hasNext()){ //Searches all the items in an ascending order.
            element = iterator.next();
            if(element.getName().contains("Pizza")){ //First Pizza restaurant will have the shortest delivery time.
                System.out.format("%-25s %-5d\n",  element.getName(), element.getDeliveryTime());
                break;
            }
        }
        System.out.println();
    }

    // Print the name of the Coffee with the highest amount of stock.
    public void operation4(){
        SearchTreeInterface<Food> temp = stockTree;
        //Creates a stack since the getInOrderIterator gives the elements in an ascending order.
        StackInterface<Food> stack = turnIntoDescending(temp.getInOrderIterator());
        Food element;
        while(!stack.isEmpty()){ //Searches all the items in a descending order.
            element = stack.pop();
            if(element.getRestaurant().getCuisine().contains("Coffee")){ // First Coffee will have the highest amount of stock.
                System.out.format("%-25s %-5d\n",  element.getName(), element.getStock());
                break;
            }
        }
        System.out.println();
    }

    // List and remove the foods (from Food BST) that are more expensive than 80 TRY.
    public void operation5(){
        SearchTreeInterface<Food> temp = stockTree;
        // Gets an iterator of the Search Tree (ascending order)
        Iterator<Food> iterator = temp.getInOrderIterator();
        Food element;
        while(iterator.hasNext()){ // Searches all items in the Tree
            element = iterator.next();
            if(element.getPrice() > 80.0){ // If the element is more expensive than 80 TRY, removes it from all  Food Trees.
                priceTree.remove(element);
                stockTree.remove(element);
                System.out.format("%-20s%-10.2f%-10s\n",  element.getName(), element.getPrice(), "Removed");
            }
        }
        System.out.println();
    }

    //List and remove the restaurants (from Restaurant BST) that are rated less than 8.0.
    public void operation6(){
        SearchTreeInterface<Restaurant> temp = ratingTree;
        //Creates a stack since the getInOrderIterator gives the elements in an ascending order.
        StackInterface<Restaurant> stack = turnIntoDescending(temp.getInOrderIterator());
        Restaurant element;
        while(!stack.isEmpty()){ // Searches all the elements
            element = stack.pop();
            if(element.getRating() < 8.0){ // If the rating is less than 8.0, removes it from all Restaurant trees.
                ratingTree.remove(element);
                deliveryTree.remove(element);
                System.out.format("%-25s%-5.1f%-10s\n",  element.getName(), element.getRating(), "Removed");
            }
        }
        System.out.println();
    }

    // Increase all food prices by 20% (use the updatePrice method).
    public void operation7(){
        SearchTreeInterface<Food> temp = stockTree;
        // Gets an iterator of the Search Tree (ascending order)
        Iterator<Food> iterator = temp.getInOrderIterator();
        Food element;
        while(iterator.hasNext()){ // Searches all the elements
            element = iterator.next();
            element.updatePrice(20); //Increase all food prices by 20%
        }
        System.out.println("Prices in FoodBSTs are updated.");
    }

    //Cut all food stocks by half (use the updateStock method).
    public void operation8(){
        SearchTreeInterface<Food> temp = stockTree;
        // Gets an iterator of the Search Tree (ascending order)
        Iterator<Food> iterator = temp.getInOrderIterator();
        Food element;
        while(iterator.hasNext()){ // Searches all the elements
            element = iterator.next();
            element.updateStock(2); // cut stock by half
        }
        System.out.println("Stocks in FoodBSTs are updated.");
    }

    // Gets an ascending order iterator and turns it into descending order (stack)
    public <T> StackInterface<T> turnIntoDescending(Iterator<T> iterator){
        StackInterface<T> stack = new ArrayStack<>();
        while(iterator.hasNext()){
            stack.push(iterator.next()); //Pushs every element to stack.
        }
        return stack;
    }


}
