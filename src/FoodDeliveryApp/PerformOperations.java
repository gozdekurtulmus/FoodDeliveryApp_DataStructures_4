package FoodDeliveryApp;

public class PerformOperations {
    private StockBst stock ;
    private FileIO fileIO = new FileIO();
    private SearchTree<Restaurant> ratingTree;
    private SearchTree<Restaurant> deliveryTree;
    private SearchTree<Food> priceTree;
    private SearchTree<Food> stockTree;

    public PerformOperations(){
        this.stock = new StockBst(fileIO.readToArray("CENG112_HW4.csv"));
        this.ratingTree = stock.getRatingTree();
        this.deliveryTree = stock.getDeliveryTree();
        this.priceTree = stock.getPriceTree();
        this.stockTree = stock.getStockTree();
    }

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

    public void operation1(){
        SearchTree<Restaurant> temp = ratingTree;
        ArrayStack<Restaurant> stack = turnIntoDescending(temp.getInOrderIterator());
        Restaurant element;
        while(!stack.isEmpty()){
            element = stack.pop();
            System.out.format("%-30s %5.1f\n",  element.getName(), element.getRating());
        }
        System.out.println();
    }

    public void operation2(){
        SearchTree<Food> temp = priceTree;
        Iterator<Food> iterator = temp.getInOrderIterator();
        Food element;
        while(iterator.hasNext()){
            element = iterator.next();
            System.out.format("%-22s %-10.2f %-5d\n",  element.getName(), element.getPrice(), element.getStock());
        }
        System.out.println();
    }

    public void operation3(){
        SearchTree<Restaurant> temp = deliveryTree;
        Iterator<Restaurant> iterator = temp.getInOrderIterator();
        Restaurant element;
        while(iterator.hasNext()){
            element = iterator.next();
            if(element.getName().contains("Pizza")){
                System.out.format("%-25s %-5d\n",  element.getName(), element.getDeliveryTime());
                break;
            }
        }
        System.out.println();
    }
    public void operation4(){
        SearchTree<Food> temp = stockTree;
        ArrayStack<Food> stack = turnIntoDescending(temp.getInOrderIterator());
        Food element;
        while(!stack.isEmpty()){
            element = stack.pop();
            if(element.getRestaurant().getCuisine().contains("Coffee")){
                System.out.format("%-25s %-5d\n",  element.getName(), element.getStock());
                break;
            }
        }
        System.out.println();
    }

    public void operation5(){
        SearchTree<Food> temp = stockTree;
        Iterator<Food> iterator = temp.getInOrderIterator();
        Food element;
        while(iterator.hasNext()){
            element = iterator.next();
            if(element.getPrice() > 80.0){
                priceTree.remove(element);
                stockTree.remove(element);
                System.out.format("%-20s%-10.2f%-10s\n",  element.getName(), element.getPrice(), "Removed");
            }
        }
        System.out.println();

    }
    public void operation6(){
        SearchTree<Restaurant> temp = ratingTree;
        Iterator<Restaurant> iterator = temp.getInOrderIterator();
        Restaurant element;
        while(iterator.hasNext()){
            element = iterator.next();
            if(element.getRating() < 8.0){
                ratingTree.remove(element);
                deliveryTree.remove(element);
                System.out.format("%-25s%-5.1f%-10s\n",  element.getName(), element.getRating(), "Removed");
            }
        }
        System.out.println();

    }
    public void operation7(){
        SearchTree<Food> temp = stockTree;
        Iterator<Food> iterator = temp.getInOrderIterator();
        Food element;
        while(iterator.hasNext()){
            element = iterator.next();
            element.updatePrice(20);
        }
        System.out.println("Prices in FoodBSTs are updated.");
    }

    public void operation8(){
        SearchTree<Food> temp = stockTree;
        Iterator<Food> iterator = temp.getInOrderIterator();
        Food element;
        while(iterator.hasNext()){
            element = iterator.next();
            element.updateStock(2);
        }
        System.out.println("Stocks in FoodBSTs are updated.");

    }

    public <T> ArrayStack<T> turnIntoDescending(Iterator<T> iterator){
        QueueInterface<T> queue = new ArrayQueue();
        while(iterator.hasNext()){
            queue.enqueue(iterator.next());
        }
        ArrayStack<T> stack = new ArrayStack<>();
        T element = queue.dequeue();
        while(element != null){
            stack.push(element);
            element = queue.dequeue();
        }
        return stack;
    }


}
