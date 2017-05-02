package cosc_311_project_3;

/**
 * @author      Michael Boettner
 * @version     1.0
 * BinarySearchTree class implements Binary Search Tree storage of Node
 * objects with methods to populate and traverse the tree
 */
public class BinarySearchTree
{
    
    /**
    * A reference to the root entry point of the BST
    */
    Node root;
    
    /**
    * The number of nodes contained in the tree
    */
    int treeSize;
    
    /**
    * Constant used to test whether to print data when traversing
    * tree. A small value (10) is used to test code output for small tree size
    */
    final int MAX_PRINT_SIZE;
    
    /**
     * @author      Michael Boettner
     * @version     1.0
     * Inner Node class for use in a Binary Search Tree allows for new Node
     * creation and initialization a random double data member
     */
    private class Node
    {
        
        /**
        * A reference to the Node's left child
        */
        Node left;
        
        /**
        * A reference to the Node's right child
        */
        Node right;
        
        /**
        * The Node's data member
        */
        double data;
        
        /**
        * Constructor initializes new Node with null children and a randomly
        * generated double as the data member
        */
        Node()
        {
            this.data = Math.random() * 100;
            this.left = null;
            this.right = null;
        }
    }
    
    /**
    * Constructor initializes new BST and instance variables
    */
    BinarySearchTree()
    {
        this.root = null;
        this.treeSize = 0;
        MAX_PRINT_SIZE = 10;
    }
    
    /**
    * Public method to generate and add a new Node to the tree
    * 
    * @return boolean true if the Node has been successfully added to tree
    */
    public boolean generateItem()
    {
        treeSize++; //increment tree size by 1
        return addItem(root, new Node());
    }

    /**
    * Recursively defined method to add a Node to the tree following
    * the insertion rules for a BST
    * 
    * @param localRoot The root of the current tree or subtree being processed
    * @param item The Node to be inserted
    * 
    * @return boolean true if the Node has been successfully inserted
    */
    private boolean addItem(Node localRoot, Node item)
    {   
        //If the tree is empty, insert at the root
        if (root == null)
        {
            root = item;
        }
        /*Otherwise, we must test the value of the Node's data against those
            in the tree, for proper insertion */
        
        //If new Node's data is less than or equal to the local root, go left
        else if (item.data <= localRoot.data)
        {
            //If the localRoot's left child is null, insert here
            if (localRoot.left == null)
            {
                localRoot.left = item;
            }
            /*Otherwise, a recursive call to addItem method with the current
                localRoot's left child as the new localRoot*/                
            else
            {
                addItem(localRoot.left, item);
            }              
        }
        //Else, Node's data tests greater than the local root, so go right
        else
        {
            //If the localRoot's right child is null, insert here
            if (localRoot.right == null)
            {
                localRoot.right = item;
            }
            /*Otherwise, a recursive call to addItem method with the current
                localRoot's right child as the new localRoot*/
            else
            {
                addItem(localRoot.right, item);
            }
        }
        return true;
    }
    
    /**
    * Public method to traverse the BST in infix order (sorted order)
    * 
    * @return boolean true when the traversal has been completed
    */
    public boolean infixTraversal()
    {
        return infixTraversal(root);
    }
    
    /**
    * Recursively defined method to traverse the BST in infix (sorted) order
    * 
    * @param localRoot The root of the current tree or subtree being processed
    * 
    * @return boolean true when the tree has been successfully traversed
    */
    private boolean infixTraversal(Node localRoot)
    {
        /*If left child exists, recursively call the function using the left
            child as new localRoot*/
        if(localRoot.left != null)
        {            
            infixTraversal(localRoot.left);    
        }
        
        //Data processed here. If the tree within the max size, print data
        if (treeSize <= MAX_PRINT_SIZE)
        {
            System.out.println(localRoot.data);
        }
        
        /*If right child exists, recursively call the function using the right
            child as new localRoot*/
        if(localRoot.right != null)
        {
            infixTraversal(localRoot.right);
        }
        
        return true;
    }
    
    /**
    * Public method to traverse the BST in postfix order
    * 
    * @return boolean true when the traversal has been completed
    */
    public boolean postFixTraversal()
    {
        return postFixTraversal(root);
    }
    
    /**
    * Recursively defined method to traverse the BST in postfix order
    * 
    * @param localRoot The root of the current tree or subtree being processed
    * 
    * @return boolean true when the tree has been successfully traversed
    */
    private boolean postFixTraversal(Node localRoot)
    {
        /*If left child exists, recursively call the function using the left
            child as new localRoot*/
        if (localRoot.left != null)
        {
            postFixTraversal(localRoot.left);
        }
        
        /*If right child exists, recursively call the function using the right
            child as new localRoot*/
        if (localRoot.right != null)
        {
            postFixTraversal(localRoot.right);
        }
        
        //Data processed here. If the tree is within the max size, print data
        if (treeSize <= MAX_PRINT_SIZE)
        {
            System.out.println(localRoot.data);
        }
        
        return true;
    }
    
    /**
    * Get method for tree size
    * 
    * @return treeSize, number of nodes in the tree
    */
    public int getSize()
    {
        return treeSize;
    }
}