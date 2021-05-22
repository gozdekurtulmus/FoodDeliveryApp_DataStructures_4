package FoodDeliveryApp;

public interface Iterator<T> {
    boolean hasNext();
    T next();
    void remove(T anEntry);
}
