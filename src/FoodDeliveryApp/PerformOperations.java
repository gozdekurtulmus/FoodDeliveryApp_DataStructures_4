package FoodDeliveryApp;

public class PerformOperations {
    private StockBst stock ;
    private FileIO fileIO = new FileIO();

    public PerformOperations(){
        stock = new StockBst(fileIO.readToArray("CENG112_HW4.csv"));
    }

    public void operation1(){
        BinaryTree<Restaurant> temp = stock.getRatingTree();
        ArrayStack<Restaurant> stack = turnIntoDescending(temp.traverseAscending());

        Restaurant element = stack.pop();
        while(element != null){
            System.out.println("Name:" + element.getName() + "\tRating:" + element.getRating());
            element = stack.pop();
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
