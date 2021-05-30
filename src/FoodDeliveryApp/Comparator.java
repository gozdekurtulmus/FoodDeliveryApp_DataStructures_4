package FoodDeliveryApp;

public interface Comparator<T> {
    
    /**
     * Specifies a comparison
     * @param first element to compare
     * @param second element to be compared with
     * @return positive if first is bigger, 0 if equal and negative otherwise.
     */
    double compare(T first, T second);
}
