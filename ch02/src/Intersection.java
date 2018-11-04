import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Given 2 singly linked lists, judge if they have an intersection (exact same reference)
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-11-03 7:38 PM
 */
public class Intersection {


    private static class Node<Integer> {
        private Node<Integer> next = null;
        private Integer data = null;

        Node(Integer d, Node<Integer> n) {
            data = d;
            next = n;
        }
    }

    public Node<Integer> getIntersectionNode(Node<Integer> n1, Node<Integer> n2) {
        int n1Len = getLength(n1);
        int n2Len = getLength(n2);
        Node<Integer> n1Cur = n1Len > n2Len ? getNodeNumberK(n1, n1Len - n2Len) : n1;
        Node<Integer> n2Cur = n1Len > n2Len ? n2 : getNodeNumberK(n2, n2Len - n1Len);

        while (n1Cur != n2Cur && n1Cur != null && n2Cur != null) {
            n1Cur = n1Cur.next;
            n2Cur = n2Cur.next;
        }
        return n1Cur;
    }

    public Node<Integer> getNodeNumberK(Node<Integer> head, int k) {
        Node<Integer> nodeNumberK = head;
        while (k > 0 && nodeNumberK != null) {
            nodeNumberK = nodeNumberK.next;
            k -= 1;
        }
        return nodeNumberK;
    }

    public int getLength(Node<Integer> head) {
        int len = 0;
        Node<Integer> cur = head;
        while (cur != null) {
            cur = cur.next;
            len += 1;
        }
        return len;
    }

    @Test
    public void test() {
        Node<Integer> n1 = new Node<>(3, null);
        n1 = new Node<>(2, n1);
        n1 = new Node<>(1, n1);

        Node<Integer> n2 = new Node<>(1, null);
        n2.next = n1.next.next;

        Node<Integer> n3 = new Node<>(1, null);
        assertEquals(getIntersectionNode(n1, n2).data, new Integer(3));
        assertEquals(getIntersectionNode(n1, n3), null);
    }
}
