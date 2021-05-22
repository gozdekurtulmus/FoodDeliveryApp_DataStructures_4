package FoodDeliveryApp;

public class BinaryTree<T> implements Comparator<Double>{
    private BinaryNode<T> rootNode;

    public BinaryTree(BinaryNode<T> root){
        setRootNode(root);
    }

    public BinaryTree() {
        rootNode =null;
    }

    public BinaryNode<T> getRootNode() {
        return rootNode;
    }

    public void setRootNode(BinaryNode<T> rootNode) {
        this.rootNode = rootNode;
    }

    @Override
    public double compare(Double first, Double second) {
        return first - second;
    }

    private class BinaryNode<T>{

        private T data;
        private double comparison;
        private BinaryNode<T> leftChild;
        private  BinaryNode<T> rightChild;

        public BinaryNode(T data, double comparison){
            this.data = data;
            this.comparison = comparison;
        }
        private BinaryNode(T data, double comparison, BinaryNode<T> leftChild, BinaryNode<T> rightChild){
            this.data = data;
            this.comparison = comparison;
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
    public void add(T data, double comparison){
        rootNode = addRecursive(rootNode,data, comparison);
        System.out.println(rootNode);
    }
    private BinaryNode<T> addRecursive(BinaryNode<T> rootNode,T data, double comparison){
        if (rootNode == null ){
            rootNode = new BinaryNode(data,comparison);
            return rootNode;
        }
        if (compare(comparison, rootNode.comparison)<0){
            rootNode.leftChild = addRecursive(rootNode.leftChild,data,comparison);
        }
        else if (compare(comparison, rootNode.comparison)>0){
            rootNode.rightChild = addRecursive(rootNode.rightChild,data,comparison);
        }
        return rootNode;
    }
    public boolean search(double comparison)  {
        rootNode = searchRecursive(rootNode, comparison);
        if (rootNode!= null)
            return true;
        else
            return false;
    }
    private BinaryNode<T> searchRecursive(BinaryNode<T> root, double comparison)  {
        if (rootNode==null || compare(rootNode.comparison,comparison)==0)
            return rootNode;
        if (compare(root.comparison,comparison)>0)
            return searchRecursive(rootNode.leftChild, comparison);
        // val is less than root's key
        return searchRecursive(rootNode.rightChild, comparison);
    }
    public void remove(double comparison) {
        rootNode = removeRecursive(rootNode, comparison);
    }

    //recursive delete function
    private BinaryNode<T> removeRecursive(BinaryNode<T> rootNode, double comparison) {
        //tree is empty
        if (rootNode == null) {
            return rootNode;
        }
        if (compare(comparison,rootNode.comparison)<0)     //traverse left subtree
            rootNode.leftChild = removeRecursive(rootNode.leftChild, comparison);
        else if (compare(comparison,rootNode.comparison)>0)  //traverse right subtree
            rootNode.rightChild = removeRecursive(rootNode.rightChild, comparison);
        else {
            if (rootNode.leftChild == null)
                return rootNode.rightChild;
            else if (rootNode.rightChild == null)
                return rootNode.leftChild;
            rootNode.comparison = getMinValue(rootNode.rightChild);
            rootNode.rightChild = removeRecursive(rootNode.rightChild, rootNode.comparison);
        }
        return rootNode;
    }
    public double getMinValue(BinaryNode<T> rootNode)  {
        double minroot = rootNode.comparison;
        while (rootNode.leftChild != null)  {
            minroot = rootNode.leftChild.comparison;
            rootNode = rootNode.leftChild;
        }
        return minroot;
    }
    
  public ArrayQueue<T> traverseAscending(){
        ArrayQueue<T> queue = new ArrayQueue<>();
        queue = inorderTraversal(rootNode, queue);
        return queue;
    }

    public ArrayQueue<T> inorderTraversal(BinaryNode node,ArrayQueue<T> queue) {

            if (node != null) {
                inorderTraversal(node.leftChild, queue);
                queue.enqueue((T)node.data);
                inorderTraversal(node.rightChild,queue);
            }
        return queue;
    }
    
    

}

