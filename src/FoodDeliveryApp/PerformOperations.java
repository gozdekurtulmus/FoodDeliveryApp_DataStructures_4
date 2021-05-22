package FoodDeliveryApp;

public class PerformOperations {
    private StockBst stock ;
    private FileIO fileIO = new FileIO();
    private BinaryTree<Restaurant> ratingTree;
    private BinaryTree<Restaurant> deliveryTree;
    private BinaryTree<Food> priceTree;
    private BinaryTree<Food> stockTree;

    public PerformOperations(){
        this.stock = new StockBst(fileIO.readToArray("CENG112_HW4.csv"));
        this.ratingTree = stock.getRatingTree();
        this.deliveryTree = stock.getDeliveryTree();
        this.priceTree = stock.getPriceTree();
        this.stockTree = stock.getStockTree();
    }

    public void start(){
        operation1();
        operation2();
        operation3();

    }

    public void operation1(){
        BinaryTree<Restaurant> temp = ratingTree;
        ArrayStack<Restaurant> stack = turnIntoDescending(temp.traverseAscending());

        Restaurant element = stack.pop();
        while(element != null){
            System.out.println("Name:" + element.getName() + "\tRating:" + element.getRating());
            element = stack.pop();
        }
    }

       public void operation2(){
        BinaryTree<Food> temp = priceTree;
        ArrayQueue<Food> queue = temp.traverseAscending();
        Food element = queue.dequeue();
        while(element != null){
            System.out.println("Name:" + element.getName()+ "\tPrice:" + element.getPrice()+"\tStocks:"+element.getStock());
            element = queue.dequeue();
        }
        System.out.println();
    }

    public void operation3(){
        BinaryTree<Restaurant> temp = deliveryTree;
        ArrayQueue<Restaurant> queue = temp.traverseAscending();
        while(true){
           Restaurant element = queue.dequeue();
           if(element.getName().contains("Pizza")){
               System.out.println("The Pizza restaurant that has the shortest delivery time : "+ element.getName());
               break;
           }
        }
    }
    
    public void operation5(){
        QueueInterface<Food> ratingQueue = priceTree.traverseAscending();
        while (!ratingQueue.isEmpty()){
            Food element = ratingQueue.dequeue();
            if(element.getPrice() > 80.0){
                ratingTree.remove(element.getPrice());
            }
        }

    }
    public void operation6(){
        QueueInterface<Restaurant> ratingQueue = ratingTree.traverseAscending();
        while (!ratingQueue.isEmpty()){
            Restaurant element = ratingQueue.dequeue();
            if(element.getRating() < 8.0){
                ratingTree.remove(element.getRating());
            }
        }

    }
    public void operation7(){
        QueueInterface<Food> stockqueue = stockTree.traverseAscending();
        while (!stockqueue.isEmpty()){
            Food food = stockqueue.dequeue();
            food.updatePrice(20);
        }
    }

    public void operation8(){
        QueueInterface<Food> stockqueue = stockTree.traverseAscending();
        while (!stockqueue.isEmpty()){
            Food food = stockqueue.dequeue();
            food.updateStock(2);
        }

    }

//    public ArrayStack<Restaurant> turnIntoDescending(ArrayQueue<Restaurant> queue){
//        ArrayStack<Restaurant> stack = new ArrayStack<>();
//        Restaurant element = queue.dequeue();
//        while(element != null){
//            stack.push(element);
//            element = queue.dequeue();
//        }
//        return stack;
//    }
    
    
       public <T> ArrayStack<T> turnIntoDescending(ArrayQueue<T> queue){
            ArrayStack<T> stack = new ArrayStack<>();
            T element = queue.dequeue();
            while(element != null){
                 stack.push(element);
                 element = queue.dequeue();
            }
            return (ArrayStack<T>) stack;
      }
    

}

