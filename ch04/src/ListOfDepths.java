import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import static junit.framework.Assert.assertEquals;

/**
 * Given a binary tree, creates a linkedlist of all the nodes at each depth.
 * e.g. A tree of depth D will make D linkedlists
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-12-10 10:52 PM
 */
public class ListOfDepths {

    private static class Node {
        private int value;
        private Node left, right;

        Node(int v) {
            value = v;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    ArrayList<LinkedList<Node>> createLevelLinkedList(Node root) {
        ArrayList<LinkedList<Node>> states = new ArrayList<>();
        LinkedList<Node> state = new LinkedList<>();
        if (root != null) {
            state.add(root);
        }

        while (state.size() > 0) {
            states.add(state);
            LinkedList<Node> parents = state;
            state = new LinkedList<>();
            for (Node parent : parents) {
                if (parent.left != null) {
                    state.add(parent.left);
                }
                if (parent.right != null) {
                    state.add(parent.right);
                }
            }
        }
        return states;
    }

    @Test
    public void test() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;

        String[] res = new String[]{
                "[1]",
                "[2, 3]",
                "[4]"
        };

        int i = 0;
        for (LinkedList ll : createLevelLinkedList(n1)) {
            assertEquals(ll.toString(), res[i]);
            i += 1;
        }
    }
}
