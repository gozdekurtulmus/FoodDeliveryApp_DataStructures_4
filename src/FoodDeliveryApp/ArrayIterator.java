package FoodDeliveryApp;

import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T>{
    private int count; //length of the array
    private int current; //Current index
    private T[] items;

    public ArrayIterator(T[] collection, int size){
        items = collection;
        count = size;
        current = 0;
    }

    //Returns true if the Array still has elements.
    public boolean hasNext(){
        return current<count;
    }

    //Returns the next element, throws NoSuchElementException if the array doesn't have next element.
    public T next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        current++;
        return items[current-1];
    }

    //getter and setters
    public int getCurrent(){
        return current;
    }
    public void setCurrent(int value){
        this.current = value;
    }

}


}
