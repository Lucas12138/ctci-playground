import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-11 3:35 PM
 */
public class Partition {

    class Node {

        Node next = null;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node partition(Node head, int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        while (head != null) {
            if (head.data < x) {
                if (beforeStart == null) {
                    beforeStart = head;
                    beforeEnd = beforeStart;
                }else {
                    beforeEnd.next = head;
                    beforeEnd = beforeEnd.next;
                }
            }else {
                if (afterStart == null) {
                    afterStart = head;
                    afterEnd = afterStart;
                }else {
                    afterEnd.next = head;
                    afterEnd = afterEnd.next;
                }
            }

            // caution: head = head.next approach will result in cycle in linked list here
            Node next = head.next;
            head.next = null;
            head = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    @Test
    public void test() {
        Node n0 = new Node(6);
        Node n1 = new Node(1);
        Node n2 = new Node(4);
        Node n3 = new Node(3);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;

        Node newHead = partition(n0, 4);

        assertEquals(newHead.data, 1);
        assertEquals(newHead.next.data, 3);
        assertEquals(newHead.next.next.data, 6);
        assertEquals(newHead.next.next.next.data, 4);
    }
}
