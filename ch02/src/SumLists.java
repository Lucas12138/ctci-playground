import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Given 2 numbers represented by 2 linked lists, sum it and return the same kind of linked list
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-11-03 5:42 PM
 */
public class SumLists {

    private static class Node<Integer> {
        private Node<Integer> next;
        private Integer data;

        Node(Integer d, Node<Integer> n) {
            data = d;
            next = n;
        }
    }

    public Node<Integer> sumLists(Node<Integer> n1, Node<Integer> n2) {

        Node<Integer> head = null;
        int carry = 0;

        while (n1 != null || n2 != null) {
            int d1 = n1 != null ? n1.data : 0;
            int d2 = n2 != null ? n2.data : 0;
            int sum = d1 + d2 + carry;

            carry = sum > 9 ? 1 : 0;
            sum %= 10;
            head = new Node<Integer>(sum, head);

            n1 = n1 == null ? null : n1.next;
            n2 = n2 == null ? null : n2.next;
        }

        if (carry == 1) {
            head = new Node<Integer>(1, head);
        }
        return reverseList(head);
    }

    public Node<Integer> reverseList(Node<Integer> head) {
        Node<Integer> newHead = null;
        while (head != null) {
            Node<Integer> next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    @Test
    public void test() {
        SumLists sl = new SumLists();
        Node<Integer> n1 = new Node<>(1, null);
        n1 = new Node<>(1, n1);
        n1 = new Node<>(2, n1);
        n1 = new Node<>(3, n1);

        Node<Integer> n2 = new Node<>(3, null);
        n2 = new Node<>(2, n2);
        n2 = new Node<>(7, n2);

        Node<Integer> sumNode = sumLists(n1, n2);
        String numStr = "";
        while (sumNode != null) {
            numStr += sumNode.data;
            sumNode = sumNode.next;
        }
        assertEquals("0541", numStr);
    }
}
