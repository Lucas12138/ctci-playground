import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Given a cirular LinkedList, find the first node that start the loop
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-11-03 8:37 PM
 */
public class LoopDetection {

    /**
     * Use 2 pointers, slow move 1 step and fast move 2 steps each time
     * Set k = the step for slow needed to get into the loop
     * The fast will be k % loopSize steps after the starting node of the loop
     * Therefore, the fast will need (loopSize - k % loopSize) extra steps to catch up the slow (consider relative motion)
     * Since the absolute length is (k + loopSize)
     * So, we notice that slow will need (k + loopSize) - (k + (loopSize - k % loopSize)) steps to traverse all nodes
     * (k + loopSize) - (k + (loopSize - k % loopSize)) is exact k steps
     * It means when they collide, if we start another pointer newP to traverse from head, slow and newP will meet at the starting node of loop
     */

    private static class Node<Integer> {
        private Node<Integer> next = null;
        private Integer data = null;

        Node(Integer d, Node<Integer> n) {
            data = d;
            next = n;
        }
    }

    public Node<Integer> getStartingNodeOfLoop(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        Node<Integer> newP = head;
        while (newP != slow) {
            slow = slow.next;
            newP = newP.next;
        }
        return newP;
    }

    @Test
    public void test() {
        Node<Integer> n = new Node<>(4, null);
        n = new Node<>(3, n);
        n = new Node<>(2, n);
        n = new Node<>(1, n);
        n.next.next.next.next = n.next;
        assertEquals(getStartingNodeOfLoop(n).data, new Integer(2));
    }
}
