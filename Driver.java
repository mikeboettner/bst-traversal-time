package cosc_311_project_3;

import java.util.Scanner;

/**
 * @author      Michael Boettner
 * @version     1.0
 * Driver class contains main method which generates a Binary Search Tree
 * of size designated by the user, then calculates time it takes to traverse
 * tree (a postfix traversal of the
 * tree)
 */
public class Driver {

    /**
    * Keyboard input
    */
    static Scanner keyboard = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("*************************");
        System.out.println("* Programming Project 3 *");
        System.out.println("*     BST: Run-time     *");
        System.out.println("* Complexity Experiment *");
        System.out.println("*************************");
        
        /**
        * Instance of BinarySearchTree
        */
        BinarySearchTree myBST;
        
        /**
        * Controls additional runs of new BST creation/traversal
        */
        boolean again = true;
        
        /**
        * Stores user specified keyboard input for a additional runs (y/n)
        */
        char runAgain;
        
        /**
        * Stores user specified keyboard input for a tree traversal (y/n)
        */
        char traverseTree;
        
        /**
        * User specified, the size of BST to generate
        */
        int dataSetSize;
        
        /**
        * Start time of BST traversal
        */
        long startTime;
        
        /**
        * End time of BST traversal
        */
        long endTime;
        
        /**
        * Calculated time for a BST traversal
        */
        long elapsedTime;
        
        while(again)
        {
            //for each run, assign the BST instance to new
            myBST = new BinarySearchTree();
            System.out.print("\nEnter data set size: ");
            dataSetSize = keyboard.nextInt();
            
            if (dataSetSize > 0)
            {
                System.out.println("\nPopulating BST. Please wait...");
                
                //add user-specified number of nodes to the tree
                for (int i = 0; i < dataSetSize; i++)
                {
                    myBST.generateItem(); 
                }
                
                System.out.print("\nCalculate elapsed time for postfix "
                        + "traversal? (y/n): ");
                
                traverseTree = keyboard.next().charAt(0);
                
                if(traverseTree == 'y' || traverseTree == 'Y')
                {
                    System.out.println("\nPostfix Traversal:");                

                    //record starting time
                    startTime = System.nanoTime();

                    if(myBST.postFixTraversal())
                    {
                        //record ending time
                        endTime = System.nanoTime();
                        
                        //calculate difference of times
                        elapsedTime = endTime - startTime;
                        
                        System.out.println("*** Postfix traversal for tree "
                                + "size " + myBST.getSize() +
                                " completed in: " + elapsedTime +
                                    " nanoseconds");
                    }
                }
            }
            else
            {
                System.out.println("\nError: Set size must be greater than "
                        + "zero.");
            }
            
            System.out.print("\nRun again? (y/n): ");
            
            runAgain = keyboard.next().charAt(0);
            
            if(runAgain == 'n' || runAgain == 'N')
            {
                again = false;
            }
        }
    }
}