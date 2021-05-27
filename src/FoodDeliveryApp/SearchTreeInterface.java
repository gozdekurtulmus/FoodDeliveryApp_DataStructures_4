package FoodDeliveryApp;

public interface SearchTreeInterface<T> {

    /** Adds a new entry to this tree, if it does not match an existing
     * object in the tree. Otherwise, replaces the existing object with
     * the new entry.
     * @param data An object to be added to the tree.
     * @return Either null if data was not int the tree already, or
     *          the existing entry that matched the parameter data
     *          and has been replaced in the tree.
     */
    T add(T data);

    /** Searches for a specific entry in this tree.
     * @param anEntry An object to be found.
     * @return True if the object was found in the tree.
     */
    boolean search(T anEntry);

    /** Removes a specific entry from this tree.
     * @param anEntry An object to be removed.
     * @return Either the object that was removed from the tree or
     *          null if no such object exists.
     */
    BinaryNode<T> remove(T anEntry);


    /** Creates an iterator that traverses all entries in this tree.
     * @return An iterator that provides sequential and ordered access
     *          to the entries in the tree.
     */
    Iterator<T> getInOrderIterator();

}
