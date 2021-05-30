package FoodDeliveryApp;

public interface Iterator<T> {
    /**
     * Looks if there are more elements.
     * @return true if there are more elements in the collection, false otherwise.
     */
    boolean hasNext();

    /**
     * @return next element of the collection.
     * @throws Error if the element does not exist.
     */
    T next();
}

