package FoodDeliveryApp;

public class BinaryTree<T> {
    private BinaryNode<T> rootNode;
    public BinaryTree(BinaryNode<T> root){
        rootNode = new BinaryNode(root);
    }

    public BinaryNode<T> getRootNode() {
        return rootNode;
    }

    public void setRootNode(BinaryNode<T> rootNode) {
        this.rootNode = rootNode;
    }

    private class BinaryNode<T>{

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
    public BinaryNode<T> add(double newEntry){
        BinaryNode<T> newNode = new BinaryNode(newEntry);
        if (rootNode == null ){
            setRootNode(newNode);
        }
        else if (compare(newEntry, (double) rootNode.getData())<0){

        }
    }

    public double compare(double v1 , double v2){
        return v1 - v2;
    }




}
