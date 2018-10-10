import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Remove duplicates from an unsorted linked list.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-10 10:28 AM
 */
public class RemoveDups {

    class Node {

        Node next = null;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }


    /**
     * Time: O(n), Space: O(n)
     */
    public void removeDups1(Node head) {
        Set<Integer> existingData = new HashSet<>();

        Node pre = null;
        while (head != null) {
            if (existingData.contains(head.data)) {
                pre.next = head.next;
            }else {
                existingData.add(head.data);
                pre = head;
            }
            head = head.next;
        }
    }

    /**
     * Time: O(n^2), Space: O(1)
     */
    public void removeDups2(Node head) {
        Node cur = head;
        while (cur != null) {
            Node runner = cur;
            while (runner.next != null) {
                if (cur.data == runner.next.data) {
                    runner.next = runner.next.next;

                }else {
                    runner = runner.next;
                }
            }
            cur = cur.next;
        }
    }

    @Test
    public void test1() {
        RemoveDups removeDups = new RemoveDups();
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        node0.next = node1;
        Node node2 = new Node(0);
        node1.next = node2;
        removeDups.removeDups1(node0);
        assertEquals(node0.data, 0);
        assertEquals(node0.next.data, 1);
        assertEquals(node0.next.next, null);
    }

    @Test
    public void test2() {
        RemoveDups removeDups = new RemoveDups();
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        node0.next = node1;
        Node node2 = new Node(0);
        node1.next = node2;
        removeDups.removeDups2(node0);
        assertEquals(node0.data, 0);
        assertEquals(node0.next.data, 1);
        assertEquals(node0.next.next, null);
    }

}
