package FoodDeliveryApp;

public class BinaryNode<T> {
    private T data;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;

    public BinaryNode(T data){
        this.data = data;
    }
    public BinaryNode(T data, BinaryNode<T> leftChild, BinaryNode<T> rightChild){
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    protected T getData(){
        return data;
    }
    protected void setData(T data){
        this.data = data;
    }
    protected BinaryNode<T> getLeftChild(){
        return this.leftChild;
    }
    protected void setLeftChild(BinaryNode<T> leftChild){
        this.leftChild = leftChild;
    }
    protected BinaryNode<T> getRightChild(){
        return this.rightChild;
    }
    protected void setRightChild(BinaryNode<T> rightChild) {
        this.rightChild = rightChild;
    }
    protected boolean isLeaf(){
        return (leftChild !=null && rightChild !=null);
    }
    protected boolean hasLeftChild(){
        return leftChild != null;
    }
    protected boolean hasRightChild(){
        return rightChild !=null;
    }
}
