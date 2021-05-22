package Iztechea;

public interface QueueInterface<T> {

    /*Detects whether this queue is full
    @param: none
    @return: True if the queue is full, or false otherwise.*/
    boolean isFull();

    /*Detects whether this queue is empty
    @param: none
    @return: True if the queue is empty, or false otherwise.*/
    boolean isEmpty();

    /* Adds a new entry to the back of this queue.
    @param: newEntry an object to be added.
    @return: True if the newEntry is added, or false otherwise.*/
    boolean enqueue(T newEntry);

    /*Removes and returns the entry at the front of this queue.
    @param: none
    @return: the object at the front of the queue.
     */
    T dequeue();

}
