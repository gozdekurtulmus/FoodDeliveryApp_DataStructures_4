package FoodDeliveryApp;

import java.util.NoSuchElementException;

/**
    Traverses the all nodes in the BST in ascending order.
 */
public class InorderIterator<T> implements Iterator<T>{
    private StackInterface<BinaryNode<T>> stack;  //Nodes inside bst are kept in the stack
    private BinaryNode<T> currentNode;

    public InorderIterator(BinaryNode<T> root){
        stack = new ArrayStack<>();
        currentNode = root;
    }
    
    @Override
    //Returns false if all nodes in BST have been visited, otherwise true.
    public boolean hasNext() {
        return (!stack.isEmpty()|| currentNode!=null);
    }

    
    @Override
    // Returns the next node in BST.
    public T next() {
        BinaryNode<T> nextNode;
        // Find leftmost node with no left child
        while (currentNode != null){
            stack.push(currentNode);
            currentNode = currentNode.getLeftChild();
        }
        // Get leftmost node, then move to its right subtree
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

