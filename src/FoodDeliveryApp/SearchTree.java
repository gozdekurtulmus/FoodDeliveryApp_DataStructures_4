package FoodDeliveryApp;


public class SearchTree<T> implements SearchTreeInterface<T> {
    private BinaryNode<T> rootNode;
    private Comparator<T> comparator;

    //constructor
    public SearchTree(BinaryNode<T> root){
        setRootNode(root);

    }
    //constructor
    public SearchTree(Comparator<T> comparator){
        this.comparator = comparator;
    }

    //constructor
    public SearchTree() {
        rootNode =null;
    }

    //starts the getters and setters methods
    public BinaryNode<T> getRootNode() {
        return rootNode;
    }

    public void setRootNode(BinaryNode<T> rootNode) {
        this.rootNode = rootNode;
    }

    public Comparator<T> getComparator(){
        return this.comparator;
    }
    public void setComparator(Comparator<T> comparator){
        this.comparator = comparator;
    }
    //ends the getters and setters methods

    //Adds a new entry to this tree.
    public T add(T data){
        T result = null;
        if(rootNode == null){ //BST is empty
            setRootNode(new BinaryNode<>(data));
        }
        else {
            result = addRecursive(rootNode, data); //calls private addRecursive
        }
        return result;
    }

    //adds data to the nonempty subtree rooted at rootNode
    private T addRecursive(BinaryNode<T> rootNode, T data){
        assert rootNode != null;
        T result = null;
        if (comparator.compare(data, rootNode.getData())<0){
            if (rootNode.hasLeftChild())
                result = addRecursive(rootNode.getLeftChild(),data);
            else
                rootNode.setLeftChild(new BinaryNode<>(data));
        }
        if (comparator.compare(data, rootNode.getData()) == 0) {
            result = rootNode.getData();
            rootNode.setData(data);
        }
        else if (comparator.compare(data, rootNode.getData())>0){
            if(rootNode.hasRightChild())
                result = addRecursive(rootNode.getRightChild(),data);
            else
                rootNode.setRightChild(new BinaryNode<>(data));
        }
        return result;
    }
    //Searches for a specific entry in this tree.
    public boolean search(T anEntry)  {
        rootNode = searchRecursive(rootNode,anEntry);  //calls private searchRecursive methods
        return rootNode != null;
    }
    //recursive search method
    private BinaryNode<T> searchRecursive(BinaryNode<T> rootNode, T anEntry)  {
        if (rootNode==null || comparator.compare(rootNode.getData(),anEntry)==0)
            return rootNode;
        if (comparator.compare(rootNode.getData(),anEntry)>0)  //traverse left subtree
            return searchRecursive(rootNode.getLeftChild(),anEntry);
        // val is less than root's key
        return searchRecursive(rootNode.getRightChild(), anEntry);
    }
    //Removes a specific entry from this tree.
    public BinaryNode<T> remove(T anEntry) {
        rootNode = removeRecursive(rootNode,anEntry);
        return rootNode;
    }

    //recursive remove method
    private BinaryNode<T> removeRecursive(BinaryNode<T> rootNode,T anEntry) {
        
        //tree is empty
        if (rootNode == null) {
            return null;
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

            rootNode.setData(getMaxValue(rootNode.getLeftChild()));
            rootNode.setLeftChild(removeRecursive(rootNode.getLeftChild(),anEntry));
        }
        return rootNode;
    }

    //Returns the highest value in the right subtree of the rootNode.
    public T getMaxValue(BinaryNode<T> rootNode)  {
        T maxRoot = rootNode.getData();
        while (rootNode.hasRightChild())  {
            maxRoot = rootNode.getRightChild().getData();
            setRootNode(rootNode.getRightChild());
        }
        return maxRoot;
    }

    //Returns the Iterator that traverse inorder way
    public Iterator<T> getInOrderIterator(){
        return new InorderIterator<>(rootNode);

    }
    //Traverses the BST with preorder traversal
    public QueueInterface<T> getPreorderTraversal(){
    	QueueInterface<T> queue = new ArrayQueue<>();
        return preOrderTraverse(rootNode,queue);
    }

    //recursive preOrderTraverse
    private QueueInterface<T> preOrderTraverse(BinaryNode<T> rootNode, QueueInterface<T> queue){
        if (rootNode != null){
            queue.enqueue(rootNode.getData());
            preOrderTraverse(rootNode.getLeftChild(),queue);
            preOrderTraverse(rootNode.getRightChild(),queue);
        }
        return queue;
    }
    //Traverses the BST with postorder traversal
    public 	QueueInterface<T> getPostOrderTraversal(){
    	QueueInterface<T> queue = new ArrayQueue<>();
        return postOrderTraverse(rootNode, queue);
    }

    //recursive postOrderTraverse
    private QueueInterface<T> postOrderTraverse(BinaryNode<T> rootNode, QueueInterface<T> queue){
        if (rootNode != null){
            postOrderTraverse(rootNode.getLeftChild(),queue);
            postOrderTraverse(rootNode.getRightChild(),queue);
            queue.enqueue(rootNode.getData());
        }
        return queue;
    }
    
    //Traverses the BST with levelorder traversal.
    public QueueInterface<T> levelOrderTraversal(){
    	QueueInterface<T> queue = new ArrayQueue<>();
        return levelOrderTraverse(rootNode,queue);
        
    }
    
    private QueueInterface<T> levelOrderTraverse(BinaryNode<T> rootNode, QueueInterface<T> returnQueue){
        QueueInterface<BinaryNode<T>> queue = new ArrayQueue<>();
        queue.enqueue(rootNode);
        while(!queue.isEmpty()){
            BinaryNode<T> temp = queue.dequeue();
            returnQueue.enqueue(temp.getData());
            if(temp.hasLeftChild()){
                queue.enqueue(temp.getLeftChild());
            }
            if(temp.hasRightChild()){
                queue.enqueue(temp.getRightChild());
            }
        }
        return returnQueue;
    }

}
