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
        operation1();
        operation2();
        operation3();
        operation4();
        operation5();
        operation6();
        operation7();
        operation8();
        operation1();
        operation2();

    }

    public void operation1(){
        SearchTree<Restaurant> temp = ratingTree;
        Iterator<Restaurant> iterator = temp.getInOrderIterator();
        Restaurant element;
        while(iterator.hasNext()){
            element = iterator.next();
            System.out.println("Name:" + element.getName() + "\tRating:" + element.getRating());
        }
        System.out.println();
    }

    public void operation2(){
        SearchTree<Food> temp = priceTree;
        Iterator<Food> iterator = temp.getInOrderIterator();
        Food element;
        while(iterator.hasNext()){
            element = iterator.next();
            System.out.println("Name:" + element.getName()+ "\tPrice:" + element.getPrice()+"\tStocks:"+element.getStock());
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
                System.out.println("The Pizza restaurant that has the shortest delivery time : "+ element.getName());
                break;
            }
        }
        System.out.println();
    }

    public void operation4(){
        SearchTree<Food> temp = stockTree;
        Iterator<Food> iterator = temp.getInOrderIterator();
        Food element;
        while(iterator.hasNext()){
            element = iterator.next();
            if(element.getRestaurant().getCuisine().equals(" Coffee")){
                System.out.println("Coffee with the highest amount of stock: "+ element.getName());
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
                System.out.println("Name:" + element.getName()+ "\tPrice:" + element.getPrice()+"\tStocks:"+element.getStock());
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
                System.out.println("Name: "+element.getName()+"\tRating: "+element.getRating());
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
    }

    public void operation8(){
        SearchTree<Food> temp = stockTree;
        Iterator<Food> iterator = temp.getInOrderIterator();
        Food element;
        while(iterator.hasNext()){
            element = iterator.next();
            element.updateStock(2);
        }

    }

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
