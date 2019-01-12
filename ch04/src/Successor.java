import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Find the next node (in order) of a 
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2019-01-11 7:07 AM
 */
public class Successor {

    private static class Node {
        private int value;
        private Node left, right, parent;

        Node(int v) {
            value = v;
        }
    }

    private Node inorderSucc(Node node) {
        if (node == null) return null;

        if (node.right != null) {
            return getLeftMostChild(node.right);
        }else {
            Node tmp = node;
            Node p = tmp.parent;
            while (p != null && p.left != tmp) {
                tmp = p;
                p = p.parent;
            }
            return p;
        }
    }

    private Node getLeftMostChild(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Test
    public void test() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.right = n2;
        n2.parent = n1;
        n2.right = n3;
        n3.parent = n2;

        assertEquals(inorderSucc(n3), null);
        assertEquals(inorderSucc(n2), n3);

        n1 = new Node(1);
        n2 = new Node(2);
        n3 = new Node(3);
        n1.left = n2;
        n2.parent = n1;
        n2.left = n3;
        n3.parent = n2;

        assertEquals(inorderSucc(n2), n1);
    }
}
