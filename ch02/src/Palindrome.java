import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * check if a lined list of Integer is a palindrom
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-11-03 7:11 PM
 */
public class Palindrome {

    private static class Node<Integer> {
        private Node<Integer> next = null;
        private Integer data = null;

        Node(Integer d, Node<Integer> n) {
            data = d;
            next = n;
        }
    }

    public Node<Integer> deepCopyAndReverse(Node<Integer> head) {
        Node<Integer> newHead = null;
        while (head != null) {
            newHead = new Node<Integer>(head.data, newHead);
            head = head.next;
        }
        return newHead;
    }

    public boolean isPalindrome(Node<Integer> head) {
        Node<Integer> reversedHead = deepCopyAndReverse(head);
        while (head != null && reversedHead != null) {
            if (head.data != reversedHead.data) {
                return false;
            }
            head = head.next;
            reversedHead = reversedHead.next;
        }
        return true;
    }

    @Test
    public void test() {
        Node<Integer> n1 = new Node<>(1, null);
        n1 = new Node<>(2, n1);
        n1 = new Node<>(1, n1);

        Node<Integer> n2 = new Node<>(1, null);
        n2 = new Node<>(2, n2);
        n2 = new Node<>(2, n2);

        assertEquals(true, isPalindrome(n1));
        assertEquals(false, isPalindrome(n2));
    }

}
