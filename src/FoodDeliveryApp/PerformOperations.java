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


    }

    public void operation8(){
        QueueInterface stockqueue = stockTree.traverseAscending();
        while (!stockqueue.isEmpty()){
            Food food = (Food) stockqueue.dequeue();
            food.updateStock(2);
        }

    }

    public ArrayStack<Restaurant> turnIntoDescending(ArrayQueue<Restaurant> queue){
        ArrayStack<Restaurant> stack = new ArrayStack<>();
        Restaurant element = queue.dequeue();
        while(element != null){
            stack.push(element);
            element = queue.dequeue();
        }
        return stack;
    }

}

