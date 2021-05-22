package FoodDeliveryApp;
/* This class creates Queue with array and manages it. */

public class ArrayQueue<T> implements QueueInterface<T>{
    private T[] queue; // circular array of queue entries and one unused location
    private int frontIndex;
    private int backIndex;
    private int size;
    private static final int DEFAULT_CAPACITY = 50;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        this.queue = (T[]) new Object[DEFAULT_CAPACITY];
        this.backIndex = queue.length-1;
        this.size = 0; //total number of items in queue
    }

    public boolean isFull() {
        return size == (queue.length - 1);
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void ensureCapacity() {
        if (isFull()) { //array is full
            T[] oldQueue = queue;
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[2*queue.length]; // Doubles the capacity of the array
            queue = tempQueue;
            for (int i = 0; i < size; i++){
                queue[i] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldQueue.length;
            }
            frontIndex = 0;
            backIndex = oldQueue.length -2;

        }
    }
    // newProduct is added in the queue
    public boolean enqueue(T newProduct) {
        ensureCapacity();
        backIndex = (backIndex +1) % queue.length;
        queue[backIndex] = newProduct;
        size++;
        return true;
    }
    //the last product in the queue is removed
    public T dequeue(){
        if (isEmpty()){ //if queue is empty, then return null
            return null;
        }
        else{
            T frontProduct = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) %queue.length;
            size--;
            return frontProduct;
        }
    }

}
