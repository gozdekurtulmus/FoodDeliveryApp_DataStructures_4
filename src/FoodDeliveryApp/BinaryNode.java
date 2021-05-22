package FoodDeliveryApp;


public class BinaryNode<T>{

    private T data;
    private BinaryNode<T> leftChild;
    private  BinaryNode<T> rightChild;

    public BinaryNode(T data){
        this.data = data;
    }
    private BinaryNode(T data, BinaryNode<T> leftChild, BinaryNode<T> rightChild){
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    private T getData(){
        return data;
    }
    private void setData(T data){
        this.data = data;
    }
    private BinaryNode getLeftChild(){
        return this.leftChild;
    }
    private void setLeftChild(BinaryNode<T> leftChild){
        this.leftChild = leftChild;
    }
    private BinaryNode getRightChild(){
        return this.rightChild;
    }
    private void setRightChild(BinaryNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}
