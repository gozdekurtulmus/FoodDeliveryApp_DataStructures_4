package FoodDeliveryApp;

public class BinaryNode<T> {
    private T data;  //keeps the data inside the node
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;

    //constructor
    public BinaryNode(T data){
        this.data = data;
    }
    //constructor
    public BinaryNode(T data, BinaryNode<T> leftChild, BinaryNode<T> rightChild){
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    /** Retrieves the data portion of this node.
    @return The object in the data portion of the node. */
    protected T getData(){
        return data;
    }
    /** Sets the data portion of this node.
      @param data: The data object. */
    protected void setData(T data){
        this.data = data;
    }
    
    /** Retrieves the left child of this node.
       @return The node that is this node's left child. */
    protected BinaryNode<T> getLeftChild(){
        return this.leftChild;
    }

    /** Sets this node's left child to a given node.
        @param leftChild: A node that will be the left child. */
    protected void setLeftChild(BinaryNode<T> leftChild){
        this.leftChild = leftChild;
    }

    /** Retrieves the right child of this node.
     @return The node that is this node's right child. */
    protected BinaryNode<T> getRightChild(){
        return this.rightChild;
    }

    /** Sets this node's right child to a given node.
     @param rightChild: A node that will be the right child. */
    protected void setRightChild(BinaryNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    /** Detects whether this node is a leaf.
      @return True if the node is a leaf. */
    protected boolean isLeaf(){
        return (leftChild !=null && rightChild !=null);
    }

    /** Detects whether this node has a left child.
      @return True if the node has a left child. */
    protected boolean hasLeftChild(){
        return leftChild != null;
    }

    /** Detects whether this node has a right child.
     @return True if the node has a right child. */
    protected boolean hasRightChild(){
        return rightChild !=null;
    }
}
