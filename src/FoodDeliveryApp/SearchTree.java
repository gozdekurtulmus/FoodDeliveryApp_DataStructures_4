package FoodDeliveryApp;

import java.util.NoSuchElementException;

public class SearchTree<T> {
    private BinaryNode<T> rootNode;
    private Comparator comparator;

    public SearchTree(BinaryNode<T> root){
        setRootNode(root);

    }
    public SearchTree(Comparator comparator){
        this.comparator = comparator;
    }

    public SearchTree() {
        rootNode =null;
    }

    public BinaryNode<T> getRootNode() {
        return rootNode;
    }

    public void setRootNode(BinaryNode<T> rootNode) {
        this.rootNode = rootNode;
    }

    public T add(T data){
        T result = null;
        if(rootNode == null){
            setRootNode(new BinaryNode<>(data));
        }
        else {
            result = addRecursive(rootNode, data);
        }
        return result;
    }
    private T addRecursive(BinaryNode<T> rootNode, T data){
        assert rootNode != null;
        T result = null;
        if (comparator.compare(data, rootNode.getData())<0){
            if (rootNode.hasLeftChild())
                result = (T) addRecursive(rootNode.getLeftChild(),data);
            else
                rootNode.setLeftChild(new BinaryNode<>(data));
        }
        if (comparator.compare(data, rootNode.getData()) == 0) {
            result = rootNode.getData();
            rootNode.setData(data);
        }
        else if (comparator.compare(data, rootNode.getData())>0){
            if(rootNode.hasRightChild())
                result = (T) addRecursive(rootNode.getRightChild(),data);
            else
                rootNode.setRightChild(new BinaryNode<>(data));
        }
        return result;
    }
    public boolean search(T anEntry)  {
        rootNode = searchRecursive(rootNode,anEntry);
        if (rootNode!= null)
            return true;
        else
            return false;
    }
    private BinaryNode<T> searchRecursive(BinaryNode<T> root, T anEntry)  {
        if (rootNode==null || comparator.compare(rootNode.getData(),anEntry)==0)
            return rootNode;
        if (comparator.compare(rootNode.getData(),anEntry)>0)
            return searchRecursive(rootNode.getLeftChild(),anEntry);
        // val is less than root's key
        return searchRecursive(rootNode.getRightChild(), anEntry);
    }

    public void remove(T anEntry) {
        rootNode = removeRecursive(rootNode,anEntry);
    }

    //recursive delete function
    private BinaryNode<T> removeRecursive(BinaryNode<T> rootNode,T anEntry) {
        //tree is empty
        if (rootNode == null) {
            return rootNode;
        }
        if (comparator.compare(anEntry, rootNode.getData()) < 0)     //traverse left subtree
            rootNode.setLeftChild(removeRecursive(rootNode.getLeftChild(), anEntry));
        else if (comparator.compare(anEntry, rootNode.getData()) > 0)  //traverse right subtree
            rootNode.setRightChild(removeRecursive(rootNode.getRightChild(), anEntry));
        else {

            if (!rootNode.hasLeftChild())
                return rootNode.getRightChild();
            else if (!rootNode.hasRightChild())
                return rootNode.getLeftChild();

            rootNode.setData((T) getMaxValue(rootNode.getLeftChild()));
            rootNode.setLeftChild(removeRecursive(rootNode.getLeftChild(),anEntry));
        }
        return rootNode;
    }
    public T getMaxValue(BinaryNode<T> rootNode)  {
        T maxRoot = rootNode.getData();
        while (rootNode.hasRightChild())  {
            maxRoot = (T) rootNode.getRightChild().getData();
            setRootNode(rootNode.getRightChild());
        }
        return maxRoot;
    }

    public Iterator<T> getInOrderIterator(){
        return new InorderIterator(rootNode);

    }

}


