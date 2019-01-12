import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Implement a function to validate if a tree is a BST.
 * A BST will not have duplicate node values.
 * A node in BST will hold a value that's larger than any node value in its left subtree and smaller than any node value in its right subtree. 
 * 
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2019-01-07 7:31 PM
 */
public class ValidateBST {

    private static class Node {
        private int value;
        private Node left, right;

        Node(int v) {
            value = v;
        }
    }
    
    private boolean isBST(Node node) {
        return validateBST(node, null, null);
    }
    
    private boolean validateBST(Node node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if (min != null && node.value < min) {
            return false;
        }
        
        if (max != null && node.value > max) {
            return false;
        }
        
        return validateBST(node.left, min, node.value) && validateBST(node.right, node.value, max);
    }
    
    @Test
    public void test() {
        Node n1 = new Node(4);
        Node n2 = new Node(2);
        Node n3 = new Node(5);
        Node n4 = new Node(1);
        Node n5 = new Node(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        assertEquals(isBST(n1), true);

        n5.value = 1;
        assertEquals(isBST(n1), false);
    }
}
