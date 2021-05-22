package FoodDeliveryApp;

public interface StackInterface<T>{
    /*Adds a new entry to the top of the stack.
    @param: newEntry an object to be added to the stack.*/
    void push(T newEntry);

    /*Removes and returns this stack's top entry.
    @param: none.
    @return The object at the top of the stack.
     */
    T pop();

    /* Retrieves this stack's top entry.
    @param:none.
    @return: The object at the top of the stack.
     */
    T peek();

    /*Detects whether this stack is empty.
    @param: none.
    @return True if the stack is empty,or false otherwise.
     */
    boolean isEmpty();

    /*Removes all entries from this stack.
    @param: none.
     */
    void clear();

    /* Shows how many entries stack has.
    @param: none
    @return int entry counts.
     */
    int getLength();

}
