import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Implement a method to check if a binary tree is balanced.
 * A balanced tree means for any given node in the tree, the difference of left subtree's height and right subtree's height will not be more than 1.
 *
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2019-01-07 6:55 PM
 */
public class CheckBalanced {

    private static class Node {
        private int value;
        private Node left, right;

        Node(int v) {
            value = v;
        }
    }

    private boolean isBalanced(Node node) {
        return checkHeight(node) != Integer.MIN_VALUE;
    }

    private int checkHeight(Node node) {
        if (node == null) {
            return -1;
        }

        int left = checkHeight(node.left);
        if (left == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int right = checkHeight(node.right);
        if (right == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if (Math.abs(left - right) > 1) return Integer.MIN_VALUE;
        return Math.max(left, right) + 1;
    }

    @Test
    public void test() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        assertEquals(isBalanced(n1), true);

        n2.right = null;
        n4.left = n5;
        assertEquals(isBalanced(n1), false);
    }

}
