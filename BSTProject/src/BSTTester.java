/*
 * TODO: Name
 * TODO: Date
 * TODO: Class Period
 * TODO: Program Description
 */

 import java.lang.Comparable;

 public class BSTTester {
   public static void main(String[] args) {
    BST tree= new BST();

    tree.add("Q");tree.add("U");tree.add("I");
    tree.add("N");tree.add("E");
    tree.add("O");tree.add("R");tree.add("C");
    tree.add("H");tree.add("A");tree.add("R");
    tree.add("D");
    

    tree.printInOrder();
    System.out.println("in order");
    
    tree.printPreOrder();
    System.out.println("pre order");

    tree.printPostOrder();
    System.out.println("post order");
   }
 }