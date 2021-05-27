package FoodDeliveryApp;

import java.util.NoSuchElementException;

public class InorderIterator<T> implements Iterator<T>{
    private StackInterface<BinaryNode<T>> stack;
    private BinaryNode<T> currentNode;

    public InorderIterator(BinaryNode<T> root){
        stack = new ArrayStack<>();
        currentNode = root;
    }

    @Override
    public boolean hasNext() {
        return (!stack.isEmpty()|| currentNode!=null);
    }

    @Override
    public T next() {
        BinaryNode<T> nextNode = null;
        while (currentNode != null){
            stack.push(currentNode);
            currentNode = currentNode.getLeftChild();
        }
        if (!stack.isEmpty()){
            nextNode = stack.pop();
            currentNode = nextNode.getRightChild();
        }
        else {
            throw new NoSuchElementException();
        }
        return nextNode.getData();
    }
}

