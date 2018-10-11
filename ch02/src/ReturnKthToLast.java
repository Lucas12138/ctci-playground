import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * find the kth to last element of a singly linked list.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-11 10:31 AM
 */
public class ReturnKthToLast {

    class Node {

        Node next = null;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    class IndexState {
        int value;
    }

    /**
     * Recursion version
     */
    public Node printKthToLast1(Node head, int k) {
        return printDFS(head, k, new IndexState());
    }

    public Node printDFS(Node head, int k, IndexState indexState) {
        if (head == null) {
            return  null;
        }

        Node node = printDFS(head.next, k, indexState);
        indexState.value += 1;
        if (indexState.value == k) {
            return head;
        }
        return node;
    }

    /**
     * Iteration version, using 2 pointers
     */
    public Node printKthToLast2(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

        while (k >= 0) {
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
        }

        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }


    @Test
    public void test() {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        node0.next = node1;
        Node node2 = new Node(0);
        node1.next = node2;

        assertEquals(printKthToLast1(node0, 4), null);
        assertEquals(printKthToLast1(node0, 2).data, 1);
    }

}
